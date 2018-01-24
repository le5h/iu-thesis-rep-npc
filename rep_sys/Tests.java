package rep_sys;

import java.util.ArrayList;

import rep_sys.Concepts.*;

public class Tests {
	
	public static void testing(String title) { Logger.log("=== testing " + title + " ==="); }
    
    public static void runAll() {
        
        testEventQuest();
        
        testNPC();
        
        testNPCgen();
        
        testNetwork();
        
    }
    
    public static void testEventQuest() {
        
    	testing("Quest");
    	
    	Quest quest = new Quest("Create prototype");
    	quest.description("Do it accurately, do not drop out.");
    	quest.primary(true);
        quest.addCategory("Important");
        quest.addCategory("Thesis");
        
        Logger.log(quest.toString());
    	Logger.log(quest.categories().toString());
    	Logger.log("Main quest: "+quest.primary());
        
    	testing("Player");
    	
    	Player player = new Player("AlexY");
    	player.affect(-95); // close to death
    	
    	testing("Event");
    	
        Event event = quest.complete(player);
        Logger.log(event.agent().name() + " (" + event.agent().health() + " hp)");
        Logger.log(event.quest().title());
        Logger.log(event.categories().toString());
        
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
        Logger.log("NPC1 (likes): " + npc1.likes());
        Logger.log("Trust 1-2: " + Float.toString(npc1.trust(npc2)));
        
        // some changes
        npc1.like("Music");
        npc2.like("Music");
        
        // new trust
        Logger.log("NPC1 (likes): " + npc1.likes());
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
        
        // let memory be remembered
        WorldTime.tick();
        
        Logger.log("Top Event Cats: " + npc1.tell().categories().toString());
        
        testing("NPC.tell (topValue)");
        
        // memory value
        Logger.log("Top Value (as is): " + npc1.topValue().value(npc1));
        
        // some changes
        event.addCategory("Dog");
        
        // memory value new
        Logger.log("Top Value (more hates): " + npc1.topValue().value(npc1));
        
        // some changes
        npc1.like("Tree");
        npc1.like("Magic");
        
        // memory value new
        Logger.log("Top Value (more likes): " + npc1.topValue().value(npc1));
        
        testing("NPC.reputation");
        
        // reputation
        Logger.log("Reputatuon: " + npc1.reputation(player));
        
        // some changes
        event.removeCategory("Tree");

        // reputation new
        Logger.log("Reputatuon: " + Float.toString(npc1.reputation(player)));
        
    }
    
    public static void testNPCgen() {
    	
    	testing("NPC Generator");
    	
    	String root = "gen_data/";
    	
    	NPCGenerator generator = new NPCGenerator((root + "names.txt"), (root + "categories.txt"));
    	
    	//ArrayList<NPC> crowd = new ArrayList<NPC>();
    	
    	Network<NPC> gossips = new Network<NPC>();
    	
    	for(int i=0; i<10; i++) {

    		NPC npc = generator.generate();
    		
        	// crowd.add(npc);
        	
        	gossips.add(npc);
        	
        	Logger.log("Name: " + npc.name());
        	Logger.log("Likes: " + npc.likes());
        	Logger.log("Hates: " + npc.hates());
        	
        	Logger.log("-----");
        	
    	}
    	
    	testing("Network");
    	
    	gossips.makeConnected();
    	
    	testing("EventFlow");
    	
    	EventFlow flow = new EventFlow(gossips);
    	
    	flow.interactAll();
    	
    }
    
    public static void testNetwork() {
    	
    	testing("Network");
    	
    	Network<NPC> gossips = new Network<NPC>();
    	
    	// create some NPCs
        NPC npc1 = new NPC("Vasya Pupkin");
        NPC npc2 = new NPC("Olya Zaharova");
    	
    	Logger.log("Add NPC1: " + gossips.add(npc1));
    	Logger.log("Add NPC2: " + gossips.add(npc2));
    	
    	Logger.log("Connect NPC1 and NPC2: " + gossips.connect(npc1, npc2));
    	
    }
    
}
