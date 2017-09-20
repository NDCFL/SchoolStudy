package Lianxi;

import java.util.Random;

public class InsertSortDemo {

	int data[];
	int len=0;
	public InsertSortDemo() {
		data = new int [10];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i] = r.nextInt(100);
		}
	}
	public InsertSortDemo(int size) {
		data = new int [size];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i] = r.nextInt(100);
		}
	}
	public InsertSortDemo(int data[]) {
		this.data=data;
	}
	public void print(){
		for (int  sa : data) {
			System.out.print(sa+"\t");
		}
	}
	public void sort(){
		int temp=0,j=0;
		for(int i=1;i<len;i++){
			temp = data[i];
			j=i-1;
			while (j>=0 && data[j]>temp) {
				data[j+1] = data[j];
				j--;
			}
			data[j+1]=temp;
		}
	}
	public static void main(String[] args) {
		InsertSortDemo i = new InsertSortDemo();
		System.out.println("排序前的数据如下");
		i.print();
		long oldtime = System.currentTimeMillis();
		System.out.println("\n排序后的数据如下");
		i.sort();
		i.print();
		System.out.println("\n本次程序共花费时间"+(System.currentTimeMillis()-oldtime)+"毫秒");
	}
}
