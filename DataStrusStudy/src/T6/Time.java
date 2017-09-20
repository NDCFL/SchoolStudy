package T6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Time extends JFrame implements Runnable,ActionListener{
	
	JLabel lbtime,lbtitle,lbweek,time;
	JPanel panel;
	JTextField txttime;
	JButton jbok;
	Date lasttime;
    @SuppressWarnings("deprecation")
	public Time() {
        super("电子时钟");
        
        panel = new JPanel(null);
        
        lbtitle = new JLabel("电子时钟");
        lbtitle.setBounds(40, 30, 100, 30);
        lbtitle.setFont(new Font("楷体",Font.BOLD,24));
        lbtitle.setForeground(Color.blue);
        panel.add(lbtitle);
        
        if(new Date().getDay()==0){
        	lbtime = new JLabel(new Date().toLocaleString()+"   星期天");
        	lbtime.setForeground(Color.blue);
        }else {
        	lbtime = new JLabel(new Date().toLocaleString()+"   星期"+new Date().getDay());
        	lbtime.setForeground(Color.blue);
        }
        lbtime.setBounds(20, 80, 180, 30);
        panel.add(lbtime);
        
        time = new JLabel("闹钟时间");
        time.setBounds(20, 120, 180, 30);
        time.setForeground(Color.red);
        panel.add(time);
       
        jbok = new JButton("设定闹钟");
        jbok.setBounds(40, 160, 120, 30);
        jbok.setForeground(Color.BLUE);
        panel.add(jbok);
        System.out.println(lbtime.getText().substring(0,19));
        add(panel);
        if(lbtime.getText().substring(0,19).equals(lasttime)){
        	Sound sound = new Sound();
        }
        jbok.addActionListener(this);
        this.setSize(200, 260);
        new Thread(this).start();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		
		new Time();
	}
	public void run() {
		while (true) {
			if(new Date().getDay()==0){
				lbtime.setText(new Date().toLocaleString()+"  星期天");
				lbtime.setForeground(Color.blue);
			}else {
				lbtime.setText(new Date().toLocaleString()+"  星期"+new Date().getDay());
				lbtime.setForeground(Color.blue);
			}
			if(lasttime!=null){
				if(lbtime.getText().substring(0,18).equals(lasttime.toLocaleString())){
					Sound sound = new Sound();
				}	
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(e.getSource()==jbok){
			String time1 = JOptionPane.showInputDialog("请输入提醒时间，如：1997-12-20 18:00:00 24小时制");
			time.setText(time1);
			if(time.equals("")){
				JOptionPane.showMessageDialog(null, "时间不能为空!");
				return;
			}else {
				if(time1.length()!=19){
					JOptionPane.showMessageDialog(null, "你输入的格式有误，如：1997-12-20 18:00:00；24小时制");
					return;
				}else {
					try {
						lasttime= formatter.parse(time1);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					System.out.println(lasttime.toLocaleString());
				}
				JOptionPane.showMessageDialog(null, "闹钟设定成功！闹钟到时会有铃声响起！");
			}
		}
		
	}
	//播放背景音乐
	class Sound {
		String path = new String("music\\");
		//默认背景音乐
		String file = new String("606.mid");
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

