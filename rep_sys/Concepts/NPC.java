package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class NPC extends Agent {
    
    // TODO: all NPCs list
    
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
    private Categories likes = new Categories();
    public void like(String category) { likes.addCategory(category); }
    public String likes() { return likes.toString(); }
    public float likes(Event event) {
        return cross(likes.list(), event.categories());
    }
    
    // dislikes
    private Categories hates = new Categories();
    public void hate(String category) { hates.addCategory(category); }
    public String hates() { return hates.toString(); }
    public float hates(Event event) {
        return cross(hates.list(), event.categories());
    }
    
    // TODO: unlike / unhate
    
    // mood
    private float mood = 1.0f;
    public float mood() { return this.mood; }
    public void mood(float mood) { this.mood = mood; }
    
    // minimum trust level
    private float minTrust = 0.5f;
    public float minTrust() { return this.minTrust; }
    public void minTrust(float value) { this.minTrust = value; }
    
    // trust (transmission probability)
    public float trust(NPC a, NPC b) {
    	float aCats = a.likes.list().size() +  a.hates.list().size();
    	float bCats = b.likes.list().size() +  b.hates.list().size();
    	float bothLikes = (float) cross(a.likes.list(),b.likes.list());
    	float bothHates = (float) cross(a.hates.list(),b.hates.list());
    	return a.mood() * ( (bothLikes + bothHates) / (aCats + bCats) + a.minTrust());
    }
    public float trust(NPC that) { return trust(this, that); }
    
    // memories
    private ArrayList<EventMemory> memories = new ArrayList<EventMemory>();
    
    // top memory by value
    public EventMemory topValue() {
    	EventMemory memory = null;
		Iterator<EventMemory> iter = memories.iterator();
        float max = Float.NEGATIVE_INFINITY;
        while(iter.hasNext()){
        	EventMemory temp = iter.next();
            if((temp.timestamp() < WorldTime.current())) { // only old memories (is it correct?)
            	float val = temp.value(this);
            	if(val > max) {
            		memory = temp;
            		max = val;
            	}
            }
        }
        return memory;
    }
    
    // share top memory
    public Event tell() {
    	EventMemory top = topValue();
    	return top == null? null : top.event();
    }
    
    // hear about
    public void hear(Event event) {
    	if(event == null) return;
    	// TODO: check trust before add
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
    
    // transmission probability of knowledge
    public boolean tpk(NPC that) {
    	float random = (float) Math.random();
    	return this.trust(that) >= random;
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
