package T5.sort;

import java.util.Arrays;
import java.util.Random;

public class BSort1 {

	int data[];
	public BSort1() {
		data = new int[10];
		Random r = new Random();
		for(int i=0;i<10;i++){
			data[i]=r.nextInt(100);
		}
	}
	public BSort1(int data[]) {
		this.data=data;
	}
	public void sort(){
		int len=data.length;
		int temp=0;
		for(int i=0;i<len;i++){
			for(int j=0;j<i;j++){
				if(data[i]<data[j]){
					temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}
	}
	public void print(){
		for (int i : data) {
			System.out.print(i+"\t");
		}
	}
	public static void main(String[] args) {
		BSort1 bs = new BSort1();
//		System.out.println("排序前的数据");
//		bs.print();
		long oldtime = System.currentTimeMillis();
		System.out.println("\n排序后的数据");
		bs.sort();
//		Arrays.sort(bs.data);
		for (int i : bs.data) {
			System.out.print(i+"\t");
		}
		System.out.println("\n花费的时间"+(System.currentTimeMillis()-oldtime)+"毫秒");
		
	}
}
	
