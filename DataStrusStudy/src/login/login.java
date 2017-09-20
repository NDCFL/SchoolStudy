package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import T6.shopping;

import lunch.lunchmanager;

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
	String value[][];
	static int row=0;
	String password="";
	String useraccount="";
	public login() {
		setTitle("用户登录");
		readfile();
		panel = new JPanel(null);
		title = new JLabel("用户登录注册");
		title.setBounds(100, 20, 100, 30);
		panel.add(title);
		
		username = new JLabel("姓名：");
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
		
		login.addActionListener(this);
		register.addActionListener(this);
		setSize(300,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new login();
	}
	public void readfile(){
		try {
			File file = new File("login.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String username[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				username = str.split(";");
			}
			value = new String[username.length][2];
			for(int i=0;i<username.length;i++){
				try {
					value[i]=username[i].split(",");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "系统繁忙，请稍后在试");
					return;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			String username = user.getText();
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][0].equals(username)){
						useraccount=value[i][0];
						password=value[i][1];
						row++;
						break;
					}
				}
			}
			if(useraccount.equals("") || useraccount==null){
				JOptionPane.showMessageDialog(null, "账号不存在，请先注册","登录信息",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!useraccount.equals("")){
				if(!password.equals(passwordField.getText())){
					JOptionPane.showMessageDialog(null, "密码输入有误","登录信息",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			dispose();
			new lunchmanager();
		}else if(e.getSource()==register){
			if(user.getText().equals("")){
				JOptionPane.showMessageDialog(null, "姓名不能为空","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(passwordField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "密码不能为空","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(passwordField.getText().length()<8){
				JOptionPane.showMessageDialog(null, "密码长度不能小于8个字符","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}
			File file = new File("login.txt");
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(file, true);
				String string = user.getText() + "," + passwordField.getText()+";";
				byte b[] = string.getBytes();
				fos.write(b, 0, b.length);
				fos.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			dispose();
			JOptionPane.showMessageDialog(null, "恭喜你注册成功！开始登录吧","用户注册",JOptionPane.INFORMATION_MESSAGE);
			new login();
		}
		
	}
	
	
	
}
