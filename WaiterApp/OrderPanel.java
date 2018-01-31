package WaiterApp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import JavaRMI.Client;
import JavaRMI.Order;

public class OrderPanel extends JPanel {
		
	private int table;
	private Order o;
	private Client c;
	
	private JPanel orderContent, meal;
	
	public OrderPanel(int table, Client c) {

		this.c = c;
		o = new Order(table);
		this.table = table;
		this.setBackground(Color.LIGHT_GRAY);
		
		
		orderContent = new JPanel();
		meal = new JPanel();
		
		this.setLayout(new GridLayout(2,1));
		
		init();
	}

	public int getTableNumber() {
		return table;
	}
		
	public void init(){
		
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JScrollPane scroll = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll);
		orderContent.setLayout(new FlowLayout());
		orderContent.setBackground(Color.LIGHT_GRAY);
		
		meal.setLayout(new BoxLayout(meal, BoxLayout.Y_AXIS));
		meal.setBackground(Color.LIGHT_GRAY);
		
		orderContent.add(new JLabel("Table number: " + table));	
		meal.add(new JLabel("Order:"));
		
		
		TitledBorder drinkText = new TitledBorder("Drinks:");
		TitledBorder foodText = new TitledBorder("Food: ");
		
		JPanel drinkP = new JPanel();
		drinkP.setBackground(Color.LIGHT_GRAY);
		drinkP.setLayout(new FlowLayout());
		
		JTextField drinkField = new JTextField(20);
		drinkField.setBorder(drinkText);
		
		SpinnerModel value = new SpinnerNumberModel(1, 0, 100, 1);
		JSpinner qty1 = new JSpinner(value);
		
		JButton addDrink = new JButton("Add drink");
		addDrink.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int value = (Integer) qty1.getValue();
				
				if(!drinkField.getText().equals("")){
					o.addDrink(drinkField.getText(), value);
					meal.add(new JLabel(drinkField.getText() + " quantity: " + value));
					revalidate();
					repaint();
					drinkField.setText("");
					
				}
				
				
			}
			
		});
		
		
		drinkP.add(drinkField);
		drinkP.add(qty1);
		drinkP.add(addDrink);
		orderContent.add(drinkP);
		
		
		JPanel foodP = new JPanel();
		foodP.setBackground(Color.LIGHT_GRAY);
		foodP.setLayout(new FlowLayout());
		
		
		SpinnerModel value1 = new SpinnerNumberModel(1, 0, 100, 1);
		JSpinner qty = new JSpinner(value1);
		
		JTextField foodField = new JTextField(20);
		foodField.setBorder(foodText);
		
		JButton addFood = new JButton("Add food");
		addFood.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int value = (Integer) qty.getValue();
				
				if(!foodField.getText().equals("")){
					
					o.addFood(foodField.getText(), value);
					meal.add(new JLabel(foodField.getText() + " quantity: " + value));
					revalidate();
					repaint();
					foodField.setText("");
				}
				
				
			}
			
		});

		
		foodP.add(foodField);
		foodP.add(qty);
		foodP.add(addFood);

		
		orderContent.add(foodP);
		
		JButton send = new JButton("Send order");
		send.setAlignmentY(CENTER_ALIGNMENT);
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!o.getDrinks().isEmpty() || !o.getFood().isEmpty())
					c.sendOrder(o);
					
				else {
					add(new JLabel("Order is empty"));
				}
				
			}
			
			
		});
		orderContent.add(send);
		
		this.add(orderContent);
		this.add(meal);
	}
	
	
	
	

}
