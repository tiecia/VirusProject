package Regular;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VirusClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Virus> vArray = parse();
		VirusCollection vcollection = new VirusCollection(vArray);
		
		boolean running = true;
		
		System.out.println(" __      ___                  _____        _        _                    \r\n" + 
				" \\ \\    / (_)                |  __ \\      | |      | |                   \r\n" + 
				"  \\ \\  / / _ _ __ _   _ ___  | |  | | __ _| |_ __ _| |__   __ _ ___  ___ \r\n" + 
				"   \\ \\/ / | | '__| | | / __| | |  | |/ _` | __/ _` | '_ \\ / _` / __|/ _ \\\r\n" + 
				"    \\  /  | | |  | |_| \\__ \\ | |__| | (_| | || (_| | |_) | (_| \\__ \\  __/\r\n" + 
				"     \\/   |_|_|   \\__,_|___/ |_____/ \\__,_|\\__\\__,_|_.__/ \\__,_|___/\\___|\r\n" + 
				"                                                                         \r\n" + 
				"                                                                         ");
		
		System.out.println();
		
		

		
		while(running) {
			System.out.println();
			enterCommand();
			
			Scanner s = new Scanner(System.in);
			String input = s.next();
			
			if(input.equals("list")) {
				vcollection.list();
			} else if(input.toLowerCase().equals("help")) {
				System.out.println();
				System.out.println();
				System.out.println("888    888          888              \r\n" + 
						"888    888          888              \r\n" + 
						"888    888          888              \r\n" + 
						"8888888888  .d88b.  888 88888b.  d8b \r\n" + 
						"888    888 d8P  Y8b 888 888 \"88b Y8P \r\n" + 
						"888    888 88888888 888 888  888     \r\n" + 
						"888    888 Y8b.     888 888 d88P d8b \r\n" + 
						"888    888  \"Y8888  888 88888P\"  Y8P \r\n" + 
						"                        888          \r\n" + 
						"                        888          \r\n" + 
						"                        888          \r\n" + 
						"                                                 \r\n" + 
						"888888 888888 888888 888888 888888\r\n");
				System.out.println();
				System.out.println("list: lists all files in directory.");
				System.out.println("filter [gene, definition, reference, year, origin] <data>: filters the list by the spesified <data>, where <data> can be a single value or range depending on the field.");
				System.out.println("sort [gene, definition, reference, year, origin]: sorts by the spesified field.");
				System.out.println();
				System.out.println();
			//SORT
			} else if(input.toLowerCase().equals("sort")) {
				input = s.next();
				//GENE
				if(input.toLowerCase().equals("gene")) {
					vcollection.sortGene();
				//DEFINITION
				} else if(input.toLowerCase().equals("definition")) {
					vcollection.sortDefinition();
				//REFERENCE
				} else if(input.toLowerCase().equals("reference")){
					vcollection.sortReference();
				//YEAR
				} else if(input.toLowerCase().equals("year")){
					vcollection.sortYear();
				//ORIGIN
				} else if(input.toLowerCase().equals("origin")) {
					vcollection.sortOrigin();
				//INVALID INPUT
				} else {
					System.out.println("Invalid Input: Sort Type");
				}

			//FILTER
			} else if(input.toLowerCase().equals("filter")) {
				input = s.next();
				//GENE
				if(input.toLowerCase().equals("gene")) {
					input = s.next();
					if(input.toLowerCase().equals("dna")) {
						vcollection.filterGene("DNA");
					} else if(input.toLowerCase().equals("rna")) {
						vcollection.filterGene("RNA");
					} else {
						System.out.println("Invalid Input: Gene Type");
					}
				//DEFINITION
				} else if(input.toLowerCase().equals("definition")) {
					input = s.next().toLowerCase();
					if(input.length() == 1) {
						vcollection.filterDefinition(input.charAt(0));
					} else {
						vcollection.filterDefinition(input);
					}
				//REFERENCE
				} else if(input.toLowerCase().equals("reference")) {
					Range r = Range.parse(s.next());
					if(r==null) {
						System.out.println("Invalid Input: Reference Range");
					} else {
						vcollection.filterReference(r);
					}
				//YEAR
				} else if(input.toLowerCase().equals("year")) {
					Range r = Range.parse(s.next());
					if(r==null) {
						System.out.println("Invalid Input: Date Range");
					} else {
						vcollection.filterYear(r);
					}
				//ORIGIN
				} else if(input.toLowerCase().equals("origin")) {
					vcollection.filterOrigin(s.next().toLowerCase());
				//INVALID INPUT
				} else {
					System.out.println("Invalid Input: Filter Type");
				}
			//INVALID INPUT
			} else {
				System.out.println("Invalid Input");
			}
			
		}
	}
	
	public static void enterCommand() {
		System.out.println("Enter Command(Type 'help' for a list of commands): ");
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<Virus> parse() {
		File[] dirFiles = new File("files/").listFiles();
		ArrayList<Virus> array = new ArrayList<Virus>();
		for(int i = 0; i<dirFiles.length; i++) {
			Scanner parse = null;
			try {
				parse = new Scanner(dirFiles[i]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			parse.next();
			parse.next();
			int bp = parse.nextInt();
			parse.next();
			String gene = parse.next();
			if(gene.contains("DNA")) {
				gene = "DNA";
			} else if(gene.contains("RNA")) {
				gene = "RNA";
			}
			parse.next();
			parse.next();
			String dateLine = parse.next();
			Scanner dateParse = new Scanner(dateLine).useDelimiter("-");
			dateParse.next();
			dateParse.next();
			int year = dateParse.nextInt();
			parse.next();
			String def = null;
			while(!parse.hasNext("ACCESSION")) {
				if(def == null) {
					def = parse.next();
				} else {
					def = def + " " + parse.next();
				}
			}
			try {
				parse = new Scanner(dirFiles[i]).useDelimiter("ORIGIN");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			parse.next();
			String origin = parse.next();
			parse = new Scanner(origin).useDelimiter("//");
			origin = parse.next();

			array.add(new Virus(bp, gene, year, def, origin));
		}
		return array;
	}
}