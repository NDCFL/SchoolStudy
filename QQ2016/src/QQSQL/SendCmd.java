package QQSQL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Vector;

import javax.swing.text.StyledDocument;

import QQbean.QQidtable;

public class SendCmd {

	public static void send(SendMsg msg){
		try {
			//定义Socket
			DatagramSocket socket = new DatagramSocket();
			//创建一个字节数组输出流
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			//把对象输出到字节数组中
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(msg);
			oos.flush();
			//把要发送的数据转换为字节数组
			byte b[]=bos.toByteArray();
			//获取好友的IP地址
			InetAddress addr = InetAddress.getByName(msg.friendtable.getIpdizhi());
			//获取好友的接收端口
			int port = msg.friendtable.getPort();
			//生成发送报
			DatagramPacket pack = new DatagramPacket(b,0,b.length,addr,port);
			socket.send(pack);//发送
			System.out.println(msg.cmd +"==发送消息,b.size="+b.length);
			socket.close();
			oos.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//广播发送信息
	public  static void sendAll(Vector<QQidtable> allimfmation,QQidtable idtable,int cmd){
		for (QQidtable qidtable : allimfmation) {
			if(!idtable.getZhuangtai().equals(QQminlin.STATUS[1]) && qidtable.getQQid()!=idtable.getQQid()){
				SendMsg msg = new SendMsg();
				msg.cmd = cmd;
				msg.idtable = idtable;
				msg.friendtable = qidtable;
				send(msg);
			}
		}
			
		
	}
	//群聊
	public  static void sendAll(Vector<QQidtable> allInfo,QQidtable idtable,int cmd,StyledDocument doc){
		for (QQidtable acc : allInfo) {
			if(!acc.getZhuangtai().equals(QQminlin.STATUS[1]) && acc.getQQid()!=idtable.getQQid()){
				SendMsg msg = new SendMsg();
				msg.cmd = cmd;
				msg.idtable = idtable;
				msg.friendtable = acc;
				msg.doc = doc;
				send(msg);
			}
		}
		
	}
}
