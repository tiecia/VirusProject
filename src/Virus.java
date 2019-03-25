public class Virus {
	
	private int year;
	private String definition;
	private int reference;
	private String origin;
	private String gene;
	
	public Virus(int bpCount, String gene, int year, String definition, String origin) {
		this.gene = gene;
		this.year = year;
		this.definition = definition;
		this.origin = origin;
		reference = bpCount;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	public int getReference() {
		return reference;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getGene() {
		return gene;
	}
	
	public String toString() {
		return definition;
	}
	
	public String printVirus() {
		return "Definition: " + definition + "\n\n" +
				"Year Discovered: " + year + "\n" + 
				"Gene: " + gene + "\n" +
				"Reference: " + reference + "\n\n" + 
				"Origin: " + "\n" + origin;
				
	}
}
