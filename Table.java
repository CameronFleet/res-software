package WaiterApp;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.*;

import JavaRMI.Client;

public class Table extends JPanel {

	private Integer number;
	private boolean isOccupied;

	private Client c;
	
	public Table(Integer number, Client c) throws HeadlessException {
		
		this.c = c;
		this.number = number;
		isOccupied = false;
		
		this.add(new JLabel(number.toString()));
		
		this.setPreferredSize(new Dimension(90,90));
		this.setBackground(Color.green);
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				isOccupied = true;
				
				setBackground(Color.RED);
				
				OrderFrame o = new OrderFrame(getNumber(), c);
				o.init();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	

	public Integer getNumber(){
		return number;
	}
	


}
