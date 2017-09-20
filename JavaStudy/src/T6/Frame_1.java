package T6;

import java.awt.Color;

import javax.swing.JFrame;


public class Frame_1 extends JFrame{
	
	public Frame_1() {
		this.setTitle("窗口演示");
		this.setBackground(Color.cyan);
		this.setBounds(10, 30, 60, 90);
		this.setSize(200, 200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new Frame_1();

			}

		});
	}
	
	
}
