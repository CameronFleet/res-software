package JavaRMI;
import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tableNum;
	private HashMap<String, Integer> drinks, food;
	
	public Order(int tableNum) {
		
		this.tableNum = tableNum;
		
		drinks = new HashMap<String, Integer>();
		food = new HashMap<String, Integer>();	
	}

	public void addFood(String s, Integer i){
		food.put(s, i);
	}

	public void addDrink(String text, int value) {
		drinks.put(text, value);
		
	}
	
	public int getTableNum(){
		return tableNum;
	}
	
	public HashMap<String, Integer> getFood(){
		return food;
	}
	
	public HashMap<String, Integer> getDrinks(){
		return drinks;
	}
}
