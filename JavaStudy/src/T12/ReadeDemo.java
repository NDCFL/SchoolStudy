
package T12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ReadeDemo {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("F:\\file.txt")));
			String string = "";
			while ((string=br.readLine())!=null) {
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
