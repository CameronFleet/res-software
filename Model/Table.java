package Model;

public class Table {

	public static final int OPEN = 1;
	public static final int OCCUPIED = 2;
	public static final int CLOSED = 3;
	
	private int number;
	private int state;
	
	public Table(int number) {
		this.number = number;
		state = OPEN;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getState() {
		return state;
	}
	
	public boolean isState(int s) {
		if(s == state) {
			return true;
		}
		
		return false;
	}
}
