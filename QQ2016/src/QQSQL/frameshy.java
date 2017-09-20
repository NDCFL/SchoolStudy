package QQSQL;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

public class frameshy {
	public frameshy() {
		Frame frame = new Frame();
		MyPanel panel = new MyPanel();
		frame.add(panel);
		frame.setBackground(Color.black);
		frame.setUndecorated(true);
		frame.setSize(800, 700);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(false);
	}
	public static void main(String[] args) {
		new frameshy();
	}
class MyPanel extends Panel {
	public void paint(Graphics g) {
		g.setColor(Color.white);
		Random random = new Random();
		for (int i = 0; i < 300; i++) {
			int x = random.nextInt(800);
			int y = random.nextInt(700);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			g.drawString("*", x, y);
		}
		g.fillOval(660, 60, 100, 100);
		g.setColor(Color.black);
		g.fillOval(640, 80, 100, 100);
	}
}
}
