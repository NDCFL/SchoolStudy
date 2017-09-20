package T12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputStreamDemo {

	public static void main(String[] args) {
		File file = new File("F:\\file.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			byte b[]="用我霓裳羽衣换你一世执念，许你三生爱意青丝白发；".getBytes();
			fos.write(b, 0, b.length);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fos1 = new FileInputStream("F:\\file.txt");
			byte b[] = new byte[1024];
			int n =0 ;
			String string=" ";
			while ((n=fos1.read(b, 0, b.length))!=-1) {
				string+=new String(b,0,n);
			}
			System.out.println(string);
			fos1.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
