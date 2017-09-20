package edu.ht.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import edu.ht.border.SetbtnBorder;

import edu.ht.bean.QQMsg;
import edu.ht.bean.Qquser;
import edu.ht.common.ClarityButton;
import edu.ht.common.Contents;
import edu.ht.common.SendMsg;
import edu.ht.common.Sound;
import edu.ht.common.TipUi;
import edu.ht.main.QQLogin.MyActionListener;
import edu.ht.main.QQLogin.MyMouseListener;
import edu.ht.service.QquserService;
import edu.ht.service.impl.QquserServiceImpl;

public class QQMain extends JFrame {
	JLabel xiao, close, state, findUser, nickname,qianming,face,bk;
	JTextArea chazhao;
	JList flist, famlist, classmlist, blackslist;
	//
	Vector<Qquser> fvecot, famvecot, classvecot, blackvecot;
	ClarityButton cb,cb1;
	QquserService qservice = new QquserServiceImpl();
	Qquser quser, frienduser;
	JPopupMenu popup, pop;// ����ʽ�˵�
	JMenuItem talk, sel, del, mfriend, mfamily, mclass, mblacks, i1, i2, i3,
			i4;// �˵���
	JButton kj ;
	// �����������
	Map<String, QQChat> chats;

	// ϵͳ������
	TrayIcon tray;// (��Ҫ�����Լ���JDK)
	PopupMenu traypop;// ����ͼ����Ҽ�˵�
	MenuItem it1, it2,it3,it4,it5,it6;// �˵�
	/***********/
	//���ý�������϶��ķ���
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQMain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQMain.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQMain.this.getLocation().x + e.getX() - tmp.x,
							QQMain.this.getLocation().y + e.getY() - tmp.y);
					QQMain.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public QQMain(Qquser qu) {
		super("QQ");
		this.quser = qu;
		this.setUndecorated(true); // ȥ��ڵ�װ��
		this.setDragable();//���ÿ����϶�
		this.createPopupMenu();// ��������ʽ�˵�
		// ���ô���ͼ��
		Image image = new ImageIcon("qqmain/tubiao.jpg").getImage();
		setIconImage(image);
		// ������ʽ
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ���ڹرռ���
		this.addWindowListener(new MyWindowListener());

		Container c = getContentPane();

		// ��С����λ��
		xiao = new JLabel(new ImageIcon("qqmain/xiao1.png"));
		xiao.setBounds(230, 7, 25, 20);
		c.add(xiao);
		xiao.addMouseListener(new MyMouseListener());
		// ��ָ��������
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// �ر�
		close = new JLabel(new ImageIcon("qqmain/close1.png"));
		close.setBounds(255, 4, 25, 20);
		c.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MyMouseListener());

		// ״̬ѡ��
		String stateimg = "qqmain/s_online.png";
		if (quser.getState() == Contents.STATE_HIDE) {// �������
			stateimg = "qqmain/s_hide.png";
		} else if (quser.getState() == Contents.STATE_BUSY) {// �������
			stateimg = "qqmain/s_busy.png";
		} else if (quser.getState() == Contents.STATE_LEAVE) {// �������
			stateimg = "qqmain/s_leave.png";
		}
		state = new JLabel(new ImageIcon("qqmain/s_online.png"));
		state.setBounds(116, 44, 15, 15);
		c.add(state);
		state.addMouseListener(new MyMouseListener());

		pop = new JPopupMenu();
		i1 = new JMenuItem("����", new ImageIcon("state/s_online.png"));
		i2 = new JMenuItem("����", new ImageIcon("state/s_hide.png"));
		i3 = new JMenuItem("æµ", new ImageIcon("state/s_busy.png"));
		i4 = new JMenuItem("�뿪", new ImageIcon("state/s_leave.png"));
		pop.add(i1);
		pop.add(i2);
		pop.add(i3);
		pop.add(i4);

		i1.addActionListener(new MyActionListener());
		i2.addActionListener(new MyActionListener());
		i3.addActionListener(new MyActionListener());
		i4.addActionListener(new MyActionListener());

		// ��ʾ�ǳ�
		nickname = new JLabel(quser.getUname());
		nickname.setFont(new Font("΢���ź�", Font.BOLD, 18));
		nickname.setBounds(72, 30, 100, 50);
		c.add(nickname);
		
		
		face = new JLabel(new ImageIcon(quser.getFace()));
		face.setBounds(5, 42, 64, 64);
		c.add(face);
		face.setForeground(Color.BLACK);
		face.setCursor(new Cursor(Cursor.HAND_CURSOR));
		face.addMouseListener(new MyMouseListener());
		face.setToolTipText("��������");
		
		//ͷ��߿�
		bk = new JLabel(new ImageIcon("qqmain/txbk.png"));
		bk.setBounds(5, 42, 64, 64);
		c.add(bk);
		
		// ��ʾ����ǩ��
		qianming = new JLabel(quser.getTxt());
		qianming.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		qianming.setBounds(75, 55, 100, 40);
		c.add(qianming);
		qianming.setForeground(Color.BLACK);

		flist = new JList();
		famlist = new JList();
		classmlist = new JList();
		blackslist = new JList();

		flist.addMouseListener(new MyMouseListener());
		famlist.addMouseListener(new MyMouseListener());
		classmlist.addMouseListener(new MyMouseListener());
		blackslist.addMouseListener(new MyMouseListener());

		// ��̬��������
		this.flushMain();
		// �����л����
		JTabbedPane tab = new JTabbedPane();

		tab.add("����", flist);
		tab.add("����", famlist);
		tab.add("ͬѧ", classmlist);
		tab.add("����", blackslist);
//		tab.add("qqȺ/������",qunlist);
		c.add(tab);
		tab.setBounds(0, 144, 281, 471);
		
		//���Ҳ��ұ��غ��ѳ����
		chazhao = new JTextArea();
		setBounds(1, 107, 260, 30);
		c.add(chazhao);
		
		//͸��ť ���ұ��غ���
		cb=new ClarityButton("");  
		cb.setBounds(74, 87, 20, 20);  
		c.add(cb); 
		
		// ���Һ��ѣ��㷶Χ������
		findUser = new JLabel(new ImageIcon(""));
		findUser.setBounds(160, 645, 60, 20);
		c.add(findUser);
		findUser.addMouseListener(new MyMouseListener());
		findUser.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// ����ͼƬ
		JLabel bgimg = new JLabel(new ImageIcon("qqmain/qqmain1.png"));
		c.add(bgimg);
		setSize(281, 673);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1000, 50);
		// ������߳�
		new MyThread().start();
		System.out.println(quser.getState());
		// ��¼�����ѡ��������� ��ȥ֪ͨ����
		if (quser.getState() == Contents.STATE_ONLINE) {
			// ����֪ͨ���к���
			this.notice(Contents.CMD_INLINE);
		} else if (quser.getState() == Contents.STATE_HIDE) {
			// ����֪ͨ���к���
			this.notice(Contents.CMD_HIDE);
		} else if (quser.getState() == Contents.STATE_BUSY) {
			// ����֪ͨ���к���
			this.notice(Contents.CMD_BUSY);
		} else if (quser.getState() == Contents.STATE_LEAVE) {
			// ����֪ͨ���к���
			this.notice(Contents.CMD_LEAVE);
		}

	}

	// ��������ͼ��ķ��� (�ڴ�����С��ʱ���� )
	public void createTray() {
		createTrayPop();// ���������Ҽ��˵�
		Image image = new ImageIcon(quser.getFace()).getImage();
		tray = new TrayIcon(image, quser.getUname() + "[" + quser.getQqnum()
				+ "]", traypop);
		tray.setImageAutoSize(true);// ��ͼ���Զ������С
		tray.addMouseListener(new MyMouseListener());// ������ͼ��Ӽ���
	}

	public void createTrayPop() {
		traypop = new PopupMenu();
		it1 = new MenuItem("�������");
		it2 = new MenuItem("�˳�");
		traypop.add(it1);
		traypop.add(it2);

		it1.addActionListener(new MyActionListener());
		it2.addActionListener(new MyActionListener());
	}

	class MyListModel extends AbstractListModel {
		Vector<Qquser> vv = new Vector<Qquser>();

		public MyListModel(Vector<Qquser> users) {
			this.vv = users;
		}

		public Object getElementAt(int index) {
			return null;
		}

		public int getSize() {
			return vv.size();
		}
	}

	// ��̬���Jlist�е�ѡ��
	class MyDefaultListCellRenderer extends DefaultListCellRenderer {
		Vector<Qquser> datas = new Vector<Qquser>();

		public MyDefaultListCellRenderer(Vector<Qquser> users) {
			this.datas = users;
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			// JList ����� �Ž�ȥ
			if (index >= 0 && index <= datas.size()) {
				Qquser quser = datas.get(index);
				String icon = quser.getFace();// ͼƬ·��
				// ����ͷ��
				// ����������������
				if (quser.getState() == Contents.STATE_HIDE
						|| quser.getState() == Contents.STATE_DOWNLINE) {
					// ��
					icon = icon.substring(0, icon.indexOf("."));
					icon = icon + "_h.png"; // imgs/0_h.png
					// ����
				} else if (quser.getState() == Contents.STATE_ONLINE) {
					// �������
				} else if (quser.getState() == Contents.STATE_BUSY) {
					icon = icon.substring(0, icon.indexOf("."));
					icon = icon + "_w.png"; // imgs/0_h.png
					// �뿪
				} else if (quser.getState() == Contents.STATE_LEAVE) {
					icon = icon.substring(0, icon.indexOf("."));
					icon = icon + "_l.png"; // imgs/0_h.png
				}
				// ��jlist����ͼ��ͷ��
				setIcon(new ImageIcon(icon));
				// ��jlist����QQ�ź�ǩ��
				setText(quser.getUname() + "[" + quser.getQqnum() + "]"
						+ quser.getTxt());
			}

			// ������꾭�����ʽ
			if (isSelected) {// ���ѡ����
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(list.getFont());

			return this;
		}
	}

	// ˢ�����
	public void flushMain() {
		// ����ݿ��и���û�QQ�źͷ������ ��ѯ���vector
		fvecot = qservice.selFriendByGroup(quser.getQqnum(),
				Contents.GROUP_FRIEND);
		famvecot = qservice.selFriendByGroup(quser.getQqnum(),
				Contents.GROUP_FAMILY);
		classvecot = qservice.selFriendByGroup(quser.getQqnum(),
				Contents.GROUP_CLASSMATE);
		blackvecot = qservice.selFriendByGroup(quser.getQqnum(),
				Contents.GROUP_BLACK);

		// ��̬��JList��������
		flist.setModel(new MyListModel(fvecot));
		flist.setCellRenderer(new MyDefaultListCellRenderer(fvecot));

		famlist.setModel(new MyListModel(famvecot));
		famlist.setCellRenderer(new MyDefaultListCellRenderer(famvecot));

		classmlist.setModel(new MyListModel(classvecot));
		classmlist.setCellRenderer(new MyDefaultListCellRenderer(classvecot));

		blackslist.setModel(new MyListModel(blackvecot));
		blackslist.setCellRenderer(new MyDefaultListCellRenderer(blackvecot));
	}

	// ��������ʽ�˵�
	public void createPopupMenu() {
		popup = new JPopupMenu();
		talk = new JMenuItem("����");
		sel = new JMenuItem("�鿴��������");
		del = new JMenuItem("ɾ�����");
		mfriend = new JMenuItem("�ƶ�������");
		mfamily = new JMenuItem("�ƶ�������");
		mclass = new JMenuItem("�ƶ���ͬѧ");
		mblacks = new JMenuItem("�ƶ�������");

		popup.add(talk);
		popup.add(sel);
		popup.add(del);
		popup.add(mfriend);
		popup.add(mfamily);
		popup.add(mclass);
		popup.add(mblacks);

		talk.addActionListener(new MyActionListener());
		sel.addActionListener(new MyActionListener());
		del.addActionListener(new MyActionListener());
		mfriend.addActionListener(new MyActionListener());
		mfamily.addActionListener(new MyActionListener());
		mclass.addActionListener(new MyActionListener());
		mblacks.addActionListener(new MyActionListener());

	}


	// ��ť����
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == talk) {// ������ʽ�˵�������
				openChat(frienduser.getQqnum(), null);
			} else if (e.getSource() == sel) {// ������ʽ�˵����鿴��������
				System.out.println("����� �鿴��������");

				new QQFriendInfo(frienduser);

			} else if (e.getSource() == del) {// ɾ����� ������ʽ�˵���
				// ��ݿ�ɾ�����
				qservice.delFF(quser, frienduser);

				// ˢ�������
				flushMain();

				// ����֪ͨ
				QQMsg msg = new QQMsg();
				msg.setCmd(Contents.CMD_DELFRIEND);// ɾ�����
				msg.setMyuser(quser);
				msg.setFruser(frienduser);
				new SendMsg().send(msg);
			} else if (e.getSource() == mfriend) {// ������ʽ�˵���
				// �����ݿ�
				qservice.moveFF(quser, frienduser, Contents.GROUP_FRIEND);
				// ˢ�����
				flushMain();
			} else if (e.getSource() == mfamily) {// ������ʽ�˵���
				// �����ݿ�
				qservice.moveFF(quser, frienduser, Contents.GROUP_FAMILY);
				// ˢ�����
				flushMain();
			} else if (e.getSource() == mclass) {// ������ʽ�˵���
				// �����ݿ�
				qservice.moveFF(quser, frienduser, Contents.GROUP_CLASSMATE);
				// ˢ�����
				flushMain();
			} else if (e.getSource() == mblacks) {// ������ʽ�˵���
				// �����ݿ�
				qservice.moveFF(quser, frienduser, Contents.GROUP_BLACK);
				// ˢ�����
				flushMain();
			}

			Qquser q = new Qquser();
			q.setQqnum(quser.getQqnum());
			if (e.getSource() == i1) {
				// /�����ݿ�״̬
				q.setState(Contents.STATE_ONLINE);
				qservice.updUserState(q);
				state.setIcon(new ImageIcon("state/s_online.png"));// ���ͼƬ
				notice(Contents.CMD_INLINE);// ����֪ͨ
			} else if (e.getSource() == i2) {
				// /�����ݿ�״̬
				q.setState(Contents.STATE_HIDE);
				qservice.updUserState(q);
				state.setIcon(new ImageIcon("state/s_hide.png"));
				notice(Contents.CMD_HIDE);
			} else if (e.getSource() == i3) {
				// /�����ݿ�״̬
				q.setState(Contents.STATE_BUSY);
				qservice.updUserState(q);
				state.setIcon(new ImageIcon("state/s_busy.png"));
				notice(Contents.CMD_BUSY);
			} else if (e.getSource() == i4) {
				// /�����ݿ�״̬
				q.setState(Contents.STATE_LEAVE);
				qservice.updUserState(q);
				notice(Contents.CMD_LEAVE);
				state.setIcon(new ImageIcon("state/s_leave.png"));
			}

			
		//��ť����  �����Ҽ�˵�
			if (e.getSource() == it1) {// �������
				QQMain.this.setVisible(true);
				// ʹ��������ģʽ��ʾ
				QQMain.this.setState(JFrame.NORMAL);
			} else if (e.getSource() == it2) {// �˳�
				//����û�״̬
				Qquser qq=new Qquser();
				qq.setQqnum(quser.getQqnum());
				qq.setState(Contents.STATE_DOWNLINE);
				qservice.updUserState(qq);
				//��������֪ͨ
				notice(Contents.CMD_OFFLINE);
				System.exit(0); 
			}
		}

	}

	// ���ڼ���
	class MyWindowListener extends WindowAdapter {
		
		public void windowClosing(WindowEvent e) {
			System.out.println("���ڱ��ر�");
			// ����û�״̬
			Qquser q = new Qquser();
			q.setQqnum(quser.getQqnum());
			q.setState(Contents.STATE_DOWNLINE);
			qservice.updUserState(q);

			// ��������֪ͨ
			notice(Contents.CMD_OFFLINE);
		}

		// ������С��ʱ ��������ͼ��
		
		public void windowIconified(WindowEvent e) {
			System.out.println("��С��");
			// ��ȡϵͳ����ͼ��
			SystemTray systray = SystemTray.getSystemTray();
			if (tray != null) {// �������ͼ�������
				systray.remove(tray);// ��ϵͳ�������Ƴ�
			}
			// ��������ͼ��

			createTray();
			try {
				systray.add(tray);// ������ͼ�����ϵͳͼ����
				QQMain.this.setVisible(false);// ���������
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// ����¼��ļ���
	class MyMouseListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==face){//����޸�����
				new QQUpdInfo(quser,QQMain.this);
			}
			if (e.getSource() == tray && e.getButton() == 1) {// ��������������ͼ��
				QQMain.this.setVisible(true);
				// ʹ��������ģʽ��ʾ
				QQMain.this.setState(JFrame.NORMAL);
			}

			if (e.getSource() == findUser) {// ���Һ���
				new QQFind(quser);
			}

			if (e.getSource() == state) {
				pop.show(QQMain.this, 110, 65);
			}

			// ��С����ť
			if (e.getSource() == xiao) {
				// �������С��
				QQMain.this.setExtendedState(QQMain.this.ICONIFIED);
			} else if (e.getSource() == close) {// �ر�
				// ����û�״̬
				Qquser q = new Qquser();
				q.setQqnum(quser.getQqnum());
				q.setState(Contents.STATE_DOWNLINE);
				qservice.updUserState(q);

				// ��������֪ͨ
				notice(Contents.CMD_OFFLINE);
				System.exit(0);
			}

			if (e.getSource() == flist) {
				if (flist.getSelectedIndex() >= 0) {// ��ȡJLIst�Ƿ��б�ѡ��ĳһ��
					frienduser = fvecot.get(flist.getSelectedIndex());
					// ˫����������
					if (e.getButton() == 1 && e.getClickCount() == 2) {
						System.out.println("˫����������!");
						// new QQChat(quser,frienduser);
						openChat(frienduser.getQqnum(), null);
					}
					if (e.getButton() == 3) {
						// ���������Ҽ�
						popup.show(flist, e.getX(), e.getY());
					}
				}

			} else if (e.getSource() == blackslist) {
				if (blackslist.getSelectedIndex() >= 0) {// ��ȡJLIst�Ƿ��б�ѡ��ĳһ��
					frienduser = blackvecot.get(blackslist.getSelectedIndex());
					// ˫����������
					if (e.getButton() == 1 && e.getClickCount() == 2) {
						System.out.println("˫����������!");
						openChat(frienduser.getQqnum(), null);
					}
					if (e.getButton() == 3) {
						// ���������Ҽ�
						popup.show(blackslist, e.getX(), e.getY());
					}
				}

			} else if (e.getSource() == famlist) {
				if (famlist.getSelectedIndex() >= 0) {// ��ȡJLIst�Ƿ��б�ѡ��ĳһ��
					frienduser = famvecot.get(famlist.getSelectedIndex());
					// ˫����������
					if (e.getButton() == 1 && e.getClickCount() == 2) {
						System.out.println("˫����������!");
						openChat(frienduser.getQqnum(), null);
					}
					if (e.getButton() == 3) {
						// ���������Ҽ�
						popup.show(famlist, e.getX(), e.getY());
					}
				}

			} else if (e.getSource() == classmlist) {
				if (classmlist.getSelectedIndex() >= 0) {// ��ȡJLIst�Ƿ��б�ѡ��ĳһ��
					frienduser = classvecot.get(classmlist.getSelectedIndex());
					// ˫����������
					if (e.getButton() == 1 && e.getClickCount() == 2) {
						System.out.println("˫����������!");
						openChat(frienduser.getQqnum(), null);
					}
					if (e.getButton() == 3) {
						// ���������Ҽ�
						popup.show(classmlist, e.getX(), e.getY());
					}
				}

			}

		}
	}

	// �����촰�� (���ѵ�QQ���� ��Ϣ��)
	public QQChat openChat(String qqnum, QQMsg msg) {
		// ȥ�����в����Ƿ��иú��ѵ��������
		QQChat chat = chats.get(qqnum);
		if (chat == null) {
			if (msg != null) {// ��ʾ�̴߳򿪴���
				Qquser myuser = msg.getMyuser();// ��
				Qquser fruser = msg.getFruser();// ����
				chat = new QQChat(fruser, myuser);// ��ʼ�����
			} else {// ˫��򿪵Ĵ���
				chat = new QQChat(quser, frienduser);// ��ʼ�����
			}

			// �Ѷ���ŵ�������
			chats.put(qqnum, chat);
		}
		if (!chat.isVisible()) {// �������� (�������촰�ں� ���´򿪴���)
			chat.t1.setText("");
			chat.setVisible(true);// �Ѵ���״̬��Ϊ��ʾ
		}

		return chat;
	}

	// ֪ͨ (������)
	public void notice(int cmd) {
		// ֪ͨ�����û� ���˺��������Լ������������û� (����Щ�û�����Ϣ)
		for (int i = 0; i < fvecot.size(); i++) {
			Qquser user = fvecot.get(i);
			if (user.getState() != Contents.STATE_DOWNLINE) {
				QQMsg msg = new QQMsg();
				msg.setCmd(cmd);// ��Ϣ��
				msg.setMyuser(quser);// �� ����������ϵ��û�
				msg.setFruser(user);
				new SendMsg().send(msg);
			}

		}
		for (int i = 0; i < famvecot.size(); i++) {
			Qquser user = famvecot.get(i);
			if (user.getState() != Contents.STATE_DOWNLINE) {
				QQMsg msg = new QQMsg();
				msg.setCmd(cmd);// ��Ϣ��
				msg.setMyuser(quser);// �� ����������ϵ��û�
				msg.setFruser(user);
				new SendMsg().send(msg);
			}
		}
		for (int i = 0; i < classvecot.size(); i++) {
			Qquser user = classvecot.get(i);
			if (user.getState() != Contents.STATE_DOWNLINE) {
				QQMsg msg = new QQMsg();
				msg.setCmd(cmd);// ��Ϣ��
				msg.setMyuser(quser);// �� ����������ϵ��û�
				msg.setFruser(user);
				new SendMsg().send(msg);
			}
		}
	}

	// ���յ��߳�
	class MyThread extends Thread {
		public MyThread() {
			// ��ʼ������
			chats = new HashMap<String, QQChat>();
		}

		public void run() {
			// �Լ��Ķ˿�
			int port = quser.getPort();
			try {
				// ���ؽ��շ����� �����Լ��˿ڵ���Ϣ
				DatagramSocket ds = new DatagramSocket(port);
				while (true) {// ѭ������ ������ѭ����b������
					byte[] b = new byte[1024 * 50];// ÿ�ν���50K
					DatagramPacket dp = new DatagramPacket(b, b.length);
					ds.receive(dp);
					ByteArrayInputStream bis = new ByteArrayInputStream(b, 0,
							dp.getLength());
					// ת���ɶ���������
					ObjectInputStream ois = new ObjectInputStream(bis);
					// �õ�����Ϣ����
					QQMsg msg = (QQMsg) ois.readObject();
					int cmd = msg.getCmd();// ��Ϣ��
					if (cmd == Contents.CMD_INLINE) { // ����֪ͨ
						// ��������
						new Sound(Contents.S_QIAOMEN);
						// ˢ�������
						flushMain();
						// ������ʾ (ȡ'��' �Ҿ��Ǻ���)
						new TipUi(msg.getMyuser());

					} else if (cmd == Contents.CMD_OFFLINE) {// ����
						// ˢ�������
						flushMain();
					} else if (cmd == Contents.CMD_BUSY) {// æµ
						// ˢ�������
						flushMain();
					} else if (cmd == Contents.CMD_LEAVE) {// �뿪
						// ˢ�������
						flushMain();
					} else if (cmd == Contents.CMD_HIDE) {// ����
						// ˢ�������
						flushMain();
					} else if (cmd == Contents.CMD_CHAT) {// ����
						// (���ѵ�QQ ��Ϣ����)
						QQChat chat = openChat(msg.getMyuser().getQqnum(), msg);
						// ����Ϣ������ʾ�������
						chat.appendView(msg.getMyuser().getUname(), msg
								.getDoc());
					} else if (cmd == Contents.CMD_SHKAE) {
						// (���ѵ�QQ ��Ϣ����)
						QQChat chat = openChat(msg.getMyuser().getQqnum(), msg);
						// ����Ϣ������ʾ�������
						chat.appendView(msg.getMyuser().getUname(), msg
								.getDoc());
						chat.shake();

					} else if (cmd == Contents.CMD_ADDFRIEND) {// ��Ӻ���
						// ���������ʾ
						new Sound(Contents.S_KESHOU);
						String message = msg.getMyuser().getUname() + "("
								+ msg.getMyuser().getQqnum() + ")������Ӻ��ѣ��Ƿ���ӣ�";
						int i = JOptionPane.showConfirmDialog(null, message,
								"��Ӻ���", JOptionPane.OK_CANCEL_OPTION);
						// ��0 ȡ��2
						QQMsg huifu = new QQMsg();

						huifu.setMyuser(msg.getFruser());
						huifu.setFruser(msg.getMyuser());

						if (i == 0) {// ͬ��������
							// ���ѱ������� (Ĭ�Ϸ��ں��ѷ���)
							qservice.addFriend(msg.getMyuser(),
									msg.getFruser(), Contents.GROUP_FRIEND);
							// ˢ�����
							flushMain();
							// ���߶Է�
							huifu.setCmd(Contents.CMD_AGREE);
						} else if (i == 2) {// �ܾ����
							huifu.setCmd(Contents.CMD_NOADD);
						}
						new SendMsg().send(huifu);
					} else if (cmd == Contents.CMD_DELFRIEND) {// ɾ�����
						// /ˢ�����
						flushMain();
					} else if (cmd == Contents.CMD_SENDFILE) {// �ļ�����
						String message = msg.getMyuser().getUname() + "���㷢���ļ�["
								+ msg.getFileName() + "]���Ƿ���գ�";
						int i = JOptionPane.showConfirmDialog(null, message,
								"�ļ�����", JOptionPane.OK_CANCEL_OPTION);

						// ������Ϣ�Ļظ�
						QQMsg m = new QQMsg();
						m.setMyuser(msg.getFruser());
						m.setFruser(msg.getMyuser());
						if (i == 0) {// ͬ��
							FileDialog fd = new FileDialog(QQMain.this, "�ļ�����",
									FileDialog.SAVE);
							fd.setFile(msg.getFileName());// ���ñ����ļ�������
							fd.show();
							
							// ��ȡ�û�ѡ��ı���λ��
							String filename = fd.getDirectory() + "\\"
									+ fd.getFile();

							// /�ж��ļ��Ƿ����
							File f = new File(filename);
							if (!f.exists()) {
								f.createNewFile();
							}
							// �ļ������
							FileOutputStream fos = new FileOutputStream(f);
							fos.write(msg.getB());
							fos.close();
							System.out.println("ͬ��");
							m.setCmd(Contents.CMD_FILEAGREE);
						} else if (i == 2) {// �ܾ�
							System.out.println("�ܾ�");
							m.setCmd(Contents.CMD_FILENO);
						}

						new SendMsg().send(m);

					} else if (cmd == Contents.CMD_AGREE) {// ͬ�����
						String message = msg.getMyuser().getUname()
								+ "ͬ��������������";
						JOptionPane.showMessageDialog(null, message);
						// ˢ�����
						flushMain();
					} else if (cmd == Contents.CMD_NOADD) {// �ܾ�
						String message = msg.getMyuser().getUname()
								+ "�ܾ�������������ԭ���ǳ���̫����!";
						JOptionPane.showMessageDialog(null, message);
					} else if (cmd == Contents.CMD_FILEAGREE) {// �������ļ�
						String message = msg.getMyuser().getUname()
								+ "����������ļ�!";
						JOptionPane.showMessageDialog(null, message);
					} else if (cmd == Contents.CMD_FILENO) {// �ܾ�����ļ�
						String message = msg.getMyuser().getUname()
						+ "�ܾ��������ļ�!";
				JOptionPane.showMessageDialog(null, message);
			}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
	}
}
