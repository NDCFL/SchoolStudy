package edu.ht.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import edu.ht.bean.QQMsg;

public class SendMsg {
	// 发送消息
	public void send(QQMsg msg) {
		// 获取字节输出流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// 转换成对象输出流
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(msg);
			// 将字节流转换成字节数组
			byte[] b = bos.toByteArray();
			DatagramSocket ds = new DatagramSocket();
			// 发送 是 获取好友的IP和端口
			InetAddress add = InetAddress.getByName(msg.getFruser().getIpadd());
			int port = msg.getFruser().getPort();
			DatagramPacket dp = new DatagramPacket(b, 0, b.length, add, port);
			//发送
			ds.send(dp);
			ds.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
