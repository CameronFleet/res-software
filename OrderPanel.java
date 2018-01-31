package KitchenApplication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import JavaRMI.Order;

public class OrderPanel extends JPanel implements Runnable{

	private Order order;
	private JLabel tableNumber;
	private JPanel orderInformation;
	private ArrayList<Item> items;
	private WallPanel wall;
	private long creationTime;
	
	public OrderPanel(Order order, WallPanel wall) {
		this.order = order;
		this.wall = wall;
		items = new ArrayList<Item>();
		creationTime = System.currentTimeMillis();
		
		
		tableNumber = new JLabel("" + order.getTableNum() , JLabel.CENTER);
		tableNumber.setFont(new Font("Arial", Font.BOLD, 25));
		tableNumber.setPreferredSize(new Dimension(100,50));

		
		orderInformation = new JPanel();
		orderInformation.setLayout(new GridLayout(order.getFood().size(),1));
		orderInformation.setBackground(Color.GREEN);
		for (String s : order.getFood().keySet()) {
			items.add(new Item(s, order.getFood().get(s), JLabel.CENTER));
		}
		
		for(Item item : items) {
			orderInformation.add(item);
		}
	
		
		this.setBackground(Color.GREEN);
		this.setLayout(new BorderLayout());
		
		this.add(tableNumber, BorderLayout.NORTH);
		this.add(orderInformation, BorderLayout.CENTER);
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(System.currentTimeMillis() - creationTime > 50000) {
				this.setBackground(Color.RED);
				orderInformation.setBackground(Color.RED);
			} else if (System.currentTimeMillis() - creationTime > 10000) {
				this.setBackground(Color.ORANGE);
				orderInformation.setBackground(Color.ORANGE);
			} else {
				this.setBackground(Color.GREEN);
				orderInformation.setBackground(Color.GREEN);
			}
			
			boolean isComplete = true; 
			for (Item i : items) {
				if(!i.getComplete()) {
					isComplete = false;
				}
			}
			
			if(isComplete) {
				this.setBackground(Color.MAGENTA);
				orderInformation.setBackground(Color.MAGENTA);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				boolean confirm = true; 
				for (Item i : items) {
					if(!i.getComplete()) {
						confirm = false;
					}
				}
				if(confirm) {
					wall.removeOrder(this);
				} 
			}
			
			
		}
		
	}

}
