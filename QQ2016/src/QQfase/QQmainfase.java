package QQfase;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import QQSQL.SQLconnection;
import QQbean.QQidtable;
import SQLBase.QQbase;

public class QQmainfase extends JFrame implements ActionListener{

	JLabel bg, title,touxiang,head1;
	JButton tubiao, look;
	JLabel QQid, QQname, QQpassword, QQhead, age, sex, QQquerenpass;
	JLabel start, blood, nation, hobit, ipdizhi, port, remark;
	JTextField txtQQid, txtQQname, txtage, txtipdizhi, txtport;
	JPasswordField jfQQpassword, jfQQquerenpass;
	JRadioButton man, weman;
	JComboBox jbstart, jbblood, jbnation, cbHeadImg;
	JCheckBox xieyi;
	String headfase = "drpicture/4.png";
	JTextArea jaremark, jahobit;
	ButtonGroup bGroup;
	JButton jtsave, jtclose, head;
	String sNation[] = { "汉族", "蒙古族", "回族", "藏族", "维吾尔族", "苗族", "彝族", "壮族",
			"布依族", "朝鲜族", "满族", "侗族", "瑶族", "白族", "土家族", "哈尼族", "哈萨克族", "傣族",
			"黎族", "僳僳族", "佤族", "高山族", "拉祜族", "水族", "东乡族", "纳西族", "景颇族",
			"柯尔克孜族", "土族", "达斡尔族", "仫佬族", "羌族", "布朗族", "撒拉族", "毛南族", "仡佬族",
			"锡伯族", "阿昌族", "普米族", "塔吉克族", "怒族", "乌孜别克族", "俄罗斯族", "鄂温克族", "德昂族",
			"保安族", "裕固族", "京族", "塔塔尔族", "独龙族", "鄂伦春族", "赫哲族", "门巴族", "珞巴族",
			"基诺族",

	};
	String sStar[] = { "双鱼座", "金牛座", "摩羯座", "天蝎座", "处女座", "狮子座", "白羊座", "水瓶座",
			"射手座", "天秤座", "巨蟹座", "双子座", };
	String sBlood[] = { "A", "B", "O", "AB" };
	String sHeadImg[] = { 
			"images/50.jpg","image/1111.gif", "images/1.jpg", "images/2.jpg",
			"images/3.jpg", "images/4.jpg", "images/5.jpg", "images/6.jpg",
			"images/7.jpg", "images/8.jpg", "images/9.jpg", "images/10.jpg",
			"images/11.jpg", "images/12.jpg", "images/13.jpg", "images/14.jpg",
			"images/15.jpg", "images/16.jpg", "images/17.jpg", "images/18.jpg",
			"images/19.jpg", "images/20.jpg", "images/21.jpg", "images/22.jpg",
			"images/23.jpg", "images/24.jpg", "images/25.jpg", "images/26.jpg",
			"images/27.jpg", "images/28.jpg", "images/29.jpg", "images/30.jpg",
			"images/31.jpg", "images/32.jpg", "images/33.jpg", "images/34.jpg",
			"images/35.jpg"
		};
	ImageIcon[] headIcon = { new ImageIcon(sHeadImg[0]),
			new ImageIcon(sHeadImg[1]),
			new ImageIcon(sHeadImg[2]), new ImageIcon(sHeadImg[3]),
			new ImageIcon(sHeadImg[4]), new ImageIcon(sHeadImg[5]),
			new ImageIcon(sHeadImg[6]), new ImageIcon(sHeadImg[7]),
			new ImageIcon(sHeadImg[8]), new ImageIcon(sHeadImg[9]),
			new ImageIcon(sHeadImg[10]), new ImageIcon(sHeadImg[11]),
			new ImageIcon(sHeadImg[12]), new ImageIcon(sHeadImg[13]),
			new ImageIcon(sHeadImg[14]), new ImageIcon(sHeadImg[15]),
			new ImageIcon(sHeadImg[16]), new ImageIcon(sHeadImg[17]),
			new ImageIcon(sHeadImg[18]), new ImageIcon(sHeadImg[19]),
			new ImageIcon(sHeadImg[20]), new ImageIcon(sHeadImg[21]),
			new ImageIcon(sHeadImg[22]), new ImageIcon(sHeadImg[23]),
			new ImageIcon(sHeadImg[24]), new ImageIcon(sHeadImg[25]),
			new ImageIcon(sHeadImg[26]), new ImageIcon(sHeadImg[27]),
			new ImageIcon(sHeadImg[28]), new ImageIcon(sHeadImg[29]),
			new ImageIcon(sHeadImg[30]), new ImageIcon(sHeadImg[31]),
			new ImageIcon(sHeadImg[32]), new ImageIcon(sHeadImg[33]),
			new ImageIcon(sHeadImg[34]), new ImageIcon(sHeadImg[35])
		
	};
	private TrayIcon trayIcon = null;
//设置界面可以拖动的方法
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQmainfase.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQmainfase.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQmainfase.this.getLocation().x + e.getX() - tmp.x,
							QQmainfase.this.getLocation().y + e.getY() - tmp.y);
					QQmainfase.this.setLocation(loc);
				}
			}
		});
	}
	public QQmainfase() {
		super("QQ注册");
//		setUndecorated(true);
		this.setDragable();
		tubiao();
		kongjian();
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(600, 670);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void kongjian() {
		bg = new JLabel(new ImageIcon("head/8.jpg"));
		bg.setLayout(null);
		bg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(bg);
		head = new JButton(new ImageIcon(sHeadImg[9]));
		head.setBounds(30, 100, 130, 130);
		bg.add(head);

		head1 = new JLabel(new ImageIcon("drpicture/11.gif"));
		head1.setBounds(20, 110, 140, 140);
		bg.add(head1);
		
		touxiang = new JLabel("选头像点这里");
		touxiang.setBounds(35, 250, 150, 30);
		touxiang.setForeground(Color.blue);
		touxiang .setFont(new Font("华文行楷",Font.BOLD,18));
		bg.add(touxiang);
		tubiao = new JButton(new ImageIcon("images/30.jpg"));
		tubiao.setBounds(50, 200, 130, 118);

		look = new JButton(new ImageIcon("images/31.jpg"));
		look.setBounds(50, 350, 130, 118);

		Icon image1 = new ImageIcon("images/41.gif");
		title = new JLabel("欢迎来到注册QQ界面");
		title.setForeground(Color.blue);
		title.setBounds(155, 30, 300, 30);
		title.setFont(new Font("华文行楷", Font.BOLD, 30));
		bg.add(title);

		QQid = new JLabel("Q  Q号码", image1, 0);
		QQid.setFont(new Font("黑体", Font.BOLD, 16));
		QQid.setForeground(new Color(40,210,180));
		QQid.setBounds(200, 80, 110, 40);
		bg.add(QQid);

		txtQQid = new JTextField("待会告诉你哦！！");
		txtQQid.setBounds(320, 85, 200, 27);
		txtQQid.setFont(new Font("黑体",Font.BOLD,16));
		txtQQid.setForeground(new Color(40,210,180));
		txtQQid.setEditable(false);
		bg.add(txtQQid);

		QQname = new JLabel("Q  Q昵称", image1, 0);
		QQname.setFont(new Font("黑体", Font.BOLD, 16));
		QQname.setForeground(new Color(40,210,180));
		QQname.setBounds(200, 115, 110, 40);
		bg.add(QQname);

		txtQQname = new JTextField();
		txtQQname.setBounds(320, 120, 200, 27);
		bg.add(txtQQname);// 35 35

		QQpassword = new JLabel();
		QQpassword = new JLabel("Q  Q密码", image1, 0);
		QQpassword.setFont(new Font("黑体", Font.BOLD, 16));
		QQpassword.setForeground(new Color(40,210,180));
		QQpassword.setBounds(200, 150, 110, 40);
		bg.add(QQpassword);

		jfQQpassword = new JPasswordField();
		jfQQpassword.setBounds(320, 155, 200, 27);
		jfQQpassword.setEchoChar('♫');
		bg.add(jfQQpassword);// 35 35

		QQquerenpass = new JLabel();
		QQquerenpass = new JLabel("确认密码", image1, 0);
		QQquerenpass.setFont(new Font("黑体", Font.BOLD, 16));
		QQquerenpass.setForeground(new Color(40,210,180));
		QQquerenpass.setBounds(200, 180, 110, 40);
		bg.add(QQquerenpass);

		jfQQquerenpass = new JPasswordField();
		jfQQquerenpass.setBounds(320, 190, 200, 27);
		jfQQquerenpass.setEchoChar('♫');
		bg.add(jfQQquerenpass);// 35 35

		age = new JLabel("年    龄", image1, 0);
		age.setFont(new Font("黑体", Font.BOLD, 16));
		age.setForeground(new Color(40,210,180));
		age.setBounds(200, 215, 110, 40);
		bg.add(age);

		txtage = new JTextField();
		txtage.setBounds(320, 225, 200, 27);
		bg.add(txtage);// 35 35

		sex = new JLabel("性    别", image1, 0);
		sex.setFont(new Font("黑体", Font.BOLD, 16));
		sex.setForeground(new Color(40,210,180));
		sex.setBounds(200, 250, 110, 40);
		bg.add(sex);

		man = new JRadioButton("男神", true);
		man.setBounds(320, 260, 100, 27);
		man.setFont(new Font("黑体", Font.BOLD, 16));
		man.setOpaque(false);

		weman = new JRadioButton("女神");
		weman.setBounds(440, 260, 100, 27);
		weman.setFont(new Font("黑体", Font.BOLD, 16));
		weman.setOpaque(false);

		bGroup = new ButtonGroup();
		bGroup.add(man);
		bGroup.add(weman);
		bg.add(man);
		bg.add(weman);

		nation = new JLabel("民    族", image1, 0);
		nation.setFont(new Font("黑体", Font.BOLD, 16));
		nation.setForeground(new Color(40,210,180));
		nation.setBounds(200, 285, 110, 40);
		bg.add(nation);

		jbnation = new JComboBox(sNation);
		jbnation.setBounds(240, 320, 70, 20);
		bg.add(jbnation);

		blood = new JLabel("血    型", image1, 0);
		blood.setFont(new Font("黑体", Font.BOLD, 16));
		blood.setForeground(new Color(40,210,180));
		blood.setBounds(320, 285, 110, 40);
		bg.add(blood);

		jbblood = new JComboBox(sBlood);
		jbblood.setBounds(360, 320, 70, 20);
		bg.add(jbblood);

		start = new JLabel("星    座", image1, 0);
		start.setFont(new Font("黑体", Font.BOLD, 16));
		start.setForeground(new Color(40,210,180));
		start.setBounds(430, 285, 110, 40);
		bg.add(start);

		jbstart = new JComboBox(sStar);
		jbstart.setBounds(470, 320, 70, 20);
		jbstart.setForeground(new Color(40,210,180));
		bg.add(jbstart);

		ipdizhi = new JLabel();
		ipdizhi = new JLabel("I P", image1, 0);
		ipdizhi.setFont(new Font("黑体", Font.BOLD, 16));
		ipdizhi.setForeground(new Color(40,210,180));
		ipdizhi.setBounds(200, 345, 80, 40);
		bg.add(ipdizhi);

		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		txtipdizhi = new JTextField(addr.getHostAddress());
		txtipdizhi.setBounds(280, 350, 100, 25);
		bg.add(txtipdizhi);// 35 35

		port = new JLabel();
		port = new JLabel("端口");
		port.setFont(new Font("黑体", Font.BOLD, 16));
		port.setForeground(new Color(40,210,180));
		port.setBounds(390, 343, 80, 40);
		bg.add(port);

		txtport = new JTextField("0");
		txtport.setBounds(430, 350, 100, 25);
		txtport.setEditable(false);
		bg.add(txtport);// 35 35

		hobit = new JLabel("签    名", image1, 0);
		hobit.setFont(new Font("黑体", Font.BOLD, 16));
		hobit.setForeground(new Color(40,210,180));
		hobit.setBounds(200, 389, 110, 40);
		bg.add(hobit);

		jahobit = new JTextArea();
		jahobit.setBounds(320, 389, 200, 30);
		bg.add(jahobit);

		remark = new JLabel("个 人 小 说 明");
		remark.setFont(new Font("黑体", Font.BOLD, 16));
		remark.setForeground(new Color(40,210,180));
		remark.setBounds(300, 425, 300, 40);
		bg.add(remark);

		jaremark = new JTextArea(4, 20);
		JScrollPane js1 = new JScrollPane(jaremark);
		jaremark.setBounds(200, 470, 330, 60);
		bg.add(jaremark);

		xieyi = new JCheckBox("我接受本QQ的服务协议");
		xieyi.setFont(new Font("黑体", Font.BOLD, 16));
		xieyi.setForeground(new Color(40,210,180));
		xieyi.setBounds(200, 535, 300, 40);
		xieyi.setOpaque(false);
		bg.add(xieyi);

		jtsave = new JButton("同意并注册");
		jtsave.setFont(new Font("黑体", Font.BOLD, 24));
		jtsave.setForeground(Color.blue);
		jtsave.setBounds(200, 579, 200, 40);

		xieyi.addActionListener(this);
		head.addActionListener(this);
		jtsave.addActionListener(this);
		bg.add(jtsave);
	}
	// 设置头像函数
	public void tubiao() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("Picture/qt.png");
		setIconImage(image);
	}
	public static void main(String[] args) {
		new QQmainfase();
	}
	public void jbInit() {
		if (SystemTray.isSupported()) { // 检查当前系统是否支持系统托盘
			SystemTray tray = SystemTray.getSystemTray();// 获取表示桌面托盘区的
															// SystemTray 实例。
			Image image = Toolkit.getDefaultToolkit().getImage("image/111.png");
			PopupMenu popupMenu = new PopupMenu();
			MenuItem exitItem = new MenuItem("关闭");
			MenuItem menuItema = new MenuItem("最小化");
			MenuItem menuItemb = new MenuItem("最大化");
			MenuItem menuItemc = new MenuItem("登录");
			MenuItem menuItemd = new MenuItem("menu d");
			exitItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						System.exit(0);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			menuItemc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						new QQdenglu();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			popupMenu.add(menuItema);
			popupMenu.add(menuItemb);
			popupMenu.add(menuItemc);
			popupMenu.add(menuItemd);
			popupMenu.add(exitItem);
			trayIcon = new TrayIcon(image, "系统托盘{kissjava}", popupMenu);
			trayIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			});
			try {
				tray.add(trayIcon); // 将 TrayIcon 添加到 SystemTray。
			} catch (AWTException e) {
				System.err.println(e);
			}
		} else {
			System.out.println("你的系统不支持系统托盘");
		}
		ImageIcon icon = new ImageIcon();
		try {
		} catch (Exception e) {
		}
		JLabel label = new JLabel();
		label.setIcon(icon);
		this.add(label);
	}
	// 设置头像函数
	public void head() {
		String string;
		int i = new Random().nextInt(43);
		string = "images/" + i + ".jpg";
		head.setIcon(new ImageIcon(string));
		headfase = string;
	}
	// 保存的函数
	public void save() {
		if (this.isExit(txtQQname.getText())) {
			JOptionPane.showMessageDialog(this, "该QQ昵称已经被占用！为保持个性请重新输入！！！");
			return;
		}
		QQidtable qqidtable = new QQidtable();
		qqidtable.setQQname(txtQQname.getText());
		qqidtable.setQQhead(headfase);
		qqidtable.setQQpassword(jfQQpassword.getText());
		qqidtable.setAge(Integer.parseInt(txtage.getText().trim()));
		if (man.isSelected()) {
			qqidtable.setSex("男神");
		} else {
			qqidtable.setSex("女神");
		}
		qqidtable.setNation(sNation[jbnation.getSelectedIndex()]);
		qqidtable.setStart(sStar[jbstart.getSelectedIndex()]);
		qqidtable.setBlood(sBlood[jbblood.getSelectedIndex()]);
		qqidtable.setHobit(jahobit.getText().trim());
		qqidtable.setIpdizhi(txtipdizhi.getText().trim());
		qqidtable.setRemark(jaremark.getText().trim());
		QQbase qqbase = new QQbase();
		// 将界面的值取到，并传递到QQbase函数里，在更新到数据库里，达到保存的效果
		qqbase.saveAccount(qqidtable);
		JOptionPane.showMessageDialog(this, "注册成功\n您的QQ号码为："
				+ qqidtable.getQQid());
	}	
	public void kongzhi() {
		String nickname = txtQQname.getText().trim();
		if (nickname.equals("")) {
			txtQQname.setText("昵称不能为空");
			txtQQname.setFont(new Font("黑体", Font.BOLD, 16));
			txtQQname.setForeground(Color.RED);
			JOptionPane.showMessageDialog(this, "请重新输入");
			txtQQname.setText("");
			txtQQname.setForeground(Color.CYAN);
			return;
		}
		String pass = jfQQpassword.getText().trim();
		String cfgpass = jfQQquerenpass.getText().trim();
		if (pass.equals("")) {
			JOptionPane.showMessageDialog(this, "登录密码不能为空");
			return;
		}
		if (!pass.equals(cfgpass)) {
			JOptionPane.showMessageDialog(this, "两次输入的密码不一致");
			return;
		}
		int age = 0;
		String sage = txtage.getText().trim();
		if (sage.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入年龄");
			txtage.setText("0");
			return;
		}
		try {
			age = Integer.parseInt(sage);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "年龄为0到100岁之间");
			return;
		}
		if (age < 0 || age > 100) {
			JOptionPane.showMessageDialog(this, "年龄为0到100岁之间");
			return;
		}
	}
	//保障昵称唯一性的函数
	public boolean isExit(String name) {
		boolean exit = false;
		Connection con = SQLconnection.openDB();
		String SQL = "select * from IDtable where QQname='" + name + "'";
		try {
			Statement sta = con.createStatement();
			ResultSet re = sta.executeQuery(SQL);
			if (re.next()) {
				exit = true;
			}
			re.close();
			sta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exit;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jtsave) {
			kongzhi();
			save();
		} else if (e.getSource() == jtclose) {
			System.exit(0);
		} else if (e.getSource() == head) {
			head();
		} else if (xieyi.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "是否接受此协议");
		} else if (e.getSource() == xieyi) {
			String string = "\t\t\t\t\t\t用户协议\t\t\t\t\t\t\n";
			string += "1．引言\n1.1编写目的为明确软件需求、安排项目规划与进度、组织软件开发与测试，撰写本文档。\n本文档供项目经理、设计人员、开发人员参考。参考项目文档：数据库设计，页面图示\n";
			string += "\t多个用户能够在局域网内互相通信，并对自己的好友进行管理。";
			string += "2.2\n运行环境操作系统：Microsoft Windows 2000 Advanced Server\n支持环境：java环境\n数 据 库：Microsoft SQL Server 2000\n";
			string += "4.1功能划分\n•注册登录+\n•个人信息管理+\n•组管理\n+\n•好友管理+\n•即时聊天";
			string += "4.2功能描述\n•注册登录\n首先要申请QQ号，用户按要求填入正确的个人信息资料后由系统生成QQ号.\n要保证每个用户的QQ号都是唯一的。然后用申请成功的QQ号和用户自己设定的密码登录本系统.\n";
			string += "QQ号或密码填入有误显示登录失败并有所提示，登录成功后弹出主面板并关闭登录的面板.\n";
			string += "\t进入主面板后可以显示本用户的头像，QQ名，QQ号，状态等个人信息，可以显示好友及好友所在的组别，\n并能通过头像区分在线的好友和隐身或离线的好友。";
			string += "5.4技术难点\n";
			string += "1.服务器如何存储上线用户。\n";
			string += "\t在服务器上有一个HashTable或者其他的集合也可以，用来存储所有上线的用户，一般应存贮用户的id以标识每个用户，还应该存储用户连上的Socket以便向对应的客户发送消息\n";
			string += "\t用户在登录的时候，我们一般会将用户的id查出来后保存在一个变量里，连上服务器后，我们马上会向服务器发送一个消息，在这个消息的字符串中我们会包含本用户的ID号在里面，\n;";
			string += "\t当服务器接受到这个消息后会根据消息的类型将该用户的状态改变为“在线”状态。\n";
			string += "\t送的消息应该包含两个要素，一个是“消息类型”，一个是“用户ID”，特殊的情况下还应该有对方的“用户ID\n";
			string += "\t如：用户上线，我们就向服务器发送消息“上线=用户ID\n";
			string += "\t用户隐身，我们就向服务器发送消息“隐身=用户ID\n";
			string += "\t用户离线，我们就向服务器发送消息“离线=用户ID\n";
			string += "注意：本QQ不得盗版！使用时需要遵守法律法规！\n";
			JOptionPane.showMessageDialog(this, string);

		}
	}
}
