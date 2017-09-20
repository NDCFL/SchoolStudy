package Lianxi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoSearchDemo {

	int data[];
	int len=0;
	public TwoSearchDemo() {
		data = new int [100];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i] = r.nextInt(1000);
		}
		Arrays.sort(data);
		print();
	}
	public TwoSearchDemo(int size) {
		data = new int [size];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i] = r.nextInt(size*10);
		}
		Arrays.sort(data);
		print();
	}
	public void print(){
		for (int  sa : data) {
			System.out.print(sa+"\t");
		}
	}
	public void findKey(int key){
		int leftindex = 0;
		int rightindex = len-1;
		int middle = 0;
		if(data[leftindex]==key){
			System.out.println("在第"+(leftindex+1)+"个位置找到了"+key);
			return;
		}
		if(data[rightindex]==key){
			System.out.println("在第"+(rightindex+1)+"个位置找到了"+key);
			return;
		}
		while(leftindex<=rightindex){
			middle = (leftindex+rightindex)/2;
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
		System.out.println("你找到数不存在！");
	}
	public static void main(String[] args) {
		TwoSearchDemo t = new TwoSearchDemo();
		int a=0;
		while(a!='a'){
			try {
				System.out.println("\n请输入你要查找的数据,按a结束程序！");
				Scanner s = new Scanner(System.in);
				a = s.nextInt();
				t.findKey(a);
			} catch (Exception e) {
				System.out.println("程序已经结束");
				return;
			}
		}
 	}
}
