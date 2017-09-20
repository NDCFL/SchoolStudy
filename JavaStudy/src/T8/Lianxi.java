package T8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Lianxi extends JFrame {

	JLabel name;
	Panel south;
	public Lianxi() {
		super("画线");
		setSize(520, 560);
		south  = new Panel();
		name = new  JLabel("五子棋棋盘",JLabel.CENTER);
		name.setFont(new Font("华文行楷",Font.BOLD,44));
		name.setForeground(Color.blue);
		south.add(name);
		add(south,BorderLayout.SOUTH);
		setBackground(Color.lightGray);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		for (int i = 40; i <= 480; i += 40) {
			g.drawLine(40, i, 480, i);
			g.drawLine(i, 40, i, 480);
		}
	}
	public static void main(String[] args) {
		new Lianxi();
	}
}
