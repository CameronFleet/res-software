package WaiterApp;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import JavaRMI.Client;
public class OrderFrame extends JFrame {

	OrderPanel o;
	Integer num;
	Client c;
	
	public OrderFrame(Integer num, Client c) throws HeadlessException {
		
		this.c = c;
		this.num = num;
		o = new OrderPanel(num, c);
		
//		this.add(o);
		
	}


	public void init(){
		//this.setSize(500, 500);
		
		Container c = this.getContentPane();
		
		c.setLayout(new FlowLayout());
		
		
		
		c.add(o);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
	}
}
