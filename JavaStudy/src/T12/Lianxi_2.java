package T12;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Lianxi_2 {

	public static void main(String[] args) {
		try {
			File file = new File("f:\\time.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			//输入数据
			DataInputStream dis = new DataInputStream(new FileInputStream(file));
			//输出数据
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file,true));
			double dou[] = {8.5,8.6,8.9,2.3,1.6,1.9,1.8};
			for (int i = 0; i < dou.length; i++) {
				dos.writeDouble(dou[i]);
			}
			int it[] = {8,6,9,3,1,9,1};
			for (int i = 0; i < it.length; i++) {
				dos.writeDouble(it[i]);
			}
			System.out.println("写入成功");
			
			int n=0;
			for (int i = 0; i < dou.length; i++) {
				dis.readDouble();
				n++;
				System.out.print("Dou = "+ dou[i]+"\t");
				if (i==dou.length-1) {
					System.out.println();
				}
			}
			int t=0;
			for (int i = 0; i < it.length; i++) {
				dis.readDouble();
				t++;
				System.out.print("int = "+ it[i]+"\t\t");
				if (i==it.length-1) {
					System.out.println();
				}
			}
			
			System.out.println("读取完毕！double数据一共"+n+"个数据");
			System.out.println("读取完毕！int数据一共"+t+"个数据");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("f:\\美句.txt"))));
			File file1 = new File("f:\\格言.txt");
			if (file1.exists()) {
				file1.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file1 , true);
			PrintWriter pw = new PrintWriter(fos,true);
			String s = "";
			
			while ((br.readLine())!=null) {
				pw.println(s);
				
			}
			System.out.println("复制成功！");
			System.out.println(file1.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
