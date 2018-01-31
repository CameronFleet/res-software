package Model;

import java.util.HashMap;

public class Order {

	private HashMap<Item, Integer> order;
	private Table table;
	
	public Order(Table table) {
		this.table = table;
		order = new HashMap<Item, Integer>();
	}
	
	public Table getTable() {
		return table;
	}
	
	public HashMap<Item, Integer> getFood() {
		HashMap<Item, Integer> food = new HashMap<Item, Integer>();
		
		for (Item i : order.keySet()) {
			if(i instanceof Food) {
				food.put(i, order.get(i));
			}
		}
		
		return food;
	}
	
	public HashMap<Item, Integer> getDrinks() {
		HashMap<Item, Integer> drinks = new HashMap<Item, Integer>();
		
		for (Item i : order.keySet()) {
			if(i instanceof Drink) {
				drinks.put(i, order.get(i));
			}
		}
		
		return drinks;
	}

	public void addItem (Item item, int quantity) {
		if(order.containsKey(item)) {
			order.put(item, quantity + order.get(item));
		} else {
			order.put(item, quantity);
		}
	}
	
	public void addItem (Item item) {
		if(order.containsKey(item)) {
			order.put(item, order.get(item) +1);
		} else {
			order.put(item, 1);
		}
	}
	
}
