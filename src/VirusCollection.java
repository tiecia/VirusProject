import java.util.ArrayList;
import java.util.Scanner;

public class VirusCollection {
	
	public final ArrayList<Virus> readCollection;
	
	public ArrayList<Virus> collection;
	
	public VirusCollection(ArrayList<Virus> collection) {
		readCollection = collection;
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
		collection = readCollection;
		for(int i = 0; i<collection.size(); i++) {
			if(s.equals("DNA") && collection.get(i).getGene().equals("RNA")) {
				collection.remove(i);
				i--;
			} else if(s.equals("RNA") && collection.get(i).getGene().equals("DNA")) {
				collection.remove(i);
				i--;
			}
		}
		for(int i = 0; i<collection.size(); i++) {
//			System.out.println(collection.get(i).getDefinition());
			System.out.println(collection.get(i).getGene());
		}
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
		collection = readCollection;
		
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
}
