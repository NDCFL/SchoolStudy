package T16;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class SeverLianxi {

	public static void main(String[] args) {
		System.out.println("我是端口类！！！！！");
		try {
			ServerSocket ss = new ServerSocket(6000);
			Socket socket =ss.accept();
			PrintStream ps = new PrintStream(socket.getOutputStream(),true);
			ps.println(new String("hello word "));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
