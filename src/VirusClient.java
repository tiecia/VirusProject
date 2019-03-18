import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VirusClient {

	public static void main(String[] args) throws FileNotFoundException {
		File[] dirFiles = new File("files/").listFiles();
		ArrayList<Virus> vArray = new ArrayList<Virus>();
		for(int i = 0; i<dirFiles.length; i++) {
			Scanner parse = new Scanner(dirFiles[i]);
			parse.next();
			parse.next();
			int bp = parse.nextInt();
			parse.next();
			String gene = parse.next();
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
			parse = new Scanner(dirFiles[i]).useDelimiter("ORIGIN");
			parse.next();
			String origin = parse.next();
			parse = new Scanner(origin).useDelimiter("//");
			origin = parse.next();
//			System.out.println(def);
//			System.out.println(bp);
//			System.out.println(gene);
//			System.out.println(year);
//			System.out.println(origin);
			vArray.add(new Virus(bp, gene, year, def, origin));
			System.out.println(vArray.toString());
			
		}
		
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
			enterCommand();
			
			Scanner s = new Scanner(System.in);
			String input = s.next();
			
			if(input.equals("list")) {
				
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
				for(int i = 0; i<dirFiles.length; i++) {
					System.out.println(dirFiles[i].getName());
				}
				System.out.println();
			} else if(input.equals("help")) {
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
				System.out.println();
				System.out.println();
			} else if(input.equals("Sort")) {
				input = s.next();
				if(input.equals("DNA")) {
					
				} else if (input.equals("RNA")) {
					
				}
			}
		}
	}
	
	public static void enterCommand() {
		System.out.println("Enter Command(Type 'help' for a list of commands): ");
	}
}