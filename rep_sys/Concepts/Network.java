package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Network<A> {
	
	private HashMap<A, ArrayList<A>> nodes = new HashMap<A, ArrayList<A>>();
	
	// returns all nodes
	public ArrayList<A> nodes(){
		ArrayList<A> list = new ArrayList<A>();
		list.addAll(nodes.keySet());
		return list;
	}
	
	// search node
	public boolean nodeExist(A content) {
		return nodes.containsKey(content);
	}
	
	// neighbours
	public ArrayList<A> edges(A content){
		return new ArrayList<A>(nodes.get(content));
	}
	
	// add node
	public boolean add(A content) {
		if(!nodes.containsKey(content)) {
			nodes.put(content, new ArrayList<A>());
			return true;
		} else {
			return false;
		}
	}
	
	// connect nodes
	public boolean connect(A from, A to) {
		if(from.equals(to)) return true;
		ArrayList<A> edgesFrom = nodes.get(from);
		ArrayList<A> edgesTo = nodes.get(to);
		if((edgesFrom != null) && (edgesTo != null)){
			if(!edgeExist(to, edgesFrom)) edgesFrom.add(to);
			if(!edgeExist(from, edgesTo)) edgesTo.add(from);
			return true;
		} else return false;
	}
	
	// check edge exists (one direction)
	private boolean edgeExist(A edge, ArrayList<A> edges) {
		Iterator<A> iter = edges.iterator();
        while(iter.hasNext()){
        	A temp = iter.next();
            if(temp.equals(edge)) {
            	return true;
            }
        }
		return false;
	}
	
	//
	public void makeConnected() {
		List<A> nodes = nodes();
		Iterator<A> iter = nodes.iterator();
		A caurr = null, prev = null;
		while(iter.hasNext()){
        	A curr = iter.next();
            if(prev != null) { connect(prev, curr); }
            prev = curr;
        }
	}
	
	// constructor
	public Network() { }
	public Network(ArrayList<A> nodes) {
		Iterator<A> iter = nodes.iterator();
        while(iter.hasNext()){
        	A node = iter.next();
            if(!this.nodes.containsKey(node)) {
            	this.nodes.put(node, new ArrayList<A>());
            }
        }
	}
	
}
