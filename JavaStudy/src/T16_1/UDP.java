package T16_1;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class UDP extends JFrame implements ActionListener,MouseListener{

	JLabel bg,exit,send,close,bendi,duifang,duifangarea,lianjie;
	JTextPane txtread,txtwrite;
	JTextField tbendi,jduifangarea,tduifang;
	public UDP(){
		super("聊天系统");
		setUndecorated(true);
		bg = new JLabel(new ImageIcon("image/chat.png"));
		//绝对布局
		bg.setLayout(null);
		add(bg);
		
		exit = new JLabel("✘");
		exit.setBounds(570, 0, 20, 20);
		bg.add(exit);
		
		send = new JLabel("        ");
		send.setBounds(355, 508, 80, 20);
		bg.add(send);
		
		close = new JLabel("         ");
		
		close.setBounds(285, 508, 60, 20);
		bg.add(close);
		
		txtread = new JTextPane();
		JScrollPane js = new JScrollPane(txtread);
		js.setBounds(0, 83,447, 318);
		js.setBorder(null);
		txtread.setEnabled(false);
		bg.add(js);
		
		
		txtwrite = new JTextPane();
		JScrollPane jss = new JScrollPane(txtwrite);
		jss.setBounds(0,428,447,75);
		jss.setBorder(null);
		bg.add(jss);
		
		bendi = new JLabel("本端");
		bendi.setBounds(0, 400, 30, 30);
		bg.add(bendi);
		
		tbendi = new JTextField("6666",6);
		tbendi.setBounds(30, 407, 60, 20);
		bg.add(tbendi);
		
		duifang = new JLabel("对端");
		duifang.setBounds(100, 400, 30, 30);
		bg.add(duifang);
		
		tduifang = new JTextField("8888",6);
		tduifang.setBounds(130, 407, 60, 20);
		bg.add(tduifang);
		
		duifangarea = new JLabel("对方IP地址");
		duifangarea.setBounds(190, 407, 100, 20);
		bg.add(duifangarea);
		
		jduifangarea = new JTextField("127.0.0.1",10);
		jduifangarea.setBounds(260, 407, 100, 20);
		bg.add(jduifangarea);
		
		Icon image1 = new ImageIcon("images/41.gif");
		lianjie = new JLabel("连接(L)",image1,0);
		lianjie.setBounds(348, 407, 120, 20);
		bg.add(lianjie);
		
		exit.addMouseListener(this);
		send.addMouseListener(this);
		close.addMouseListener(this);
		lianjie.addMouseListener(this);
		
		setDragable();
		setSize(586,539);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
//设置界面可以拖动的方法
	
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				UDP.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				UDP.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(UDP.this.getLocation().x + e.getX() - tmp.x,
							UDP.this.getLocation().y + e.getY() - tmp.y);
					UDP.this.setLocation(loc);
				}
			}
		});
	}
	public static void main(String[] args) {
		new UDP();
	}
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==exit) {
			System.exit(0);
		}else if (e.getSource()==send) {
			send.setEnabled(false);
			if (txtwrite.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "内容为空无法发送");
			}
			String str = txtwrite.getText().trim();
			String s=txtread.getText().trim()+"\n";
			s+=new Date().toLocaleString()+"\n";
			s+=str+"\n";
			txtread.setText(s);
			
			try {
				InetAddress ip = InetAddress.getByName(jduifangarea.getText().trim());
				int port = Integer.parseInt(tduifang.getText().trim());
				byte b[] = str.getBytes();
				DatagramPacket dp = new DatagramPacket(b,b.length,ip,port);
				DatagramSocket ds = new DatagramSocket();
				ds.send(dp);
				//清空内容
				txtwrite.setText("");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if (e.getSource()==close) {
			System.exit(0);
		}else if (e.getSource()==lianjie) {
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
			new thread().start();
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

	class thread extends Thread{
		
		DatagramSocket ds;
		public thread() {
			//得到端口值
			int port = Integer.parseInt(tbendi.getText().trim());
			try {
				ds = new DatagramSocket(port);
			} catch (SocketException e) {
				
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			while (true) {
				try {
					byte b[] = new byte[1024];
					DatagramPacket dp = new DatagramPacket(b,b.length);
					ds.receive(dp);
					//读取字符，从0开始读取，读到数据报的结束
					String str = new String(b,0,dp.getLength());
					String s = txtread.getText();
					s+=new Date().toLocaleString()+"\n";
					s+=str+"\n";
					//显示在显示框中
					txtread.setText(s);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
	}
	
}
