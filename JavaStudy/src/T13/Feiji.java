package T13;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Feiji extends JFrame implements Runnable{
	int y;
	public Feiji() {
		super("飞机移动");
		setSize(500, 500);
		new Thread(this).start();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Feiji();
	}
	@Override
	public void paint(Graphics f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/dj.gif");
		f.drawImage(image,100, y, this);
	}
	public void run() {
		while (true) {
			y=100;
			for (int i = 0; i < 50; i++) {
				y=y+10;
				this.repaint();
				this.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
