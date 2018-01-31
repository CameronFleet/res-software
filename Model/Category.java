package Model;

import java.util.ArrayList;

public class Category {

	private ArrayList<Item> items;
	
	public Category() {
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public void removeItem(Item i) {
		items.remove(i);
	}
	
	public boolean containsItem(Item i) {
		if(items.contains(i)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsItem(String s) {
		for(Item i : items) {
			if(i.getName().equals(s)) {
				return true;
			}
		}
		
		return false;
	}
}
