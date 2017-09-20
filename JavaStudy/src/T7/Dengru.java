package T7;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import T15_1.QQzhuce1;

public class Dengru extends JFrame{
	private TrayIcon trayIcon = null;
	Panel p1,p2;
	JPanel south,center;
	JButton close,zhuce;
	JLabel title,name,password,qpassword,cardid,age,sex,mingzu,hobit,shuoming;
	JTextField usename,card,age1;
	JPasswordField pass,qpass;
	JRadioButton man,weman;
	ButtonGroup btsex;
	JComboBox  nation;
	JCheckBox sing,dance,game,slepp,eat,sport;
	JTextArea shuomin;
	public Dengru() {
		super("用户注册");
		setBackground(Color.PINK);
		setSize(500, 600);
		title = new JLabel("QQ注册",JLabel.CENTER);
		title.setFont(new Font("华文行楷",Font.BOLD,32));
		title.setForeground(Color.blue);
		title.setBackground(Color.black);
		center = new JPanel(null);
		south = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		zhuce = new JButton("注册");
		close = new JButton("关闭");
		zhuce.setFont(new Font("华文行楷",Font.BOLD,20));
		zhuce.setForeground(Color.PINK);
		close.setFont(new Font("华文行楷",Font.BOLD,20));
		close.setForeground(Color.PINK);
		south.add(zhuce);
		south.add(close);
		add(title,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(center,BorderLayout.CENTER);
		
		name = new JLabel("QQ昵称 ",JLabel.RIGHT);
		name.setFont(new Font("华文行楷",Font.BOLD,16));
		name.setForeground(Color.blue);
		name.setBounds(100, 30, 100, 30);
		usename = new JTextField();
		usename.setBounds(200, 30, 200, 30);
		center.add(name);
		center.add(usename);
		
		password = new JLabel("QQ密码 ",JLabel.RIGHT);
		password.setFont(new Font("华文行楷",Font.BOLD,16));
		password.setForeground(Color.blue);
		password.setBounds(100, 70, 100, 30);
		pass = new JPasswordField();
		pass.setBounds(200, 70, 200, 30);
		center.add(password);
		center.add(pass);
		
		qpassword = new JLabel("确认密码 ",JLabel.RIGHT);
		qpassword.setFont(new Font("华文行楷",Font.BOLD,16));
		qpassword.setForeground(Color.blue);
		qpassword.setBounds(100, 110, 100, 30);
		qpass = new JPasswordField();
		qpass.setBounds(200, 110, 200, 30);
		center.add(qpassword);
		center.add(qpass);
		
		
		age = new JLabel("年龄 ",JLabel.RIGHT);
		age.setFont(new Font("华文行楷",Font.BOLD,16));
		age.setForeground(Color.blue);
		age.setBounds(100, 150, 100, 30);
		age1 = new JTextField();
		age1.setBounds(200, 150, 200, 30);
		center.add(age);
		center.add(age1);
		
		
		cardid = new JLabel("身份证号码 ",JLabel.RIGHT);
		cardid.setFont(new Font("华文行楷",Font.BOLD,16));
		cardid.setForeground(Color.blue);
		cardid.setBounds(100, 190, 100, 30);
		card = new JTextField();
		card.setBounds(200, 190, 200, 30);
		center.add(cardid);
		center.add(card);
		
		sex = new JLabel("性别 ",JLabel.RIGHT);
		sex.setFont(new Font("华文行楷",Font.BOLD,16));
		sex.setForeground(Color.blue);
		sex.setBounds(100, 230, 100, 30);
		man = new JRadioButton("男");
		man.setFont(new Font("华文行楷",Font.BOLD,16));
		man.setForeground(Color.blue);
		man.setSelected(true);
		man.setBounds(220, 230, 50, 30);
		weman = new JRadioButton("女");
		weman.setFont(new Font("华文行楷",Font.BOLD,16));
		weman.setForeground(Color.blue);
		weman.setBounds(280, 230, 50, 30);
		btsex = new ButtonGroup();
		btsex.add(man);
		btsex.add(weman);
		center.add(sex);
		center.add(man);
		center.add(weman);
		
		mingzu = new JLabel("民族 ",JLabel.RIGHT);
		mingzu.setFont(new Font("华文行楷",Font.BOLD,16));
		mingzu.setForeground(Color.blue);
		mingzu.setBounds(100, 270, 100, 30);
		String [] mz={"汉族","壮族","独龙族","苗族","藏族","高山族","傣族"};
		nation = new JComboBox(mz);
		nation.setBounds(200, 270, 200, 30);
		center.add(mingzu);
		center.add(nation);
		
		hobit = new JLabel("爱好 ",JLabel.RIGHT);
		hobit.setFont(new Font("华文行楷",Font.BOLD,16));
		hobit.setForeground(Color.blue);
		hobit.setBounds(100, 310, 100, 30);
		sing = new JCheckBox("唱歌");
		sing.setFont(new Font("华文行楷",Font.BOLD,16));
		sing.setForeground(Color.blue);
		sing.setBounds(200, 310, 60, 30);
		
		dance= new JCheckBox("跳舞");
		dance.setFont(new Font("华文行楷",Font.BOLD,16));
		dance.setForeground(Color.blue);
		dance.setBounds(260, 310, 60, 30);
		
		game= new JCheckBox("玩游戏");
		game.setFont(new Font("华文行楷",Font.BOLD,16));
		game.setForeground(Color.blue);
		game.setBounds(320, 310, 80, 30);
		
		slepp= new JCheckBox("睡觉");
		slepp.setFont(new Font("华文行楷",Font.BOLD,16));
		slepp.setForeground(Color.blue);
		slepp.setBounds(200, 350, 60, 30);
		
		eat= new JCheckBox("吃饭");
		eat.setFont(new Font("华文行楷",Font.BOLD,16));
		eat.setForeground(Color.blue);
		eat.setBounds(260, 350, 60, 30);
		
		sport= new JCheckBox("运动");
		sport.setFont(new Font("华文行楷",Font.BOLD,16));
		sport.setForeground(Color.blue);
		sport.setBounds(320, 350, 60, 30);
		center.add(hobit);
		center.add(sing);
		center.add(dance);
		center.add(game);
		center.add(slepp);
		center.add(eat);
		center.add(sport);
		
		shuoming = new JLabel("显显小身手 ",JLabel.RIGHT);
		shuoming.setFont(new Font("华文行楷",Font.BOLD,16));
		shuoming.setForeground(Color.blue);
		shuoming.setBounds(100, 390, 100, 30);
		shuomin = new JTextArea();
		JScrollPane jS = new JScrollPane(shuomin);
		jS.setBounds(200, 390, 200, 80);
		center.add(shuoming);
		center.add(jS);
		
		ActionHandle a = new ActionHandle();
		zhuce.addActionListener(a);
		close.addActionListener(a);
		
		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void jbInit() {

		if (SystemTray.isSupported()) { // 检查当前系统是否支持系统托盘

			SystemTray tray = SystemTray.getSystemTray();// 获取表示桌面托盘区的
															// SystemTray 实例。

			Image image = Toolkit.getDefaultToolkit().getImage("images/1.gif");

			PopupMenu popupMenu = new PopupMenu();

			MenuItem exitItem = new MenuItem("关闭");

			MenuItem menuItema = new MenuItem("menu a");

			MenuItem menuItemb = new MenuItem("menu b");

			MenuItem menuItemc = new MenuItem("menu c");

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

			popupMenu.add(menuItema);

			popupMenu.add(menuItemb);

			popupMenu.add(menuItemc);

			popupMenu.add(menuItemd);

			popupMenu.add(exitItem);

			trayIcon = new TrayIcon(image, "系统托盘{kissjava}", popupMenu);

			trayIcon.addMouseListener(new java.awt.event.MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					if (e.getClickCount() == 2) {

						showIT(true);

					}

				}

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

			URL url = new URL("http://img1.qq.com/ent/pics/11436/11436218.jpg");

			icon = new ImageIcon(url);

		} catch (Exception e) {

		}

		JLabel label = new JLabel();

		label.setIcon(icon);

		this.add(label);

	}
	public void showIT(boolean visable) {

		if (this.isVisible() != visable)

			this.setVisible(visable);

	}
	class ActionHandle implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==zhuce) {
				
				if(usename.getText().equals("")){
					JOptionPane.showMessageDialog(null, "昵称不能为空");
					usename.requestFocus();
					return;
				}
				if (usename.getText().equals("陈飞龙")) {
					JOptionPane.showMessageDialog(null, "该昵称已被占用");
					usename.requestFocus();
					return;
				}
				if (pass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					pass.requestFocus();
					return;
				}
				if (qpass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "确认密码不能为空");
					pass.requestFocus();
					return;
				}
				if (!pass.getText().equals(qpass.getText())) {
					JOptionPane.showMessageDialog(null, "两次密码不一致");
					qpass.requestFocus();
					return;
				}
				if (age1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "年龄不能为空");
					age1.requestFocus();
					return;
				}
				int age2=0;
				try {
					age2=Integer.parseInt(age1.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "年龄必须为数字");
					age1.requestFocus();
					return;
				}
				if (age2>200 || age2<0) {
					JOptionPane.showMessageDialog(null, "年龄必须0到200之间");
					age1.requestFocus();
					return;
				}
				if (card.getText().length()!=18) {
					JOptionPane.showMessageDialog(null, "身份证号码为18位数");
					usename.requestFocus();
					return;
				}
				JOptionPane.showMessageDialog(null, "注册成功");
				
				//System.out.println("用户名："+usename.getText());
				System.out.println("QQ号为："+Math.round(257300091));
				System.exit(0);
			}else if (e.getSource()==close) {
				System.exit(0);
			}
		}
		
	}
	public static void main(String[] args) {
		new Dengru();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new QQzhuce1().setVisible(true);

			}

		});

	}
}
