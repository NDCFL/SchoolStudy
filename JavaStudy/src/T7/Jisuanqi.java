package T7;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Jisuanqi extends JFrame implements ActionListener{

	boolean start=true;
	String op="=";
	double arg=0;
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	TextField num = new TextField(18);
	Button qingkong = new Button("清空");
	Button exit = new Button("退出");
	public Jisuanqi() {
		
		super("计算器");
		setSize(300, 300);
		setLayout(new BorderLayout());
		p2.add(num);
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		num = new TextField(20);
		p1.add(num);
		qingkong = new Button("关闭");
		exit = new Button("清空");
		p3.add(qingkong);
		p3.add(exit);
		p2.setLayout(new GridLayout(4,4,5,5));
		String buttons ="789/456+123*0.-=";
		for (int i = 0; i <buttons.length(); i++) {
			this.addButton(p2,buttons.substring(i,i+1));
		}
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		qingkong.addActionListener(this);
		exit.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addButton(Container c,String s) {
		Button b = new Button(s);
		c.add(b);
		b.addActionListener(this);
	}
	public static void main(String[] args) {
		new Jisuanqi();
	}
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		System.out.println(s+" ");
		if('0'<=s.charAt(0) && s.charAt(0)<='9'){
			if(start){
				num.setText(s);
			}else{
				num.setText(num.getText()+s);
			}
			start = false;
		}else if (s.equals(".")) {
			if(start){
				num.setText("0"+s);
			}
			start = false;
		}else if (start) {
			if (s.equals("-")) {
				num.setText(s);
				start=false;
			}else {
				op=s;
			}
		}else {
			double x=Double.parseDouble(num.getText());
			operation(x);
			op=s;
			start = true;
		}
	
	
	if (s.equals("清空")) {
		num.setText("0");
	} 
	if (s.equals("关闭")) {
		
		System.exit(0);
		
		}
	}
	public void operation(double n){
		if(op.equals("+")){
			arg+=n;
		}else if (op.equals("-")) {
			arg-=n;
		}else if (op.equals("*")) {
			arg*=n;
		}else if (op.equals("/")) {
			arg/=n;
		}else if (op.equals("=")) {
			arg=n;
		}
		num.setText(""+arg);
	
		
	}
}
