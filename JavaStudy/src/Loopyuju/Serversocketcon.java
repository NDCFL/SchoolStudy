package Loopyuju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serversocketcon extends Thread{
	
	/**
	 * @param args
	 * 2．编写TCP服务器端程序，并且每个连接启动一个单独的线程来处理。
	 */
	public static void main(String[] args) {
		Serversocketcon ss = new Serversocketcon();
		new Thread(ss,"服务器一启动").start();
		new Thread(ss,"服务器二启动").start();
	}
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					ServerSocket ss = new ServerSocket(8000);
					System.out.println(Thread.currentThread().getName()+"连接成功！！");
					Socket socket=ss.accept();//等待连接
					System.out.println("有客户端连接！！！");
					//绑定输入流
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					//绑定输出流
					OutputStream os = socket.getOutputStream();
					PrintStream ps = new PrintStream(os);
					ps.println("你好呀！！客户端");
					System.out.println("客户端发来信息："+br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
			
		}
		
	}
}
