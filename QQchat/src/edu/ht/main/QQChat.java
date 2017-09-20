package edu.ht.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import edu.ht.bean.QQMsg;
import edu.ht.bean.Qquser;
import edu.ht.common.Contents;
import edu.ht.common.SendMsg;

public class QQChat extends JFrame {
	
	JLabel xiao, close,cancel,send;
	
	JTextPane t1,t2;
	
	JComboBox fnt,fntsize,bq;//���壬�����С������ 
	
	JButton fntcolor,dd,sendfile;//������ɫ�������������ļ�  ȡ�� ����
	
	String fonts[]={"����","e��","����","΢���ź�","��Բ","����"};

	String [] fontsizes={"12","14","16","18","20","22","24"};
	
	//���� 
	Icon[] bqs=new ImageIcon[96];
	
	Qquser me,friend;
	/***********/
	//���ý�������϶��ķ���
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				QQChat.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				QQChat.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(QQChat.this.getLocation().x + e.getX() - tmp.x,
							QQChat.this.getLocation().y + e.getY() - tmp.y);
					QQChat.this.setLocation(loc);
				}
			}
		});
	}
	/***********/
	public QQChat(Qquser me, Qquser friend) {
		super("��"+friend.getUname()+"������...");
		this.setDragable();//���ÿ����϶�
		this.me=me;
		this.friend=friend;
		//�������
		for (int i = 0; i <=95; i++) {
			bqs[i]=new ImageIcon("bq/"+i+".gif");
		}
		
		// ���ô���ͼ��
		Image image = new ImageIcon(friend.getFace()).getImage();
		setIconImage(image);

		this.setUndecorated(true); // ȥ��ڵ�װ��

		// ������ʽ
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��ڼ�������˶�ʱ�����
		
		Container c = getContentPane();
		// ��С����λ��
		xiao = new JLabel(new ImageIcon("qqmain/xiao1.png"));
		xiao.setBounds(520, 10, 30, 30);
		c.add(xiao);
		xiao.addMouseListener(new MyMouseListener());
		// ��ָ��������
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// �ر�
		close = new JLabel(new ImageIcon("qqmain/close1.png"));
		close.setBounds(553, 5, 30, 30);
		c.add(close);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MyMouseListener());
		
		
		//����ͷ��
		JLabel face=new JLabel(new ImageIcon(friend.getFace()));
		face.setBounds(9, 4, 42, 42);
		c.add(face);
		
		//�ǳ�
		JLabel nickname=new JLabel(friend.getUname());
		nickname.setBounds(65, 2, 100, 30);
		c.add(nickname);
		nickname.setFont(new Font("΢���ź�",Font.PLAIN,15));
		
		//ǩ��
		JLabel qianming=new JLabel(friend.getTxt());
		qianming.setBounds(65, 25, 200, 30);
		c.add(qianming);
		qianming.setFont(new Font("΢���ź�",Font.PLAIN,12));
		qianming.setForeground(new Color(31,114,146));
		
		//���տ�
		t1=new JTextPane();
		JScrollPane pan1=new JScrollPane(t1);
		pan1.setBounds(1,84, 444, 288);
		c.add(pan1);
		t1.setEditable(false);
		
		
		//�м���壨�������á����飩
		JPanel pcenter=new JPanel();
		pcenter.setLayout(new FlowLayout());
		
		//����
		fnt=new JComboBox(fonts);
		pcenter.add(fnt);
		fnt.addItemListener(new MyItemListener());
		
		//�����С
		fntsize=new JComboBox(fontsizes);
		pcenter.add(fntsize);
		fntsize.addItemListener(new MyItemListener());
		
		//������ɫѡ��
		fntcolor=new JButton(new ImageIcon("qqmain/zt.png"));
		pcenter.add(fntcolor);
		fntcolor.addActionListener(new MyActionListener());
		
		//����
		dd=new JButton(new ImageIcon("qqmain/zd.png"));
		pcenter.add(dd);
		dd.addActionListener(new MyActionListener());

		//�����ļ�
		sendfile=new JButton("�����ļ�");
		pcenter.add(sendfile);
		sendfile.addActionListener(new MyActionListener());
		
		//����
		bq=new JComboBox(bqs);
		pcenter.add(bq);
		bq.addItemListener(new MyItemListener());

		pcenter.setBounds(1, 365 , 442, 35);
		c.add(pcenter);
		
		//���Ϳ�
		t2=new JTextPane();
		JScrollPane pan2=new JScrollPane(t2);
		pan2.setBounds(1, 400, 443, 105);
		c.add(pan2);
		

		//ȡ��
		cancel=new JLabel(new ImageIcon(""));
		c.add(cancel);
		cancel.setBounds(280, 505, 72, 25);
		cancel.addMouseListener(new MyMouseListener());
		
		
		//����
		send=new JLabel(new ImageIcon(""));
		c.add(send);
		send.setBounds(356, 505, 87, 25);
		send.addMouseListener(new MyMouseListener());
		// ����ͼƬ
		JLabel bgimg = new JLabel(new ImageIcon("qqmain/chat.png"));
		c.add(bgimg);
		
		setSize(586, 539);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	// ����¼��ļ���
	class MyMouseListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			// ��С����ť
			if (e.getSource() == xiao) {
				// �������С��
				QQChat.this.setExtendedState(QQChat.this.ICONIFIED);
			} else if (e.getSource() == close) {
				//���Լ�����
				QQChat.this.setVisible(false);
			}else if(e.getSource()==send){//����
				try {
					//��������������ʾ�����ܿ�
					appendView(me.getUname(), t2.getStyledDocument());
					
					//����Ϣ���͸����
					QQMsg msg=new QQMsg();
					msg.setCmd(Contents.CMD_CHAT);//��Ϣ��
					msg.setMyuser(me);
					msg.setFruser(friend);
					msg.setDoc(t2.getStyledDocument());//������Ϣ����
					new SendMsg().send(msg);//����
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				t2.setText("");
			}else if(e.getSource()==cancel){
				//���Լ�����
				QQChat.this.setVisible(false);
			}
		}
	}
	
	//��-�����
	class MyItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==fnt||e.getSource()==fntsize){
				//����
				String fontname=fnt.getSelectedItem().toString();
				//�ֺ�
				int fontsizes=Integer.parseInt(fntsize.getSelectedItem().toString());
				//���Ϳ���������
				t2.setFont(new Font(fontname,Font.PLAIN,fontsizes));
			}else if(e.getSource()==bq){//����
				Icon icon=(Icon) bq.getSelectedItem();
				t2.insertIcon(icon);
			}
		}
	}
	
	class MyActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==fntcolor){//������ɫ
				//��ʼ��һ����ɫ ѡ����
				JColorChooser choose=new JColorChooser();
				//������ɫѡ����
				Color mycolor= choose.showDialog(null, "��ɫѡ����", Color.BLACK);
				//���Ϳ������������ɫ
				t2.setForeground(mycolor);
			}else if(e.getSource()==dd){//����
				//���Լ���
				shake();
				//�ñ��˶�
				//���Ͷ���֪ͨ
				QQMsg msg=new QQMsg();
				msg.setCmd(Contents.CMD_SHKAE);
				msg.setMyuser(me);
				msg.setFruser(friend);
				t2.setText("�Ҹ��㷢����һ�����");
				msg.setDoc(t2.getStyledDocument());
				new SendMsg().send(msg);
				t2.setText("");
				
			}else if(e.getSource()==sendfile){//�����ļ�
				//�����ļ�ѡ��� 
				FileDialog fd=new FileDialog(QQChat.this,"��ѡ���ļ�",FileDialog.LOAD);
				fd.show();
				//��ȡ�ļ���·�������
				String filename=fd.getDirectory()+"\\"+fd.getFile();
				//�����ļ�����
				File file=new File(filename);
				
				if(file.length()>1024*64){
					JOptionPane.showMessageDialog(null, "�ļ���С���ܳ���64K");
					return ;
				}
				try {
					byte[] b=new byte[(int)file.length()]; 
					//���������ȡ�ļ�
					FileInputStream fi=new FileInputStream(file);
					//��ȡ�ļ����ֽ�������
					fi.read(b);
					//�ر�������
					fi.close();
					
					//�����ļ�֪ͨ
					QQMsg msg=new QQMsg();
					msg.setCmd(Contents.CMD_SENDFILE);
					msg.setMyuser(me);
					msg.setFruser(friend);
					msg.setFileName(fd.getFile());
					msg.setB(b);
					new SendMsg().send(msg);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
	}
	
	public void shake(){
		//��ȡ���ڵ�ǰλ�õĵ�
		Point p=QQChat.this.getLocationOnScreen();
		for (int i = 0; i < 20; i++) {
			if(i%2==0){
				QQChat.this.setLocation(p.x+5, p.y+5);
			}else{
				QQChat.this.setLocation(p.x-5, p.y-5);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//�ѷ��Ϳ�������ύ�����տ�ͬʱ����Ϳ������ (�Լ����ǳƣ����Ϳ������)
	public  void appendView(String name, StyledDocument xx)throws BadLocationException {
		//��ȡ���տ���ĵ������ݣ�
		StyledDocument vdoc = t1.getStyledDocument();//��ȡ���տ������
		
		// ��ʽ��ʱ��
		Date date = new Date();//��ȡϵͳ��ǰʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); //������ʾʱ����ĸ�ʽ
		String time = sdf.format(date);//��ȡʱ����
		//����һ�����Լ���
		SimpleAttributeSet as = new SimpleAttributeSet();
		// ��ʾ˭˵
		//vdoc.getLength()��ȡ���տ��е�ԭ4���ݵĳ���
		String s =name + "  " + time + "\n";
//		saveRecord(name,s);//���������¼
		//��ʾ�����տ�
		vdoc.insertString(vdoc.getLength(), s, as);
		int end = 0;
		//������ʾ������
		while (end < xx.getLength()) {
			// ���һ��Ԫ��
			Element e0 = xx.getCharacterElement(end);
			//��ȡ��Ӧ�ķ��
			SimpleAttributeSet as1 = new SimpleAttributeSet();
			StyleConstants.setForeground(as1, StyleConstants.getForeground(e0.getAttributes()));
			StyleConstants.setFontSize(as1, StyleConstants.getFontSize(e0.getAttributes()));
			StyleConstants.setFontFamily(as1, StyleConstants.getFontFamily(e0.getAttributes()));
			//��ȡ��Ԫ�ص�����
			s = e0.getDocument().getText(end, e0.getEndOffset() - end);
			// ��Ԫ�ؼӵ���4���
			if("icon".equals(e0.getName())){
				vdoc.insertString(vdoc.getLength(), s, e0.getAttributes());
			}
			else{
				vdoc.insertString(vdoc.getLength(), s, as1);
//				saveRecord(name,s+"\n");//���������¼
			}
			//getEndOffset����������ǻ�ȡ��ǰԪ�صĳ���
			end = e0.getEndOffset(); 
		}
		// ����һ����
		vdoc.insertString(vdoc.getLength(), "\n", as);
		
		// ������ʾ��ͼ���ַ��λ�����ĵ���β���Ա���ͼ��
		t1.setCaretPosition(vdoc.getLength());
	}
}
