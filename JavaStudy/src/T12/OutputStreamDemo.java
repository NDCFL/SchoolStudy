package T12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class OutputStreamDemo {

	public static void main(String[] args) {
		
		try {
			File file = new File("F:\\美句 1.txt");
			if (!file.exists()) {
				//如果文件不存在，则重新建立文件
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			String string="看浮沉往事，今晓多少！";
			byte b[]=string.getBytes();
			fos.write(b, 0, b.length);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//读文件
		File file1 = new File("F:\\美句 1.txt");
		try {
			FileInputStream fis = new FileInputStream(file1);
			byte b [] = new byte[1024];
			int n=fis.read(b);
			System.out.println("文件内容=="+new String(b,0,n));
			System.out.println("文件名："+file1.getName());
			System.out.println("文件大小："+file1.length()+"个字节");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
