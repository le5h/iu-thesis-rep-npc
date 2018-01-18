package rep_sys.Concepts;

public class Position {

    // position in two dimensions (for now)
    protected int positionX, positionY;
    public int x() { return this.positionX; }
    public int y() { return this.positionY; }
    public void place(int x, int y) {    this.positionX = x; this.positionY = y; }
    public void move(int x, int y) { this.positionX += x; this.positionY += y; }
	
    // constructor
    public Position() { this(0,0); }
    public Position(int x, int y) { positionX = x; positionY = y; }
    
}
