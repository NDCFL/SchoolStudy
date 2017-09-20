package Tuixiangzi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
public class Tuixiangzi extends JFrame implements ActionListener,ItemListener{
	JButton lbchonglai,lbFirst,lbnext,lblast,lbxuanguan,lbhuiyibu,lbshangyiguan,lbxiayiguan,lbmusic;
	JMenu jmxuanzhe,jmmusic,jmhelpMenu;
	JLabel title,yingyue;
	JPanel panel;
	JComboBox cmusic;
	JMenu xuanzhe,yinyue,help;
	JMenuBar caidan;
	JPopupMenu popup;
	MyPanel mypanel;
	Sound sound;
	String sMusicFile[]={
			"nor.mid",
			"qin.mid",
			"popo.mid",
			"guang.mid",
			"eyes on me.mid"
	};
	final int MAXLEVEL=50;//关卡总数
	JMenuItem jxiayguan,jshangyiguan,jlast,jfirst,jhuiyibu,jexit,qin,po,guang,nor,eye,guanyu;
	public Tuixiangzi() {
		super("推箱子游戏");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("pic/5.gif");
		setIconImage(image);
		panel = new JPanel(null);
		menu();
		lable();
		mypanel = new MyPanel();
		mypanel.setBounds(10, 60, 600, 600);
		panel.add(mypanel);
		panel.requestFocus();
		setSize(720, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sound = new Sound();
		mypanel.requestFocus();
	}
	public void lable() {
		
		
		title = new JLabel("推箱子游戏",JLabel.CENTER);
		title.setBounds(230, 20, 200, 30);
		title.setFont(new Font("华文行楷",Font.BOLD,35));
		title.setForeground(Color.lightGray);
		
		lbchonglai = new JButton("重来");
		lbchonglai.setBounds(620, 100, 80, 30);
		lbchonglai.setFont(new Font("黑体",Font.BOLD,14));
		lbchonglai.setForeground(Color.blue);
		
		lbFirst= new JButton("第一关");
		lbFirst.setBounds(620, 150, 80, 30);
		lbFirst.setFont(new Font("黑体",Font.BOLD,14));
		lbFirst.setForeground(Color.cyan);
		
		lbshangyiguan= new JButton("上一关");
		lbshangyiguan.setBounds(620, 200, 80, 30);
		lbshangyiguan.setFont(new Font("黑体",Font.BOLD,14));
		lbshangyiguan.setForeground(Color.darkGray);
		
		
		lbnext= new JButton("下一关");
		lbnext.setBounds(620, 250, 80, 30);
		lbnext.setFont(new Font("黑体",Font.BOLD,14));
		lbnext.setForeground(Color.gray);
		
		lblast= new JButton("最后关");
		lblast.setBounds(620, 300, 80, 30);
		lblast.setFont(new Font("黑体",Font.BOLD,14));
		lblast.setForeground(Color.green);
		
		lbxuanguan= new JButton("选关");
		lbxuanguan.setBounds(620, 350, 80, 30);
		lbxuanguan.setFont(new Font("黑体",Font.BOLD,14));
		lbxuanguan.setForeground(Color.LIGHT_GRAY);
		
		lbhuiyibu= new JButton("悔一步");
		lbhuiyibu.setBounds(620, 400, 80, 30);
		lbhuiyibu.setFont(new Font("黑体",Font.BOLD,14));
		lbhuiyibu.setForeground(Color.magenta);
		
		lbmusic= new JButton("音乐关");
		lbmusic.setBounds(620, 450, 80, 30);
		lbmusic.setFont(new Font("黑体",Font.BOLD,14));
		lbmusic.setForeground(Color.yellow);
		
		yingyue = new JLabel("选择音乐",JLabel.CENTER);
		yingyue.setBounds(620, 500, 80, 30);
		yingyue.setFont(new Font("黑体",Font.BOLD,14));
		yingyue.setForeground(Color.gray);
		
		String [] yl={"默认","琴萧合奏","泡泡堂","灌篮高手","eyes on me"};
		cmusic= new JComboBox(yl);
		cmusic.setBounds(620, 550, 80, 30);
		
		panel.add(title);
		panel.add(lbchonglai);
		panel.add(lbFirst);
		panel.add(lbnext);
		panel.add(lblast);
		panel.add(lbxuanguan);
		panel.add(lbhuiyibu);
		panel.add(lbmusic);
		panel.add(lbshangyiguan);
		panel.add(yingyue);
		panel.add(cmusic);
		
		//监听事件
		lbchonglai.addActionListener(this);
		lbFirst.addActionListener(this);
		lbnext.addActionListener(this);
		lblast.addActionListener(this);
		lbxuanguan.addActionListener(this);
		lbhuiyibu.addActionListener(this);
		lbshangyiguan.addActionListener(this);
		lbmusic.addActionListener(this);

		
		jxiayguan.addActionListener(this);
		jshangyiguan.addActionListener(this);
		jlast.addActionListener(this);
		jfirst.addActionListener(this);
		jhuiyibu.addActionListener(this);
		jexit.addActionListener(this);
		qin.addActionListener(this);
		po.addActionListener(this);
		guang.addActionListener(this);
		nor.addActionListener(this);
		eye.addActionListener(this);
		guanyu.addActionListener(this);
		cmusic.addItemListener(this);
		add(panel);
		
		
	}
	public void menu(){
		Icon icon = new ImageIcon("images/41.gif");
		caidan = new JMenuBar();//菜单条
		//子菜单
		xuanzhe = new JMenu("选择");
		yinyue = new JMenu("音乐");
		help = new JMenu("帮助");
		//把子菜单加到菜单条里
		caidan.add(xuanzhe);
		caidan.add(yinyue);
		caidan.add(help);
		//菜单项
		jfirst= new JMenuItem("第一关",icon);
		jlast= new JMenuItem("最后一关",icon);
		jshangyiguan= new JMenuItem("上一关",icon);
		jxiayguan = new JMenuItem("下一关",icon);
		jhuiyibu= new JMenuItem("悔一步",icon);
		jexit= new JMenuItem("退出",icon);
		
		
		xuanzhe.add(jfirst);
		xuanzhe.add(jlast);
		xuanzhe.add(jshangyiguan);
		xuanzhe.add(jxiayguan);
		xuanzhe.add(jhuiyibu);
		xuanzhe.addSeparator();
		xuanzhe.add(jexit);
		
		qin = new JCheckBoxMenuItem("琴萧合奏",icon);

		po = new JCheckBoxMenuItem("泡泡堂",icon);

		guang = new JCheckBoxMenuItem("灌篮高手",icon);

		nor = new JCheckBoxMenuItem("默认",icon);

		eye = new JCheckBoxMenuItem("eyes on me",icon);
		ButtonGroup bg = new ButtonGroup();
		bg.add(qin);
		bg.add(po);
		bg.add(guang);
		bg.add(nor);
		bg.add(eye);
		yinyue.add(nor);
		yinyue.add(qin);
		yinyue.add(po);
		yinyue.add(guang);
		yinyue.add(eye);
		nor.setSelected(true);
		nor.setEnabled(false);
		
		guanyu = new JMenuItem("关于推箱子",icon); 
		help.add(guanyu);
		
		JMenuItem jfirst1= new JMenuItem("第一关",icon);
		JMenuItem jlast1= new JMenuItem("最后一关",icon);
		JMenuItem jshangyiguan1= new JMenuItem("上一关",icon);
		JMenuItem jxiayguan1 = new JMenuItem("下一关",icon);
		JMenuItem jhuiyibu1= new JMenuItem("悔一步",icon);
		JMenuItem jexit1= new JMenuItem("退出",icon);
		
		//弹出菜单
		popup = new JPopupMenu();
		popup.add(jfirst1);
		popup.add(jlast1);
		popup.add(jshangyiguan1);
		popup.add(jxiayguan1);
		popup.add(jhuiyibu1);
		
		setJMenuBar(caidan);
	}
	public void setmenuitem(int Index){
		switch (Index) {
			case 0:
				nor.setSelected(true);
				nor.setEnabled(false);
				qin.setEnabled(true);
				po.setEnabled(true);
				guang.setEnabled(true);
				eye.setEnabled(true);
				mypanel.requestFocus();
				break;
	
			case 1:
				qin.setSelected(true);
				qin.setEnabled(false);
				nor.setEnabled(true);
				po.setEnabled(true);
				guang.setEnabled(true);
				eye.setEnabled(true);
				mypanel.requestFocus();
				break;
			case 2:
				po.setSelected(true);
				po.setEnabled(false);
				nor.setEnabled(true);
				qin.setEnabled(true);
				guang.setEnabled(true);
				eye.setEnabled(true);
				mypanel.requestFocus();
				break;
			case 3:
				guang.setSelected(true);
				guang.setEnabled(false);
				nor.setEnabled(true);
				qin.setEnabled(true);
				po.setEnabled(true);
				eye.setEnabled(true);
				mypanel.requestFocus();
				break;
			case 4:
				eye.setSelected(true);
				eye.setEnabled(false);
				nor.setEnabled(true);
				qin.setEnabled(true);
				po.setEnabled(true);
				guang.setEnabled(true);
				mypanel.requestFocus();
				break;
		}
	}
	
	public static void main(String[] args) {
		new Tuixiangzi();
		//new ReadMap(1);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==guanyu) {
			String str = "游戏名称：推箱子\n作者：陈飞龙\n玩法帮助：操控键盘上的上下左右键就可以玩游戏了\n作者寄语：希望你玩的开心";
			JOptionPane.showMessageDialog(this,str,"游戏帮助\n",JOptionPane.INFORMATION_MESSAGE);
		}else if (e.getSource()==jexit ) {
			System.exit(0);
		}else if (e.getSource()==lbFirst || e.getSource()==jfirst) {
			mypanel.level=1;
			mypanel.readFile(mypanel.level);
			mypanel.requestFocus();
		}else if (e.getSource()==lbnext || e.getSource()==jxiayguan) {
			mypanel.level++;
			mypanel.readFile(mypanel.level);
			mypanel.requestFocus();
		}else if (e.getSource()==lbshangyiguan || e.getSource()==jshangyiguan) {
			mypanel.level--;
			if ( mypanel.level < 1 ) {
				mypanel.level++;
				JOptionPane.showMessageDialog(this, "本关是第一关");
				mypanel.requestFocus();
			}
			else {
				mypanel.readFile(mypanel.level);
				mypanel.requestFocus();
			}
			mypanel.requestFocus();
		}else if (e.getSource()==lblast || e.getSource()==jlast) {
			mypanel.level=50;
			mypanel.readFile(mypanel.level);
			mypanel.requestFocus();
		}else if (e.getSource()==lbxuanguan) {
			String str = JOptionPane.showInputDialog(this, "请输入你喜爱的关卡","选关",JOptionPane.OK_CANCEL_OPTION);
			if (str!=null) {
				try {
					int level = Integer.parseInt(str);
					if (level<0 || level>50) {
						
							JOptionPane.showMessageDialog(this, "你输入的关卡有误！请输入1到50的数字");
							return;
					}
					
					mypanel.setLevel(level);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "你输入的关卡有误！请输入1到50的数字");
					return;
				}
			}
			
		}else if(e.getSource()==lbmusic){
			//获取按钮文字
			String title = lbmusic.getText();
			if(title.equals("音乐关")){
				if(sound.isplay()){
					//停止播放音乐
					sound.mystop();
				}
				//设置按钮标题
				lbmusic.setText("音乐开");
				mypanel.requestFocus();
			}else{
				lbmusic.setText("音乐关");
				//播放音乐
				sound.loadSound();
				mypanel.requestFocus();
			}
		}else if (e.getSource()==lbhuiyibu || e.getSource()==jhuiyibu) {
			//悔一步的函数
			mypanel.goback();
			mypanel.requestFocus();
		}else if (e.getSource()==lbchonglai) {
			mypanel.setLevel();
		}else if (e.getSource()==nor) {
			cmusic.setSelectedIndex(0);
		}else if (e.getSource()==qin) {
			cmusic.setSelectedIndex(1);
		}else if (e.getSource()==po) {
			cmusic.setSelectedIndex(2);
		}else if (e.getSource()==guang) {
			cmusic.setSelectedIndex(3);
		}else if (e.getSource()==eye) {
			cmusic.setSelectedIndex(4);
		}

	}
	public void itemStateChanged(ItemEvent e) {
		
		//获取在下拉框中选中的索引
		int index = cmusic.getSelectedIndex();
		setmenuitem(index);
		//利用索引，从数组中获取背景音乐文件名称
		String sfilename = sMusicFile[index];
		
		sound.setMusic(sfilename);
		//如果已经在播放背景音乐，则先停止播放
		if(sound.isplay()){
			sound.mystop();
		}
		//播放音乐
		sound.loadSound();
		mypanel.requestFocus();
	}
	
	//游戏面板
	class MyPanel extends JPanel implements KeyListener{
		private int level=1;
		private int mx;
		private int my;
		//原始数据
		private int map[][]; 
		//临时数据
		private int tempMap[][];
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image mapimg[]={
			kit.getImage("pic/0.gif"),
			kit.getImage("pic/1.gif"),
			kit.getImage("pic/2.gif"),
			kit.getImage("pic/3.gif"),
			kit.getImage("pic/4.gif"),
			kit.getImage("pic/5.gif"),
			kit.getImage("pic/6.gif"),
			kit.getImage("pic/7.gif"),
			kit.getImage("pic/8.gif"),
			kit.getImage("pic/9.gif"),
		};
		Stack<Integer> stack = new Stack<Integer>();
		//读取地图；
		public void readFile(int level){
			
			ReadMap readMap = new ReadMap(level);
			//原始数据
			this.map = readMap.getMap();
			this.mx  = readMap.getMx();
			this.my  = readMap.getMy();
			//临时数据，推箱子的过程中，该数组的值会发生变化
			this.tempMap = new ReadMap(level).getMap();
			//重画
			repaint();
		}
		public MyPanel() {
			//监听键盘事件
			this.addKeyListener(this);
			setSize(600, 600);
			readFile(level);
			requestFocus();
		}
		@Override
		public void paint(Graphics g) {
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					g.drawImage(mapimg[tempMap[j][i]], i*30, j*30, 30, 30,this);
				}
			}
			//白色RGB;255*255*255
			g.setColor(new Color(10, 0, 100));
			g.setFont(new Font("华文行楷", Font.BOLD, 40));
			g.drawString("现在是第" +level + "关", 210, 60);
			
		}
		//判断箱子是否已经全部推到位了
		public boolean isWin(){
			boolean isok=true;
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					if((map[i][j]==4 || map[i][j]==9) && tempMap[i][j]!=9){
						isok=false;
						break;
					}
				}
				if(!isok)
					break;
			}
			return isok;
		}
		//设置关卡
		
		//重来的构造函数无参数
		public void setLevel() {
			readFile(this.level);
			stack.clear();
			//设置焦点
			requestFocus();
		}
		public void setLevel(int level) {
			if(level == 0){//第一关
				this.level=1;
			}else if(level==50){//最后一关
				this.level=50;
			}else if(level>0){//选关
				this.level = level;
			}else{
				this.level = this.level +level;
			}
			if(this.level<=0 ){
				this.level =1;	
			}else if( this.level>=50){
				this.level =50;
			}
			readFile(this.level);
			//清空上一关保存在堆栈中的所有步骤
			stack.clear();
			//设置焦点
			requestFocus();
		}
		//控制人物的方向，达到动起来的目的
		public void keyPressed(KeyEvent e) {
			//方向键左键的值
			if(e.getKeyCode()==37){
				goLeft();
			}else if(e.getKeyCode()==38){//方向键向上键的值
				goUp();
			}else if(e.getKeyCode()==39){//方向键向右键的值
				goRight();
			}else if(e.getKeyCode()==40){//方向键向下键的值
				goDown();
			}
			if(isWin()){
				JOptionPane.showMessageDialog(null,"恭喜您过关了，进入下一关");
				mypanel.level=1;
			}
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
		public void goLeft(){
			//人的左边有箱子
			if(tempMap[mx][my-1]==3 || tempMap[mx][my-1]==9){
				//箱子的左边是草地2或者4就可以左边推箱子
				if(tempMap[mx][my-2]==2 || tempMap[mx][my-2]==4){
					if(tempMap[mx][my-2]==2){
						tempMap[mx][my-2]=3;
						tempMap[mx][my-1]=6;
					}else{
						tempMap[mx][my-2]=9;
						tempMap[mx][my-1]=6;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					my--;
					stack.push(33);
				}
				//前面是草地
			}else if(tempMap[mx][my-1]==2 || tempMap[mx][my-1]==4 || tempMap[mx][my-1]==5){
				tempMap[mx][my-1]=6;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				my--;
				stack.push(3);
			}
			repaint();

		}
		public void goUp(){
			//人的上面有箱子
			if(tempMap[mx-1][my]==3 || tempMap[mx-1][my]==9){
				//箱子的上面是草地2或者4就可以向上推箱子
				if(tempMap[mx-2][my]==2 || tempMap[mx-2][my]==4){
					if(tempMap[mx-2][my]==2){
						tempMap[mx-2][my]=3;
						tempMap[mx-1][my]=8;
					}else{
						tempMap[mx-2][my]=9;
						tempMap[mx-1][my]=8;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					mx--;
					stack.push(11);
				}
				//前面是草地
			}else if(tempMap[mx-1][my]==2 || tempMap[mx-1][my]==4 || tempMap[mx-1][my]==5){
				tempMap[mx-1][my]=8;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				mx--;
				stack.push(1);
			}
			repaint();
		}
		public void goRight(){
			//人的右边有箱子
			if(tempMap[mx][my+1]==3 || tempMap[mx][my+1]==9){
				//箱子的右边是草地2或者4就可以右边推箱子
				if(tempMap[mx][my+2]==2 || tempMap[mx][my+2]==4){
					if(tempMap[mx][my+2]==2){
						tempMap[mx][my+2]=3;
						tempMap[mx][my+1]=7;
					}else{
						tempMap[mx][my+2]=9;
						tempMap[mx][my+1]=7;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					my++;
					stack.push(44);
				}
				//右面是草地
			}else if(tempMap[mx][my+1]==2 || tempMap[mx][my+1]==4 || tempMap[mx][my+1]==5){
				tempMap[mx][my+1]=7;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				my++;
				stack.push(4);
			}
			repaint();

		}
		public void goDown(){
			//人的下面有箱子
			if(tempMap[mx+1][my]==3 || tempMap[mx+1][my]==9){
				//箱子的下面是草地2或者4就可以向下推箱子
				if(tempMap[mx+2][my]==2 || tempMap[mx+2][my]==4){
					if(tempMap[mx+2][my]==2){
						tempMap[mx+2][my]=3;
						tempMap[mx+1][my]=5;
					}else{
						tempMap[mx+2][my]=9;
						tempMap[mx+1][my]=5;
					}
					//原来站人的地方要与原始地图进行比较(map数组)
					if(map[mx][my]==4 || map[mx][my]==9){
						tempMap[mx][my]=4;
					}else{
						tempMap[mx][my]=2;
					}
					mx++;
					stack.push(22);
				}
				//前面是草地
			}else if(tempMap[mx+1][my]==2 || tempMap[mx+1][my]==4 || tempMap[mx+1][my]==5){
				tempMap[mx+1][my]=5;
				//原来站人的地方要与原始地图进行比较(map数组)
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=4;
				}else{
					tempMap[mx][my]=2;
				}
				mx++;
				stack.push(2);
			}
			repaint();
		}
		//悔一步所调用的函数
		public void goback(){
			if(stack.isEmpty()){
				JOptionPane.showMessageDialog(null, "已经是初始化状态了");
				return;
			}
			//取出堆栈里的元素
			int n=stack.pop();
			switch(n){
				case 1:
				case 11:
					backup(n);
					break;
				case 2:
				case 22:
					backdown(n);
					break;
				case 3:
				case 33:
					backleft(n);
					break;
				case 4:
				case 44:
					backright(n);
					break;
			}
			//获取焦点
			requestFocus();
		}
		/*
		 * 1 向上没有推到箱子
		 * 11 向上推到了箱子
		 * 
		 * 2 向下没有推到箱子
		 * 22 向下推到了箱子
		 * 
		 * 3 向左没有推到箱子
		 * 33 向左推到了箱子
		 * 
		 * 4 向右没有推到箱子
		 * 44 向右推到了箱子
		 * 
		 * */
		
		//向上边悔一步，悔一步都是对应的方向的相反的的方向
		//上----下；下-----上；左-----右；右-----左；
		public void backleft(int step){
			if(step==3){ //没有推箱子
				tempMap[mx][my+1]=6;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				my++;
			}else{//推了箱子
				tempMap[mx][my+1]=6;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx][my-1]==4 || map[mx][my-1]==9){
					tempMap[mx][my-1]=4;
				}else{
					tempMap[mx][my-1]=2;
				}
				my++;
			}
			//重画界面
			repaint();
		}
		public void backup(int step){
			if(step==1){ //没有推箱子
				tempMap[mx+1][my]=8;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				mx++;
			}else{//推了箱子
				tempMap[mx+1][my]=8;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx-1][my]==4 || map[mx-1][my]==9){
					tempMap[mx-1][my]=4;
				}else{
					tempMap[mx-1][my]=2;
				}
				mx++;
			}
			//重画界面
			repaint();
		}
		public void backright(int step){
			if(step==4){ //没有推箱子
				tempMap[mx][my-1]=7;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				my--;
			}else{//推了箱子
				tempMap[mx][my-1]=7;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx][my+1]==4 || map[mx][my+1]==9){
					tempMap[mx][my+1]=4;
				}else{
					tempMap[mx][my+1]=2;
				}
				my--;
			}
			//重画界面
			repaint();
		}
		public void backdown(int step){
			if(step==2){ //没有推箱子
				tempMap[mx-1][my]=5;
				//原来站人的地方,现在变成草地
				if(map[mx][my]==4 || map[mx][my]==9)
					tempMap[mx][my]=4;
				else
					tempMap[mx][my]=2;
				mx--;
			}else{//推了箱子
				tempMap[mx-1][my]=5;
				//原来站人的地方,现在放箱子
				if(map[mx][my]==4 || map[mx][my]==9){
					tempMap[mx][my]=9;
				}else{
					tempMap[mx][my]=3;
				}
				//原来放箱子的地方，现在变成空地
				if(map[mx+1][my]==4 || map[mx+1][my]==9){
					tempMap[mx+1][my]=4;
				}else{
					tempMap[mx+1][my]=2;
				}
				mx--;
			}
			//重画界面
			repaint();
		}
		
		
		
	}
	
}
//读取地图文件
class ReadMap{
	private int map[][];
	private int mx,my;
	//保存游戏关卡编号
	private int level;
	
	public ReadMap(int level) {
		this.level = level;
		String sfilename = "maps/"+level+".map";
		String content="";
		//用字符流读取文件中的地图数据
		try {
			FileReader fr = new FileReader(sfilename);
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			//一行一行的读取文件的内容，如果读到文件的末尾，则返回null值
			while((temp = br.readLine())!=null){
				content += temp;
			}
			byte b[] = content.getBytes();
			map = new int[20][20];
			int c=0;
			for(int i=0;i<20;i++){
				for(int j=0;j<20;j++){
					map[i][j]=b[c]-48;
					c++;
					if(map[i][j]==5){
						mx=i;
						my=j;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[][] getMap() {
		return map;
	}

	public int getMx() {
		return mx;
	}

	public int getMy() {
		return my;
	}
	
}
//播放背景音乐
class Sound {
	
	
	String path = new String("musics\\");
	//默认背景音乐
	String file = new String("nor.mid");
	Sequence seq;
	Sequencer midi;
	//判断是否在播放音乐
	boolean sign;

	public Sound() {
		loadSound();
	}
	//播放背景音乐的函数
	void loadSound() {
		try {
			//读取音频文件
			seq = MidiSystem.getSequence(new File(path + file));
			//获取一个音频设备
			midi = MidiSystem.getSequencer();
			//打开音频设备
			midi.open();
			//把音频文件设置到播放设备中
			midi.setSequence(seq);
			//开始播放音乐
			midi.start();
			//循环播放
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		}
		catch ( Exception ex ) {
			ex.printStackTrace();
		}
		//代表正在播放背景音乐
		sign = true;
	}
	//停止播放背景音乐
	void mystop() {
		midi.stop();
		midi.close();
		sign = false;
	}

	//判断是否在播放背景音乐
	boolean isplay() {
		return sign;
	}
	//设置在下拉框中选择的背景音乐文件名称
	void setMusic(String e) {
		file = e;
	}
}




