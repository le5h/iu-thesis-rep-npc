package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;

public class EventFlow {

	// all NPCs
	public Network<NPC> community;
	
	// make all interact with closest
	public void interactAll() {
		ArrayList<NPC> members = community.nodes();
		ArrayList<NPC> closest;
		NPC member; Event event;
		Iterator<NPC> all = members.iterator();
        while(all.hasNext()){
        	member = all.next();
        	closest = community.edges(member);
        	event = member.tell();
        	Iterator<NPC> part = closest.iterator();
        	while(part.hasNext()){
        		NPC next = part.next();
        		// transmission probability
        		if(next.tpk(member)) { next.hear(event); }
        	}
        }
	}
	
	// TODO: global mood control
	
	// constructor
	public EventFlow(Network<NPC> community) {
		this.community = community;
	}
	
}
