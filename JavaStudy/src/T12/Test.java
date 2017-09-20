package T12;

import java.io.File;
import java.io.FileInputStream;

public class Test {

	public static void main(String[] args) {
		File file = new File("F:\\美句.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			int n=0;
			String str= "";
			char c [] = "isafoaifjoawnfo".toCharArray();
			System.out.println(str);
			System.out.println("共有多大:"+(float)(file.length())/1024+"k");
			System.out.println("共字节数："+file.length()+";字数为"+(file.length())/2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
