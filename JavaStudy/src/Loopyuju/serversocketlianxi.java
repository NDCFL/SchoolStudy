package Loopyuju;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class serversocketlianxi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8000);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("晚上好呀！你在干嘛呢？");
			System.out.println("服务器端发来信息："+br.readLine());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

}
