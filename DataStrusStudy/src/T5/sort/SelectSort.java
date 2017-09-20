package T5.sort;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.accessibility.internal.resources.accessibility;


public class SelectSort {

	public int getminindex(int data[],int first){
		int minindex=data[first];
		int index=first;
		for(int i=first;i<data.length;i++){
			if(data[i]<minindex){
				minindex=data[i];
				index=i;
			}
		}
		return index;
	}
	public void datasort(int data[]){
		int temp;
		for(int i=0;i<data.length;i++){
			int index=getminindex(data, i);
			if(index!=i){
				temp=data[i];
				data[i]=data[index];
				data[index]=temp;
			}
		}
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"    ");
		}
	}
	public static void main(String[] args) {
//		SelectSort ss = new SelectSort();
		int data[]={50,-3,50,1,3,50,7,10,-6,100};
//		ss.datasort(data);
		System.out.println("拷贝的数据");
		int data1[] = Arrays.copyOf(data,10);
		for(int i=0;i<data1.length;i++){
			System.out.print(data1[i]+"  ");
		}
		System.out.println("\n源数据");
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"  ");
		}
		System.out.println("\n查找100在数组中的位置");
		System.out.print("数组中的第"+(Arrays.binarySearch(data, 100)+1)+"个数是你要查找的");//数据的查找
		Arrays.sort(data);
		System.out.println("\n排序后的数据");
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"    ");
		}
		System.out.println("填充数组");
		Arrays.fill(data, 50);
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"    ");
		}
//		System.out.println();
		
	}
	
}
