package Lianxi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DTwoSearchDemo {

	int data[];
	int len=0;
	public DTwoSearchDemo() {
		data = new int [100];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i] = r.nextInt(1000);
		}
		Arrays.sort(data);
		print();
	}
	public DTwoSearchDemo(int size) {
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
	public void findKey(int key,int leftindex,int rightindex){
		int middle = 0;
		if(leftindex>rightindex){
			System.out.println("你找到数据不存在!");
		}else{
			middle = (leftindex+rightindex)/2;
			if(key>data[middle]){
				leftindex = middle+1;
				findKey(key, leftindex, rightindex);
			}else if (key<data[middle]) {
				rightindex = middle-1;
				findKey(key, leftindex, rightindex);
			}else {
				System.out.println("在第"+(middle+1)+"个位置找到了"+key);
				return;
			}
		}
	}
	public static void main(String[] args) {
		DTwoSearchDemo t = new DTwoSearchDemo();
		int a=0;
		while(a!='a'){
			try {
				System.out.println("\n请输入你要查找的数据,按a结束程序！");
				Scanner s = new Scanner(System.in);
				a = s.nextInt();
				t.findKey(a,0,t.data.length-1);
			} catch (Exception e) {
				System.out.println("程序已经结束");
				return;
			}
		}
 	}
}
