package T12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {

	public static void main(String[] args) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("F:\\美句1.txt"),true));
			byte b [] = "今天我很忙！".getBytes();
			dos.write(b, 0, b.length);
			System.out.println("保存成功！");
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
