package T1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Socketcon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8000);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("hello！服务器端！");//接收客户端的信息
			System.out.println("服务器端发来信息："+br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
