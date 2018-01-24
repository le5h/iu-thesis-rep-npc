package rep_sys.Concepts;

import java.util.ArrayList;
import java.util.Iterator;


public class Categories {
    
    private static ArrayList<String> allCategories = new ArrayList<String>();
    
    private static String add(String category) {
        String temp = Categories.search(allCategories, category);
        if(temp == null) {
            allCategories.add(category);
            temp = category;
        }
        return temp;
    }
    
    private static String search(ArrayList<String> list, String category) {
        String temp = null;
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            temp = iter.next();
            if(temp.equals(category)) { break; }
            temp = null;
        }
        return temp;
    }
    
    private ArrayList<String> categories = new ArrayList<String>();
    public ArrayList<String> list(){
        return new ArrayList<String>(this.categories);
    }
    public void addCategory(String category) {
        category = Categories.add(category);
        if(!categories.contains(category)) { categories.add(category); }
    }
    public void removeCategory(String category) {
    	category = search(allCategories, category);
    	if(category != null && categories.contains(category)) {
    		categories.remove(category);
    	}
    }
    
    // list of cats
    public String toString() {
        return String.join(", ", this.categories) + ".";
    }
    
    // constructor
    public Categories() { }
    
}
