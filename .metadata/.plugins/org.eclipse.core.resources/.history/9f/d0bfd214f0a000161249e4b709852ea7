package edu.ht.main;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
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


public class QQUpdInfo extends JFrame {
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JPasswordField pwd1, pwd2;
	JRadioButton sex1, sex2;
	String[] stars = { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座",
			"处女座", "天秤座", "天蝎座", "射手座" };
	String[] nations = { "汉族", "满族", "藏族", "白族", "傣族", "苗族", "高山族", "畲族", "回族",
			"壮族", "彝族" };
	JComboBox com1, com2,com3;
	JTextArea txt1;

	QquserService qservice = new QquserServiceImpl();
	ImageIcon[] faces=new ImageIcon[10];
	Qquser qq;
	QQMain mm;
	public QQUpdInfo(Qquser quser,QQMain main) {
		super("修改资料");
		this.qq=quser;
		this.mm=main;
		// 设置窗口图标
		Image image = new ImageIcon("img/tubiao.png").getImage();
		setIconImage(image);
		Container c = getContentPane();
		for (int i = 0; i < 10; i++) {
			faces[i]=new ImageIcon("img/"+i+".png");
		}
		
		// 设置样式
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel face=new JLabel(new ImageIcon(quser.getFace()));
		face.setBounds(80, 5, 150, 50);
		c.add(face);
		
		
		// 标题
		JLabel title = new JLabel("修改头像");
		title.setBounds(75, 20,60 ,20);
		c.add(title);

		// 昵称
		JLabel luname = new JLabel("昵称：");
		luname.setBounds(75, 70, 40, 20);
		c.add(luname);

		t1 = new JTextField();
		t1.setBounds(120, 70, 180, 20);
		c.add(t1);

		// 昵称
		JLabel lpwd1 = new JLabel("密码：");
		lpwd1.setBounds(75, 120, 40, 20);
		c.add(lpwd1);

		pwd1 = new JPasswordField();
		pwd1.setBounds(120, 120, 180, 20);
		c.add(pwd1);

		// 昵称
		JLabel lpwd2 = new JLabel("确认密码：");
		lpwd2.setBounds(55, 170, 70, 20);
		c.add(lpwd2);

		pwd2 = new JPasswordField();
		pwd2.setBounds(120, 170, 180, 20);
		c.add(pwd2);

		// 性别
		JLabel lsex = new JLabel("性别：");
		lsex.setBounds(75, 220, 70, 20);
		c.add(lsex);

		sex1 = new JRadioButton("男");
		sex1.setBounds(120, 220, 40, 20);
		sex1.setSelected(true);
		sex2 = new JRadioButton("女");
		sex2.setBounds(160, 220, 40, 20);

		c.add(sex1);
		c.add(sex2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(sex1);
		bg.add(sex2);
		
		//头像
		com3=new JComboBox(faces);
		com3.setBounds(230, 5, 90, 60);
		c.add(com3);

		// 电话
		JLabel ltel = new JLabel("电话：");
		ltel.setBounds(75, 270, 40, 20);
		c.add(ltel);

		t2 = new JTextField();
		t2.setBounds(120, 270, 180, 20);
		c.add(t2);

		// 星座
		JLabel lstar = new JLabel("星座：");
		lstar.setBounds(75, 320, 40, 20);
		c.add(lstar);

		com1 = new JComboBox(stars);
		com1.setBounds(120, 320, 70, 20);
		c.add(com1);
		// 星座
		JLabel lnation = new JLabel("民族：");
		lnation.setBounds(205, 320, 40, 20);
		c.add(lnation);

		com2 = new JComboBox(nations);
		com2.setBounds(240, 320, 60, 20);
		c.add(com2);

		// 星座
		JLabel ltxt = new JLabel("个性签名：");
		ltxt.setBounds(55, 370, 70, 20);
		c.add(ltxt);

		txt1 = new JTextArea();
		txt1.setBounds(120, 370, 180, 70);
		c.add(txt1);

		JButton b1 = new JButton("修改");
		b1.setBounds(75, 460, 70, 30);
		c.add(b1);
		b1.addActionListener(new MyActionListener());

		JButton b2 = new JButton("取消");
		b2.setBounds(255, 460, 70, 30);
		c.add(b2);
		b2.addActionListener(new MyActionListener());
		
		
		//给组件设值
		t1.setText(quser.getUname());//昵称
		
		pwd1.setText(quser.getPwd());//密码
		pwd2.setText(quser.getPwd());
		
		if(quser.getSex().equals("男")){//性别
			sex1.setSelected(true);
		}else {
			sex2.setSelected(true);
		}
		t2.setText(quser.getTel());
		
		com1.setSelectedItem(quser.getStar());//星座
		com2.setSelectedItem(quser.getNation());//民族
		String faces=quser.getFace();//imgs/4.png
		faces=faces.substring(faces.indexOf("/")+1,faces.indexOf("."));
		com3.setSelectedIndex(Integer.parseInt(faces));
		txt1.setText(quser.getTxt());//个性签名
		

		// 背景图片
		JLabel bgimg = new JLabel(new ImageIcon(""));
		c.add(bgimg);

		setSize(400, 550);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("修改")) {
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
					//设置QQ号
					quser.setQqnum(qq.getQqnum());
					quser.setUname(nickname);
					quser.setPwd(p2);
					// 设置性别
					if (sex1.isSelected()) {
						quser.setSex("男");
					} else if (sex2.isSelected()) {
						quser.setSex("女");
					}
					// 默认头像
					quser.setFace("img/"+com3.getSelectedIndex()+".png");
					quser.setTel(t2.getText().trim());
					//直接取下拉框文字
//					System.out.println(com1.getSelectedItem().toString());
					quser.setStar(stars[com1.getSelectedIndex()]);// 星座
					quser.setNation(nations[com2.getSelectedIndex()]);// 民族
					quser.setTxt(txt1.getText());
					
					
					boolean bln = qservice.updInfo(quser);
					if (bln) {
//						/让主面板刷新个人资料
						mm.nickname.setText(nickname);
						mm.qianming.setText(txt1.getText());
						mm.quser.setUname(nickname);
						mm.quser.setTxt(txt1.getText());
						mm.face.setIcon(new ImageIcon(("img/"+com3.getSelectedIndex()+".png")));
						JOptionPane.showMessageDialog(null, "恭喜修改成功！");
						QQUpdInfo.this.dispose();//关闭注册窗口
					} else {
						JOptionPane.showMessageDialog(null, "修改失败!");
					}
				}
			} else if (e.getActionCommand().equals("取消")){
				QQUpdInfo.this.dispose();//关闭注册窗口
			}
		}

	}
}
