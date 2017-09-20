package T6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import java.util.Date;

public class Birthday extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane js;
	JButton find,add,close,update,delete,closemusic,closeclass;
	JLabel lbheadtitle,lb2,lbname,lbbirthday,lbsex,lbhobit,lbphone,lbtitle,lbxinge;
	JTextField text,name,birthday,hobit,phone,xinge;
	JRadioButton man,weman;
	JTableHeader head;
	ButtonGroup bg;
	JPanel panel;
	String title[]={"姓名","性别","生日","爱好","联系方式","性格特点"};
	String data[][]=new String[90][6];
	String value[][];
	String temp[]= new String[6];
	static int row=0;
	Sound sound;
	@SuppressWarnings("deprecation")
	public Birthday() {
		//设置窗口标题
		setTitle("好友信息管理");
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("281128.jpg");
		setIconImage(image);
		//界面的控件布局
		panel = new JPanel(null);
		table = new JTable(data,title);
		table.setBounds(0, 60, 500, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,16));
		table.setForeground(Color.blue);
		head = table.getTableHeader();
	    //设置表头的背景色
		head.setBackground(new Color(200, 200, 200));
	    //设置表头的文字颜色
		head.setForeground(Color.blue);
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(200,80,580, 292);
		
		panel.add(js);
		
		lbheadtitle = new JLabel("好友信息管理");
		lbheadtitle.setBounds(420, 30, 200, 30);
		lbheadtitle.setFont(new Font("楷体",Font.BOLD,24));
		lbheadtitle.setForeground(Color.blue);
		panel.add(lbheadtitle);
		
		lbtitle = new JLabel("好友新增");
		lbtitle.setBounds(60, 50, 80, 30);
		lbtitle.setForeground(Color.blue);
		panel.add(lbtitle);
		
		lbname = new JLabel("姓名：");
		lbname.setBounds(10, 90, 50, 30);
		lbname.setForeground(Color.blue);
		panel.add(lbname);
		
		name = new JTextField();
		name.setBounds(60, 90, 120, 30);
		panel.add(name);
		
		
		lbsex = new JLabel("性别：");
		lbsex.setBounds(10, 130, 50, 30);
		lbsex.setForeground(Color.blue);
		panel.add(lbsex);
		
		man = new JRadioButton("男",true);
		man.setBounds(60, 130, 50, 30);
		man.setForeground(Color.blue);
		panel.add(man);
		
		weman = new JRadioButton("女",false);
		weman.setBounds(120, 130, 40, 30);
		weman.setForeground(Color.blue);
		panel.add(weman);
		
		bg = new ButtonGroup();
		bg.add(man);
		bg.add(weman);
		
		lbbirthday = new JLabel("生日：");
		lbbirthday.setBounds(10, 170, 50, 30);
		lbbirthday.setForeground(Color.blue);
		panel.add(lbbirthday);
		
		birthday = new JTextField();
		birthday.setBounds(60, 170, 120, 30);
		panel.add(birthday);
		
		lbhobit = new JLabel("爱好：");
		lbhobit.setBounds(10, 220, 60, 30);
		lbhobit.setForeground(Color.blue);
		panel.add(lbhobit);
		
		hobit = new JTextField();
		hobit.setBounds(60, 220, 120, 30);
		panel.add(hobit);
		
		lbphone = new JLabel("Tel：");
		lbphone.setBounds(10, 270, 60, 30);
		lbphone.setForeground(Color.blue);
		panel.add(lbphone);
		
		phone = new JTextField();
		phone.setBounds(60, 270, 120, 30);
		panel.add(phone);
		
		lbxinge = new JLabel("性格：");
		lbxinge.setBounds(10, 320, 60, 30);
		lbxinge.setForeground(Color.blue);
		panel.add(lbxinge);
		
		xinge = new JTextField();
		xinge.setBounds(60, 320, 120, 30);
		panel.add(xinge);
		
		add = new JButton("新增/修改");
		add.setBounds(30, 400, 100, 30);
		add.setForeground(Color.blue);
		panel.add(add);

		find = new JButton("查找");
		find.setBounds(470, 400, 80, 30);
		find.setForeground(Color.blue);
		panel.add(find);
		
		update = new JButton("修改");
		update.setBounds(330, 400, 80, 30);
		update.setForeground(Color.blue);
		panel.add(update);
		
		delete = new JButton("删除");
		delete.setBounds(190, 400, 80, 30);
		delete.setForeground(Color.blue);
		panel.add(delete);
		
		closemusic = new JButton("关闭音乐");
		closemusic.setBounds(600, 400, 120, 30);
		closemusic.setForeground(Color.blue);
		panel.add(closemusic);
		
		
		delete.addActionListener(this);
		update.addActionListener(this);
		find.addActionListener(this);
		add.addActionListener(this);
		closemusic.addActionListener(this);
		add(panel);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Birthday();
	}
	//读取文件，放入数组中，以便于后面的操作
	public void readfile(){
		//判断生日
		int mouth = new Date().getMonth()+1;
		int day = new Date().getDate();
		try {
			File file = new File("friend.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String birthday[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				birthday = str.split(";");
			}
			value = new String[birthday.length][6];
			for(int i=0;i<birthday.length;i++){
				try {
					value[i]=birthday[i].split(",");
					data[i]=birthday[i].split(",");
					String friend = data[i][2];
					int friendmongth = Integer.parseInt(friend.substring(5, 7));
					int friendday = Integer.parseInt(friend.substring(8, 10));
					if(friendmongth==mouth && friendday==day){
						sound = new Sound();
						JOptionPane.showMessageDialog(this, "你的好友"+data[i][0]+"今天生日","好友生日提醒\nHappy Birthday!",JOptionPane.WARNING_MESSAGE);
					}
					System.out.println(friendmongth+";"+friendday);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "系统繁忙，请稍后在试");
					return;
				}
			}
			br.close();
			file=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//事件处理
	public void actionPerformed(ActionEvent e) {
		//查找好友
		if(e.getSource()==find){
			String nameid = name.getText();
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][0].equals(nameid)){
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示");
						return;
					}else if (value[i][1].equals(birthday.getText())) {
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示");
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "无此人");
			return;
			//新增好友
		}else if(e.getSource()==add){
			if(name.getText().equals("")){
				JOptionPane.showMessageDialog(this, "姓名为空！");
				return;
			}else if (birthday.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "生日不能为空！");
				return;
			}else if (hobit.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "爱好不能为空！");
				return;
			}else if (phone.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "联系方式不能为空！");
				return;
			}else if (xinge.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "性格不能为空！");
				return;
			}else if (birthday.getText().length()!=10) {
				JOptionPane.showMessageDialog(this, "生日格式错误，如：1997-12-20！");
				return;
			}
			File file = new File("friend.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				String sex="";
				if(man.isSelected()){
					sex="男";
				}else {
					sex="女";
				}
				String string = name.getText()+","+sex+","+birthday.getText()+","+hobit.getText()+","+phone.getText()+","+xinge.getText()+";";
				byte b[]=string.getBytes();
				if(temp[5]==null || temp[5].equals("")){
					temp[5]="新增";
				}
				if(temp[5].equals("修改")){
					try {
						String username = name.getText();
						for(int i=0;i<value.length;i++){
							for(int j=0;j<value[i].length;j++){
								if(value[i][0].equals(username)){
									table.setValueAt(username, row, 0);
									table.setValueAt(birthday.getText(), row, 1);
									table.setValueAt(sex, row, 2);
									table.setValueAt(hobit.getText(), row, 3);
									table.setValueAt(phone.getText(), row, 4);
									value[i][0]=name.getText();
									value[i][1]=birthday.getText();
									value[i][2]=sex;
									value[i][3]=hobit.getText();
									value[i][4]=phone.getText();
									row++;
									break;
								}
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "系统繁忙");
					}
					
				}
				if(temp[5].equals("新增")){
					fos.write(b, 0, b.length);
					dispose();
					new Birthday();
					fos.close();
				}else {
					String valueString="";
 					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(j==value[i].length-1){
								valueString+=value[i][j]+";";
							}else {
								valueString+=value[i][j]+",";
							}
						}
					}
					File file1 = new File("friend.txt");
					try {
						FileOutputStream fos1 = new FileOutputStream(file1);
						byte b1[]=valueString.getBytes();
						fos1.write(b1, 0, b1.length);
						dispose();
						new Birthday();
						fos1.close();
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			//更新好友
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要修改的好友");
				return;
			}
			name.setText(data[index][0]);
			if(data[index][1].equals("男")){
				man.setSelected(true);
			}else {
				weman.setSelected(true);
			}
			birthday.setText(data[index][2]);
			hobit.setText(data[index][3]);
			phone.setText(data[index][4]);
			xinge.setText(data[index][5]);
			temp[0]=data[index][0];
			temp[1]=data[index][1];
			temp[2]=data[index][2];
			temp[3]=data[index][3];
			temp[4]=data[index][4];
			temp[5]="修改";
			//删除好友
		}else if (e.getSource()==delete) {
			int index=table.getSelectedRow();
			String string = "";
			try {
				for(int i=0;i<value.length;i++){
					for(int j=0;j<value[i].length;j++){
						if(value[i][0].equals(data[index][0])){
							value[i][0].replace(data[index][0], "");
							value[i][1].replace(data[index][1], "");
							value[i][2].replace(data[index][2], "");
							value[i][3].replace(data[index][3], "");
							value[i][4].replace(data[index][4], "");
							value[i][5].replace(data[index][5]+";","");
							table.setValueAt("", index, 0);
							table.setValueAt("", index, 1);
							table.setValueAt("", index, 2);
							table.setValueAt("", index, 3);
							table.setValueAt("", index, 4);
							table.setValueAt("", index, 5);
							row++;
							continue;
						}
					}
				}
				for(int i=0;i<value.length;i++){
					for(int j=0;j<value[i].length;j++){
						if(i!=index){
							if(j==value[i].length-1){
								string+=value[i][j]+";";
							}else {
								string+=value[i][j]+",";
							}
						}
					}
				}
				File file = new File("friend.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					System.out.println("string="+string);
					byte b[]=string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					fos.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "系统繁忙！");
			}
			new Birthday();
			//开关音乐
		}else if (e.getSource()==closemusic) {
			String title = closemusic.getText();
			if(title.equals("关闭音乐")){
				if(sound.isplay()){
					//停止播放音乐
					sound.mystop();
				}
				//设置按钮标题
				closemusic.setText("打开音乐");
			}else{
				closemusic.setText("关闭音乐");
				//播放音乐
				sound.loadSound();
			}
		}
	}
	//播放背景音乐
	class Sound {
		String path = new String("musics\\");
		//默认背景音乐
		String file = new String("生日快乐.mid");
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

}
