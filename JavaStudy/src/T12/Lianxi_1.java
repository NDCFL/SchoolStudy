package T12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Lianxi_1 {

	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("F:\\美句1.txt"),true));
			String str = "";
			System.out.println("请输入你要保存的数据");
			Scanner input = new Scanner(System.in);
			str=input.next();
			bw.write(str);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("保存完毕");
	}
}
