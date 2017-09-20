package edu.ht.main;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import edu.ht.bean.Qquser;
import edu.ht.service.QquserService;
import edu.ht.service.impl.QquserServiceImpl;

public class QQFriendInfo extends JFrame {
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

	public QQFriendInfo(Qquser frienduser) {
		super("�鿴��������");
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
		JLabel title = new JLabel("��������");
		title.setFont(new Font("����", Font.BOLD, 25));
		title.setBounds(140, 5, 150, 50);
		c.add(title);

		// �ǳ�
		JLabel luname = new JLabel("�ǳƣ�"+frienduser.getUname());
		luname.setBounds(75, 70, 240, 20);
		c.add(luname);


		// ͷ��
		JLabel face = new JLabel(new ImageIcon(frienduser.getFace()));
		face.setBounds(75, 120, 60, 60);
		c.add(face);


		// �Ա�
		JLabel lsex = new JLabel("�Ա�"+frienduser.getSex());
		lsex.setBounds(75, 220, 270, 20);
		c.add(lsex);



		// �绰
		JLabel ltel = new JLabel("�绰��"+frienduser.getTel());
		ltel.setBounds(75, 270, 240, 20);
		c.add(ltel);


		// ����
		JLabel lstar = new JLabel("������"+frienduser.getStar());
		lstar.setBounds(75, 320, 240, 20);
		c.add(lstar);

		// ����
		JLabel lnation = new JLabel("���壺"+frienduser.getNation());
		lnation.setBounds(205, 320, 240, 20);
		c.add(lnation);


		// ����
		JLabel ltxt = new JLabel("����ǩ����"+frienduser.getTxt());
		ltxt.setBounds(55, 370, 270, 20);
		c.add(ltxt);

		// ����ͼƬ
		JLabel bgimg = new JLabel(new ImageIcon(""));
		c.add(bgimg);

		setSize(400, 550);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
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
}
