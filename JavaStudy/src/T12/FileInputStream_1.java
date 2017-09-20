package T12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_1 {

	public static void main(String[] args) {
		try {
			File file = new File("f:\\file.txt");
			FileInputStream fis = new FileInputStream(file);
			byte b[]=new byte[1024];
			@SuppressWarnings("unused")
			int n = 0;
			String str = "";
			while ((n=fis.read(b, 0, b.length))!=-1) {
				str+=new String(b,0,n);
			}
			System.out.println(str);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
