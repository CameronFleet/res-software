package KitchenApplication;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Item extends JLabel {
	
	private boolean complete;

	public Item(String name, int quantity, int i) {
		super(" " + name + "  :  " + quantity +" ",i);
		complete = false;
		
		this.setFont(new Font("Arial",Font.PLAIN,15));
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Map p = getFont().getAttributes();
				if(!complete) {
					p.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
				} else {
					p.put(TextAttribute.STRIKETHROUGH, false);
				}
				setFont(new Font(p));
				complete = !complete;
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public boolean getComplete() {
		return complete;
	}


}
