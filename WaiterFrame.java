package WaiterApp;
import java.awt.*;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.*;

import JavaRMI.Client;

public class WaiterFrame extends JFrame {

	public WaiterFrame(String title) throws HeadlessException {
		
		super(title);
		init();
	}


	public void init(){
		
		Client cl = new Client();
		
		this.setSize(800,800);
		
		Container c = this.getContentPane();
		c.setBackground(Color.DARK_GRAY);
		
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		c.setLayout(fl);
		
		Table t = new Table(1,cl);
		Table t2 = new Table(2,cl);
		Table t3 = new Table(3,cl);
		
		c.add(t);
		c.add(t2);
		c.add(t3);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	public static void main(String[] args){
		
		WaiterFrame wf = new WaiterFrame("Waiter");
	}
}
