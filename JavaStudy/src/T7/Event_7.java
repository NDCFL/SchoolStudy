package T7;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Event_7 extends JFrame implements ActionListener{

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Button black = new Button("黑色");
	Button white = new Button("白色");
	public Event_7() {
		setTitle("变色窗口");
		setSize(300, 300);
		this.setLayout(new BorderLayout());
		black.addActionListener(this);
		white.addActionListener(this);
		p1.add(white);
		p1.add(black);
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.CENTER);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==black){
			p2.setBackground(Color.BLACK);
			
		}else if (e.getSource()==white) {
			p2.setBackground(Color.white);
			new Event_1();
		}
	}
	public static void main(String[] args) {
		new Event_7();
	}

}
