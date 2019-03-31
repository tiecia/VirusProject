package Regular;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Range {
	private int min;
	private int max;
	
	@SuppressWarnings("resource")
	public static Range parse(String s) {
		Scanner parse = new Scanner(s).useDelimiter("-");
		try {
			return new Range(parse.nextInt(), parse.nextInt());
		} catch(NoSuchElementException e) {
			return null;
		}
	}

	public Range(int min, int max) {
		this.max = max;
		this.min = min;
	}
	
	public boolean contains(int n) {
		if(n<max && n>min) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
	public String toString() {
		return min + "-" + max;
	}
}
