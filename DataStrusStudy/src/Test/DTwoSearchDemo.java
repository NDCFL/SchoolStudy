package Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

public class DTwoSearchDemo {

	int data[];
	public DTwoSearchDemo() {
		data = new int[100];
		Random r = new Random();
 		for(int i=0;i<data.length;i++){
			data[i] = r.nextInt(1000);
		}
		Arrays.sort(data);
		for (int en : data) {
			System.out.print(en+"\t");
		}
	}
	public DTwoSearchDemo(int size) {
		data = new int[size];
		Random r = new Random();
 		for(int i=0;i<data.length;i++){
			data[i] = r.nextInt(1000);
		}
		Arrays.sort(data);
		for (int en : data) {
			System.out.print(en+"\t");
		}
	}
	public void findkey(int leftindex,int rightindex,int key){
		int middle=0;
		if(leftindex>rightindex){
			System.out.println("你找到数据不存在");
			return;
		}else{
			middle=(leftindex+rightindex)/2;
			if(key>data[middle]){
				leftindex = middle+1;
				findkey(leftindex, rightindex, key);
			}else if (key<data[middle]) {
				rightindex = middle-1;
				findkey(leftindex, rightindex, key);
			}else {
				System.out.println("在第"+(middle+1)+"个位置找到了"+key);
				return;
			}
			
		}
			
	}
		
	public static void main(String[] args) {
		DTwoSearchDemo ts = new DTwoSearchDemo();
		int n=0;
		while(n!='a'){
			try {
				
				System.out.println("\n请输入你要查找的数据，按a结束程序");
				Scanner  s = new Scanner(System.in);
				n=s.nextInt();
				ts.findkey(0,ts.data.length-1,n);
			} catch (Exception e) {
				System.out.println("程序已经结束");
				e.printStackTrace();
				return;
			}
		}
	}
}
