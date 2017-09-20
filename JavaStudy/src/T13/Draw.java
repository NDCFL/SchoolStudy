package T13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw extends JFrame{

	public Draw() {
		super("画图");
		setSize(500,500);
		setContentPane(new Drawpanel());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Draw();
	}
	class Drawpanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			g.drawOval(50, 50, 100, 100);
			g.drawOval(70, 70, 100, 100);
		}
	}
}
