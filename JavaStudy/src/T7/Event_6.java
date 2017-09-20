package T7;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Event_6 extends JFrame {

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Button black = new Button("黑色");
	Button white = new Button("白色");
	Button pink = new Button("粉色");

	public Event_6() {
		setTitle("黑白切换");
		// 创建实例
		setSize(300, 300);
		this.setLayout(new BorderLayout());
		Action a = new Action(); 
		white.addActionListener(a);
		black.addActionListener(a);
		pink.addActionListener(a);
		p1.add(black);
		p1.add(white);
		p1.add(pink);
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
	
			if (e.getSource() == white) {
				p2.setBackground(Color.WHITE);
			} else if (e.getSource() == black) {
				p2.setBackground(Color.BLACK);
			} else if (e.getSource() == pink) {
				p2.setBackground(Color.pink);
			}
		}
	}

	public static void main(String[] args) {
		new Event_6();
	}
}
