package T7;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sun.security.util.Password;

public class Event_1 extends JFrame {

	Button btOK, btClose;// 登入，关闭的控件
	TextField usenameField;// 用户名的输入文本框
	JPasswordField usePass;// 用户密码的输入文本框
	Label name, pass;// 用户名，用户密码的控件

	// 定义构造方法
	public Event_1() {
		// 创建容器的实例,设置布局方式,流布局，默认是边框布局
		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 1));
		// 设置大小
		setSize(200, 200);
		// 设置窗口的名称
		setTitle("QQ登入");
		// 创建控件的实例
		name = new Label("QQ账号", Label.RIGHT);
		pass = new Label("QQ密码", Label.RIGHT);
		usenameField = new TextField(18);
		usePass = new JPasswordField(14);
		btOK = new Button("登入");
		btClose = new Button("关闭");
		// 创建Action实例
		ActionHandle a = new ActionHandle();
		KeyHandle K = new KeyHandle();
		// 监听控件
		btOK.addActionListener(a);
		btClose.addActionListener(a);
		usenameField.addKeyListener(K);
		usePass.addKeyListener(K);
		// 加入容器
		add(name);
		add(usenameField);
		add(pass);
		add(usePass);
		add(btOK);
		add(btClose);
		// 设置背景颜色
		setBackground(Color.CYAN);
		// 设置是否显示窗口
		setVisible(true);
		// 设置窗口居中
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Event_1();
	}

	// 创建一个内部类，因为其可以访问外部类的变量和方法，比较实用
	class ActionHandle implements ActionListener {

		public void actionPerformed(ActionEvent a) {
			if (a.getSource() == btOK) {
				String usename = usenameField.getText().trim();// 去空格
				String pass = usePass.getText().trim();// 去空格
				if (usename.equals("275300091") && pass.equals("cfl,1997")) {
					JOptionPane.showMessageDialog(null, "登入成功");
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
			} else if (a.getSource() == btClose) {
				JOptionPane.showMessageDialog(null, "即将关闭窗口并退出程序");
				System.exit(0);
			}
		}

	}

	class KeyHandle implements KeyListener {
		// 按键
		public void keyPressed(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}

		// 放开按键
		public void keyReleased(KeyEvent e) {

			if (e.getSource() == usenameField) {
				String use = usenameField.getText();
				try {
					Long.parseLong(use);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "QQ账号只允许为数字");
					ex.printStackTrace();// 返回异常
					return;
				}
			} else if (e.getSource() == usePass) {
			}

		}

	}

}
