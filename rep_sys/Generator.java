package rep_sys;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

	// random
	private static Random rand = new Random();
	
	public static Random rand() {
		return rand;
	}
	
	public static int rand(int from, int to) {
		return rand.nextInt((to - from)) + from;
	}
	
	// random string from array
	public static String randomString(ArrayList<String> list) {
		if(list == null) return "";
		return list.get(rand(0, list.size()-1));
	}
	
	public static String randomString(String[] list) {
		if(list == null) return "";
		return list[rand(0, list.length-1)];
	}
	
	public static String[] lineItems(String line) {
		return line.split("[|]");
	}
	
}
