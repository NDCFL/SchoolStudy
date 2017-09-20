package QQfase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import QQbean.QQidtable;
import SQLBase.QQbase;

public class FindPassword extends JFrame implements ActionListener {
	JPanel p1;
	JLabel bjimage, jsm;
	JLabel title, id, pass, name, pass1, qrpass;
	JTextField idField, nameField, emaiField;
	JPasswordField passwordField, passwordField1, ageField;
	JButton ok, quxiao;
	JRadioButton man, weman;
	ButtonGroup btsex;
	JTextArea shuoming;
	QQbase qqbase = new QQbase();

	public FindPassword() {
		super("更改密码");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/qt.png");
		setIconImage(image);
		kongjian();
		setSize(280, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FindPassword();
	}

	public void kongjian() {
		p1 = new JPanel(null);
		title = new JLabel("找回密码", JLabel.CENTER);
		title.setBounds(80, 15, 100, 30);
		title.setFont(new Font("黑体", Font.BOLD, 18));
		title.setForeground(Color.blue);
		p1.add(title);

		name = new JLabel("昵 称：", JLabel.LEFT);
		name.setFont(new Font("黑体", Font.BOLD, 14));
		name.setForeground(Color.blue);
		name.setBounds(20, 65, 60, 30);
		p1.add(name);

		nameField = new JTextField();
		nameField.setBounds(90, 65, 150, 30);
		p1.add(nameField);

		id = new JLabel("账 号：", JLabel.LEFT);
		id.setFont(new Font("黑体", Font.BOLD, 14));
		id.setForeground(Color.blue);
		id.setBounds(20, 105, 60, 30);
		p1.add(id);

		idField = new JTextField();
		idField.setBounds(90, 105, 150, 30);
		p1.add(idField);

		pass = new JLabel("原密码：", JLabel.LEFT);
		pass.setFont(new Font("黑体", Font.BOLD, 14));
		pass.setForeground(Color.blue);
		pass.setBounds(20, 145, 140, 30);
		p1.add(pass);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('▓');
		passwordField.setBounds(90, 150, 150, 30);
		p1.add(passwordField);

		pass1 = new JLabel("新密码：", JLabel.LEFT);
		pass1.setFont(new Font("黑体", Font.BOLD, 14));
		pass1.setForeground(Color.blue);
		pass1.setBounds(20, 185, 140, 30);
		p1.add(pass1);

		passwordField1 = new JPasswordField();
		passwordField1.setEchoChar('▓');
		passwordField1.setBounds(90, 185, 150, 30);
		p1.add(passwordField1);

		Icon image = new ImageIcon("images/41.gif");
		ok = new JButton("确定", image);
		ok.setFont(new Font("黑体", Font.BOLD, 12));
		ok.setForeground(Color.blue);
		ok.setBounds(20, 396, 100, 30);
		quxiao = new JButton("查找", image);
		quxiao.setFont(new Font("黑体", Font.BOLD, 12));
		quxiao.setForeground(Color.blue);
		quxiao.setBounds(150, 396, 100, 30);
		p1.add(ok);
		p1.add(quxiao);
		add(p1);
		ok.addActionListener(this);
	}

	public void beijin() {
		Icon icon = new ImageIcon("image/42.gif");
		bjimage = new JLabel(icon);
		add(bjimage);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			if (idField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "QQ号码为空!!");
			} else if (passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "QQ密码为空!!");
			} else if ((passwordField1.getText().equals(""))) {
				JOptionPane.showMessageDialog(this, "新密码不能为空!!");
			}
			System.out.println(idField.getText());
			System.out.println(passwordField.getText());
			qqbase.changepassword(Integer.parseInt(idField.getText()),
					passwordField1.getText());
			JOptionPane.showMessageDialog(this, "恭喜你修改成功");
			dispose();
		}
	}
}
