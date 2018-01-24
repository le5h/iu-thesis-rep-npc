package rep_sys.Concepts;

import java.util.ArrayList;

public class Quest {
    
    // quest title
    private String title;
    public String title() { return this.title; }
    
    // quest description
    private String description;
    public String description() { return this. description; }
    public void description(String description) { this.description = description; }
    
    // main quest mark
    private boolean primary = false;
    public boolean primary() { return this.primary; }
    public void primary(boolean value) { this.primary = value; }
    
    // state of completion
    private boolean completed;
    public boolean completed() { return this.completed; }
    public Event complete(Agent agent) {
        this.completed = true;
        Event event = new Event(agent);
        event.quest(this);
        event.unforgettable(this.primary);
        event.addCategories(categories);
        return event;
    }
    
    // related categories
    private ArrayList<String> categories = new ArrayList<String>();
    public ArrayList<String> categories() {
        return new ArrayList<String>(this.categories);
    }
    public void addCategory(String category) {
        categories.add(category);
    }
    
    public String toString() {
    	return title + ": " + description;
    }
    
    // constructor
    public Quest(String title) {
        this.title = title;
        this.completed = false;
    }
    
}
