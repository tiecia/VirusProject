import java.io.File;

public class VirusClient {

	public static void main(String[] args) {
		File[] dirFiles = new File("files/").listFiles();
		System.out.println("|------------|");
		System.out.println("|Files Loaded|");
		System.out.println("|------------|");
		for(int i = 0; i<dirFiles.length; i++) {
			System.out.println(dirFiles[i].getName());
		}
	}
}