package T1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Datasoccon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte buf[] = {'h', 'e', 'l', 'l', 'o'};
        try {
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(buf, 0, buf.length,InetAddress.getByName("localhost"), 8000);
            ds.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
