package Loopyuju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverlianxi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket ssk = new ServerSocket(8000);
			Socket socket = ssk.accept();
			//绑定输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//绑定输出流
			PrintStream ps = new PrintStream(socket.getOutputStream());
			System.out.println("客户端发来信息给你："+br.readLine());
			ps.println("你好呀！客户端，晚上好呀！");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

}
