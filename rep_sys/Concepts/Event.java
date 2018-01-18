package rep_sys.Concepts;

import java.util.ArrayList;

public class Event {
    
	// TODO: counter of whom who remember
	
    // all events created
    private static ArrayList<Event> events = new ArrayList<Event>();
    // TODO: delete unused
    
    // related categories
    private EventCategories categories = new EventCategories();
    public EventCategories categories() {
        return this.categories; // TODO: copy list (or replace method)
    }
    public void addCategory(String category) {
        categories.addCategory(category);
    }
    
    // link to quest
    private Quest quest;
    public Quest quest() { return this.quest; }
    
    // is event unforgettable
    private boolean unforgettable = false;
    public boolean unforgettable() { return this.unforgettable; }
    
    // event weight
    private float weight = 0.5f; // 0 .. 1
    public float weight() { return weight; }
    public void weight(Float weight) { this.weight = weight; }
    
    // constructor
    public Event(Quest quest) {
        events.add(this);
        this.quest = quest;
    }
    
    public Event(Quest quest, boolean unforgetable) {
        this(quest);
        this.unforgettable = unforgetable;
    }
    
}
