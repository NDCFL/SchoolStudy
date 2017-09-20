package T11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Text {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File file = new File("f:\\pass.txt");
		FileReader fr = new FileReader(file);
		int n=0;
		char ch[] = new char[5];
		while ((n=fr.read(ch, 0, 5))!=-1) {
			for (int i = 0; i < ch.length; i++) {
				ch[i] = (char)(ch[i]^'a');
			}
			String s = new String(ch,0,n);
			System.out.println(s);
		}

	}

}
