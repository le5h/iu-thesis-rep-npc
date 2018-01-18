package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class NPC extends Agent {
    
    // TODO: all NPC list
    
	// intersection
	private int cross(ArrayList<String> a, ArrayList<String> b) {
		// TODO: count intersections
		return 0;
	}
	
    // likes
    public EventCategories likes = new EventCategories();
    public void like(String category) { likes.addCategory(category); }
    public float likes(Event event) {
        return cross(likes.categories(), event.categories().categories());
    }
    
    // dislikes
    public EventCategories hates = new EventCategories();
    public void hate(String category) { hates.addCategory(category); }
    public float hates(Event event) {
        return cross(hates.categories(), event.categories().categories());
    }
    
    // trust
    public float trust(NPC a, NPC b) {
    	float mood = 1.0f, min = 0.1f; // TODO: bring outside
    	float aCats = a.likes.categories().size() +  a.hates.categories().size();
    	float bCats = b.likes.categories().size() +  b.hates.categories().size();
    	float bothLikes = cross(a.likes.categories(),b.likes.categories());
    	float bothHates = cross(a.hates.categories(),b.hates.categories());
    	return mood * ( (bothLikes + bothHates) / (aCats + bCats) + min);
    }
    
    public float trust(NPC that) { return trust(this, that); }
    
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
            if(temp.event().agent().id() == player.id()) {
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
