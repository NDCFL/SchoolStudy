package T13;

import java.awt.Container;
import java.awt.Panel;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jishiqi extends JFrame implements Runnable{
	
	String time = new Date().toLocaleString();
	int week = new Date().getDay();
	JLabel label = new JLabel(time+"\n星期"+week); //实例化一个Label对象
    public Jishiqi() {
        super("电子时钟");
        Container co = getContentPane();
        co.add(label);
        this.setSize(150, 150);
        new Thread(this).start();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public static void main(String[] args) {
		
		new Jishiqi();
	}
	public void run() {
		
		while (true) {
			label.setText(new Date().toLocaleString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
