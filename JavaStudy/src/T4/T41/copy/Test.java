package T4.T41.copy;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Test extends JFrame{

	JPanel panel;
	public Test() {
		panel = new JPanel();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMinimum(0); //设置最小进度值
		progressBar.setMaximum(100); //设置最大进度值
		progressBar.setBackground(new Color(209, 206, 200)); //设置背景颜色
		progressBar.setForeground(new Color(172, 168, 163)); //设置前景颜色
		panel.add(progressBar);
		add(panel);
		this.setSize(200,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Test();
	}
}
