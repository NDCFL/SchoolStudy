package edu.ht.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.ht.bean.Qquser;
import edu.ht.service.QquserService;
import edu.ht.service.impl.QquserServiceImpl;


public class QQRegister extends JFrame {
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JPasswordField pwd1, pwd2;
	JRadioButton sex1, sex2;
	String[] stars = { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座",
			"处女座", "天秤座", "天蝎座", "射手座" };
	String[] nations = { "汉族", "满族", "藏族", "白族", "傣族", "苗族", "高山族", "畲族", "回族",
			"壮族", "彝族" };
	JComboBox com1, com2;
	JTextArea txt1;
	
	QquserService qservice = new QquserServiceImpl();
	/***********/
	//设置界面可以拖动的方法
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQRegister.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQRegister.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQRegister.this.getLocation().x + e.getX() - tmp.x,
							QQRegister.this.getLocation().y + e.getY() - tmp.y);
					QQRegister.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public QQRegister() {
		super("注册");
		this.setDragable();//设置可以拖动
		this.setUndecorated(true); // 去掉窗口的装饰
		// 设置窗口图标
		Image image = new ImageIcon("qqmain/tubiao.jpg").getImage();
		setIconImage(image);
		Container c = getContentPane();

		// 设置样式
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 标题
		JLabel title = new JLabel("注册");
		title.setFont(new Font("微软雅黑", Font.BOLD, 20));
		title.setBounds(190, 5, 150, 50);
		title.setForeground( Color.WHITE);
		c.add(title);

		// 昵称
		JLabel luname = new JLabel("昵称：");
		luname.setBounds(75, 70, 40, 20);
		luname.setForeground( Color.WHITE);
		c.add(luname);

		t1 = new JTextField();
		t1.setBounds(120, 70, 180, 20);
		c.add(t1);

		// 密码
		JLabel lpwd1 = new JLabel("密码：");
		lpwd1.setBounds(75, 120, 40, 20);
		lpwd1.setForeground( Color.WHITE);
		c.add(lpwd1);

		pwd1 = new JPasswordField();
		pwd1.setBounds(120, 120, 180, 20);
		c.add(pwd1);

		// 确认密码
		JLabel lpwd2 = new JLabel("确认密码：");
		lpwd2.setBounds(55, 170, 70, 20);
		lpwd2.setForeground( Color.WHITE);
		c.add(lpwd2);

		pwd2 = new JPasswordField();
		pwd2.setBounds(120, 170, 180, 20);
		c.add(pwd2);

		// 性别
		JLabel lsex = new JLabel("性别：");
		lsex.setBounds(75, 220, 70, 20);
		lsex.setForeground( Color.WHITE);
		c.add(lsex);

		sex1 = new JRadioButton("男");
		sex1.setBounds(120, 220, 70, 20);
		sex1.setSelected(true);
		sex2 = new JRadioButton("女");
		sex2.setBounds(230, 220, 70, 20);

		c.add(sex1);
		c.add(sex2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(sex1);
		bg.add(sex2);
		
		// 电话
		JLabel ltel = new JLabel("电话：");
		ltel.setBounds(75, 270, 40, 20);
		ltel.setForeground( Color.WHITE);
		c.add(ltel);

		t2 = new JTextField();
		t2.setBounds(120, 270, 180, 20);
		c.add(t2);

		// 星座
		JLabel lstar = new JLabel("星座：");
		lstar.setForeground( Color.WHITE);
		lstar.setBounds(75, 320, 40, 20);
		c.add(lstar);

		com1 = new JComboBox(stars);
		com1.setBounds(120, 320, 70, 20);
		c.add(com1);
		// mz
		JLabel lnation = new JLabel("民族：");
		lnation.setBounds(205, 320, 40, 20);
		lnation.setForeground( Color.WHITE);
		c.add(lnation);

		com2 = new JComboBox(nations);
		com2.setBounds(240, 320, 60, 20);
		c.add(com2);

		// qm
		JLabel ltxt = new JLabel("个性签名：");
		ltxt.setBounds(55, 370, 70, 20);
		ltxt.setForeground( Color.WHITE);
		c.add(ltxt);

		txt1 = new JTextArea();
		txt1.setBounds(120, 370, 180, 70);
		c.add(txt1);

		JButton b1 = new JButton("提交");
		b1.setBounds(75, 460, 70, 30);
		c.add(b1);
		b1.addActionListener(new MyActionListener());

		JButton b2 = new JButton("取消");
		b2.setBounds(255, 460, 70, 30);
		c.add(b2);
		b2.addActionListener(new MyActionListener());

		// 背景图片
		JLabel bgimg = new JLabel(new ImageIcon("qqmain/11_24.jpg"));
		c.add(bgimg);

		setSize(400, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("提交")) {
				String nickname = t1.getText().trim();// 昵称
				String p1 = pwd1.getText().trim();
				String p2 = pwd2.getText().trim();
				if (nickname.equals("") || nickname == null) {
					JOptionPane.showMessageDialog(null, "请输入昵称!");
					t1.requestFocus();
				} else if (p1.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入密码!");
					pwd1.requestFocus();
				} else if (p2.equals("")) {
					JOptionPane.showMessageDialog(null, "请确认密码!");
					pwd2.requestFocus();
				} else if (!p1.equals(p2)) {
					JOptionPane.showMessageDialog(null, "两次密码输入不一致!");
					pwd2.requestFocus();
				} else {
					// 提交数据
					Qquser quser = new Qquser();
					quser.setQqnum(getQnum());// QQ号码的生成方法
					quser.setUname(nickname);
					quser.setIpadd("127.0.0.1");//IP
					quser.setPort(getPort());//用方法生成端口
					quser.setPwd(p2);
					// 设置性别
					if (sex1.isSelected()) {
						quser.setSex("男");
					} else if (sex2.isSelected()) {
						quser.setSex("女");
					}
					// 默认头像
					quser.setFace("img/0.png");
					quser.setTel(t2.getText().trim());
					//直接取下拉框文字
//					System.out.println(com1.getSelectedItem().toString());
					quser.setStar(stars[com1.getSelectedIndex()]);// 星座
					quser.setNation(nations[com2.getSelectedIndex()]);// 民族
					quser.setTxt(txt1.getText());

					// 注册
					boolean bln = qservice.addUSer(quser);
					if (bln) {
						JOptionPane.showMessageDialog(null, "恭喜注册成功，您的QQ号是"
								+ quser.getQqnum());
						QQRegister.this.dispose();//关闭注册窗口
					} else {
						JOptionPane.showMessageDialog(null, "注册失败!");
					}
				}
			} else if (e.getActionCommand().equals("取消")) {
				QQRegister.this.dispose();//关闭注册窗口
			}
		}

	}

	// QQ号码生成方法
	public String getQnum() {
		Random r = new Random();
		int i = r.nextInt(10000);
		// 9000
		// i<1000控制生成QQ号的位数 && 在用户表中不存在
		while (i < 1000 && qservice.selUser(i + "")) {
			i = r.nextInt(10000);
		}

		return i + "";
	}
	
	//端口生成方法
	public int getPort() {
		Random r = new Random();
		//0-9999 
		int i = r.nextInt(10000)+10000;
		
		return i;
	}

	public static void main(String[] args) {
		new QQRegister();
	}
}
