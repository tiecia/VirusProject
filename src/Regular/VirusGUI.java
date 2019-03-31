package Regular;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VirusGUI {

	private JFrame frame;
	
	private ArrayList<Virus> vArray = VirusClient.parse();
	private VirusCollection vcollection = new VirusCollection(vArray);
	private JScrollPane textScrollPane;
	private JTextArea textArea;
	private DefaultListModel<Virus> listModel = new DefaultListModel<Virus>();
	private JList<Virus> list = new JList<Virus>(listModel);
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnSort;
	private JMenu mnFilter;
	private JMenuItem mntmGene;
	private JMenuItem mntmGene_1;
	private JMenuItem mntmDefinition;
	private JMenuItem mntmReference;
	private JMenuItem mntmYear;
	private JMenuItem mntmOrigin;
	private JMenuItem menuItem;
	private JMenuItem menuItem_1;
	private JMenuItem menuItem_2;
	private JMenuItem menuItem_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VirusGUI window = new VirusGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VirusGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList<Virus> virusList = VirusClient.parse();
		VirusCollection collection = new VirusCollection(virusList);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		textScrollPane = new JScrollPane();
		frame.getContentPane().add(textScrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textScrollPane.setViewportView(textArea);
		textArea.setColumns(10);
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		for(int i = 0; i<vArray.size(); i++) {
			listModel.addElement(vArray.get(i));
		}
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					textArea.setText(vArray.get(list.getSelectedIndex()).printVirus());
				} catch (ArrayIndexOutOfBoundsException e) {
					
				}
			}
		});
		scrollPane.setViewportView(list);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnSort = new JMenu("Sort");
		menuBar.add(mnSort);
		
		mntmGene = new JMenuItem("Gene");
		mntmGene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//SORT GENE
				vArray = collection.sortGene();
				updateList();
			}
		});
		mnSort.add(mntmGene);
		
		mntmDefinition = new JMenuItem("Definition");
		mntmDefinition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vArray = vcollection.sortDefinition();
				updateList();
			}
		});
		mnSort.add(mntmDefinition);
		
		mntmReference = new JMenuItem("Reference");
		mntmReference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vArray = vcollection.sortReference();
				updateList();
			}
		});
		mnSort.add(mntmReference);
		
		mntmYear = new JMenuItem("Year");
		mntmYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vArray = vcollection.sortYear();
				updateList();
			}
		});
		mnSort.add(mntmYear);
		
		mntmOrigin = new JMenuItem("Origin");
		mntmOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vArray = vcollection.sortOrigin();
				updateList();
			}
		});
		mnSort.add(mntmOrigin);
		
		mnFilter = new JMenu("Filter");
		menuBar.add(mnFilter);
		
		mntmGene_1 = new JMenuItem("Gene");
		mntmGene_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(frame,"Enter Filter Term", "Enter Filter Term");
				if(input != null) {
					if(input.toLowerCase().equals("dna")) {
						vArray = vcollection.filterGene("DNA");
					} else if(input.toLowerCase().equals("rna")) {
						vArray = vcollection.filterGene("RNA");
					} else {
						vArray.clear();
					}
					updateList();
				}
			}
		});
		mnFilter.add(mntmGene_1);
		
		menuItem = new JMenuItem("Definition");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(frame,"Enter Filter Term", "Enter Filter Term");
				if(input != null) {
					if(input.length() == 1) {
						vArray = vcollection.filterDefinition(input.charAt(0));
					} else {
						vArray = vcollection.filterDefinition(input);
					}
					updateList();
				}
			}
		});
		mnFilter.add(menuItem);
		
		menuItem_3 = new JMenuItem("Reference");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dialog = JOptionPane.showInputDialog(frame,"Enter Reference Range", "Enter Reference Range");
				
				if(dialog != null) {
					Range r = Range.parse(dialog);
					System.out.println(r);
					if(r==null) {
						vArray.clear();
					} else {
						vArray = vcollection.filterReference(r);
					}
					updateList();
				}
			}
		});
		mnFilter.add(menuItem_3);
		
		menuItem_2 = new JMenuItem("Year");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dialog = JOptionPane.showInputDialog(frame,"Enter Reference Range", "Enter Reference Range");
				if(dialog != null) {
					Range r = Range.parse(dialog);
					if(r==null) {
						System.out.println("Invalid Input: Date Range");
						vArray.clear();
					} else {
						vArray = vcollection.filterYear(r);
					}
					updateList();
				}
			}
		});
		mnFilter.add(menuItem_2);
		
		menuItem_1 = new JMenuItem("Origin");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(frame,"Enter Filter Term", "Enter Filter Term");
				if(input != null) {
					vcollection.filterOrigin(input.toLowerCase());
				}
			}
		});
		mnFilter.add(menuItem_1);
	}
	
	private void updateList() {
		System.out.println(vArray);
		textArea.setText("");
		list.clearSelection();
		
		listModel.removeAllElements();
		
		for(int i = 0; i<vArray.size(); i++) {
			listModel.addElement(vArray.get(i));
		}
	}
}
