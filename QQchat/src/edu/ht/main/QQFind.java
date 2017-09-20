package edu.ht.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import edu.ht.bean.QQMsg;
import edu.ht.bean.Qquser;
import edu.ht.common.Contents;
import edu.ht.common.SendMsg;
import edu.ht.service.QquserService;
import edu.ht.service.impl.QquserServiceImpl;

public class QQFind extends JFrame {
	JLabel xiao, close;
	JLabel l1, l2, l3;
	JTextField t1, t2, t3 ;
	JComboBox c1;
	JButton j1, j2, j3,j4;
	String[] sexs = { "-选择性别-", "男", "女" };
	// 表格模型
	DefaultTableModel tab = new DefaultTableModel();
	Vector title, data;
	JTable table;
	QquserService qserice = new QquserServiceImpl();
	Vector<Vector> vv;
	Qquser myuser;

	/***********/
	//设置界面可以拖动的方法
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQFind.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQFind.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQFind.this.getLocation().x + e.getX() - tmp.x,
							QQFind.this.getLocation().y + e.getY() - tmp.y);
					QQFind.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public QQFind(Qquser myuser) {
		super("查找好友");
		this.setDragable();//设置可以拖动
		this.myuser = myuser;
		// 设置窗口图标
		Image image = new ImageIcon("qqmain/tubiao.jpg").getImage();
		setIconImage(image);

		this.setUndecorated(true); // 去掉窗口的装饰

		// 设置样式
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Container c = getContentPane();

		
		// 最小化的位置
		xiao = new JLabel(new ImageIcon(""));
		xiao.setBounds(860, 2, 25, 25);
		c.add(xiao);
		xiao.addMouseListener(new MyMouseListener());
		// 让指针变成手型
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// 关闭
		close = new JLabel(new ImageIcon(""));
		close.setBounds(885,2, 25, 25);
		c.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MyMouseListener());


		l1 = new JLabel("QQ号：");
		l1.setBounds(100, 80, 60, 25);
		l1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(l1);
		
		t1 = new JTextField(25);
		t1.setBounds(165, 80, 120, 25);
		c.add(t1);

		l2 = new JLabel("昵称：");
		l2.setBounds(305, 80, 60, 25);
		l2.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(l2);

		t2 = new JTextField();
		t2.setBounds(345, 80, 120, 25);
		c.add(t2);

		l3 = new JLabel("年龄：");
		l3.setBounds(485, 80, 60, 25);
		l3.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(l3);

		t3 = new JTextField(5);
		t3.setBounds(520, 80, 70, 25);
		c.add(t3);

		c1 = new JComboBox(sexs);
		c1.setBounds(600, 80, 90, 25);
		c1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(c1);

		j1 = new JButton("查找");
		j1.setBounds(700, 80,70, 25);
		j1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(j1);
		
		j1.addActionListener(new MyActionListener());

		// 确定好表格的列
		title = new Vector();
		title.add("QQ号码");
		title.add("昵称    ");
		title.add("年龄");
		title.add("性别");
		title.add("民族");
		title.add("星座");
		title.add("电话");
		title.add("等级");
		title.add("个性签名       ");

		// 给表格模型加标题和数据
		tab.setDataVector(data, title);

		table = new JTable(tab);
		JScrollPane scroll = new JScrollPane(table);

		table.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		table.setForeground(new Color(45, 45, 23));

		c.add(scroll);
		scroll.setBounds(2,130,893,420);

		// 底部按钮
		j2 = new JButton("添加选中的好友");
		c.add(j2);
		j2.setBounds(600, 565,125, 25);

		j2.addActionListener(new MyActionListener());

		j3 = new JButton("取消");
		c.add(j3);
		j3.setBounds(750, 565,70, 25);

		j3.addActionListener(new MyActionListener());
		
		
		j4 = new JButton("查看资料");
		c.add(j4);
		j4.setBounds(500, 565,95, 25);

		j4.addActionListener(new MyActionListener());

		// 背景图片
		JLabel bgimg = new JLabel(new ImageIcon("qqmain/find.png"));
		c.add(bgimg);

		setSize(897,597);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == j1) {// 查找
				Qquser quser = new Qquser();
				String qqnum = t1.getText().trim();// QQ号
				String uname = t2.getText().trim();// 昵称

				int age = 0;
				if (t3.getText() != null && !"".equals(t3.getText())) {
					age = Integer.parseInt(t3.getText());
				}
				String sex = "";// 性别
				if (c1.getSelectedIndex() == 1) {
					sex = "男";
				} else if (c1.getSelectedIndex() == 2) {
					sex = "女";
				}

				quser.setQqnum(qqnum);
				quser.setUname(uname);
				quser.setAge(age);
				quser.setSex(sex);

				tab.setRowCount(0);// 控制显示的条数

				vv = qserice.selectFriend(quser);
				for (int i = 0; i < vv.size(); i++) {
					tab.addRow(vv.get(i));// 给表格插入数据
				}

			} else if (e.getSource() == j2) {// 添加选中的好友
				// 是否有好友被选中
				System.out.println(table.getSelectedRow() + " "
						+ table.getSelectedColumn());
				int index = table.getSelectedRow();
				if (index > -1) {

					Vector v = vv.get(index);// 从集合中取出选中的集合
					String qqnum = v.get(0).toString();
					// 选中的是不是自己
					if(qqnum.equals(myuser.getQqnum())){
						JOptionPane.showMessageDialog(null, "不能添加自己啊！");
						return ;
					}
					//检查我是否已经有了这个好友
					boolean bln=qserice.selFF(myuser.getQqnum(), qqnum);
					if(bln){
						JOptionPane.showMessageDialog(null, "对方已经是您的好友了！");
						return ;
					}
					System.out.println(qqnum);
					// 通过QQ号去查询用户对象 (得到要添加的好友对象)
					Qquser fruser = qserice.selUserByQQnum(qqnum);
					
					//发送添加好友的消息通知
					QQMsg msg=new QQMsg();
					msg.setCmd(Contents.CMD_ADDFRIEND);
					msg.setMyuser(myuser);
					msg.setFruser(fruser);
					new SendMsg().send(msg);
					JOptionPane.showMessageDialog(null, "请求已发送，请等待对方处理！");
				}

				

			} else if (e.getSource() == j3) {
				QQFind.this.dispose();
			}else if(e.getSource()==j4){//查看资料
				int index = table.getSelectedRow();
				if (index > -1) {

					Vector v = vv.get(index);// 从集合中取出选中的集合
					String qqnum = v.get(0).toString();
					// 通过QQ号去查询用户对象 (得到要添加的好友对象)
					Qquser fruser = qserice.selUserByQQnum(qqnum);
					new QQFriendInfo(fruser);
				}
			}
		}

	}


	// 鼠标事件的监听
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// 最小化按钮
			if (e.getSource() == xiao) {
				// 让面板最小化
				QQFind.this.setExtendedState(QQFind.this.ICONIFIED);
			} else if (e.getSource() == close) {
				QQFind.this.dispose();
			}
		}
	}
}
