package rep_sys.Concepts;

public class WorldTime {
	
	// time in concrete units
	 private static volatile long absoluteTime = 0;
	
	// return current time
	public static long current() {
		return WorldTime.absoluteTime;
	}
	
	// set current time (initial / cheat)
	public static void set(long time) {
		WorldTime.absoluteTime = time;
	}
	
	// increase time
	public static void tick() { WorldTime.shift(1); }
	public static void shift(long amount) {
		WorldTime.absoluteTime += amount;
	}
	
	// TODO: abstract units (days, hours, minutes, etc).
	
}
