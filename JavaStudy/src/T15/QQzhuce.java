package T15;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class QQzhuce extends JFrame{
	JPanel p1;
	JLabel bjimage,jsm;
	JLabel title,id,pass,name,email,sex,age,qrpass;
	JTextField idField,nameField,emaiField,ageField;
	JPasswordField passwordField,quepass;
	JButton ok,quxiao;
	JRadioButton man,weman;
	ButtonGroup btsex;
	JTextArea shuoming;
	public QQzhuce(){
		super("QQ注册");
		new Sound();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/qt.png");
		setIconImage(image);
		kongjian();
		setSize(280, 500);
		ActionHandle a = new ActionHandle();
		ok.addActionListener(a);
		quxiao.addActionListener(a);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new QQzhuce();
	}
	public void kongjian(){
		p1 = new JPanel(null);
		title = new JLabel("QQ注册窗体",JLabel.CENTER);
		title.setBounds(80, 15, 100, 30);
		title.setFont(new Font("黑体",Font.BOLD,18));
		title.setForeground(Color.blue);
		p1.add(title);
		name = new JLabel("昵 称：",JLabel.LEFT);
		name.setFont(new Font("黑体",Font.BOLD,14));
		name.setForeground(Color.blue);
		name.setBounds(20, 65, 60, 30);
		p1.add(name);
		nameField = new JTextField();
		nameField.setBounds(90, 65, 150, 30);
		p1.add(nameField);
		id = new JLabel("账 号：",JLabel.LEFT);
		id.setFont(new Font("黑体",Font.BOLD,14));
		id.setForeground(Color.blue);
		id.setBounds(20, 105, 60, 30);
		p1.add(id);
		idField = new JTextField();
		idField.setBounds(90, 105, 150, 30);
		p1.add(idField);
		pass = new JLabel("密 码：",JLabel.LEFT);
		pass.setFont(new Font("黑体",Font.BOLD,14));
		pass.setForeground(Color.blue);
		pass.setBounds(20, 145, 140, 30);
		p1.add(pass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 150, 150, 30);
		p1.add(passwordField);
		sex = new JLabel("性 别：",JLabel.LEFT);
		sex.setFont(new Font("黑体",Font.BOLD,14));
		sex.setForeground(Color.blue);
		sex.setBounds(20, 185, 60, 30);
		man = new JRadioButton("男");
		man.setFont(new Font("黑体",Font.BOLD,14));
		man.setForeground(Color.blue);
		man.setSelected(true);
		man.setBounds(90, 189, 65, 20);
		weman = new JRadioButton("女");
		weman.setFont(new Font("黑体",Font.BOLD,14));
		weman.setForeground(Color.blue);
		weman.setBounds(160, 189, 65, 20);
		btsex = new ButtonGroup();
		btsex.add(man);
		btsex.add(weman);
		p1.add(man);
		p1.add(weman);
		p1.add(sex);
		
		age = new JLabel("年 龄：",JLabel.LEFT);
		age.setFont(new Font("黑体",Font.BOLD,14));
		age.setForeground(Color.blue);
		age.setBounds(20, 220, 60, 30);
		p1.add(age);
		
		ageField = new JTextField();
		ageField.setBounds(90, 225, 150, 30);
		p1.add(ageField);
		
		email = new JLabel("email：",JLabel.LEFT);
		email.setFont(new Font("黑体",Font.BOLD,14));
		email.setForeground(Color.blue);
		email.setBounds(20, 265, 60, 30);
		p1.add(email);
		
		emaiField = new JTextField();
		emaiField.setBounds(90, 265, 150, 30);
		p1.add(emaiField);
		
		jsm = new JLabel("签 名：");
		jsm.setFont(new Font("黑体",Font.BOLD,14));
		jsm.setForeground(Color.blue);
		jsm.setBounds(20, 320, 60, 30);
		p1.add(jsm);
		
		
		shuoming = new JTextArea(4,5);
		JScrollPane js = new JScrollPane(shuoming);
		js.setBounds(90, 305, 150, 60);
		p1.add(js);
		ok = new JButton("确定");
		ok.setFont(new Font("黑体",Font.BOLD,14));
		ok.setForeground(Color.blue);
		ok.setBounds(40, 396, 80, 30);
		quxiao = new JButton("取消");
		quxiao.setFont(new Font("黑体",Font.BOLD,14));
		quxiao.setForeground(Color.blue);
		quxiao.setBounds(130, 396, 80, 30);
		p1.add(ok);
		p1.add(quxiao);
		add(p1);
		
	}
	public void look(){
		String str = "select * from QQcard";
		Connection conn = new DBdemo().DB();
		Statement sta;
		try {
			sta = conn.createStatement();
			ResultSet re = sta.executeQuery(str);
			while (re.next()) {
				System.out.println(re.getString(1)+"\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getString(4)+"\t"+re.getString(5)+"\t"+re.getString(6)+"\t"+re.getString(7)+"\t"+re.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
//	public void lianjie2(){
//		
//		try {
//			String SQL="insert into QQcard values(";
//			SQL+="'"+nameField.getText()+"',";
//			SQL+="'"+idField.getText()+"',";
//			SQL+="'"+passwordField.getText()+"',";
//			SQL+="'"+btsex.getButtonCount()+"',";
//			SQL+="'"+emaiField.getText()+"',";
//			SQL+="'"+telField.getText()+"',";
//			SQL+="'"+shuoming.getText()+"')";
//			System.out.println(SQL);
//			Connection conn = new DBdemo().DB();
//			Statement sta = conn.createStatement();
//			int sql = sta.executeUpdate(SQL);
//			System.out.println(sql);
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public void lianjie(){
		
		try {
			int n=1;
			Connection conn = new DBdemo().DB();
			String SQL = "insert into QQcard values(?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(n++, nameField.getText());
			ps.setString(n++, idField.getText());
			ps.setString(n++, passwordField.getText());
			ps.setLong(n++, btsex.getButtonCount());
			ps.setString(n++, ageField.getText());
			ps.setString(n++, emaiField.getText());
			ps.setString(n++, shuoming.getText());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this, "注册成功");
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void beijin(){
		Icon icon = new ImageIcon("image/42.gif");
		bjimage = new JLabel(icon);
		add(bjimage);
	}
	class ActionHandle implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==ok) {
				
				if(idField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "账号不能为空");
					
					idField.requestFocus();
					return;
				}
				if (idField.getText().equals("275300091")) {
					JOptionPane.showMessageDialog(null, "该号码已被占用");
					id.requestFocus();
					return;
				}
				if (passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					passwordField.requestFocus();
					return;
				}
				if (emaiField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "email不能为空");
					emaiField.requestFocus();
					return;
				}
				if (ageField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "号码不能为空");
					ageField.requestFocus();
					return;
				}
				if (idField.getText().length()>10) {
					JOptionPane.showMessageDialog(null, "账号为10位以内数");
					idField.requestFocus();
					return;
				}
				lianjie();
				look();
				JOptionPane.showMessageDialog(null, "账号为："+idField.getText()+"\nemail为："+emaiField.getText()+"\n年龄为："+ageField.getText()+"\n个人说明为："+shuoming.getText());
				
			}else if (e.getSource()==quxiao) {
				System.exit(0);
			}
		}
		
	}
}
//播放背景音乐
class Sound {
	
	String path = new String("musics\\");

	//默认背景音乐
	String file = new String("qin.mid");

	
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

