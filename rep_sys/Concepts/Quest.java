package rep_sys.Concepts;

public class Quest {
    
    // quest title
    private String title;
    public String title() { return this.title; }
    
    // quest description
    private String description;
    public String description() { return this. description; }
    public void setDescription(String description) { this.description = description; }
    
    // state of completion
    private boolean completed;
    public boolean completed() { return this.completed; }
    public void complete() {
        // TODO: create event
        this.completed = true;
    }
    
    // agent id to whom quest assigned
    private Agent executor = null;
    public Agent executor() { return this.executor; }
    public void assign(Agent character) {
        this.executor = character;
        // TODO: checks
    }
    
    // constructor
    public Quest(String title) {
        this.title = title;
        this.completed = false;
    }
    
}
