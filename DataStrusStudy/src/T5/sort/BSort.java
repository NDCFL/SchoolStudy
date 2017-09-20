package T5.sort;

import java.util.Random;

public class BSort {

	int data[];
	public BSort() {
		data = new int[]{10,9,8,7,6,5,4,3,2,1};
//		Random r = new Random();
//		for(int i=0;i<10000;i++){
//			data[i]=r.nextInt(10000);
//		}
	}
	public BSort(int data[]) {
		this.data=data;
	}
	public void sort(){
		int len=data.length;
		int temp=0;
		for(int i=0;i<len-1;i++){
			for(int j=0;j<len-1-i;j++){
				if(data[j]>data[j+1]){
					temp=data[j];
					data[j]=data[j+1];
					data[j+1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		BSort bs = new BSort();
		System.out.println("排序前的数据");
		for (int i : bs.data) {
			System.out.print(i+"\t");
		}
		long oldtime = System.currentTimeMillis();
		System.out.println("\n 排序后的数据");
		bs.sort();
//		int data[]={20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
//		long oldtime = System.currentTimeMillis();
//		System.out.println("\n旧时间："+System.currentTimeMillis());
//		Arrays.sort(data);
		long newtime = System.currentTimeMillis();
		for (int i : bs.data) {
			System.out.print(i+"\t");
		}
		System.out.println("\n花费的时间"+(newtime-oldtime));
		
	}
}
	
