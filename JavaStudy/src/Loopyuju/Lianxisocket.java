package Loopyuju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Lianxisocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//创建socket连接服务器端，传入端口和IP地址
			Socket socket = new Socket("127.0.0.1",8000);
			//验证是否成功连接
			System.out.println("太好了连接成功！！");
			//绑定输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//绑定输入流
			PrintStream ps = new PrintStream(socket.getOutputStream());
			//发送信息到服务器端
			ps.println("hello!晚上好呀！");
			//接收服务器端的信息
			System.out.println("服务器端来消息："+br.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
