package KitchenApplication;
import javax.swing.*;

import JavaRMI.Order;
import JavaRMI.Server;

import java.awt.*;

public class KitchenClient extends JFrame{

	private WallPanel wp;
	private SystemPanel sp;
	public void init() { 
		this.setSize(1024,720);
		this.setTitle("Kitchen Application");
		
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		/*** PANEL INITALIASATION ***/
		wp = new WallPanel();
		sp = new SystemPanel();
		
		c.add(wp, BorderLayout.CENTER);
		c.add(sp, BorderLayout.NORTH);
		
		/*** THREAD INITALISATION ***/
		Thread t = new Thread(sp);
		t.start();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void addOrder(Order o) {
		wp.addOrder(o);
	}
	
	public static void main(String[] args) {
		KitchenClient kc = new KitchenClient();
		kc.init();
		Server s = new Server(kc);
		s.start();
	}
}
