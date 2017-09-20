package shop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class shoppinglog extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel jlbUser, jlbPasswd,jbtnLogin;
	private JPasswordField jpfPasswd;
	private JTextField jtfUser;
	private JButton login;

	public static void main(String[] args) {
		new shoppinglog();
	}

	public shoppinglog() {

		setTitle("超市收银登录");
		panel = new JPanel(null);
		jbtnLogin = new JLabel("超市收银登录");
		jbtnLogin.setBounds(100, 20, 100, 30);
		panel.add(jbtnLogin);
		
		jlbUser = new JLabel("收银员名称：");
		jlbUser.setBounds(20, 60, 120, 30);
		panel.add(jlbUser);

		jtfUser = new JTextField();
		jtfUser.setBounds(110,60, 150, 30);
		panel.add(jtfUser);
		
		jlbPasswd = new JLabel("收银员编号：");
		jlbPasswd.setBounds(20, 100, 120, 30);
		panel.add(jlbPasswd);
		
		jpfPasswd = new JPasswordField();
		jpfPasswd.setBounds(110,100, 150, 30);
		panel.add(jpfPasswd);
		
		login = new JButton("开始营业");
		login.setBounds(100, 160, 100, 30);
		panel.add(login);
		add(panel);
		
		login.addActionListener(this);
		setSize(300, 240);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			if(jtfUser.getText().equals("")){
				JOptionPane.showMessageDialog(null, "名称不能为空！");
				return;
			}else if(jpfPasswd.getText().equals("")){
				JOptionPane.showMessageDialog(null, "编号不能为空！");
				return;
			}
			dispose();
			new shoppingselect();
			
		}
		
	}
}
