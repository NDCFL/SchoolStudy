package T12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class WriteDemo {

	public static void main(String[] args) {
		
		try {
			File file = new File("F:\\file.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			String string = "";
			System.out.println("请输入数据");
			Scanner in = new Scanner(System.in);
			string=in.next();
			bw.write(string+" ");
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
