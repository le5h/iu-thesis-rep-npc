package rep_sys.Concepts;

public class Agent implements WorldObject {

    private static int counter = 0; // we don't need long yet
    
    // unique id
    private Integer id;
    public Integer id(){ return this.id; }
    
    // full name
    private String name;
    public String name(){ return this.name; }
    public void name(String name){ this.name = name; }
    
    // primitive health (just for fun)
    volatile private Integer health = 100;
    public boolean isDead() { return this.health <= 0; }
    public int health() { return this.health; }
    public void affect(int shift) { this.health += shift; }
    
    // position
    private Position position = new Position();
    public Position position() { return position; }
    
    // constructor
    public Agent(String name) {
        Agent.counter++;
        this.id = counter;
        this.name = name;
    }
    
}
