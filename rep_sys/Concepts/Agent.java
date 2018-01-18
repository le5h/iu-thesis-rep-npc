package rep_sys.Concepts;

public class Agent {

    private static int counter = 0; // we don't need long yet
    // TODO: use size instead of counter
    
    // unique id
    private Integer id;
    public Integer id(){ return this.id; }
    
    // full name
    private String name;
    public String name(){ return this.name; }
    public void name(String name){ this.name = name; }
    
    // position in two dimensions (for now)
    private int positionX, positionY;
    public int positionX() { return this.positionX; }
    public int positionY() { return this.positionY; }
    public void place(int x, int y) {    this.positionX = x; this.positionY = y; }
    public void move(int x, int y) { this.positionX += x; this.positionY += y; }
    
    // TODO: connections
    
    // constructor
    public Agent(String name) {
        // set id
        Agent.counter++;
        this.id = counter;
        // set name
        this.name = name;
        // set position
        this.positionX = 0;
        this.positionY = 0;
    }
    
}
