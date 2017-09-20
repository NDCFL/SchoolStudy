package T7;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;


public class Event extends JFrame{
	
	public Event() {
		setTitle("窗口");
		setSize(400, 400);
		setLayout(new GridLayout(2,1));
		Button close = new Button("关闭");
		Button ok = new Button("打开");
		add(close);
		add(ok);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		
		new Event();
	}
}
