package QQfase;

import game.TankClient;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;

import QQSQL.QQminlin;
import QQSQL.SendCmd;
import QQSQL.SendMsg;
import QQbean.QQidtable;
import SQLBase.OpenWeb;
import SQLBase.QQbase;
import SQLBase.TipUI;

public class haoyoufase extends JFrame implements MouseListener,ActionListener,WindowListener{

	JLabel bg,close,min,music,youxi,taonbao;
	JLabel head,online,youxiang;
	JLabel name, qianming, huanfu, look,qqliuranqi,yingyongbao,tengxun,qqkongjian;
	JTabbedPane jp;
	JList list1,list2,list3,list4,list5; 
	JMenuItem  chat,jvfriend,jvsunyou,jvmare,jvhmd,jvsidang,lookfriendinfo,delete;
	JPopupMenu pop,isonline,playganme;
	JMenuItem zaixian,likai,manglu,saolei,tanke;
	Point loc = null;
	Point tmp = null;
	JMenuItem open,clo;
	JPopupMenu pop1;
	Sound4 sound4;
	boolean isDragged = false;
	QQidtable idtable,friendtable;
	Vector<QQidtable> allimfmation,vfriend,vmare,vsunyou,vhmd,vsidang;
	QQbase qqbase = new QQbase();
	Hashtable<Integer, Chatfase> QQchat = new Hashtable<Integer, Chatfase>();
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				haoyoufase.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				haoyoufase.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(haoyoufase.this.getLocation().x + e.getX() - tmp.x,
							haoyoufase.this.getLocation().y + e.getY() - tmp.y);
					haoyoufase.this.setLocation(loc);
				}
			}
		});
	}
	public haoyoufase(){};
	public haoyoufase(QQidtable idtable){
		super("好友界面");
		this.idtable=idtable;
		addWindowListener(this);
		setIconImage(new ImageIcon(idtable.getQQhead()).getImage());
		setDragable();
		setUndecorated(true);
		bg=new JLabel(new ImageIcon("head/qqmain1.png"));
		bg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(bg);
		
		close = new JLabel("  ");
		close.setBounds(250, 5, 20, 20);
		close.setToolTipText("关闭");
		bg.add(close);
		
		min = new JLabel();
		min.setBounds(230, 5, 20, 20);
		min.setToolTipText("最小化");
		bg.add(min);
		
		qqliuranqi = new JLabel("  ");
		qqliuranqi.setBounds(8, 615, 30, 30);
		qqliuranqi.setToolTipText("QQ浏览器");
		bg.add(qqliuranqi);
		
		
		yingyongbao = new JLabel("  ");
		yingyongbao.setBounds(230, 643, 60, 30);
		yingyongbao.setToolTipText("应用宝");
		bg.add(yingyongbao);
		
		tengxun = new JLabel("  ");
		tengxun.setBounds(136,85,20,20);
		tengxun.setToolTipText("腾讯新闻");
		bg.add(tengxun);
		
		qqkongjian = new JLabel("  ");
		qqkongjian.setBounds(76,85,25,25);
		qqkongjian.setToolTipText("QQ空间");
		bg.add(qqkongjian);
		
		youxiang = new JLabel("  ");
		youxiang.setBounds(96,85,25,25);
		youxiang.setToolTipText("邮箱");
		bg.add(youxiang);
		
		isonline = new JPopupMenu("状态");
		
		zaixian = new JMenuItem("在线",new ImageIcon("tubiao/online.jpg"));
		likai = new JMenuItem("离开",new ImageIcon("tubiao/zoule.jpg"));
		manglu = new JMenuItem("忙碌",new ImageIcon("tubiao/manglu.jpg"));
		
		isonline.add(zaixian);
		isonline.add(likai);
		isonline.add(manglu);
		
		head = new JLabel(new ImageIcon(idtable.getQQhead()));
		head.setBounds(10, 43, 60, 62);
		bg.add(head);
		
		name = new JLabel(idtable.getQQname());
		name.setBounds(80, 35, 40, 30);
		bg.add(name);
		
		huanfu = new JLabel("  ");
		huanfu.setBounds(232, 90, 15, 15);
		huanfu.setToolTipText("换肤");
		bg.add(huanfu);
		
		qianming =  new JLabel(idtable.getHobit());
		qianming.setBounds(80, 58, 100, 30);
		bg.add(qianming);
		
		look = new JLabel("   ");
		look.setBounds(180, 643, 30, 30);
		bg.add(look);
		
		playganme = new JPopupMenu();
		saolei = new JMenuItem("扫雷");
		tanke = new JMenuItem("坦克大战");
		
		playganme.add(saolei);
		playganme.add(tanke);
		
		youxi=new JLabel(" ");
		youxi.setBounds(38, 615, 30, 30);
		youxi.setToolTipText("游戏");
		bg.add(youxi);
		
		chat = new JMenuItem("聊天");
		jvsunyou = new JMenuItem("移动到损友分组");
		jvmare = new JMenuItem("移动到同学分组");
		jvsidang = new JMenuItem("移动到死党分组");
		jvfriend = new JMenuItem("移动到有群分组");
		jvhmd = new JMenuItem("移入黑名单");
		delete = new JMenuItem("删除好友");
		lookfriendinfo = new JMenuItem("查看好友资料");
		
		pop = new JPopupMenu();
		
		pop.add(chat);
		pop.add(jvsunyou);
		pop.add(jvmare);
		pop.add(jvsidang);
		pop.add(jvfriend);
		pop.add(jvhmd);
		pop.add(lookfriendinfo);
		pop.add(delete);
		
		chat.addActionListener(this);
		jvsunyou.addActionListener(this);
		jvmare.addActionListener(this);
		jvsidang.addActionListener(this);
		jvfriend.addActionListener(this);
		jvhmd.addActionListener(this);
		lookfriendinfo.addActionListener(this);
		delete.addActionListener(this);
		youxi.addMouseListener(this);
		
		//实例化向量，分组向量
		allimfmation = new Vector<QQidtable>();
		vsunyou = new Vector<QQidtable>();//损友
		vmare = new Vector<QQidtable>();//同学
		vsidang  = new Vector<QQidtable>();//死党 
		vfriend = new Vector<QQidtable>();//朋友
		vhmd  = new Vector<QQidtable>();//黑名单
		
		list1 = new JList();
		list2 = new JList();
		list3 = new JList();
		list4 = new JList();
		list5 = new JList();
		
		//更新界面
		reflush();
		//设置透明的背景
		UIManager.put("TabbedPane.contentOpaque", false);
//		"损友","同学","死党","朋友","黑名单"
		jp = new JTabbedPane();
		jp.addTab("损友",list1);
		jp.addTab("同学",list2);
		jp.addTab("死党",list4);
		jp.addTab("友群",list3);
		jp.addTab("黑名单",list5);
		jp.setBounds(0, 140, 281, 474);
		jp.setOpaque(false);
		bg.add(jp);
		
		close.addMouseListener(this);
		min.addMouseListener(this);
		huanfu.addMouseListener(this);
		look.addMouseListener(this);
		head.addMouseListener(this);
		
		list1.addMouseListener(this);
		list2.addMouseListener(this);
		list3.addMouseListener(this);
		list4.addMouseListener(this);
		list5.addMouseListener(this);
		qqliuranqi.addMouseListener(this);
		yingyongbao.addMouseListener(this);
		tengxun.addMouseListener(this);
		qqkongjian.addMouseListener(this);
		youxiang.addMouseListener(this);
		saolei.addActionListener(this);
		tanke.addActionListener(this);
		
		music = new JLabel(" ");
		music.setBounds(64, 615, 30, 30);
		bg.add(music);

		pop1 = new JPopupMenu();
		
		open = new JMenuItem("音乐开");
		clo = new JMenuItem("音乐关");
		
		pop1.add(open);
		pop1.add(clo);
		
		open.addActionListener(this);
		clo.addActionListener(this);
		music.addMouseListener(this);
		zaixian.addActionListener(this);
		likai.addActionListener(this);
		manglu.addActionListener(this);
		 
		//启动线程
		new ReceiveThread().start();
		//发送登录广播
		SendCmd.sendAll(allimfmation, idtable, QQminlin.CMD_ONLINE);
		setSize(281, 671);
		setVisible(true);
		Vector offdata=new Vector();
		offdata=new QQbase().readoffline(idtable.getQQid());
		System.out.println("打印数据"+offdata.size());
		if(offdata.size()!=0){
			int qq=((Integer)offdata.get(0));
			QQidtable offsendinfo=qqbase.getselectfriend(qq);
			String str5="你的好友"+offsendinfo.getQQname()+"给你发来消息，是否接收";
			JOptionPane.showMessageDialog(this, "好友发来离线消息");
			Chatfase chat=QQchat.get(offsendinfo.getQQid());
			if(chat==null){
				chat=new Chatfase(idtable,offsendinfo,null);
				QQchat.put(offsendinfo.getQQid(), chat);
				
			chat.show();
			String str2=offdata.get(3).toString();
			String name=offsendinfo.getQQname();
			Date date=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time=sf.format(date);
			String s=name+""+time+"\n"+str2+"\n";
			System.out.println(str2);
			chat.txtread.setText(s);
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		qqbase.deletenews(idtable.getQQid());
		setLocation(700, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new haoyoufase(new QQidtable());
	}
	public void openchat(){
		Chatfase chatfase = QQchat.get(friendtable.getQQid());
		if (chatfase==null) {
			chatfase = new Chatfase(idtable,friendtable,vfriend);
			QQchat.put(idtable.getQQid(), chatfase);
		}
		chatfase.show();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == close) {
			reflush();
			//更改为离线状态
			qqbase.changeStatus(idtable.getQQid(), QQminlin.STATUS[1]);
			idtable.setZhuangtai(QQminlin.STATUS[1]);
			reflush();
			SendCmd.sendAll(allimfmation, idtable, QQminlin.CMD_OFFLINE);
			System.exit(0);
		}else if (e.getSource()==min) {
			setState(JFrame.HIDE_ON_CLOSE);
		}else if (e.getSource()==huanfu) {
			//换肤函数，运用文件选择框
			JFileChooser dlg = new JFileChooser();
			//打开文件对话框
			dlg.setDialogType(JFileChooser.OPEN_DIALOG);
			dlg.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //设置对话框标题
			dlg.setDialogTitle("更换皮肤");
			if (dlg.showOpenDialog(this) == dlg.APPROVE_OPTION) {
            	File file = dlg.getSelectedFile();
            	String path = file.getPath();
            	bg.setIcon(new ImageIcon(path));
            }
		}else if (e.getSource()==look) {
			new LookFriend1(idtable);
		}else if (e.getSource()==head) {
			if (e.getClickCount()==2) {
				new Updatefriendfase(idtable,this);
			}
			if (e.getButton()==3) {
				isonline.show(head,e.getX(),e.getY());
			}
		}else if (e.getSource()==list1) {
			if(list1.getSelectedIndex()>=0){
				friendtable = vsunyou.get(list1.getSelectedIndex());
			}
			if (e.getButton()==3) {
					if(list1.getSelectedIndex()>=0){
						pop.show(list1, e.getX(), e.getY());
					}
			}else if (e.getClickCount()==2) {
				if(list1.getSelectedIndex()>=0){
					openchat();
				}
				
			}
		}else if (e.getSource()==list2) {
			if(list2.getSelectedIndex()>=0){
				friendtable = vmare.get(list2.getSelectedIndex());
			}
			if (e.getButton()==3) {
				if(list2.getSelectedIndex()>=0){
					pop.show(list2, e.getX(), e.getY());
				}
			}else if (e.getClickCount()==2) {
				if(list2.getSelectedIndex()>=0){
					openchat();
				}
				
			}
		}else if (e.getSource()==list3) {
			if(list3.getSelectedIndex()>=0){
				friendtable = vfriend.get(list3.getSelectedIndex());
			}
			if (e.getButton()==3) {
				if(list3.getSelectedIndex()>=0){
					pop.show(list3, e.getX(), e.getY());
				}
			}else if (e.getClickCount()==2) {
				if(list3.getSelectedIndex()>=0){
					openchat();
				}
				
			}
		}else if (e.getSource()==list4) {
			if(list4.getSelectedIndex()>=0){
				friendtable = vsidang.get(list4.getSelectedIndex());
			}
			if (e.getButton()==3) {
				if(list4.getSelectedIndex()>=0){
					pop.show(list4, e.getX(), e.getY());
				}
			}else if (e.getClickCount()==2) {
				if(list4.getSelectedIndex()>=0){
					openchat();
				}
			}
		}else if (e.getSource()==list5) {
			if(list5.getSelectedIndex()>=0){
				friendtable = vhmd.get(list5.getSelectedIndex());
			}
			if (e.getButton()==3) {
				if(list5.getSelectedIndex()>=0){
					pop.show(list5, e.getX(), e.getY());
				}
			}else if (e.getClickCount()==2) {
				if(list5.getSelectedIndex()>=0){
					
					openchat();
				}
				
			}
		}else if (e.getSource()==music) {
			if (e.getButton()==3) {
				pop1.show(this, 64, 615);
			}else if (e.getButton()==1) {
				new OpenWeb("QQ音乐.lnk");
			}
			
		}else if (e.getSource()==youxi) {
			if (e.getButton()==3) {
				playganme.show(this,38, 615);
			}
			
		}else if (e.getSource()==qqliuranqi) {
			new OpenWeb("qqliuranqi.lnk");
		}else if (e.getSource()==yingyongbao) {
			new OpenWeb("yingyongbao.html");
		}else if (e.getSource()==tengxun) {
			new OpenWeb("tengxun.html");
		}else if (e.getSource()==qqkongjian) {
			new OpenWeb("qqkongjian.html");
		}else if(e.getSource()==youxiang){
			new OpenWeb("qqemail.html");
		}
		
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource()==lookfriendinfo) {
			friendtable = vsunyou.get(list1.getSelectedIndex());
			new Lookfriendfase(friendtable);
		}
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==lookfriendinfo) {
			friendtable = vsunyou.get(list1.getSelectedIndex());
			new Lookfriendfase(friendtable);
		}else if (e.getSource()==chat) {
			friendtable = vsunyou.get(list5.getSelectedIndex());
			new Chatfase(idtable,friendtable,vfriend);
		}else if (e.getSource()==open) {
			sound4 = new Sound4();
		}else if(e.getSource()==clo){
			if(sound4.isplay()){
				sound4.mystop();
			}
		}else if (e.getSource()==jvsunyou) {
			qqbase.MoveGroupName(idtable.getQQid(), friendtable.getQQid(), QQminlin.GROUPNAME[0]);
			reflush();
		}else if (e.getSource()==jvmare) {
			qqbase.MoveGroupName(idtable.getQQid(), friendtable.getQQid(), QQminlin.GROUPNAME[1]);
			reflush();
		}else if (e.getSource()==jvsidang) {
			qqbase.MoveGroupName(idtable.getQQid(), friendtable.getQQid(), QQminlin.GROUPNAME[2]);
			reflush();
		}else if (e.getSource()==jvfriend) {
			qqbase.MoveGroupName(idtable.getQQid(), friendtable.getQQid(), QQminlin.GROUPNAME[3]);
			reflush();
		}else if (e.getSource()==jvhmd) {
			qqbase.MoveGroupName(idtable.getQQid(), friendtable.getQQid(), QQminlin.GROUPNAME[4]);
			reflush();
		}else if (e.getSource()==zaixian) {
			String status = idtable.getZhuangtai();
			String headImg = idtable.getQQhead();
			String filename = "";
			int pos = headImg.indexOf('.');
			String pre = headImg.substring(0,pos);
			String fix = headImg.substring(pos,headImg.length());
			filename = pre +fix;
			head.setIcon(new ImageIcon(filename));
			qqbase.changeStatus(idtable.getQQid(), QQminlin.STATUS[0]);
			SendCmd.sendAll(allimfmation, idtable, QQminlin.CMD_CHANGESTATE);
		}else if (e.getSource()==likai) {
			JOptionPane.showMessageDialog(this, "离开");
			String status = idtable.getZhuangtai();
			String headImg = idtable.getQQhead();
			String filename = "";
			int pos = headImg.indexOf('.');
			String pre = headImg.substring(0,pos);
			String fix = headImg.substring(pos,headImg.length());
			filename = pre +"k"+fix;
			head.setIcon(new ImageIcon(filename));
			qqbase.changeStatus(idtable.getQQid(), QQminlin.STATUS[2]);
			System.out.println("离开头像"+filename);
			SendCmd.sendAll(allimfmation, idtable, QQminlin.CMD_CHANGESTATE);
		}else if (e.getSource()==manglu) {
			JOptionPane.showMessageDialog(this, "忙碌");
			String status = idtable.getZhuangtai();
			String headImg = idtable.getQQhead();
			String filename = "";
			int pos = headImg.indexOf('.');
			String pre = headImg.substring(0,pos);
			String fix = headImg.substring(pos,headImg.length());
			filename = pre + "m"+fix;
			head.setIcon(new ImageIcon(filename));
			qqbase.changeStatus(idtable.getQQid(), QQminlin.STATUS[3]);
			SendCmd.sendAll(allimfmation, idtable, QQminlin.CMD_CHANGESTATE);
			System.out.println("忙碌头像"+filename);
		}else if (e.getSource()==delete) {
			JOptionPane.showMessageDialog(this, "删除好友!");
			qqbase.delFriend(idtable.getQQid(), friendtable.getQQid());
			JOptionPane.showMessageDialog(this, "你正在删除你的好友"+friendtable.getQQname()+"确认删除吗？");
			reflush();
			SendMsg msg = new SendMsg();
			msg.cmd = QQminlin.CMD_DELETE;
			msg.idtable=idtable;
			msg.friendtable = friendtable;
			SendCmd.send(msg);
			reflush();
			
		}else if (e.getSource()==saolei) {
			new game.ShaoRei();
		}else if (e.getSource()==tanke) {
			new TankClient();
		}
	}
	public void reflush(){
		//获取所有好友的信息
		allimfmation = qqbase.getmyfriend(idtable.getQQid());
		//清空个个分组的数据，重新赋值
		vsunyou.clear();
		vmare.clear();
		vsidang.clear();
		vfriend.clear();
		vhmd.clear();
		//循环保存数据
		for (QQidtable table : allimfmation) {
//			"损友","同学","死党","朋友","黑名单"
			String groupname = table.getGroupname();
			//区别各个好友的类型，区分各个分组
			if(groupname.equals(QQminlin.GROUPNAME[0])){
				vsunyou.add(table);
			}else if(groupname.equals(QQminlin.GROUPNAME[1])){
				vmare.add(table);
			}else if(groupname.equals(QQminlin.GROUPNAME[2])){
				vsidang.add(table);
			}else if(groupname.equals(QQminlin.GROUPNAME[3])){
				vfriend.add(table);
			}else if(groupname.equals(QQminlin.GROUPNAME[4])){
				vhmd.add(table);
			}
			
			list1.setModel(new DataModel(vsunyou));
			list2.setModel(new DataModel(vmare));
			list3.setModel(new DataModel(vfriend));
			list4.setModel(new DataModel(vsidang));
			list5.setModel(new DataModel(vhmd));	
			
			list1.setCellRenderer(new MyfriendHead(vsunyou));
			list2.setCellRenderer(new MyfriendHead(vmare));
			list3.setCellRenderer(new MyfriendHead(vfriend));
			list4.setCellRenderer(new MyfriendHead(vsidang));
			list5.setCellRenderer(new MyfriendHead(vhmd));
		}
	}
	//显示文本信息
	class DataModel extends AbstractListModel {
		Vector<QQidtable> data;
		public DataModel() {
				
		}
		public DataModel(Vector<QQidtable> data) {
			this.data = data;
		}
	    //系统自动运行，下标从0开始计算
	    public Object getElementAt(int index) {
	    	QQidtable info = data.get(index);
	    	//返回当前的信息，QQ号码，签名，QQ昵称
	    	return info.getQQname()+"("+info.getQQid()+")<"+info.getRemark()+">";
	    }

	    public int getSize() {
//	    	System.out.println("data.size()="+data.size());
	        return data.size();
	    }
	}
	// 获取好友头像
	class MyfriendHead extends DefaultListCellRenderer {
		Vector<QQidtable> datas;
		public MyfriendHead(Vector<QQidtable> datas) {
			
			this.datas = datas;
		}
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			if (index >= 0 && index < datas.size()) {
				QQidtable user =  datas.get(index);
				String status = user.getZhuangtai();
				String headImg = user.getQQhead();
				String filename = "";
				if(status.equals(QQminlin.STATUS[0])){
					int pos = headImg.indexOf('.');
					String pre = headImg.substring(0,pos);
					String fix = headImg.substring(pos,headImg.length());
					filename = pre + "b"+fix;
				}else if(status.equals(QQminlin.STATUS[1])){
					int pos = headImg.indexOf('.');
					String pre = headImg.substring(0,pos);
					String fix = headImg.substring(pos,headImg.length());
					filename = pre + "l"+fix;
				}else if (status.equals(QQminlin.STATUS[2])) {
					int pos = headImg.indexOf('.');
					String pre = headImg.substring(0,pos);
					String fix = headImg.substring(pos,headImg.length());
					filename = pre + "bl"+fix;
					System.out.println(filename);
				}else if (status.equals(QQminlin.STATUS[3])) {
					int pos = headImg.indexOf('.');
					String pre = headImg.substring(0,pos);
					String fix = headImg.substring(pos,headImg.length());
					filename = pre + "bm"+fix;
					System.out.println(filename);
				}
				
				setIcon(new ImageIcon(filename));
				setText(user.getQQname()+"("+user.getQQid()+")<"+user.getRemark()+">");
			}
			// 设置字体颜色
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			setEnabled(list.isEnabled());
			setFont(new Font("黑体",Font.BOLD,16));
			setForeground(Color.blue);
			setOpaque(true);
			return this;
		}
	}
	//定义内部线程类
	class ReceiveThread extends Thread{
		public ReceiveThread() {
			
		}
		@Override
		public void run() {
			try {
				DatagramSocket socket = new DatagramSocket(idtable.getPort());
				while(true){
					byte b[] = new byte[1024*512];
					DatagramPacket pack = new DatagramPacket(b,0,b.length);
					//接收信息
					socket.receive(pack);
					ByteArrayInputStream bais = new ByteArrayInputStream(pack.getData());
					ObjectInputStream ois = new ObjectInputStream(bais);
					SendMsg msg = (SendMsg)ois.readObject();
					idtable=msg.friendtable;
					friendtable = msg.idtable;
					switch(msg.cmd){
					case QQminlin.CMD_CHANGESTATE:
						reflush();
						break;
					case QQminlin.CMD_ONLINE: //登录
					case QQminlin.CMD_OFFLINE:
						reflush();
						System.out.println("上线通知！！！");
						new QQSQL.Sound(msg.cmd);
						new TipUI(friendtable);
						reflush();
						break;
					case QQminlin.CMD_SEND: //接收聊天消息
						new QQSQL.Sound(msg.cmd);
						System.out.println("接收聊天消息....");
						Chatfase chatfase = QQchat.get(idtable.getQQid());
						if (chatfase==null) {
							chatfase = new Chatfase(msg.friendtable,msg.idtable,vfriend);
						}
						QQchat.put(idtable.getQQid(), chatfase);
						chatfase.show();
						try {
								chatfase.appendView(msg.idtable.getQQname(), msg.doc);
							} catch (BadLocationException e) {
								e.printStackTrace();
							}
						break;
					case QQminlin.CMD_SHAKE:
						new QQSQL.Sound(msg.cmd);
						chatfase = QQchat.get(idtable.getQQid());
						if (chatfase==null) {
							chatfase = new Chatfase(msg.friendtable,msg.idtable,vfriend);
						}
						QQchat.put(idtable.getQQid(), chatfase);
						chatfase.show();
						chatfase.shake();
						System.out.println("接收抖动消息....");
						break;
					case QQminlin.CMD_ADDFRI:
						new QQSQL.Sound(msg.cmd);
						String str = "@"+idtable.getQQname()+"@请求添加你为好友，是否同意？";
						SendMsg msg2 = new SendMsg();
						if(JOptionPane.showConfirmDialog(null, str,"添加好友",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							msg2.cmd = QQminlin.CMD_ARGEE;
							qqbase.addFriend( idtable.getQQid(),friendtable.getQQid());
							reflush();
						}else{
							msg2.cmd = QQminlin.CMD_REFUSE;
						}
						msg2.idtable = idtable;
						msg2.friendtable = friendtable;
						SendCmd.send(msg2);
						reflush();
						break;
					case QQminlin.CMD_ARGEE:
						reflush();
						break;
					case QQminlin.CMD_REFUSE:
						str = "@"+friendtable.getQQname()+"@拒绝了你。";
						JOptionPane.showMessageDialog(null, str);
						break;
					case QQminlin.CMD_DELETE:
						reflush();
						break;
					case QQminlin.CMD_FILE:
						str = friendtable.getQQname()+"发送了一个【"+msg.fileName+"文件】，是否接收？";
						if(JOptionPane.showConfirmDialog(null, "是否接收文件","接收文件",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							JFileChooser chooser = new JFileChooser(" ");
				            chooser.setDialogType(JFileChooser.SAVE_DIALOG);
				            chooser.setDialogTitle("保存文件");
				            if (chooser.showOpenDialog(null) == chooser.APPROVE_OPTION) {
				            	String ext = msg.fileName.substring(msg.fileName.indexOf('.'),msg.fileName.length());
				            	String filename = chooser.getSelectedFile().getAbsolutePath()+ext;
				            	FileOutputStream fos = new FileOutputStream(filename);
				            	fos.write(msg.b);
				            	fos.flush();
				            	fos.close();
				            }
						}
					}
				}
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosing(WindowEvent e) {
		
		
	}
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
//播放背景音乐
class Sound4 {
	String path = new String("musics\\");
	// 默认背景音乐
	String file = new String("694.mid");
	Sequence seq;
	Sequencer midi;
	// 判断是否在播放音乐
	boolean sign;

	public Sound4() {
		loadSound();
	}

//播放背景音乐的函数
void loadSound() {
	try {
		// 读取音频文件
		seq = MidiSystem.getSequence(new File(path + file));
		// 获取一个音频设备
		midi = MidiSystem.getSequencer();
		// 打开音频设备
		midi.open();
		// 把音频文件设置到播放设备中
		midi.setSequence(seq);
		// 开始播放音乐
		midi.start();
		// 循环播放
		midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	// 代表正在播放背景音乐
	sign = true;
}

// 停止播放背景音乐
void mystop() {
	midi.stop();
	midi.close();
	sign = false;
}

// 判断是否在播放背景音乐
boolean isplay() {
	return sign;
}

// 设置在下拉框中选择的背景音乐文件名称
void setMusic(String e) {
	file = e;
}
}

