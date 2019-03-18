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
		collection = readCollection;
		for(int i = 0; i<collection.size(); i++) {
			Scanner s = new Scanner(collection.get(i).getGene()).useDelimiter("-");
			if(s.hasNext("ss")) {
				s.next();
			}
			String gene = s.next();
			if(gene.equals("DNA")) {
				collection.add(0, collection.get(i));
			} else if (gene.equals("RNA"))
		}
		System.out.println(collection);
	}
}
