package rep_sys.Concepts;

public class WorldSpace {
	
	// default world size
	private static int defSize = 128;
	
	// current size
	private int width, height;
	
	// bounds
	public int minX() { return width - (width / 2); }
	public int minY() { return height - (height / 2); }
	public int maxX() { return width / 2; }
	public int maxY() { return height / 2; }
	
	// convert value
	public int convertX(int x){ return x + minX(); }
	public int convertY(int y){ return y + minY(); }
	
	// constructor
	public WorldSpace(int width, int height) { this.width = width; this.height = height; }
	
	public WorldSpace() { this.width = defSize; this.height = defSize; }
	
}
