package Regular;
import java.util.ArrayList;

public class VirusCollection {
	
	public ArrayList<Virus> collection;
	
	public VirusCollection(ArrayList<Virus> collection) {
		this.collection = collection;
	}
	
	/*
	 * 
	 * FILTERING
	 * 
	 */
	
	//DEFINITION CHAR
	public ArrayList<Virus> filterDefinition(char s) {
		collection = VirusClient.parse();
		for(int i = 0; i<collection.size(); i++) {
			if(collection.get(i).getDefinition().toLowerCase().charAt(0) != s) {
				collection.remove(i);
				i--;
			}
		}
		printList();
		return collection;
	}
	
	//DEFINITION STRING
	public ArrayList<Virus> filterDefinition(String s) {
		collection = VirusClient.parse();
		for(int i = 0; i<collection.size(); i++) {
			if(!collection.get(i).getDefinition().toLowerCase().contains(s)) {
				collection.remove(i);
				i--;
			}
		}
		printList();
		return collection;
	}
	
	//REFERENCE
	public ArrayList<Virus> filterReference(Range r) {
		collection = VirusClient.parse();
		for(int i = 0; i<collection.size(); i++) {
			if(!r.contains(collection.get(i).getReference())) {
				collection.remove(i);
				i--;
			}
		}
		printList();
		return collection;
	}
	
	//ORIGIN
	public ArrayList<Virus> filterOrigin(String s) {
		collection = VirusClient.parse();
		for(int i = 0; i<collection.size(); i++) {
			if(!collection.get(i).getParsedOrigin().contains(s)) {
				collection.remove(i);
				i--;
			}
		}
		printList();
		return collection;
	}
	
	//YEAR
	public ArrayList<Virus> filterYear(Range r) {
		collection = VirusClient.parse();
		for(int i = 0; i<collection.size(); i++) {
			if(!r.contains(collection.get(i).getYear())) {
				collection.remove(i);
				i--;
			}
		}
		printList();
		return collection;
	}
	
	//GENE
	public ArrayList<Virus> filterGene(String s) {
		collection = VirusClient.parse();
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
		return collection;
	}
	
	
	
	/*
	 * 
	 * SORTING
	 * 
	 */
	
	//DEFINITION
	public ArrayList<Virus> sortDefinition() {
		collection = VirusClient.parse();
		boolean searching = true;
		for(int i = 0; i<collection.size()-1; i++) {
			int min = i;
			searching = true;
			for(int j = i + 1; j<collection.size() && searching; j++) {
				if(collection.get(j).getDefinition().compareTo(collection.get(min).getDefinition()) < 0) {
					min = j;
				}
			}
			Virus temp = collection.get(i);
			collection.add(i, collection.get(min));
			collection.remove(i+1);
			collection.add(min, temp);
			collection.remove(min+1);
		}
		printList();
		return collection;
	}
	
	//REFERENCE
	public ArrayList<Virus> sortReference() {
		collection = VirusClient.parse();
		boolean searching = true;
		for(int i = 0; i<collection.size()-1; i++) {
			System.out.println(collection.size());
			int min = i;
			searching = true;
			for(int j = i + 1; j<collection.size() && searching; j++) {
				if(collection.get(j).getReference() < collection.get(min).getReference()) {
					min = j;
				}
			}
			Virus temp = collection.get(i);
			collection.add(i, collection.get(min));
			collection.remove(i+1);
			collection.add(min, temp);
			collection.remove(min+1);
		}
		printList();
		return collection;
	}
	
	//YEAR
	public ArrayList<Virus> sortYear() {
		collection = VirusClient.parse();
		boolean searching = true;
		for(int i = 0; i<collection.size()-1; i++) {
			int min = i;
			searching = true;
			for(int j = i + 1; j<collection.size() && searching; j++) {
				if(collection.get(j).getYear() > collection.get(min).getYear()) {
					min = j;
				}
			}
			Virus temp = collection.get(i);
			collection.add(i, collection.get(min));
			collection.remove(i+1);
			collection.add(min, temp);
			collection.remove(min+1);
		}
		printList();
		return collection;
	}
	
	//ORIGIN
	public ArrayList<Virus> sortOrigin() {
		collection = VirusClient.parse();
		
		boolean searching = true;
		for(int i = 0; i<collection.size()-1; i++) {
			int min = i;
			searching = true;
			for(int j = i + 1; j<collection.size() && searching; j++) {
				if(collection.get(j).getParsedOrigin().compareTo(collection.get(min).getParsedOrigin()) < 0) {
					min = j;
				}
			}
			Virus temp = collection.get(i);
			collection.add(i, collection.get(min));
			collection.remove(i+1);
			collection.add(min, temp);
			collection.remove(min+1);
		}
		printList();
		return collection;
	}
	
	//GENE
	public ArrayList<Virus> sortGene() {
		collection = VirusClient.parse();
		int index = 0;
		for(int i = 0; i<collection.size(); i++) {
			index++;
			String gene = collection.get(index).getGene();
			if(gene.equals("RNA")) {
				collection.add(collection.get(index));
				collection.remove(index);
				index--;
			}
		}
		printList();
		return collection;
	}
	
	
	/*
	 * 
	 * LIST
	 * 
	 */
	
	public void list() {
		collection = VirusClient.parse();
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
	
	
	/*
	 * 
	 * OTHER METHODS
	 * 
	 */
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
	}
}
