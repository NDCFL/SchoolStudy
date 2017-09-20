package Loopyuju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketcon extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		socketcon atc = new socketcon();
		new Thread(atc,"客户端一").start();
		new Thread(atc,"客户端二").start();
			

	}
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				try {
					Socket st = new Socket("127.0.0.1",8000);
					System.out.println("连接成功！！！");
					System.out.println(Thread.currentThread().getName()+"启动了");
					//绑定输入流
					BufferedReader br = new BufferedReader(new InputStreamReader(st.getInputStream()));
					//绑定输出流
					OutputStream os = st.getOutputStream();
					PrintStream ps = new PrintStream(os);
					ps.println("你也好呀！！服务器端");
					System.out.println("服务器发来信息："+br.readLine());
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
