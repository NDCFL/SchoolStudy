package Test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OpenAccFrame extends JFrame {
	JPasswordField rePwdField;
	JPasswordField pwdField;
	JTextField moneyField;
	String accNum;
	public OpenAccFrame() {
		// 设置窗口的标题
		this.setTitle("开户...");
		// 设置窗口大小
		this.setSize(500, 500);
		// 设置窗口的起始位置
		this.setLocation(400, 200);
		this.setResizable(false);
		// 取消窗口的布局
		this.setLayout(null);

		JLabel infoLabel = new JLabel("欢迎使用xxx银行系统！");
		infoLabel.setFont(new Font(null, Font.ITALIC + Font.BOLD, 20));
		infoLabel.setBounds(120, 40, 280, 70);
		this.add(infoLabel);

		// 创建"账号"标签
		JLabel accNumLabel = new JLabel("账号：");
		// 设置组件的位置
		accNumLabel.setBounds(120, 140, 80, 35);
		this.add(accNumLabel);

		// 创建"账号窗口"的输入框
		JTextField accNumField = new JTextField();
		//设置文本框不可编辑
		accNumField.setEditable(false);
		accNumField.setBounds(200, 140, 200, 27);
		this.add(accNumField);
		//系统生成唯一的账户账号
		int num = new Random().nextInt(100000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = sdf.format(new Date());
		accNum = dateStr + num;
		accNumField.setText(accNum);

		// 创建"密码"标签
		JLabel pwdLabel = new JLabel("密码：");
		pwdLabel.setBounds(120, 180, 80, 35);
		this.add(pwdLabel);

		// 创建"密码"的输入框
		pwdField = new JPasswordField();
		pwdField.setBounds(200, 180, 200, 27);
		this.add(pwdField);

		// 创建"确认密码"标签
		JLabel rePwdLabel = new JLabel("确认密码：");
		rePwdLabel.setBounds(120, 220, 80, 35);
		this.add(rePwdLabel);

		// 创建"确认密码"的输入框
		rePwdField = new JPasswordField();
		rePwdField.setBounds(200, 220, 200, 27);
		this.add(rePwdField);

		// 创建"预存金额"标签
		JLabel moneyLabel = new JLabel("预存金额");
		moneyLabel.setBounds(120, 260, 80, 35);
		this.add(moneyLabel);

		// 创建"预存金额"的输入框
		moneyField = new JTextField();
		moneyField.setText("0.0");
		moneyField.setBounds(200, 260, 200, 27);
		this.add(moneyField);

		// 创建"开户"按钮
		JButton openAccButton = new JButton("开户");
		openAccButton.setBounds(150, 300, 80, 27);
		this.add(openAccButton);
		openAccButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取密码和确认密码，预存金额
				String pwd = new String(pwdField.getPassword());
				String repwd = new String(rePwdField.getPassword());
				String moneyStr = moneyField.getText();
				if(null == pwd || "".equals(pwd)){
					JOptionPane.showMessageDialog(OpenAccFrame.this, "请输入密码！");
					return;
				}
				if(null == repwd || "".equals(repwd)){
					JOptionPane.showMessageDialog(OpenAccFrame.this, "请确认密码！");
					return;
				}
				if(!pwd.equals(repwd)){
					JOptionPane.showMessageDialog(OpenAccFrame.this, "两次输入密码不一致！");
					return;
				}
				try {
					double money = Double.parseDouble(moneyStr);
					if(money < 0){
						JOptionPane.showMessageDialog(OpenAccFrame.this, "金额不能小于0！");
					}else{
						String userAcc = accNum+","+pwd+","+money;
						BufferedWriter bw = null;
						try {
							bw = new BufferedWriter(new FileWriter("d:/bankuser.txt",true));
							bw.write(userAcc);
							bw.newLine();//换行
							bw.flush();
							JOptionPane.showMessageDialog(OpenAccFrame.this, "开户成功！");
							OpenAccFrame.this.dispose();
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(OpenAccFrame.this, "文件写出失败，创建账户失败！");
						} finally{
							try {
								if(null != bw){
									bw.close();
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(OpenAccFrame.this, "请输入有效金额！");
					return;
				}
			}
		});

		JButton delButton = new JButton("取消");
		delButton.setBounds(300, 300, 80, 27);
		this.add(delButton);
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OpenAccFrame.this.dispose();
			}
		});

		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new OpenAccFrame();
	}
}
