package Loopyuju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Lianxi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			//创建tcp服务端连接，并且加入端口
			ServerSocket ssk = new ServerSocket(8000);
			//验证是否成功连接
			System.out.println("太开心了！服务器连接成功！！");
			//创建socket等待客户端连接
			Socket socket = ssk.accept();
			//判断是否有客户端来来连接
			System.out.println("有客户端来了！！");
			//绑定输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//绑定输出流
			PrintStream ps = new PrintStream(socket.getOutputStream());
			//向客户端发送信息
			ps.println("客户端你好呀！！");
			//接收客户端信息并读取到界面上
			System.out.println("客户端发来信息："+br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
