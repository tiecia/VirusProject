import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class VirusCollection {
	
	public ArrayList<Virus> collection;
	
	public VirusCollection(ArrayList<Virus> collection) {
		this.collection = collection;
	}
	
	public void filterDefinition(char s) {
		System.out.println("Char");
		for(int i = 0; i<collection.size(); i++) {
			if(collection.get(i).getDefinition().toLowerCase().charAt(0) != s) {
				collection.remove(i);
				i--;
			}
		}
		printList();	
	}
	
	public void filterDefinition(String s) {
		System.out.println("String");
		for(int i = 0; i<collection.size(); i++) {
			if(!collection.get(i).getDefinition().toLowerCase().contains(s)) {
				collection.remove(i);
				i--;
			}
		}
		printList();
	}
	
	public void filterReference(Range r) {
		
	}
	
	public void filterOrigin(String s) {
		
	}
	
	public void filterYear(Range r) {
		
	}
	
	public void filterGene(String s) {
		for(int i = 0; i<collection.size(); i++) {
			if(s.equals("DNA") && collection.get(i).getGene().equals("RNA")) {
				collection.remove(i);
				i--;
			} else if(s.equals("RNA") && collection.get(i).getGene().equals("DNA")) {
				collection.remove(i);
				i--;
			}
		}
		printList();
	}
	
	
	
	public void sortDefinition() {
		
		System.out.println("sort def");
		
		Virus[] list = (Virus[]) collection.toArray();
		
		boolean searching = true;
		for(int i = 0; i<list.length-1; i++) {
			int min = i;
			searching = true;
			for(int j = i + 1; j<list.length && searching; j++) {
				if(list[j].getDefinition().charAt(0) < list[min].getDefinition().charAt(0)) {
					min = j;
				}
			}
			Virus temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
		
		collection.clear();
		
		for(int i = 0; i<list.length; i++) {
			collection.add(list[i]);
		}
		printList();
	}
	
	public void sortReference() {
		
	}
	
	public void sortYear() {
		
	}
	
	public void sortOrigin() {
		
	}
	
	public ArrayList<Virus> sortGene() {
		System.out.println("Gene");
		
		int index = 0;
		
		for(int i = 0; i<collection.size(); i++) {
			index++;
			System.out.println(collection.get(index).getGene());
			String gene = collection.get(index).getGene();
			if(gene.equals("RNA")) {
				collection.add(collection.get(index));
				collection.remove(index);
				index--;
			}
		}
		System.out.println(collection);
		printList();
		System.out.println();
		return collection;
	}
	
	private void printList() {
		if(collection.size() == 0) {
			System.out.println("Nothing To Print");
		}
		for(int i = 0; i<collection.size(); i++) {
			System.out.println("__");
			System.out.println("| " + collection.get(i).getDefinition());
			System.out.println("| " + collection.get(i).getYear());
			System.out.println("| " + collection.get(i).getReference());
			System.out.println("| " + collection.get(i).getGene());
//			System.out.println("| " + collection.get(i).getOrigin());
			System.out.println("__");
		}
		collection = VirusClient.parse();
	}
	
	public void list() {
		System.out.println();
		System.out.println();
		System.out.println("8888888888 d8b 888                        888                            888               888    \r\n" + 
				"888        Y8P 888                        888                            888               888    \r\n" + 
				"888            888                        888                            888               888    \r\n" + 
				"8888888    888 888  .d88b.  .d8888b       888      .d88b.   8888b.   .d88888  .d88b.   .d88888    \r\n" + 
				"888        888 888 d8P  Y8b 88K           888     d88\"\"88b     \"88b d88\" 888 d8P  Y8b d88\" 888    \r\n" + 
				"888        888 888 88888888 \"Y8888b.      888     888  888 .d888888 888  888 88888888 888  888    \r\n" + 
				"888        888 888 Y8b.          X88      888     Y88..88P 888  888 Y88b 888 Y8b.     Y88b 888    \r\n" + 
				"888        888 888  \"Y8888   88888P'      88888888 \"Y88P\"  \"Y888888  \"Y88888  \"Y8888   \"Y88888    \r\n" );
		printList();
		System.out.println();
	}
}
