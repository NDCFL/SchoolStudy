package T16;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo1 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://static1.51cto.com/edu/css/gen_top.css");
			URLConnection un = url.openConnection();
			InputStream in = un.getInputStream();
			FileOutputStream file = new FileOutputStream("f:\\gen_top.css");
			BufferedInputStream bf = new BufferedInputStream(in);
			int n=0;
			byte b[] = new byte[2048];
			while ((n=bf.read(b))!=-1) {
				file.write(b, 0, n);
				System.out.println(new String(b,0,n,"utf-8"));
			}
			in.close();
			bf.close();
			System.out.println("保存成功！！！");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
