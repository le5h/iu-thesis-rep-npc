package rep_sys;

import rep_sys.Concepts.*;

public class Tests {
	
	public static void testing(String title) { Logger.log("=== testing " + title + " ==="); }
    
    public static void runAll() {
        
        testEvent();
        
        testNPC();
        
    }
	
    public static void testNPC() {
    	
    	testing("NPC.id");

    	// create some NPCs
        NPC npc1 = new NPC("Vasya Pupkin");
        NPC npc2 = new NPC("Olya Zaharova");

        // check ID
        Logger.log(npc1.name() + " " + npc1.id().toString());
        Logger.log(npc2.name() + " " + npc2.id().toString());
        
        testing("NPC.trust (like/hate)");
        
        // add liked categories
        npc1.like("Cat");
        npc2.like("Dog");
        
        // add hated categories
        npc1.hate("Dog");
        npc2.hate("Cat");
        
        // trust
        Logger.log("NPC1 (likes): " + npc1.likes.toString());
        Logger.log("Trust 1-2: " + Float.toString(npc1.trust(npc2)));
        
        // some changes
        npc1.like("Music");
        npc2.like("Music");
        
        // new trust
        Logger.log("NPC1 (likes): " + npc1.likes.toString());
        Logger.log("Trust 1-2: " + Float.toString(npc1.trust(npc2)));
        
        testing("NPC.mood");
        
        // back trust
        Logger.log("NPC2 (mood): " + Float.toString(npc2.mood()));
        Logger.log("Trust 2-1: " + Float.toString(npc2.trust(npc1)));
        
        // some changes
        npc2.mood(0.5f);
        
        // back trust new
        Logger.log("NPC2 (mood): " + Float.toString(npc2.mood()));
        Logger.log("Trust 2-1: " + Float.toString(npc2.trust(npc1)));
        
        // events
        Player player = new Player();
        Event event = new Event(player);
        event.addCategory("Music");
        event.addCategory("Tree");
        event.addCategory("Magic");
        event.weight(1.0f);
        
        testing("NPC.hear");
        
        // memorize event
        npc1.hear(event);
        
        Logger.log("Top Event Cats: " + npc1.tell().categories().toString());
        
        testing("NPC.tell (topValue)");
        
        // memory value
        Logger.log("Top Value (as is): " + Float.toString(npc1.topValue().value(npc1)));
        
        // some changes
        event.addCategory("Dog");
        
        // memory value new
        Logger.log("Top Value (more hates): " + Float.toString(npc1.topValue().value(npc1)));
        
        // some changes
        npc1.like("Tree");
        npc1.like("Magic");
        
        // memory value new
        Logger.log("Top Value (more likes): " + Float.toString(npc1.topValue().value(npc1)));
        
        testing("NPC.reputation");
        
        // reputation
        Logger.log("Reputatuon: " + npc1.reputation(player));
        
        // some changes
        event.categories().categories().clear();

        // reputation new
        Logger.log("Reputatuon: " + Float.toString(npc1.reputation(player)));
        
    }
    
    public static void testEvent() {
        
    	testing("Event");
    	
    	Quest quest = new Quest("Create prototype.");
    	quest.primary(true);
        quest.addCategory("Important");
        quest.addCategory("Thesis");
        
    	Player player = new Player("AlexY");
    	player.affect(-95); // close to death
    	
        Event event = quest.complete(player);
        Logger.log(event.agent().name() + " (" + event.agent().health() + " hp)");
        Logger.log(event.quest().title());
        Logger.log(event.categories().toString());
        
    }
    
    public static void testQuest() {
    	
    	// TODO: test
    	
    }
    
}
