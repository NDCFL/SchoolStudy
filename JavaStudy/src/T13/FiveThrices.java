package T13;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FiveThrices extends JFrame{
	
	public FiveThrices() {
		setSize(300, 220);
		setContentPane(new Draw());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("奥运五环");
	}
	public static void main(String[] args) {
		//实例函数在被类函数调用的时候是要通过实例化的才可以使用
		new FiveThrices().setVisible(true);
	}
	class Draw extends JPanel{
		private final int WIDTH=80;
		private final int HEIGHT=80;
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.blue);
			g.setFont(new Font("黑体",Font.BOLD,24));
			g.drawString("中国", 20, 60);
			g.drawOval(10, 10,WIDTH, HEIGHT);
			g.setColor(Color.cyan);
			g.drawOval(80, 10, WIDTH, HEIGHT);
			g.setColor(Color.green);
			g.drawOval(150, 10,WIDTH, HEIGHT);
			g.setColor(Color.red);
			g.drawOval(50, 70, WIDTH, HEIGHT);
			g.setColor(Color.white);
			g.drawOval(120, 70, WIDTH, HEIGHT);
		}
	}
}
