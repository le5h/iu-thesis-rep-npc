package rep_sys;

import rep_sys.Concepts.*;

public class Tests {

	public static void testNPC() {

		NPC npc1 = new NPC("Vasya Pupkin");
		NPC npc2 = new NPC("Olya Zaharova");

		System.out.println(npc1.name() + " " + npc1.id().toString());
		System.out.println(npc2.name() + " " + npc2.id().toString());
		
	}
	
	public static void testEvent() {
		
		Quest quest = new Quest("Find dogo");
		
		Event event = new Event(quest);
		
		event.addCategory("good");
		event.addCategory("dog");
		
		System.out.println(event.categories().toString());
		
	}
	
	public static void runAll() {
		
		Tests.testNPC();
		
		Tests.testEvent();
		
	}
	
}
