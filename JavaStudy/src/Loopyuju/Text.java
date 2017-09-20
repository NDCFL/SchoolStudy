package Loopyuju;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

public class Text {

	/**
	 * 1、写程序，对 int arrays[]={10,1,4,2,6,8,3,25}数组排序后输出？
	 * 2、编写一个TCP服务器，接收客户端发过来的信息，当接收到End字符时结束? 3、编写程序，将“Hello” 写入到
	 * d:/test/msg.txt 文件中,再把它读出来，并打印？
	 * 
	 */
	public static void main(String[] args) {
		Text t = new Text();
		t.paixu();
		t.hellow();
		t.te();
		int n = Math.abs(new Random().nextInt(100));
		System.out.println("随机n=" + n);
	}
	public void paixu() {
		int arrays[] = { 10, 1, 4, 2, 6, 8, 3, 25 };
		System.out.println("源数据\t" + Arrays.toString(arrays));
		Arrays.sort(arrays);
		System.out.println("排序后\t" + Arrays.toString(arrays));
	}
	public void hellow() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("f:/msg.dat"));
			bw.write("Hello");
			bw.close();
			System.out.println("写入成功");
			System.out.println("-----------------");
			System.out.print("文件内容为：          ");
			BufferedReader br = new BufferedReader(new FileReader("f:/msg.dat"));
			System.out.println(new String(br.readLine()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void te() {
		int x[] = { 10, 1, 4, 2, 6, 8, 3, 25 };
		System.out.println("排序前的结果\n");
		// 排序前
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + "    ");
		}
		// 排序后
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[i] > x[j]) {
					int temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("排序后的结果\n");
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + "    ");
		}
		System.out.println();
	}
}
