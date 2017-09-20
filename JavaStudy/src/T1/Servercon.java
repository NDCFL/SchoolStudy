package T1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servercon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(8000);
			//等待连接
			Socket socket=ss.accept();
			//绑定输入输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("嘿！客户端");//发送数据
			System.out.println("客户端来消息："+br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
