package T4.T41;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Lianxi extends JFrame{

	JLabel 	QQname,QQmima;
	JTextField qqname;
	JPasswordField 	QQpass;
	JButton denglu,zhuche;
	public Lianxi() {
		
		super("作业练习");
		Container c = new Container();
		QQname = new JLabel("QQ昵称：");
		QQname.setBounds(100, 100, 60, 30);
		
		qqname = new JTextField();
		qqname.setBounds(170, 100, 200, 30);
		
		QQmima = new JLabel("QQ密码：");
		QQmima.setBounds(100,150 , 60, 30);
		
		QQpass = new JPasswordField();
		QQpass.setBounds(170, 150, 200, 30);
		
		denglu = new JButton("登录");
		denglu.setBounds(150, 200, 80, 30);
		
		
		zhuche = new JButton("注册");
		zhuche.setBounds(250, 200, 80, 30);
		
		c.add(QQname);
		c.add(qqname);
		c.add(QQmima);
		c.add(QQpass);
		c.add(denglu);
		c.add(zhuche);
		add(c);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/qt.png");
		setIconImage(image);
		setSize(430, 340);
		//设置显示窗口
		setVisible(true);
		//设置居中
		setLocationRelativeTo(null);
		//设置关闭按钮
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	@Override
	public void paint(Graphics g) {
		String img="image/i.jpg";
		//g.drawImage("img", 0, 0, 0, 0, this);
	}
	public static void main(String[] args) {
		new Lianxi();
	}
}
