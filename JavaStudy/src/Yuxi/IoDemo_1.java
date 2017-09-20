package Yuxi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IoDemo_1 {

	File file = new File("f:\\test.txt");
	public static void main(String[] args) {
		new IoDemo_1().write();
		new IoDemo_1().read();
	}
	public void read(){
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(file));
			System.out.println("文件内容为："+dis.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void write(){
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file,true));
			byte b[] = "\n美句一篇，仅供欣赏！！".getBytes();
			dos.write(b);
			System.out.println("保存成功！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
