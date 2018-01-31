package KitchenApplication;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

import JavaRMI.Order;
/*
 * Orders are pinned on the Wall. 
 */
public class WallPanel extends JPanel {
	private LinkedList<OrderPanel> queue;

	public WallPanel() {
		this.setBackground(Color.GRAY);
		queue = new LinkedList<OrderPanel>();
	}
	
	public void addOrder(Order o) {
		
		OrderPanel op = new OrderPanel(o , this);
		System.out.println(o.getFood().size());
		queue.add(op);
		new Thread(op).start();
		this.add(op);
		repaint();
		
	}
	
	public void removeOrder(OrderPanel op) {
		this.remove(op);
		queue.remove(op);
		this.repaint();
	}
}
