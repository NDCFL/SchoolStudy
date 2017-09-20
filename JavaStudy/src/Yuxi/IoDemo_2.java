package Yuxi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IoDemo_2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("f:\\美文.txt")));
			PrintWriter pw = new PrintWriter(new FileOutputStream("f:\\美文3.txt",true),true);
			String str = "";
			try {
				while ((str=br.readLine())!=null){
					pw.println(str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("拷贝成功！！！！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
