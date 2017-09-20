package Test;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

public class TwoSearchDemo {

	int data[];
	public TwoSearchDemo() {
		data = new int[]{10,9,8,7,6,5,4,1,2,3};
		Arrays.sort(data);
		for (int en : data) {
			System.out.print(en+"\t");
		}
	}
	public TwoSearchDemo(int data[]) {
		this.data = data;
		Arrays.sort(data);
		for (int en : data) {
			System.out.print(en+"\t");
		}
	}
	public void findkey(int key){
		int leftindex = 0;
		int rightindex=data.length-1;
		int middle=0;
		if(data[leftindex]==key){
			System.out.println("在第"+(leftindex+1)+"个位置找到了"+key);
			return;
		}
		if(data[rightindex]==key){
			System.out.println("在第"+(rightindex+1)+"个位置找到了"+key);
			return;
		}
		while(leftindex<=rightindex){
			middle=(leftindex+rightindex)/2;
			if(data[middle]==key){
				System.out.println("在第"+(middle+1)+"个位置找到了"+key);
				return;
			}
			if(key>data[middle]){
				leftindex = middle+1;
			}else if (key<data[middle]) {
				rightindex = middle-1;
			}else {
				System.out.println("在第"+(middle+1)+"个位置找到了"+key);
				return;
			}
		}
		System.out.println("你找到数据不存在");
		return;
	}
	public static void main(String[] args) {
		TwoSearchDemo ts = new TwoSearchDemo();
		int n=0;
		while(n!='a'){
			try {
				
				System.out.println("\n请输入你要查找的数据，按a结束程序");
				Scanner  s = new Scanner(System.in);
				n=s.nextInt();
				ts.findkey(n);
			} catch (Exception e) {
				System.out.println("程序已经结束");
				return;
			}
		}
	}
}
