package T11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class PassWorld {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		char c[] = "下午吃饭吗?".toCharArray();
		int n = 0;
		for (int i = 0; i < c.length; i++) {
			c[i] = (char) (c[i] ^ 'a');
		}
		File file = new File("f:\\pass.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		fw.write(c);
		fw.flush();
		System.out.println("密文保存成功！");
		fw.close();
		FileReader fr = new FileReader(file);
		System.out.println("密文内容为：");
		char ch[] = new char[6];
		while ((n = fr.read(ch, 0, 6)) != -1) {
			String string = new String(c, 0, n);
			System.out.println(string);
		}
		fr.close();
		fr= new FileReader(file);
		System.out.println("");
		System.out.println("明文");
		while ((n = fr.read(ch, 0, 6)) != -1) {
			for (int i = 0; i < n; i++) {
				ch[i] = (char) (ch[i] ^ 'a');
			}
			String str = new String(ch, 0, n);
			System.out.println(str);
		}
		fr.close();

	}

}
