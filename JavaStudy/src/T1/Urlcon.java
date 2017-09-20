package T1;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Urlcon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.jxau.edu.cn/");
			URLConnection con = url.openConnection();
			FileOutputStream file = new FileOutputStream("f:\\nd.heml");
			BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
			int n=0;
			byte b[] = new byte[1024];
			while ((n=bis.read(b))!=-1) {
				//写入文件
				file.write(b,0,n);
				System.out.println(new String(b,0,n));
			}
			System.out.println("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
