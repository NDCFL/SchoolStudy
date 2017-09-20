package T12;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class DateInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(new File("F:\\美句1.txt")));
			byte b [] = new byte[1024];
			int n=0;
			while ((n=dis.read(b, 0, b.length))!=-1) {
				String string = new String(b, 0, n);
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


