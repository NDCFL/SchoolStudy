package T6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class studentlogin extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,username,studentid;
	JTextField user;
	JPasswordField passwordField;
	JButton login;
	JPanel panel;
	public studentlogin() {
		setTitle("学生登录");
		
		panel = new JPanel(null);
		
		title = new JLabel("学生登录");
		title.setBounds(100, 20, 100, 30);
		panel.add(title);
		
		username = new JLabel("姓名");
		username.setBounds(20, 70, 50, 30);
		panel.add(username);
		
		user = new JTextField();
		user.setBounds(80,  70, 120, 30);
		panel.add(user);
		
		studentid = new JLabel("学号");
		studentid.setBounds(20, 120, 50, 30);
		panel.add(studentid);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 120, 120, 30);
		panel.add(passwordField);
		
		login = new JButton("开始上课");
		login.setBounds(100, 180, 80, 30);
		panel.add(login);
		
		add(panel);
		
		login.addActionListener(this);
		setSize(300,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new studentlogin();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			dispose();
			new StudentTimeWork();
			
		}
		
	}
	
	
	
}
