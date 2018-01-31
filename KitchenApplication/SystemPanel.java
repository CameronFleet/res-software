package KitchenApplication;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SystemPanel extends JPanel implements Runnable{
	
	private JLabel currentTime;

	public SystemPanel() {
		this.setBackground(Color.YELLOW);
		currentTime = new JLabel();
		currentTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
		this.add(currentTime);
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				currentTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
				this.revalidate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
