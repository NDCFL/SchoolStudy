package T16_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * UDP通信的聊天软件
 * 
 * */
public class UDPChat extends JFrame implements ActionListener{

	//私有的串有化变量
	private transient JLabel lblPort,lblAddr,lblPort2;
	private  transient JTextField txtPort,txtAddr,txtPort2;
	private  transient JButton btnConn,btnSend,btnClose;
	private transient JEditorPane txtReceive,txtSend;
	public UDPChat() {
		super("UDP通信的聊天软件");
		
		lblPort = new JLabel("本机端口：",JLabel.RIGHT);
		lblPort2 = new JLabel("对方端口：",JLabel.RIGHT);
		lblAddr = new JLabel("对方地址：",JLabel.RIGHT);
		txtPort = new JTextField("8888",5);
		txtPort2 = new JTextField("9999",5);
		InetAddress ipaddr =null;
		try {
			ipaddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		txtAddr = new JTextField(ipaddr.getHostAddress(),10);
		btnConn = new JButton("连接(C))");
		btnConn.setMnemonic('C');
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(lblPort);
		topPanel.add(txtPort);
		topPanel.add(lblAddr);
		topPanel.add(txtAddr);
		topPanel.add(lblPort2);
		topPanel.add(txtPort2);
		topPanel.add(btnConn);
		txtReceive = new JEditorPane();
		txtSend = new JEditorPane();
		JPanel centerPanel = new JPanel(new GridLayout(2,1,5,10));
		centerPanel.add(txtReceive);
		txtReceive.setBorder(BorderFactory.createLoweredBevelBorder());
		//接收框不能编辑
		txtReceive.setEditable(false);
		
		txtSend.setBorder(BorderFactory.createLoweredBevelBorder());
		centerPanel.add(txtSend);
		btnSend = new JButton("发送(S)");
		btnSend.setMnemonic('S');
		btnClose = new JButton("退出(X)");
		btnClose.setMnemonic('X');
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.add(btnSend);
		bottomPanel.add(btnClose);
		add(topPanel,BorderLayout.NORTH);
//		centerPanel.setBackground(Color.RED);
		add(centerPanel,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
		
		btnConn.addActionListener(this);
		btnSend.addActionListener(this);
		btnClose.addActionListener(this);
		//发送按钮禁用
		btnSend.setEnabled(false);
		setSize(600, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//创建内部类，实现接收线程
	class ReceiveThread extends Thread{
		//数据报（UDP）连接函数
		DatagramSocket socket;
		public ReceiveThread() {
			try{
				int port = Integer.parseInt(txtPort.getText().trim());
				socket = new DatagramSocket(port);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			byte[] b = new byte[1024];
			//数据报接收数据，实例化并进行传值，联通输入输出流
			DatagramPacket packet = new DatagramPacket(b,b.length);
			while(true){
				try {
					 
					//接收数据，数据来自于数据报中
					socket.receive(packet);
					//转换为字符串
					String str = new String(b,0,packet.getLength());
					//显示在接收框
					String content = txtReceive.getText();
					content += new Date().toLocaleString()+"\n";
					content += str+"\n";
					//显示内容到显示框中
					txtReceive.setText(content);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new UDPChat();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConn){
			btnConn.setEnabled(false);
			btnSend.setEnabled(true);
			//启动线程，立马会执行连接服务，进行模拟聊天
			new ReceiveThread().start();
		}else if(e.getSource()==btnSend){
			//发送内容
			String str = txtSend.getText().trim();
			if(str.equals("")){
				JOptionPane.showMessageDialog(this, "请输入要发送的内容");
				return;
			}
			//把要发送的内容显示到接收框
			String content = txtReceive.getText();
			content += new Date().toLocaleString()+"\n";
			content += str+"\n";
			txtReceive.setText(content);
			try {
				//设置对方IP地址
				InetAddress ip = InetAddress.getByName(txtAddr.getText().trim());
				//设置对方的端口
				int port = Integer.parseInt(txtPort2.getText().trim());
				//创建发送包
				byte b[] = str.getBytes();
				DatagramPacket p = new DatagramPacket(b,b.length,ip,port);
				//创建DatagramSocket发送
				DatagramSocket socket = new DatagramSocket();
				//发送
				socket.send(p);
				//清空发送框的内容
				txtSend.setText("");
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (SocketException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			
			
			
		}else if(e.getSource()==btnClose){
			System.exit(0);
		}
		
	}
}
