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
	String[] stars = { "Ħ����", "ˮƿ��", "˫����", "������", "��ţ��", "˫����", "��з��", "ʨ����",
			"��Ů��", "�����", "��Ы��", "������" };
	String[] nations = { "����", "����", "����", "����", "����", "����", "��ɽ��", "���", "����",
			"׳��", "����" };
	JComboBox com1, com2,com3;
	JTextArea txt1;

	QquserService qservice = new QquserServiceImpl();
	ImageIcon[] faces=new ImageIcon[10];
	Qquser qq;
	QQMain mm;
	public QQUpdInfo(Qquser quser,QQMain main) {
		super("�޸�����");
		this.qq=quser;
		this.mm=main;
		// ���ô���ͼ��
		Image image = new ImageIcon("img/tubiao.png").getImage();
		setIconImage(image);
		Container c = getContentPane();
		for (int i = 0; i < 10; i++) {
			faces[i]=new ImageIcon("img/"+i+".png");
		}
		
		// ������ʽ
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel face=new JLabel(new ImageIcon(quser.getFace()));
		face.setBounds(80, 5, 150, 50);
		c.add(face);
		
		
		// ����
		JLabel title = new JLabel("�޸�ͷ��");
		title.setBounds(75, 20,60 ,20);
		c.add(title);

		// �ǳ�
		JLabel luname = new JLabel("�ǳƣ�");
		luname.setBounds(75, 70, 40, 20);
		c.add(luname);

		t1 = new JTextField();
		t1.setBounds(120, 70, 180, 20);
		c.add(t1);

		// �ǳ�
		JLabel lpwd1 = new JLabel("���룺");
		lpwd1.setBounds(75, 120, 40, 20);
		c.add(lpwd1);

		pwd1 = new JPasswordField();
		pwd1.setBounds(120, 120, 180, 20);
		c.add(pwd1);

		// �ǳ�
		JLabel lpwd2 = new JLabel("ȷ�����룺");
		lpwd2.setBounds(55, 170, 70, 20);
		c.add(lpwd2);

		pwd2 = new JPasswordField();
		pwd2.setBounds(120, 170, 180, 20);
		c.add(pwd2);

		// �Ա�
		JLabel lsex = new JLabel("�Ա�");
		lsex.setBounds(75, 220, 70, 20);
		c.add(lsex);

		sex1 = new JRadioButton("��");
		sex1.setBounds(120, 220, 40, 20);
		sex1.setSelected(true);
		sex2 = new JRadioButton("Ů");
		sex2.setBounds(160, 220, 40, 20);

		c.add(sex1);
		c.add(sex2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(sex1);
		bg.add(sex2);
		
		//ͷ��
		com3=new JComboBox(faces);
		com3.setBounds(230, 5, 90, 60);
		c.add(com3);

		// �绰
		JLabel ltel = new JLabel("�绰��");
		ltel.setBounds(75, 270, 40, 20);
		c.add(ltel);

		t2 = new JTextField();
		t2.setBounds(120, 270, 180, 20);
		c.add(t2);

		// ����
		JLabel lstar = new JLabel("������");
		lstar.setBounds(75, 320, 40, 20);
		c.add(lstar);

		com1 = new JComboBox(stars);
		com1.setBounds(120, 320, 70, 20);
		c.add(com1);
		// ����
		JLabel lnation = new JLabel("���壺");
		lnation.setBounds(205, 320, 40, 20);
		c.add(lnation);

		com2 = new JComboBox(nations);
		com2.setBounds(240, 320, 60, 20);
		c.add(com2);

		// ����
		JLabel ltxt = new JLabel("����ǩ����");
		ltxt.setBounds(55, 370, 70, 20);
		c.add(ltxt);

		txt1 = new JTextArea();
		txt1.setBounds(120, 370, 180, 70);
		c.add(txt1);

		JButton b1 = new JButton("�޸�");
		b1.setBounds(75, 460, 70, 30);
		c.add(b1);
		b1.addActionListener(new MyActionListener());

		JButton b2 = new JButton("ȡ��");
		b2.setBounds(255, 460, 70, 30);
		c.add(b2);
		b2.addActionListener(new MyActionListener());
		
		
		//�������ֵ
		t1.setText(quser.getUname());//�ǳ�
		
		pwd1.setText(quser.getPwd());//����
		pwd2.setText(quser.getPwd());
		
		if(quser.getSex().equals("��")){//�Ա�
			sex1.setSelected(true);
		}else {
			sex2.setSelected(true);
		}
		t2.setText(quser.getTel());
		
		com1.setSelectedItem(quser.getStar());//����
		com2.setSelectedItem(quser.getNation());//����
		String faces=quser.getFace();//imgs/4.png
		faces=faces.substring(faces.indexOf("/")+1,faces.indexOf("."));
		com3.setSelectedIndex(Integer.parseInt(faces));
		txt1.setText(quser.getTxt());//����ǩ��
		

		// ����ͼƬ
		JLabel bgimg = new JLabel(new ImageIcon(""));
		c.add(bgimg);

		setSize(400, 550);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�޸�")) {
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
					//����QQ��
					quser.setQqnum(qq.getQqnum());
					quser.setUname(nickname);
					quser.setPwd(p2);
					// �����Ա�
					if (sex1.isSelected()) {
						quser.setSex("��");
					} else if (sex2.isSelected()) {
						quser.setSex("Ů");
					}
					// Ĭ��ͷ��
					quser.setFace("img/"+com3.getSelectedIndex()+".png");
					quser.setTel(t2.getText().trim());
					//ֱ��ȡ����������
//					System.out.println(com1.getSelectedItem().toString());
					quser.setStar(stars[com1.getSelectedIndex()]);// ����
					quser.setNation(nations[com2.getSelectedIndex()]);// ����
					quser.setTxt(txt1.getText());
					
					
					boolean bln = qservice.updInfo(quser);
					if (bln) {
//						/�������ˢ�¸�������
						mm.nickname.setText(nickname);
						mm.qianming.setText(txt1.getText());
						mm.quser.setUname(nickname);
						mm.quser.setTxt(txt1.getText());
						mm.face.setIcon(new ImageIcon(("img/"+com3.getSelectedIndex()+".png")));
						JOptionPane.showMessageDialog(null, "��ϲ�޸ĳɹ���");
						QQUpdInfo.this.dispose();//�ر�ע�ᴰ��
					} else {
						JOptionPane.showMessageDialog(null, "�޸�ʧ��!");
					}
				}
			} else if (e.getActionCommand().equals("ȡ��")){
				QQUpdInfo.this.dispose();//�ر�ע�ᴰ��
			}
		}

	}
}
