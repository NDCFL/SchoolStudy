package T16;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverDemo {

	public static void main(String[] args) {
		System.out.println("我是服务器端");
		try {
			ServerSocket se = new ServerSocket(5000);
			Socket socket = se.accept();
			PrintStream ps = new PrintStream(socket.getOutputStream(),true);
			ps.println(new String("hello word!!!!"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
