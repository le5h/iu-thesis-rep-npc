package rep_sys.Concepts;

public class EventMemory {
    
    // event memorized
    public Event event;
    public Event event() {
    	return this.event;
    };
    
    // memorized time
    public long timestamp;
    
    // decay function
    public static long remember = 1000; // time before decay
    public float deacy(long time) {
        return 1 - ((WorldTime.current() - timestamp) / time);
    }
    
    // location
    public int locationX, locationY;
    
    // value function
    public float value = 0.0F;
    public float value(NPC npc) {
        this.value = this.deacy(EventMemory.remember) * ((npc.likes(this.event) - npc.hates(this.event)) * this.event.weight());
        return value;
    }
    
    public EventMemory(Event event) {
        this.event = event;
        timestamp = WorldTime.current();
    }
    
}
