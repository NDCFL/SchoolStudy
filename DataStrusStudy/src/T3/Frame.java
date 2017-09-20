package T3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{

	JButton jbt,jbt1;
	JPanel jpl;
	public void face(){
		this.setTitle("汽车管理系统");
		jbt = new JButton("进站");
		jbt1 = new JButton("出站");
		jpl = new JPanel();
		jpl.add(jbt);
		jpl.add(jbt1);
		add(jpl);
		this.setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.face();
	}
	
}
