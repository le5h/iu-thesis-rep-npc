package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class NPC extends Agent {
    
    // TODO: all NPC list
    
	// intersection
	private int cross(ArrayList<String> a, ArrayList<String> b) {
	    ArrayList<String> result = new ArrayList<String>();
	    a.sort(null); b.sort(null);
	    int i = 0, j = 0;
	    while(i< a.size() && j<b.size()){
		    if (a.get(i).compareTo(b.get(j)) > 0){ j++; }
		    else if (a.get(i).compareTo(b.get(j)) < 0){ i++; }
		    else { result.add(a.get(i));  i++; j++; }
	    }
		return result.size();
	}
	
    // likes
    public EventCategories likes = new EventCategories();
    public void like(String category) { likes.addCategory(category); }
    public float likes(Event event) {
        return (float) cross(likes.categories(), event.categories().categories());
    }
    
    // dislikes
    public EventCategories hates = new EventCategories();
    public void hate(String category) { hates.addCategory(category); }
    public float hates(Event event) {
        return (float) cross(hates.categories(), event.categories().categories());
    }
    
    // mood
    private float mood = 1.0f;
    public float mood() { return this.mood; }
    public void mood(float mood) { this.mood = mood; }
    
    // trust (transmission probability)
    public float minTrust = 0.5f;
    public float trust(NPC a, NPC b) {
    	float aCats = a.likes.categories().size() +  a.hates.categories().size();
    	float bCats = b.likes.categories().size() +  b.hates.categories().size();
    	float bothLikes = (float) cross(a.likes.categories(),b.likes.categories());
    	float bothHates = (float) cross(a.hates.categories(),b.hates.categories());
    	return a.mood() * ( (bothLikes + bothHates) / (aCats + bCats) + a.minTrust);
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
    public Event tell() { return topValue().event(); }
    
    // hear about
    public void hear(Event event) {
    	Iterator<EventMemory> iter = memories.iterator();
        while(iter.hasNext()){
        	EventMemory temp = iter.next();
            if(temp.event().equals(event)) {
            	// update memory
            	temp.timestamp(WorldTime.current());
            	return;
            }
        }
        memories.add(new EventMemory(event));
    }
    
    // reputation of player(s)
    public float reputation(Agent agent) {
        // float min = 0f, max = 0f, count = 0f;
        float sum = 0f;
		Iterator<EventMemory> iter = memories.iterator();
        while(iter.hasNext()){
        	EventMemory temp = iter.next();
            if(temp.event().agent().id() == agent.id()) {
            	sum += temp.value(this); // count++;
            	// if(temp.value > max) { max = temp.value; }
            	// if(temp.value < min) { min = temp.value; }
            }
        }
        float result = sum; // TODO: output range to -1..1 (normalize)
        return result;
    }
    
    // constructor
    public NPC(String name) {
        super(name);
    }
    
}
