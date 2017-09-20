package shopping;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,username,lbpassword;
	JTextField user;
	JPasswordField passwordField;
	JButton login,register;
	JPanel panel;
	public login() {
		setTitle("超市收银登录");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("shop.png");
		setIconImage(image);
		//实例化一个面板
		panel = new JPanel(null);
		
		//实例化一个标题
		title = new JLabel("超市管理员登录");
		//标题的位置
		title.setBounds(100, 20, 100, 30);
		//将label标题控件加入到面板
		panel.add(title);
		
		//以下操作一样实例化label，设置位置放入面板
		username = new JLabel("管理员：");
		username.setBounds(30, 70, 60, 30);
		panel.add(username);
		
		user = new JTextField();
		user.setBounds(90,  70, 150, 30);
		panel.add(user);
		
		lbpassword = new JLabel("密码：");
		lbpassword.setBounds(30, 120,60, 30);
		panel.add(lbpassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 120, 150, 30);
		panel.add(passwordField);
		
		login = new JButton("登录");
		login.setBounds(50, 180, 80, 30);
		panel.add(login);
		
		register = new JButton("注册");
		register.setBounds(160, 180, 80, 30);
		panel.add(register);
		
		add(panel);
		
		//监听事件
		login.addActionListener(this);
		register.addActionListener(this);
		//设置窗口大小
		setSize(300,300);
		//显示窗口
		setVisible(true);
		//居中显示
		setLocationRelativeTo(null);
		//关闭窗口关闭程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new login();
	}
	//处理监听事件
	public void actionPerformed(ActionEvent e) {
		//点击了登录之后，隐藏当前窗口，打开主页
		if(e.getSource()==login){
			dispose();
			new shopping();
			//点击注册，进行合法性验证
		}else if(e.getSource()==register){
			if(user.getText().equals("")){
				JOptionPane.showMessageDialog(null, "名称不能为空","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(user.getText().length()<3){
				JOptionPane.showMessageDialog(null, "名称长度不能小于3个字符","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(passwordField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "密码不能为空","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(passwordField.getText().length()<6){
				JOptionPane.showMessageDialog(null, "密码长度不能小于6个字符","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}
			//注册成功，隐藏当前窗口
			dispose();
			JOptionPane.showMessageDialog(null, "恭喜你注册成功！开始使用吧","设备人员注册",JOptionPane.INFORMATION_MESSAGE);
			new shopping();
		}
		
	}
	
	
	
}
