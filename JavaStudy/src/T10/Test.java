package T10;

import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test extends JFrame{
	JLabel id;
	JTextField idField;
	JLabel bjimage,bjimage1;
	public Test() {
		super("图标");
		setSize(500, 500);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/qt.png");
		setIconImage(image);
		beijin();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void beijin(){
		
		Icon icon = new ImageIcon("image/42.gif");
		bjimage = new JLabel(icon);
		
		Icon icon1 = new ImageIcon("image/qt.png");
		bjimage1 = new JLabel(icon1);
		
		bjimage.add(bjimage1);
		
		add(bjimage);
	}
	public static void main(String[] args) {
		//new Test();
		SimpleDateFormat df = new SimpleDateFormat();
		System.out.println();

	}
}
