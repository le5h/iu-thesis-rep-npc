package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class Event {
	
    // all events created
    private static ArrayList<Event> events = new ArrayList<Event>();
    // TODO: delete unused
    
	// TODO: counter of whom who remember this event
    
    // agent id to whom quest assigned
    private Agent agent = null;
    public Agent agent() { return this.agent; }
    
    // related categories
    private EventCategories categories = new EventCategories();
    public EventCategories categories() {
        return this.categories; // TODO: copy list (or replace method)
    }
    public void addCategory(String category) { categories.addCategory(category); }
    public void addCategories(ArrayList<String> categories) {
		Iterator<String> iter = categories.iterator();
        while(iter.hasNext()){ addCategory(iter.next()); }
    }
    
    // link to quest
    private Quest quest;
    public Quest quest() { return this.quest; }
    public void quest(Quest quest) { this.quest = quest; }
    
    // is event unforgettable
    private boolean unforgettable = false;
    public boolean unforgettable() { return this.unforgettable; }
    public void unforgettable(boolean value) { this.unforgettable = value; }
    
    // event weight
    private float weight = 0.5f; // 0 .. 1
    public float weight() { return weight; }
    public void weight(Float weight) { this.weight = weight; }
    
    // constructor
    public Event(Agent agent) {
        events.add(this);
        this.agent = agent;
    }
    
}
