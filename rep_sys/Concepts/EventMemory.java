package rep_sys.Concepts;

public class EventMemory {
    
    // event memorized
    private Event event;
    public Event event() { return this.event; }
    
    // memorized time
    private long timestamp;
    public long timestamp() { return this.timestamp; }
    public void timestamp(long timestamp) { this.timestamp = timestamp; }
    
    // decay function
    public long decayTime = 1000; // memory ability
    public float deacy() {
        return 1 - ((WorldTime.current() - timestamp()) / this.decayTime);
    }
    
    // location
    public int locationX, locationY;
    
    // value function
    public float value = 0.0f;
    public float value(NPC npc) {
        this.value = this.deacy() * ((npc.likes(this.event) - npc.hates(this.event)) * this.event.weight());
        return this.value;
    }
    
    public EventMemory(Event event) {
        this.event = event;
        timestamp = WorldTime.current();
    }
    
}
