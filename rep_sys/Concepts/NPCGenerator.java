package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Random;

public class NPCGenerator {
	
	// random
	private static Random rand = new Random();
	public static int rand(int from, int to) {
		return rand.nextInt(to - from) + from;
	}
	// random string from array
	public static String randomString(ArrayList<String> list) {
		if(list == null) return "";
		return list.get(rand(0, list.size()-1));
	}
	
	// name source
	public ArrayList<String> namesFirst;
	public ArrayList<String> namesLast;
	
	// category source
	public ArrayList<String> categories;
	
	// create random NPC
	public NPC generate() {
		// name
		String name = randomString(namesFirst) + " " + randomString(namesLast);
		NPC npc = new NPC(name);
		// mood
		npc.mood(rand.nextFloat()); // (or) make it global
		// minTrust
		npc.minTrust(rand.nextFloat()); // (or) make it global
		// likes / hates
		int min = 0, max = 10; // (or) make it global
		for(int i = rand(min, max); i > 0; i--) { npc.like(randomString(categories)); }
		for(int i = rand(min, max); i > 0; i--) { npc.hate(randomString(categories)); }
		return npc;
	}
	
}
