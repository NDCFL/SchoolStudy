﻿package peasonmanager1;

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
		setTitle("个人小管家登录");
		
		panel = new JPanel(null);
		
		title = new JLabel("个人小管家登录");
		title.setBounds(100, 20, 100, 30);
		panel.add(title);
		
		username = new JLabel("管家：");
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			dispose();
			new peasonmanager();
		}else if(e.getSource()==register){
			if(user.getText().equals("")){
				JOptionPane.showMessageDialog(null, "管家不能为空","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(passwordField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "密码不能为空","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(passwordField.getText().length()<8){
				JOptionPane.showMessageDialog(null, "密码长度不能小于8个字符","注册信息",JOptionPane.ERROR_MESSAGE);
				return;
			}
			dispose();
			JOptionPane.showMessageDialog(null, "恭喜你注册成功！开始使用吧","个人小管家注册",JOptionPane.INFORMATION_MESSAGE);
			new peasonmanager();
		}
		
	}
	
	
	
}
