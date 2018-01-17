package rep_sys.Concepts;

public class Player extends Agent {
	
	// primitive health (just for fun)
	volatile private Integer health = 100;
	public boolean isDead() { return this.health <= 0; }
	public int health() { return this.health; }
	public void affect(int shift) { this.health += shift; }
	
	// constructor
	public Player(String name) {
		super(name);
	}
	
}
