package Lianxi;

import java.util.Date;
import java.util.Random;

import javax.xml.crypto.Data;


public class QuickSortDemo {

	int data[];
	int len=0;
	public QuickSortDemo() {
		data = new int [10];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i] = r.nextInt(100);
		}
	}
	public QuickSortDemo(int size) {
		data = new int [size];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i] = r.nextInt(100);
		}
	}
	public QuickSortDemo(int data[]) {
		this.data=data;
	}
	public void print(){
		for (int  sa : data) {
			System.out.print(sa+"\t");
		}
	}
	public int getindex(int leftindex,int rightindex){
		int temp = data[leftindex];
		while(leftindex<rightindex){
			while(leftindex<rightindex && data[rightindex]>=temp){
				rightindex--;
			}
			if(leftindex<rightindex){
				data[leftindex++]=data[rightindex];
			}
			while(leftindex<rightindex && data[leftindex]<temp){
				leftindex++;
			}
			if(leftindex<rightindex){
				data[rightindex--]=data[leftindex];
			}
			data[leftindex]=temp;
		}
		return leftindex;
	}
	public void sort(int leftindex , int rightindex){
		int index=0;
		if(leftindex<rightindex){
			index = getindex(leftindex, rightindex);
			sort(leftindex, index-1);
			sort(index+1, rightindex);
		}
	}
	public static void main(String[] args) {
		QuickSortDemo q = new QuickSortDemo();
		System.out.println("排序前的数据如下");
		q.print();
		System.out.println("\n当前时间："+new Date().toLocaleString());
		long oldtime = System.currentTimeMillis();
		System.out.println("\n排序后的数据如下");
		q.sort(0, q.data.length-1);
		q.print();
		System.out.println("\n当前时间："+new Date().toLocaleString());
		System.out.println("\n本次程序共花费时间"+(System.currentTimeMillis()-oldtime)+"毫秒");
	
	}
}
