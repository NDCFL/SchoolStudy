package T12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Passwors {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){
		char c[]="晚上早点睡".toCharArray();
		int n=0;
		File file = new File("F:\\file\\pass.txt");
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)(c[i]^'a');
		}
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(c, 0, c.length);
			fw.close();
			FileReader fr = new FileReader(file);
			char ch[] = new char[10];
			System.out.println("密文");
			while ((n=fr.read(ch, 0, ch.length))!=-1) {
				String str = new String(ch, 0, n);
				System.out.println(str);
			}
			//fr.close();
			FileReader f = new FileReader(file);
			System.out.println("明文");
			while ((n=f.read(ch, 0, ch.length))!=-1) {
				for (int i = 0; i < ch.length; i++) {
					ch[i] = (char)(ch[i]^'a');
				}
				String str1 = new String(ch, 0, n);
				System.out.println(str1);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

}
