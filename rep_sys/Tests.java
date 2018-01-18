package rep_sys;

import rep_sys.Concepts.*;

public class Tests {

	public static void log(String string) { System.out.println(string); }
	
	public static void testing(String title) { log("=== testing " + title + " ==="); }
    
    public static void runAll() {
        
        testNPC();
        
        testEvent();
        
    }
	
    public static void testNPC() {
    	
    	testing("NPC");

        NPC npc1 = new NPC("Vasya Pupkin");
        NPC npc2 = new NPC("Olya Zaharova");

        log(npc1.name() + " " + npc1.id().toString());
        log(npc2.name() + " " + npc2.id().toString());
        
    }
    
    public static void testEvent() {
        
    	testing("Event");
    	
    	Quest quest = new Quest("Create prototype");
    	quest.primary(true);
        quest.addCategory("Important");
        quest.addCategory("Thesis");
        
    	Player player = new Player("AlexY");
    	player.affect(-95); // close to death
    	
        Event event = quest.complete(player);
        log(event.agent().name() + " (" + event.agent().health() + " hp)");
        log(event.categories().toString());
        
    }
    
}
