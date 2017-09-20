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
import T10.Table;

public class Updatefriendfase1 extends JFrame implements ActionListener {

	JLabel bg, title, touxiang, head1;
	JButton tubiao, look;
	JLabel QQid, QQname, QQhead, age, sex;
	JLabel start, blood, nation, hobit, remark;
	JTextField txtQQid, txtQQname, txtage;
	JRadioButton man, weman;
	JComboBox jbstart, jbblood, jbnation, cbHeadImg;
	String headfase = "drpicture/4.png";
	JTextArea jaremark;
	JTextField jahobit;
	ButtonGroup bGroup;
	QQidtable idtable;
	haoyoufase hf;
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
	String sHeadImg[] = { "images/50.jpg", "image/1111.gif", "images/1.jpg",
			"images/2.jpg", "images/3.jpg", "images/4.jpg", "images/5.jpg",
			"images/6.jpg", "images/7.jpg", "images/8.jpg", "images/9.jpg",
			"images/10.jpg", "images/11.jpg", "images/12.jpg", "images/13.jpg",
			"images/14.jpg", "images/15.jpg", "images/16.jpg", "images/17.jpg",
			"images/18.jpg", "images/19.jpg", "images/20.jpg", "images/21.jpg",
			"images/22.jpg", "images/23.jpg", "images/24.jpg", "images/25.jpg",
			"images/26.jpg", "images/27.jpg", "images/28.jpg", "images/29.jpg",
			"images/30.jpg", "images/31.jpg", "images/32.jpg", "images/33.jpg",
			"images/34.jpg", "images/35.jpg",  };
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
	// 设置界面可以拖动的方法

	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;

	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				Updatefriendfase1.this.setCursor(new Cursor(
						Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
				Updatefriendfase1.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(Updatefriendfase1.this.getLocation().x
							+ e.getX() - tmp.x, Updatefriendfase1.this
							.getLocation().y
							+ e.getY() - tmp.y);
					Updatefriendfase1.this.setLocation(loc);
				}
			}
		});
	}

	public Updatefriendfase1(QQidtable idtable,haoyoufase hf){}
	public Updatefriendfase1() {
		super("QQ注册");
		// setUndecorated(true);
		this.idtable=idtable;
		this.hf=hf;
		this.setDragable();
		jbInit();
		tubiao();
		bg = new JLabel(new ImageIcon("head/8.jpg"));
		bg.setLayout(null);
		add(bg);
		head = new JButton(new ImageIcon(idtable.getQQhead()));
		head.setBounds(30, 100, 130, 130);
		bg.add(head);

		head1 = new JLabel(new ImageIcon("drpicture/11.gif"));
		head1.setBounds(20, 110, 140, 140);
		bg.add(head1);

		touxiang = new JLabel("选头像点这里");
		touxiang.setBounds(35, 250, 150, 30);
		touxiang.setForeground(Color.blue);
		touxiang.setFont(new Font("华文行楷", Font.BOLD, 18));
		bg.add(touxiang);
		tubiao = new JButton(new ImageIcon("images/30.jpg"));
		tubiao.setBounds(50, 200, 130, 118);
		// bg.add(tubiao);

		look = new JButton(new ImageIcon("images/31.jpg"));
		look.setBounds(50, 350, 130, 118);
		// bg.add(look);

		Icon image1 = new ImageIcon("images/41.gif");
		title = new JLabel("更改用户信息");
		title.setForeground(Color.blue);
		title.setBounds(155, 30, 300, 30);
		title.setFont(new Font("华文行楷", Font.BOLD, 30));
		bg.add(title);

		// 控件
		QQid = new JLabel("Q  Q号码", image1, 0);
		QQid.setFont(new Font("黑体", Font.BOLD, 16));
		QQid.setForeground(Color.gray);
		QQid.setBounds(200, 100, 110, 40);
		bg.add(QQid);

		txtQQid = new JTextField();
		txtQQid.setText(idtable.getQQid()+"");
		System.out.println("QQ号码围殴"+idtable.getQQid());
		txtQQid.setBounds(320, 105, 200, 27);
		txtQQid.setFont(new Font("黑体", Font.BOLD, 16));
		txtQQid.setEditable(false);
		bg.add(txtQQid);

		QQname = new JLabel("Q  Q昵称", image1, 0);
		QQname.setFont(new Font("黑体", Font.BOLD, 16));
		QQname.setForeground(Color.gray);
		QQname.setBounds(200, 137, 110, 40);
		bg.add(QQname);

		txtQQname = new JTextField();
		txtQQname.setText(idtable.getQQname());
		txtQQname.setBounds(320, 145, 200, 27);
		bg.add(txtQQname);// 35 35

		age = new JLabel("年    龄", image1, 0);
		age.setFont(new Font("黑体", Font.BOLD, 16));
		age.setForeground(Color.gray);
		age.setBounds(200, 215, 110, 40);
		bg.add(age);

		txtage = new JTextField();
		txtage.setText(idtable.getAge()+"");
		txtage.setBounds(320, 225, 200, 27);
		bg.add(txtage);// 35 35

		sex = new JLabel("性    别", image1, 0);
		sex.setFont(new Font("黑体", Font.BOLD, 16));
		sex.setForeground(Color.gray);
		sex.setBounds(200, 250, 110, 40);
		bg.add(sex);

		if(idtable.getSex().equals("男")){
			man = new JRadioButton("男",true);
			weman = new JRadioButton("女");
		}else{
			man = new JRadioButton("男");
			weman = new JRadioButton("女",true);
		}
		bGroup = new ButtonGroup();
		bGroup.add(man);
		bGroup.add(weman);
		bg.add(man);
		bg.add(weman);

		nation = new JLabel("民    族", image1, 0);
		nation.setFont(new Font("黑体", Font.BOLD, 16));
		nation.setForeground(Color.gray);
		nation.setBounds(200, 285, 110, 40);
		bg.add(nation);

		jbnation = new JComboBox(sNation);
		for(int i=0;i<sNation.length;i++){
			if(sNation[i].equals(idtable.getNation())){
				jbnation.setSelectedIndex(i);
				break;
			}
		}
		jbnation.setBounds(240, 320, 70, 20);
		bg.add(jbnation);

		blood = new JLabel("血    型", image1, 0);
		blood.setFont(new Font("黑体", Font.BOLD, 16));
		blood.setForeground(Color.gray);
		
		blood.setBounds(320, 285, 110, 40);
		bg.add(blood);

		jbblood = new JComboBox(sBlood);
		for(int i=0;i<sBlood.length;i++){
			if(sBlood[i].equals(idtable.getBlood())){
				jbblood.setSelectedIndex(i);
				break;
			}
		}
		jbblood.setBounds(360, 320, 70, 20);
		bg.add(jbblood);

		start = new JLabel("星    座", image1, 0);
		start.setFont(new Font("黑体", Font.BOLD, 16));
		start.setForeground(Color.gray);
		start.setBounds(430, 285, 110, 40);
		bg.add(start);

		jbstart = new JComboBox(sStar);
		for(int i=0;i<sStar.length;i++){
			if(sStar[i].equals(idtable.getStart())){
				jbstart.setSelectedIndex(i);
				break;
			}
		}
		jbstart.setBounds(470, 320, 70, 20);
		bg.add(jbstart);


		hobit = new JLabel("签    名", image1, 0);
		hobit.setFont(new Font("黑体", Font.BOLD, 16));
		hobit.setForeground(Color.gray);
		hobit.setBounds(200, 180, 110, 40);
		bg.add(hobit);

		jahobit = new JTextField();
		jahobit.setText(idtable.getHobit());
		jahobit.setBounds(320, 185, 200, 30);
		bg.add(jahobit);

		remark = new JLabel("个 人 小 说 明");
		remark.setFont(new Font("黑体", Font.BOLD, 16));
		remark.setForeground(Color.gray);
		remark.setBounds(300, 345, 300, 40);
		bg.add(remark);

		jaremark = new JTextArea();
		jaremark.setText(idtable.getRemark());
		JScrollPane js1 = new JScrollPane(jaremark);
		jaremark.setBounds(200, 400, 330, 60);
		bg.add(jaremark);

		jtsave = new JButton("确认修改");
		jtsave.setFont(new Font("黑体", Font.BOLD, 24));
		jtsave.setForeground(Color.blue);
		jtsave.setBounds(200, 539, 200, 40);

		head.addActionListener(this);
		jtsave.addActionListener(this);
		bg.add(jtsave);
		setSize(600, 670);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 设置头像函数
	public void tubiao() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("Picture/qt.png");
		setIconImage(image);
	}

	public static void main(String[] args) {
		new Updatefriendfase1();
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jtsave) {
			kongzhi();
			idtable.setQQname(txtQQname.getText());
			idtable.setQQhead(headfase);
			idtable.setAge(Integer.parseInt(txtage.getText().trim()));
			if (man.isSelected()) {
				idtable.setSex("男神");
			} else {
				idtable.setSex("女神");
			}
			idtable.setNation(sNation[jbnation.getSelectedIndex()]);
			idtable.setStart(sStar[jbstart.getSelectedIndex()]);
			idtable.setBlood(sBlood[jbblood.getSelectedIndex()]);
			idtable.setHobit(jahobit.getText().trim());
			idtable.setRemark(jaremark.getText().trim());
			QQbase qqbase = new QQbase();
			// 将界面的值取到，并传递到QQbase函数里，在更新到数据库里，达到保存的效果
			idtable=qqbase.UpdateAccount(idtable);
			
			ImageIcon icon = new ImageIcon(idtable.getQQhead());
			//刷新主窗口的信息
			hf.head.setIcon(icon);
			hf.name.setText(idtable.getQQname());
			hf.qianming.setText(idtable.getHobit());
			
			dispose();
		} else if (e.getSource() == jtclose) {
			System.exit(0);
		} else if (e.getSource() == head) {
			head();
		}
		
	}
}
