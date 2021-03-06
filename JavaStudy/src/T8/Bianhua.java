package T8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bianhua extends JFrame{

	JPanel p1,p2;
	JButton fang,yuan,f,y;
	public Bianhua() {
		super("方圆转换");
		setSize(500, 500);
		fang = new JButton("变方");
		yuan = new JButton("变圆");
		p1 = new JPanel();
		p2 = new JPanel();
		y = new JButton("圆");
		f = new JButton("方");
		p1.add(fang);
		p1.add(yuan);
		p2.add(y);
		p2.add(f);
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		setBackground(Color.cyan);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Bianhua();
	}
	@Override
	public void paint(Graphics g) {
		g.drawArc(100, 100, 100, 100, 360, 360);
		g.drawRect(200, 200, 100, 100);
	}
}
