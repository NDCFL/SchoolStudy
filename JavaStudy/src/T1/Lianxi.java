package T1;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Lianxi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			URL url = new URL("http://www.jxau.edu.cn/");
			URLConnection con = url.openConnection();
			BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
			FileOutputStream file = new FileOutputStream("f:\\nndd.html");
			int n=0;
			byte b[] = new byte[1024];
			while (( n=bis.read(b, 0, b.length))!=-1) {
				file.write(b, 0, b.length);
				System.out.println(new String(b, 0, b.length));
			}
			System.out.println("保存成功！");
			file.close();
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

}
