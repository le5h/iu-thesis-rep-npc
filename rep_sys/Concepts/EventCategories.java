package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;


public class EventCategories {
	
	private static ArrayList<String> allCategories = new ArrayList<String>();
	
	private static String add(String category) {
		
		String temp = EventCategories.search(category);
		
		if(temp == null) {
			allCategories.add(category);
			temp = category;
		}
		
		return temp;
		
	}
	
	private static String search(String category) {
		
		String temp = null;
		
		Iterator<String> iter = allCategories.iterator();
		
		while(iter.hasNext()){
			temp = iter.next();
            if(temp.equals(category)) { break; }
            temp = null;
        }
		
		return temp;
		
	}
	
	private ArrayList<String> categories = new ArrayList<String>();
	public ArrayList<String> categories(){
		return this.categories; // TODO: return copy
	}
	public void addCategory(String category) {
		category = EventCategories.add(category);
		categories.add(category); // TODO: check duplicates
	}
	
	// string
	public String toString() {
		return String.join(", ", this.categories) + ".";
	}
	
	// constructor
	public EventCategories() {
		
	}
	
}
