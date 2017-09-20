package T5.sort;

import java.util.Random;

public class QuickSort {
	int data[];
	int num=0;
	public QuickSort() {
		data = new int[50000];
		Random r = new Random();
		for(int i=0;i<50000;i++){
			data[i]=r.nextInt(100000);
		}
	}
	public QuickSort(int data[]) {
		this.data=data;
	}
	public int getindex(int data[],int leftindex,int rightindex,int size){
		int temp=data[leftindex];
		while(leftindex<rightindex){
			//从大到小排序
//			while(leftindex<rightindex && data[rightindex]<temp){
//				rightindex--;
//			}
			//从小到大排序
			while(leftindex<rightindex && data[rightindex]>=temp){
				rightindex--;
			}
			if(leftindex<rightindex){
				data[leftindex++]=data[rightindex];
			}
			//从大到小排序
//			while(leftindex<rightindex && data[leftindex]>temp){
//				leftindex++;
//			}
			//从小到大排序
			while(leftindex<rightindex && data[leftindex]<=temp){
				leftindex++;
			}
			if(leftindex<rightindex){
				data[rightindex--]=data[leftindex];
			}
		}
		data[leftindex]=temp;
		return leftindex;
	}
	public void print(){
		for (int a : data) {
			System.out.print(a+"\t");
		}
		System.out.println();
	}
	public void sort(int data[],int leftindex,int rightindex,int size){
		if(leftindex<rightindex){
			int index = getindex(data, leftindex, rightindex, size);
			sort(data, leftindex, index-1, size);
//			sort(data, index+1, rightindex, size);
		}
	}
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		long oldtime = System.currentTimeMillis();
		System.out.println("\n排序后的数据");
		qs.sort(qs.data, 0, qs.data.length-1, qs.data.length);
		qs.print();
		long newtime = System.currentTimeMillis()-oldtime;
		System.out.println("\n共用时："+newtime+"毫秒");
	}
}
