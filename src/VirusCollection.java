import java.util.ArrayList;
import java.util.Scanner;

public class VirusCollection {
	
	public ArrayList<Virus> collection;
	
	public VirusCollection(ArrayList<Virus> collection) {
		this.collection = collection;
	}
	
	public void filterDefinition(String s) {
		
	}
	
	public void filterReference(Range r) {
		
	}
	
	public void filterOrigin(String s) {
		
	}
	
	public void filterYear(Range r) {
		
	}
	
	public void filterGene(String s) {
		System.out.println("Pre Filter" + collection);
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
		
	}
	
	public void sortReference() {
		
	}
	
	public void sortYear() {
		
	}
	
	public void sortOrigin() {
		
	}
	
	public void sortGene() {
		System.out.println("Gene");
		
		for(int i = 0; i<collection.size(); i++) {
			System.out.println(i);
			System.out.println(collection.get(i).getGene());
			String gene = collection.get(i).getGene();
			if(gene.equals("DNA")) {
				collection.add(0, collection.get(i));
				collection.remove(i);
			}
		}
		System.out.println(collection);
		for(int i = 0; i<collection.size(); i++) {
//			System.out.println(collection.get(i).getDefinition());
			System.out.println(collection.get(i).getGene());
		}
		
//		boolean searching = true;
//		for(int i = 0; i<collection.size()-1; i++) {
//			int min = i;
//			searching = true;
//			for(int j = i + 1; j<collection.size() && searching; j++) {
//				if(collection.get(j).getGene().compareTo(collection.get(min).getGene()) < 0) {
//					min = j;
//				}
//			}
//			Virus temp = collection.get(i);
//			collection.add(i, collection.get(min));
//			collection.add(min, temp);
//		}
//		for(int i = 0; i<collection.size(); i++) {
////			System.out.println(collection.get(i).getDefinition());
//			System.out.println(collection.get(i).getGene());
//		}
	}
	
	private void printList() {
		for(int i = 0; i<collection.size(); i++) {
			System.out.println("__");
			System.out.println("| " + collection.get(i).getDefinition());
			System.out.println("| " + collection.get(i).getYear());
			System.out.println("| " + collection.get(i).getReference());
			System.out.println("| " + collection.get(i).getGene());
//			System.out.println("| " + collection.g et(i).getOrigin());
			System.out.println("__");
		}
		System.out.println("Post Filter" + collection);
		collection = VirusClient.parse();
		System.out.println("Post Parse" + collection);
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
