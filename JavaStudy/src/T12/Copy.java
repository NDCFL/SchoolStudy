package T12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Copy {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("F:\\msg.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("F:\\美文.txt"),true);
		String s = "";
		//一行一行的读取文件
		while ((s=br.readLine())!=null) {
			pw.println(s);
		}
		System.out.println("复制成功！");
   	}
}