package edu.ht.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import edu.ht.bean.QqHistory;
import edu.ht.bean.Qquser;
import edu.ht.common.Contents;
import edu.ht.service.QquserService;
import edu.ht.service.impl.QquserServiceImpl;

public class QQLogin extends JFrame {
	JLabel xiao,close,l1,l2,loginbtn,face,state;
	JComboBox t1;
	JPasswordField pwd1;
	JCheckBox c1,c2;
	String[] accs;//��¼��ʷ����-��
	QquserService qservice=new QquserServiceImpl();
	List list=null;//��¼��ʷ��-��
	
	JPopupMenu pop;
	JMenuItem i1,i2,i3,i4;
	/***********/
	//���ý�������϶��ķ���
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQLogin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQLogin.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQLogin.this.getLocation().x + e.getX() - tmp.x,
							QQLogin.this.getLocation().y + e.getY() - tmp.y);
					QQLogin.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public QQLogin() {
		super("QQ��¼");
		this.setDragable();//���ÿ����϶�
		this.setUndecorated(true); // ȥ��ڵ�װ��
		
		this.getHistory();//��ѯ��¼��ʷ
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
		
		Container c = getContentPane();
		
		//��С����λ��
		xiao=new JLabel();
		xiao.setBounds(375, 7, 25, 20);
		c.add(xiao);
		xiao.addMouseListener(new MyMouseListener());
		//��ָ��������
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		// �ر�
		close = new JLabel();
		close.setBounds(400, 5, 24, 20);
		c.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MyMouseListener());
		
		//״̬ѡ��
		state=new JLabel(new ImageIcon("state/s_online.png"));
		state.setBounds(109, 260, 15, 15);
		c.add(state);
		state.addMouseListener(new MyMouseListener());
		
		// ͷ��
		face = new JLabel(new ImageIcon("state/touxiang1.png"));
		face.setBounds(40, 193, 80, 80);
		c.add(face);
		
		pop=new JPopupMenu();
		i1=new JMenuItem("����",new ImageIcon("state/s_online.png"));
		i2=new JMenuItem("����",new ImageIcon("state/s_hide.png"));
		i3=new JMenuItem("æµ",new ImageIcon("state/s_busy.png"));
		i4=new JMenuItem("�뿪",new ImageIcon("state/s_leave.png"));
		pop.add(i1);
		pop.add(i2);
		pop.add(i3);
		pop.add(i4);
		i1.addActionListener(new MyActionListener());
		i2.addActionListener(new MyActionListener());
		i3.addActionListener(new MyActionListener());
		i4.addActionListener(new MyActionListener());
		
		//QQ�˺������
		t1 = new JComboBox(accs);
		t1.setEditable(true);//���ÿ��Ա༭
		t1.setBounds(135, 196, 194, 30);
		c.add(t1);
		t1.setFont(new Font("",Font.PLAIN,14));
		t1.addItemListener(new MyItemListener());
		
		//ע���˺�
		l1 = new JLabel("");
		l1.setBounds(335, 209, 50, 20);
		c.add(l1);
		Color mycolor=new Color(15,177,255);//�Զ�����ɫ
		l1.setForeground(mycolor);
		l1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l1.addMouseListener(new MyMouseListener());
		
		//�����
		pwd1 = new JPasswordField();
		pwd1.setBounds(135,226, 194, 30);
		c.add(pwd1);
		
		//�������
		l2 = new JLabel("");
		l2.setBounds(335, 235, 50, 20);
		c.add(l2);
		l2.setForeground(mycolor);
		l2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l2.addMouseListener(new MyMouseListener());
		
		Color myco = new Color(90, 90, 90);

		c1 = new JCheckBox("��ס����");
		c1.setBounds(132, 261, 80, 20);
		c.add(c1);
		c1.setForeground(myco);
		c1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		int index=t1.getSelectedIndex();
		QqHistory qh=(QqHistory) list.get(index);
		if(!qh.getPwd().equals("")){//����¼������ �Ͱ� ��ס����Ĺ� ����
			c1.setSelected(true);
		}
		pwd1.setText(qh.getPwd());//��������ʾ��4 
		
		c2 = new JCheckBox("�Զ���¼");
		c2.setBounds(259, 261, 80, 20);
		c.add(c2);
		c2.setForeground(myco);
		c2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		// ��¼��ť
		loginbtn = new JLabel(new ImageIcon("qqmain/loginbutton.png"));
		loginbtn.setBounds(135, 287, 195, 30);
		c.add(loginbtn);
		loginbtn.addMouseListener(new MyMouseListener());
		
		//����ͼƬ
		JLabel bgimg = new JLabel(new ImageIcon("qqmain/QQ.gif"));
		c.add(bgimg);
		setSize(428, 330);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
//			�ı�ͼ��
			if(e.getSource()==i1){
				state.setIcon(new ImageIcon("state/s_online.png"));
			}else if(e.getSource()==i2){
				state.setIcon(new ImageIcon("state/s_hide.png"));
			}else if(e.getSource()==i3){
				state.setIcon(new ImageIcon("state/s_busy.png"));
			}else if(e.getSource()==i4){
				state.setIcon(new ImageIcon("state/s_leave.png"));
			}
			
		}
		
	}
	
	//��-��ѡ���ļ���
	class MyItemListener implements ItemListener{

		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==t1){
				//��-����±�
				int index=t1.getSelectedIndex();
				QqHistory qh=(QqHistory) list.get(index);
				if(!qh.getPwd().equals("")){//����¼������ �Ͱ� ��ס����Ĺ� ����
					c1.setSelected(true);
					
				}
				pwd1.setText(qh.getPwd());//��������ʾ��4 
				
				//���ͷ��
				face.setIcon(new ImageIcon(qh.getFace()));
				
			}
			
		}
		
	}
	
	//����¼��ļ���
	class MyMouseListener extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource()==state){
				pop.show(QQLogin.this, 110, 275);
			}
			//��С����ť
			if(e.getSource()==xiao){
				//�������С��
				QQLogin.this.setExtendedState(QQLogin.this.ICONIFIED);
			}else if(e.getSource()==close){
				System.exit(0);
			}else if(e.getSource()==l1){//�����ע���˺�
				new QQRegister();
			}else if(e.getSource()==loginbtn){//����ǵ�¼��ť
				//��ȡ�˺�
				String qqNum=t1.getSelectedItem().toString().trim();
				//��ȡ����
				String pwd=pwd1.getText().trim();
				System.out.println(qqNum+" "+pwd);
				if(qqNum.equals("")){
					JOptionPane.showMessageDialog(null, "�������˺ţ�");
					t1.requestFocus();
					return ;
				}else if(pwd.equals("")){
					JOptionPane.showMessageDialog(null, "���������룡");
					pwd1.requestFocus();
					return ;
				}
				
				//��֤��¼
				Qquser quser=new Qquser();
				quser.setQqnum(qqNum);
				quser.setPwd(pwd);
				Qquser qu= qservice.chkUser(quser);
				if(qu==null){//����¼ʧ��
					JOptionPane.showMessageDialog(null, "�˺���������");
					pwd1.requestFocus();
					return ;
				}else{//��¼�ɹ�
					
					//�޸��û�����״̬ (��Ϊ����	)
					Qquser qus=new Qquser();
					qus.setQqnum(qqNum);
					//����û�ѡ���״̬4��Ķ�Ӧ���û�״̬
					String str=state.getIcon().toString();
					if(str.equals("state/s_online.png")){
						qus.setState(Contents.STATE_ONLINE);
					}else if(str.equals("state/s_hide.png")){
						qus.setState(Contents.STATE_HIDE);
					}else if(str.equals("state/s_busy.png")){
						qus.setState(Contents.STATE_BUSY);
					}else if(str.equals("state/s_leave.png")){
						qus.setState(Contents.STATE_LEAVE);
					}
					System.out.println(" ��¼ʱ��״̬ "+qus.getState());
					qservice.updUserState(qus);//�޸���ݿ�״̬
					
					//����������û����״̬
					quser.setState(qus.getState());
					
					//����¼��Ϣ���浽��ݿ����
					
					//����ͷ��
					
					qus.setFace(qu.getFace());
					
					
					//�ж����ѡ�˱�������
					if(c1.isSelected()){//�жϵ�ѡ��/��ѡ���Ƿ�ѡ�� ѡ�з���true
						qus.setPwd(pwd);
					}else{
						qus.setPwd("");
					}
					
//					
//					//���ѡ���Զ���¼
//					if(c2.isSelected()){
//						qus.setAge(1);//�����Զ���¼״̬Ϊ0
//					}else{
//						qus.setAge(0);//�����Զ���¼״̬Ϊ0
//					}
//					
					//�����¼��ʷ
					qservice.saveHistory(qus);
					
					
					System.out.println("��¼�ɹ�");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					//����¼���ڹر� 
					QQLogin.this.dispose();
					
					
					//��QQ����壨����¼���û��� ����ȥ��
					new QQMain(quser);
				}
			}
		}
	}
	
	//��ȡ��¼��ʷ������-�����鸳ֵ
	public void getHistory(){
		//��ȡ��¼��ʷ
		list=qservice.selHistory();
		//��-�������
		accs=new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			QqHistory qh=(QqHistory) list.get(i);
			accs[i]=qh.getQqnum();
		}
	}

	public static void main(String[] args) {
		
		new QQLogin();
	}
}
