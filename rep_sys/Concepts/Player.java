package rep_sys.Concepts;

public class Player extends Agent {
    
	public static String defaultName = "Unnamed";
	
    // TODO: all players list
    
    // constructor
    public Player() { this(defaultName); }
    public Player(String name) {
        super(name);
    }
    
}
