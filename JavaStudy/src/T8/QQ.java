package T8;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class QQ extends JFrame implements ActionListener{
	JTextField textField;
	JLabel name,passname;
	JPasswordField password;
	Button dengru,quxiao,ok;
	JPanel p1,p2;
	JCheckBox mima,zidong;
	public QQ(){
		setTitle("QQ");
		setSize(500,500);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/qq.jpg");
		//设置图标函数;
		setIconImage(image);
		
		p1 = new JPanel(null);
		p2 = new JPanel(null);
		setLayout(new GridLayout(2,1));
		p1.setBackground(Color.gray);
		
		textField = new JTextField();
		textField.setBounds(160, 150, 200, 30);
		name = new JLabel("注册账号");
		name.setFont(new Font("华文行楷",Font.BOLD,16));
		name.setForeground(Color.white);
		name.setBounds(370, 150, 100, 30);
		p1.add(textField);
		p1.add(name);
		
		password = new JPasswordField();
		password.setBounds(160, 190, 200, 30);
		passname = new JLabel("找回密码");
		passname.setFont(new Font("华文行楷",Font.BOLD,16));
		passname.setForeground(Color.white);
		passname.setBounds(370, 190, 100, 30);
		p1.add(password);
		p1.add(passname);
		
		
		
		mima = new JCheckBox("记住密码");
		mima.setFont(new Font("华文行楷",Font.BOLD,16));
		mima.setForeground(Color.LIGHT_GRAY);
		mima.setBounds(160, 10, 100, 30);
		zidong = new JCheckBox("自动登入");
		zidong.setFont(new Font("华文行楷",Font.BOLD,16));
		zidong.setForeground(Color.LIGHT_GRAY);
		zidong.setBounds(280, 10, 100, 30);
		p2.add(mima);
		p2.add(zidong);
		
		ok = new Button("登录");
		ok.setFont(new Font("华文行楷",Font.BOLD,32));
		ok.setForeground(Color.LIGHT_GRAY);
		ok.setBackground(Color.CYAN);
		ok.setBounds(180, 70, 160, 50);
		p2.add(ok);
		
		ok.addActionListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new QQ();
	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==ok){
			if(name.getText().equals("")){
				JOptionPane.showMessageDialog(null, "账号不能为空");
			}if (password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
			}
		}
	}
	
}
