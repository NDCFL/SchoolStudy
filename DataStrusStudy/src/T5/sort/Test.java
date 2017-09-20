package T5.sort;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		int data[] = new int[2000];
		int len=data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i]=r.nextInt();
		}
		int data1[] = Arrays.copyOf(data, data.length);
		NewSort ns = new NewSort(data1);
		long oldtime = System.currentTimeMillis();
		ns.sort();
		for (int i : data1) {
			System.out.print(i+"\t");
		}
		System.out.println("\n新排序程序共花费时间："+(System.currentTimeMillis()-oldtime)+"毫秒");
		System.out.println("------------------------------------------------------");
		QuickSort qs = new QuickSort(data1);
		qs.sort(data1, 0, data1.length-1, data1.length);
		for (int j : data1) {
			System.out.print(j+"\t");
		}
		System.out.println("\n快速程序共花费时间："+(System.currentTimeMillis()-oldtime)+"毫秒");
		System.out.println("------------------------------------------------------");
		BSort bs = new BSort(data1);
		bs.sort();
		for (int p : data1) {
			System.out.print(p+"\t");
		}
		System.out.println("\n冒泡程序共花费时间："+(System.currentTimeMillis()-oldtime)+"毫秒");
		
 	}
	
}
