package T6;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Random;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

//在窗口中加入控件
public class Frame_2 extends JFrame implements MouseListener, ActionListener {

	// 声明的成员变量

	JLabel bg, close, music,youxi;
	JMenuItem open,clo;
	JPopupMenu pop;
	Sound4 sound4;
	public Frame_2() {
		this.setTitle("控件");

		setUndecorated(true);
		bg = new JLabel(new ImageIcon("image/qqmain1.png"));
		bg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(bg);

		close = new JLabel("关闭");
		close.setBounds(250, 5, 30, 30);
		bg.add(close);

		music = new JLabel(" ");
		music.setBounds(64, 615, 30, 30);
		bg.add(music);

		close.addMouseListener(this);
		music.addMouseListener(this);
		
		pop = new JPopupMenu();
		
		open = new JMenuItem("音乐开");
		clo = new JMenuItem("音乐关");
		
		pop.add(open);
		pop.add(clo);
		
		youxi=new JLabel("又");
		youxi.setBounds(38, 615, 30, 30);
		bg.add(youxi);
		
		open.addActionListener(this);
		clo.addActionListener(this);
		youxi.addMouseListener(this);
		setSize(281, 671);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Frame_2();
	}

	public void mouseClicked(MouseEvent e) {
//		sound4 = new Sound4();
		if (e.getSource() == close) {
			System.exit(0);
		}else if (e.getSource()==music) {
			if (e.getButton()==3) {
				pop.show(this, 64, 615);
			}
			
		}else if (e.getSource()==youxi) {
			new ShaoRei();
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==open) {
			sound4 = new Sound4();
		}else if(e.getSource()==clo){
			if(sound4.isplay()){
				sound4.mystop();
			}
		}

	}
}

// 播放背景音乐
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

	// 播放背景音乐的函数
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
