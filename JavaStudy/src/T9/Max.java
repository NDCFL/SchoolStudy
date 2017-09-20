package T9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Max extends JFrame{
	
	int n1,n2;
	public Max() {
		super("比较大小");
		setSize(300, 300);
		bijiao();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void bijiao(){
		String first = JOptionPane.showInputDialog(null, "请输入第一个数");
		n1=Integer.parseInt(first);
		String second = JOptionPane.showInputDialog(null, "请输入第二个数");
		n2=Integer.parseInt(second);
		if(n1>n2){
			JOptionPane.showMessageDialog(null, n1+">"+n2);
		}else if (n1<n2) {
			JOptionPane.showMessageDialog(null, n1+"<"+n2);
		}else {
			JOptionPane.showMessageDialog(null, n1+"="+n2);
		}
		
	}
	public static void main(String[] args) {
		new Max();
	}
}
