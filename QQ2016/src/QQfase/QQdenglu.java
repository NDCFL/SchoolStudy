package QQfase;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import QQbean.QQidtable;
import SQLBase.OpenWeb;
import SQLBase.QQbase;

@SuppressWarnings("serial")
public class QQdenglu extends JFrame implements ActionListener,ItemListener,MouseListener,MouseMotionListener,KeyListener{
	private TrayIcon trayIcon = null;
	HashMap<Integer, QQidtable> hm =null;
	JLabel lbzhuce,lbfindpwd,head,lb1,lb2,lb3,ppt;
	JButton denglu;
	JComboBox txtQQid;
	JPasswordField password;
	JCheckBox jkpwd,jkdenglu;
	JLabel bg;
	QQbase qqbase = new QQbase();
	public QQdenglu() {
		super("QQ登录");
		jbInit();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("Picture/qt.png");
		setIconImage(image);
		setUndecorated(true);
		bg = new JLabel(new ImageIcon("drpicture/QQ.gif"));
		add(bg);
		
		lb1 = new JLabel("  ");
		lb1.setBounds(345, 3, 20, 20);
		lb1.setOpaque(false);
		bg.add(lb1);
		
		lb2 = new JLabel("  ");
		lb2.setBounds(378, 3, 20, 20);
		lb2.setOpaque(false);
		bg.add(lb2);
		
		lb3 = new JLabel("  ");
		lb3.setBounds(410, 3, 20, 20);
		lb3.setOpaque(false);
		bg.add(lb3);
		
		lbzhuce = new JLabel("      ");
		lbzhuce.setOpaque(false);
		lbzhuce.setBounds(330, 195, 60, 20);
		bg.add(lbzhuce);
		
		lbfindpwd = new JLabel("      ");
		lbfindpwd.setOpaque(false);
		lbfindpwd.setBounds(330, 230, 60, 20);
		bg.add(lbfindpwd);
		
		denglu= new JButton(new ImageIcon("head/1.png"));
		denglu.setOpaque(false);
		denglu.setBackground(new Color(250,250,250));
		denglu.setBounds(136, 287, 195, 30);
		denglu.setForeground(Color.white);
		bg.add(denglu);
		
		ppt = new JLabel("  ");
		ppt.setBounds(14, 305, 22,20);
		bg.add(ppt);
		
		txtQQid = new JComboBox();
		txtQQid.setBackground(Color.white);
		txtQQid.setBounds(135, 195, 194, 30);
		txtQQid.setToolTipText("QQ账号");
		txtQQid.setEditable(true);
		bg.add(txtQQid);
		
		password = new JPasswordField();
		password.setBounds(136, 225, 194, 30);
		password.setToolTipText("QQ密码");
		password.setEchoChar('♬');
		bg.add(password);
		
		jkpwd = new JCheckBox("记住密码");
		jkpwd.setBounds(130, 260, 80, 20);
		bg.add(jkpwd);
		
		jkdenglu = new JCheckBox("自动登录");
		jkdenglu.setBounds(260, 260, 80, 20);
		bg.add(jkdenglu);
		
		head = new JLabel(new ImageIcon("drpicture/4.png"));
		head.setBounds(45, 195, 81, 80);
		bg.add(head);
		
		this.addKeyListener(this);
		denglu.addKeyListener(this);
		lbzhuce.addMouseListener(this);
		lbfindpwd.addMouseListener(this);
		denglu.addActionListener(this);
		lb1.addMouseListener(this);
		lb2.addMouseListener(this);
		lb3.addMouseListener(this);
		txtQQid.addItemListener(this);
		bg.addMouseMotionListener(this);
		bg.addMouseListener(this);
		jkpwd.addActionListener(this);
		ppt.addMouseListener(this);
		
		readFile();
		setSize(432, 330);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new QQdenglu();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==denglu) {
			
			String qqcode=txtQQid.getSelectedItem().toString();
			String pwd = password.getText().trim();
			if(txtQQid.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(this, "请输入QQ号码");
				return;
			}
			try{
				Integer.parseInt(txtQQid.getSelectedItem().toString().trim());
			}catch(Exception e2){
				JOptionPane.showMessageDialog(this, "QQ账号不能出现字符");
				return;
			}
			if(pwd.equals("")){
				JOptionPane.showMessageDialog(this, "请输入登录密码");
				return;
			}
			qqcode = txtQQid.getSelectedItem().toString();
			int qqid = Integer.parseInt(txtQQid.getSelectedItem().toString());
			QQidtable idtable = new QQidtable();
			if (qqbase.isonline(qqid)) {
				JOptionPane.showMessageDialog(this, "登录失败，你已经在线了!");
				return;
			}
			idtable.setQQid(Integer.parseInt(qqcode));
			idtable.setQQpassword(pwd);
			idtable = new QQbase().login(idtable);
			if(idtable==null){
				JOptionPane.showMessageDialog(this, "登录失败，用户名或密码错误!");
				return;
			}else{
				try {
					saveQQ(idtable);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
				new haoyoufase(idtable);
			}
		}
	}
	//保存登录成功的QQ号码到文件中
	public void saveQQ(QQidtable qt){
		HashMap<Integer, QQidtable> user =null;
		File file = new File("qq.dat");
		try {
			if(!file.exists()){//第一次使用QQ
					file.createNewFile();
					user = new HashMap<Integer, QQidtable>();
			}else{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				//读取文件内容
				user = (HashMap<Integer, QQidtable>)ois.readObject();
				fis.close();
				ois.close();
			}
			user.put(qt.getQQid(), qt);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("qq.dat"));
			oos.writeObject(user);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//读取文件内容
	public void readFile(){
		try{
			File file = new File("qq.dat");
			//文件不存在就结束
			if(!file.exists()){
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			//成员变量，不是局部变量
			hm = (HashMap<Integer, QQidtable>)ois.readObject();
			Set<Integer> set = hm.keySet();
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()){
				txtQQid.addItem(it.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void itemStateChanged(ItemEvent e) {
		int qqcode = Integer.parseInt(txtQQid.getSelectedItem().toString());
		if(txtQQid.getSelectedItem().toString()!=null && txtQQid.getSelectedItem().toString()!=null && qqcode>=0&& qqcode<=1000000000){
			QQidtable idtable = hm.get(qqcode);
			try{
				Integer.parseInt(txtQQid.getSelectedItem().toString().trim());
			}catch(Exception e2){
				JOptionPane.showMessageDialog(this, "QQ账号不能出现字符");
				return;
			}
			if (idtable!=null || qqcode>=0&& qqcode<=1000000000 || head.getText()!=null) {
				head.setIcon(new ImageIcon(idtable.getQQhead()));
				password.setText(idtable.getQQpassword());
			}
		}
	}
	public void jbInit() {

		if (SystemTray.isSupported()) { // 检查当前系统是否支持系统托盘

			SystemTray tray = SystemTray.getSystemTray();// 获取表示桌面托盘区的
															// SystemTray 实例。

			Image image = Toolkit.getDefaultToolkit().getImage("image/111.png");

			PopupMenu popupMenu = new PopupMenu();

			MenuItem exitItem = new MenuItem("关闭");

			MenuItem menuItema = new MenuItem("在线状态");

			MenuItem menuItemb = new MenuItem("离线");

			final MenuItem menuItemc = new MenuItem("注册用户");

			MenuItem menuItemd = new MenuItem("主界面");

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

						new QQmainfase();

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
		if (e.getSource()==lbzhuce) {
			new QQmainfase();
		}else if (e.getSource()==lbfindpwd) {
			int qqcode = Integer.parseInt(txtQQid.getSelectedItem().toString());
			QQidtable idtable = hm.get(qqcode);
			JOptionPane.showMessageDialog(this, "你的密码忘记了！你需要填写资料找回");
			new FindPassword();
			//JOptionPane.showMessageDialog(this, "密码为"+idtable.getQQpassword());
		}else if (e.getSource()==lb1) {
			JOptionPane.showMessageDialog(this, "你点击了设置按钮");
		}else if (e.getSource()==lb2) {
			setState(JFrame.HIDE_ON_CLOSE);
		}else if (e.getSource()==lb3) {
			System.exit(0);
		}else if (e.getSource()==ppt) {
			new OpenWeb("QQ项目答辩.pptx");
		}
		
	}
	int x,y;
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {
		x= this.getX();
		y= this.getY();
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
		this.setLocation(x+e.getX(),y+e.getY());
		x= this.getX()/2;
		y= this.getY()/2;
	
	}
	public void mouseMoved(MouseEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==10) {
			JOptionPane.showMessageDialog(this, "你按了回车");
		}
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 

}
