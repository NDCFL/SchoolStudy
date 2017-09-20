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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class Lookfriendfase extends JFrame implements MouseListener{

	JLabel bg, title, touxiang, head1;
	JLabel QQid, QQname, QQhead, age, sex;
	JLabel start, blood, nation, hobit, remark;
	JRadioButton man, weman;
	QQidtable idtable;
	JButton jtsave, jtclose, head;
	private TrayIcon trayIcon = null;

	public Lookfriendfase(){
		
		
	}
	public Lookfriendfase(QQidtable idtable) {
		super("QQ注册");
		this.idtable=idtable;
		tubiao();
		bg = new JLabel(new ImageIcon("head/6.jpg"));
		bg.setLayout(null);
		add(bg);
		head = new JButton(new ImageIcon(idtable.getQQhead()));
		head.setBounds(230, 100, 60, 60);
		bg.add(head);

		title = new JLabel("好友资料");
		title.setForeground(Color.blue);
		title.setBounds(65, 30, 300, 30);
		title.setFont(new Font("华文行楷", Font.BOLD, 30));
		bg.add(title);

		// 控件
		QQid = new JLabel("账    号      "+idtable.getQQid());
		QQid.setFont(new Font("华文行楷", Font.BOLD, 20));
		QQid.setForeground(Color.BLUE);
		QQid.setBounds(20, 100, 200, 40);
		bg.add(QQid);


		QQname = new JLabel("昵    称      "+idtable.getQQname());
		QQname.setFont(new Font("华文行楷", Font.BOLD, 20));
		QQname.setForeground(Color.BLUE);
		QQname.setBounds(20, 140, 200, 40);
		bg.add(QQname);


		age = new JLabel("年    龄      "+idtable.getAge());
		age.setFont(new Font("华文行楷", Font.BOLD, 20));
		age.setForeground(Color.BLUE);
		age.setBounds(20, 180, 200, 40);
		bg.add(age);


		sex = new JLabel("性    别      "+idtable.getSex());
		sex.setFont(new Font("华文行楷", Font.BOLD, 20));
		sex.setForeground(Color.BLUE);
		sex.setBounds(20, 220, 200, 40);
		bg.add(sex);


		nation = new JLabel("民    族      "+idtable.getNation());
		nation.setFont(new Font("华文行楷", Font.BOLD, 20));
		nation.setForeground(Color.BLUE);
		nation.setBounds(20, 260, 200, 40);
		bg.add(nation);


		blood = new JLabel("血    型      "+idtable.getBlood());
		blood.setFont(new Font("华文行楷", Font.BOLD, 20));
		blood.setForeground(Color.BLUE);
		
		blood.setBounds(20, 300, 200, 40);
		bg.add(blood);


		start = new JLabel("星    座      "+idtable.getStart());
		start.setFont(new Font("华文行楷", Font.BOLD, 20));
		start.setForeground(Color.BLUE);
		start.setBounds(20, 340, 200, 40);
		bg.add(start);



		hobit = new JLabel("签    名      "+idtable.getHobit());
		hobit.setFont(new Font("华文行楷", Font.BOLD, 20));
		hobit.setForeground(Color.BLUE);
		hobit.setBounds(20, 380, 200, 40);
		bg.add(hobit);


		remark = new JLabel("个人说明      "+idtable.getRemark());
		remark.setFont(new Font("华文行楷", Font.BOLD, 20));
		remark.setForeground(Color.BLUE);
		remark.setBounds(20, 420, 200, 40);
		bg.add(remark);

		addMouseListener(this);
		setSize(300, 500);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// 设置头像函数
	public void tubiao() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(idtable.getQQhead());
		setIconImage(image);
	}

	public static void main(String[] args) {
		new Lookfriendfase();
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		dispose();
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




}
