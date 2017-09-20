package T16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketLianxi {

	public static void main(String[] args) {
		System.err.println("我是客户类端！！！！");
		try {
			Socket socket = new Socket("127.0.0.1",6000);
			BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("服务端口类说："+br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
