import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VirusGUI {

	private JFrame frame;
	
	private ArrayList<Virus> vArray = VirusClient.parse();
	private VirusCollection vcollection = new VirusCollection(vArray);
	private JScrollPane textScrollPane;
	private JTextArea textArea;
	private JList list;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu mnSort;
	private JMenu mnFilter;
	private JMenuItem mntmGene;
	private JMenuItem mntmGene_1;


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
		
		list = new JList(virusList.toArray());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				textArea.setText(virusList.get(list.getSelectedIndex()).printVirus());
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
				vArray = collection.sortGene();
//				list.setListData(vArray.toArray());
				updateList();
			}
		});
		mnSort.add(mntmGene);
		
		mnFilter = new JMenu("Filter");
		menuBar.add(mnFilter);
		
		mntmGene_1 = new JMenuItem("Gene");
		mnFilter.add(mntmGene_1);
	}
	
	private void updateList() {
		for(int i = 0; i<list.getModel().getSize(); i++) {
			list.remove(i);
		}
		for(int i = 0; i<vArray.size(); i++) {
			list.add(list, vArray.get(i));
		}
	}
}
