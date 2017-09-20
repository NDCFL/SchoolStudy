package T1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Datacon {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(8000);
			byte[] b = new byte[5];
			DatagramPacket dp = new DatagramPacket(b,b.length);
			ds.receive(dp);
			for (int i = 0; i < b.length; i++) {
                System.out.print((char)b[i]);
            }
            System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
