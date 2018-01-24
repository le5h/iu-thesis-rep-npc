package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import rep_sys.Generator;
import rep_sys.IO;

public class NPCGenerator extends Generator {
	
	// name source
	public String[] firstNames;
	public String[] lastNames;
	
	// category source
	public String[] categories;
	
	// create random NPC
	public NPC generate() {
		
		// name
		String name = randomString(firstNames) + " " + randomString(lastNames);
		NPC npc = new NPC(name);
		
		// mood
		npc.mood(rand().nextFloat()); // (or) make it global
		// minTrust
		npc.minTrust(rand().nextFloat()); // (or) make it global
		
		// random PLUS
		Queue<String> cats = new LinkedList<String>(Arrays.asList(categories));
		Collections.shuffle((List<String>)cats);
		
		// likes / hates
		int min = 1, max = cats.size() / 2; // (or) make it global
		for(int i = rand(min, max); i > 0; i--) { npc.like(cats.poll()); }
		for(int i = rand(min, max); i > 0; i--) { npc.hate(cats.poll()); }
		
		return npc;
		
	}
	
	public NPCGenerator(String namesPath, String categoriesPath) {
		
		String names[] = IO.lines(namesPath);
		String categories[] = IO.lines(categoriesPath);
		
		this.firstNames = lineItems(names[0]);
		this.lastNames = lineItems(names[1]);
		
		this.categories = lineItems(categories[0]);
		
	}
	
}
