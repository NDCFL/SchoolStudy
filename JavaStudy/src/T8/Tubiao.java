package T8;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Tubiao extends JFrame {

	public Tubiao() {
		setTitle("QQ");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/1.jpg");
		setIconImage(image);
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Tubiao();
	}
}
