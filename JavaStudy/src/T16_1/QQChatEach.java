package T16_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QQChatEach extends JFrame implements ActionListener,KeyListener{

	JLabel bendi,duifang,duifangarea;
	JButton lianjie,close,send;
	JTextField tbendi,jduifangarea,tduifang;
	JTextArea jsend,jjieshou;
	JPanel top,center,down;
	JButton sendfile;
	public QQChatEach() {
		super("QQ聊天");
		FrameDemo();
		
		setSize(600, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void FrameDemo(){
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/qt.png");
		setIconImage(image);
		//流布局
		top = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bendi = new JLabel("本地端口");
		duifang = new JLabel("对方端口");
		duifangarea = new JLabel("对方IP地址");
		tbendi = new JTextField("6666",6);
		tduifang = new JTextField("8888",6);
		jduifangarea = new JTextField("127.0.0.1",10);
		Icon image1 = new ImageIcon("images/41.gif");
		lianjie = new JButton("连接(L)",image1);
		lianjie.setMnemonic('L');
		top.add(bendi);
		top.add(tbendi);
		top.add(duifangarea);
		top.add(jduifangarea);
		top.add(duifang);
		top.add(tduifang);
		top.add(lianjie);
		top.setBackground(Color.LIGHT_GRAY);
		center = new JPanel(new GridLayout(2,1,10,10));
		jsend = new JTextArea();
		jsend.setBorder(BorderFactory.createLineBorder(Color.gray));
		jsend.setBorder(BorderFactory.createLoweredBevelBorder());
		
		jjieshou = new JTextArea();
		JScrollPane js = new JScrollPane(jjieshou);
		jjieshou.setBorder(BorderFactory.createLoweredBevelBorder());
		jjieshou.setBorder(BorderFactory.createLineBorder(Color.green));
		//jjieshou.setEditable(false);
		center.add(js);
		center.add(jsend);
		center.setBackground(Color.cyan);
		down = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		close = new JButton("关闭(S)",image1);
		close.setMnemonic('S');
		send = new JButton("发送(F)",image1);
		send.setMnemonic('F');
		sendfile = new JButton("发送文件");
		
		//监听
		lianjie.addActionListener(this);
		close.addActionListener(this);
		send.addActionListener(this);
		send.setEnabled(false);
		jsend.addKeyListener(this);
		sendfile.addActionListener(this);
		down.add(send);
		down.add(close);
		down.add(sendfile);
		down.setBackground(Color.gray);
		add(top,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		add(down,BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		new QQChatEach();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==lianjie) {
			if (!tbendi.getText().trim().equals(tduifang.getText().trim())) {
				JOptionPane.showMessageDialog(this, "连接成功");
			}else {
				JOptionPane.showMessageDialog(this, "端口出现异常！！");
				return;
			}
			tbendi.setEditable(false);
			tduifang.setEditable(false);
			jduifangarea.setEditable(false);
			send.setEnabled(true);
			lianjie.setEnabled(false);
			new threa().start();
		}else if (e.getSource()==send) {
			csend();
		}else if (e.getSource()==close) {
			System.exit(0);
		}else if(e.getSource()==sendfile){//发送文件
			//弹出文件选择框 
			FileDialog fd=new FileDialog(QQChatEach.this,"请选择文件",FileDialog.LOAD);
			fd.show();
			//获取文件的路径和名称
			String filename=fd.getDirectory()+"\\"+fd.getFile();
			//构建文件对象
			File file=new File(filename);
			
			if(file.length()>1024*64){
				JOptionPane.showMessageDialog(null, "文件大小不能超过64K");
				return ;
			}
			try {
				byte[] b=new byte[(int)file.length()]; 
				//用输入流读取文件
				FileInputStream fi=new FileInputStream(file);
				//读取文件在字节数组中
				fi.read(b);
				//关闭输入流
				fi.close();
				//发送文件通知
				QQChatEach msg=new QQChatEach();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
		
		

		}
	}
	public void csend(){
		if (jsend.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "消息为空，无法发送！请输入信息！！");
			return;
		}
		String str = jsend.getText().trim();
		String s=jjieshou.getText().trim()+"\n";
		s+=new Date().toLocaleString()+"\n";
		s+=str+"\n";
		jjieshou.setText(s);
		
		try {
			InetAddress ip = InetAddress.getByName(jduifangarea.getText().trim());
			int port = Integer.parseInt(tduifang.getText().trim());
			byte b[] = str.getBytes();
			DatagramPacket dp = new DatagramPacket(b,b.length,ip,port);
			DatagramSocket ds = new DatagramSocket();
			ds.send(dp);
			jsend.setText("");
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (SocketException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}
	class threa extends Thread{
		//数据报连接
		DatagramSocket socket;
		public threa() {
			try {
				//端口
				int port = Integer.parseInt(tbendi.getText().trim());
				socket = new DatagramSocket(port);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			while (true) {
				byte b[] = new byte[1024];
				try {
					//数据报传输数据
					DatagramPacket dp = new DatagramPacket(b,b.length);
					socket.receive(dp);
					String str = new String(b,0,dp.getLength());
					String s = jjieshou.getText();
					s+=new Date().toLocaleString()+"\n";
					s+=str+"\n";
					jjieshou.setText(s);
					jjieshou.setForeground(Color.blue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==10) {
			csend();
		}
	}
	public void keyReleased(KeyEvent e) {
		
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
}
