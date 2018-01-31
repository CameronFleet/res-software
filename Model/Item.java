package Model;

public abstract class Item {

	private String name;
	private int price;
	
	public Item (String name, int price) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
