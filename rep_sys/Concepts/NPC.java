package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class NPC extends Agent {
    
    // TODO: all NPC list
    
    // likes
    public EventCategories likes = new EventCategories();
    public float likes(Event event) {
        // TODO: count intersection
        return 0;
    }
    
    // dislikes
    public EventCategories dislikes = new EventCategories();
    public float hates(Event event) {
        // TODO: count intersection
        return 0;
    }
    
    // memories
    public ArrayList<EventMemory> memories = new ArrayList<EventMemory>();
    
    // top memory by value
    public EventMemory topValue() {
    	EventMemory memory = null;
		Iterator<EventMemory> iter = memories.iterator();
		if(iter.hasNext()) {
			memory = iter.next();
	        float max = memory.value(this);
	        while(iter.hasNext()){
	        	EventMemory temp = iter.next();
	            if(temp.value(this) > max) {
	            	max = temp.value;
	            	memory = temp;
	            }
	        }
        }
        return memory;
    }
    
    // share top memory
    public Event tell() {
        return topValue().event;
    }
    
    // hear about
    public void hear(Event event) {
        // TODO: memorize event or update memory
    }
    
    // reputation of player(s)
    public float reputation(Player player) {
        float min = 0, max = 0, count = 0, sum = 0;
		Iterator<EventMemory> iter = memories.iterator();
        while(iter.hasNext()){
        	EventMemory temp = iter.next();
            if(temp.event().quest().executor().id() == player.id()) {
            	sum += temp.value(this); count++;
            	if(temp.value > max) { max = temp.value; }
            	if(temp.value < min) { min = temp.value; }
            }
        }
        return (((sum / count) + ((min + max) / 2)) - min) / (max - min);
    }
    
    // constructor
    public NPC(String name) {
        super(name);
    }
    
}
