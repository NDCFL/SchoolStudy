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
	String[] stars = { "Ħ����", "ˮƿ��", "˫����", "������", "��ţ��", "˫����", "��з��", "ʨ����",
			"��Ů��", "�����", "��Ы��", "������" };
	String[] nations = { "����", "����", "����", "����", "����", "����", "��ɽ��", "���", "����",
			"׳��", "����" };
	JComboBox com1, com2;
	JTextArea txt1;
	
	QquserService qservice = new QquserServiceImpl();
	/***********/
	//���ý�������϶��ķ���
	
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
		super("ע��");
		this.setDragable();//���ÿ����϶�
		this.setUndecorated(true); // ȥ�����ڵ�װ��
		// ���ô���ͼ��
		Image image = new ImageIcon("qqmain/tubiao.jpg").getImage();
		setIconImage(image);
		Container c = getContentPane();

		// ������ʽ
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ����
		JLabel title = new JLabel("ע��");
		title.setFont(new Font("΢���ź�", Font.BOLD, 20));
		title.setBounds(190, 5, 150, 50);
		title.setForeground( Color.WHITE);
		c.add(title);

		// �ǳ�
		JLabel luname = new JLabel("�ǳƣ�");
		luname.setBounds(75, 70, 40, 20);
		luname.setForeground( Color.WHITE);
		c.add(luname);

		t1 = new JTextField();
		t1.setBounds(120, 70, 180, 20);
		c.add(t1);

		// ����
		JLabel lpwd1 = new JLabel("���룺");
		lpwd1.setBounds(75, 120, 40, 20);
		lpwd1.setForeground( Color.WHITE);
		c.add(lpwd1);

		pwd1 = new JPasswordField();
		pwd1.setBounds(120, 120, 180, 20);
		c.add(pwd1);

		// ȷ������
		JLabel lpwd2 = new JLabel("ȷ�����룺");
		lpwd2.setBounds(55, 170, 70, 20);
		lpwd2.setForeground( Color.WHITE);
		c.add(lpwd2);

		pwd2 = new JPasswordField();
		pwd2.setBounds(120, 170, 180, 20);
		c.add(pwd2);

		// �Ա�
		JLabel lsex = new JLabel("�Ա�");
		lsex.setBounds(75, 220, 70, 20);
		lsex.setForeground( Color.WHITE);
		c.add(lsex);

		sex1 = new JRadioButton("��");
		sex1.setBounds(120, 220, 70, 20);
		sex1.setSelected(true);
		sex2 = new JRadioButton("Ů");
		sex2.setBounds(230, 220, 70, 20);

		c.add(sex1);
		c.add(sex2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(sex1);
		bg.add(sex2);
		
		// �绰
		JLabel ltel = new JLabel("�绰��");
		ltel.setBounds(75, 270, 40, 20);
		ltel.setForeground( Color.WHITE);
		c.add(ltel);

		t2 = new JTextField();
		t2.setBounds(120, 270, 180, 20);
		c.add(t2);

		// ����
		JLabel lstar = new JLabel("������");
		lstar.setForeground( Color.WHITE);
		lstar.setBounds(75, 320, 40, 20);
		c.add(lstar);

		com1 = new JComboBox(stars);
		com1.setBounds(120, 320, 70, 20);
		c.add(com1);
		// mz
		JLabel lnation = new JLabel("���壺");
		lnation.setBounds(205, 320, 40, 20);
		lnation.setForeground( Color.WHITE);
		c.add(lnation);

		com2 = new JComboBox(nations);
		com2.setBounds(240, 320, 60, 20);
		c.add(com2);

		// qm
		JLabel ltxt = new JLabel("����ǩ����");
		ltxt.setBounds(55, 370, 70, 20);
		ltxt.setForeground( Color.WHITE);
		c.add(ltxt);

		txt1 = new JTextArea();
		txt1.setBounds(120, 370, 180, 70);
		c.add(txt1);

		JButton b1 = new JButton("�ύ");
		b1.setBounds(75, 460, 70, 30);
		c.add(b1);
		b1.addActionListener(new MyActionListener());

		JButton b2 = new JButton("ȡ��");
		b2.setBounds(255, 460, 70, 30);
		c.add(b2);
		b2.addActionListener(new MyActionListener());

		// ����ͼƬ
		JLabel bgimg = new JLabel(new ImageIcon("qqmain/11_24.jpg"));
		c.add(bgimg);

		setSize(400, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�ύ")) {
				String nickname = t1.getText().trim();// �ǳ�
				String p1 = pwd1.getText().trim();
				String p2 = pwd2.getText().trim();
				if (nickname.equals("") || nickname == null) {
					JOptionPane.showMessageDialog(null, "�������ǳ�!");
					t1.requestFocus();
				} else if (p1.equals("")) {
					JOptionPane.showMessageDialog(null, "����������!");
					pwd1.requestFocus();
				} else if (p2.equals("")) {
					JOptionPane.showMessageDialog(null, "��ȷ������!");
					pwd2.requestFocus();
				} else if (!p1.equals(p2)) {
					JOptionPane.showMessageDialog(null, "�����������벻һ��!");
					pwd2.requestFocus();
				} else {
					// �ύ����
					Qquser quser = new Qquser();
					quser.setQqnum(getQnum());// QQ��������ɷ���
					quser.setUname(nickname);
					quser.setIpadd("127.0.0.1");//IP
					quser.setPort(getPort());//�÷������ɶ˿�
					quser.setPwd(p2);
					// �����Ա�
					if (sex1.isSelected()) {
						quser.setSex("��");
					} else if (sex2.isSelected()) {
						quser.setSex("Ů");
					}
					// Ĭ��ͷ��
					quser.setFace("img/0.png");
					quser.setTel(t2.getText().trim());
					//ֱ��ȡ����������
//					System.out.println(com1.getSelectedItem().toString());
					quser.setStar(stars[com1.getSelectedIndex()]);// ����
					quser.setNation(nations[com2.getSelectedIndex()]);// ����
					quser.setTxt(txt1.getText());

					// ע��
					boolean bln = qservice.addUSer(quser);
					if (bln) {
						JOptionPane.showMessageDialog(null, "��ϲע��ɹ�������QQ����"
								+ quser.getQqnum());
						QQRegister.this.dispose();//�ر�ע�ᴰ��
					} else {
						JOptionPane.showMessageDialog(null, "ע��ʧ��!");
					}
				}
			} else if (e.getActionCommand().equals("ȡ��")) {
				QQRegister.this.dispose();//�ر�ע�ᴰ��
			}
		}

	}

	// QQ�������ɷ���
	public String getQnum() {
		Random r = new Random();
		int i = r.nextInt(10000);
		// 9000
		// i<1000��������QQ�ŵ�λ�� && ���û����в�����
		while (i < 1000 && qservice.selUser(i + "")) {
			i = r.nextInt(10000);
		}

		return i + "";
	}
	
	//�˿����ɷ���
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
