package T6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MiddleSearch {

	int data[];
	int len=0;
	public MiddleSearch() {
		data = new int[100];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i]=r.nextInt(100);
		}
		Arrays.sort(data);
		for (int sa : data) {
			System.out.print(sa+"\t");
		}
	}
	public MiddleSearch(int size) {
		data = new int[size];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i]=r.nextInt(100);
		}
		Arrays.sort(data);
		for (int sa : data) {
			System.out.print(sa+"\t");
		}
	}
	public void search(int key){
		int leftindex=0;
		int rightindex=len-1;
		int middle=0;
		if(data[leftindex]==key){
			System.out.print("在第"+(leftindex+1)+"个位置找到了");
			return;
		}
		if(data[rightindex]==key){
			System.out.print("在第"+(rightindex+1)+"个位置找到了");
			return;
		}
		while(leftindex<=rightindex){
			middle = (leftindex+rightindex)/2;
			if(data[middle]==key){
				System.out.println("在第"+(middle+1)+"个位置找到了");
				return;
			}
			if(key>data[middle]){
				leftindex = middle+1;
			}else if(data[middle]>key){
				rightindex = middle -1;
			}else{
				System.out.print("在第"+(middle+1)+"个位置找到了");
				return;
			}
		}
		System.out.println("查不到该数据");
	}
	public static void main(String[] args) {
		MiddleSearch ms = new MiddleSearch(100);
		System.out.println();
		int n=0;
		while(n!='a'){
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("请输入你要查找的数据，按a停止程序\n");
				n=s.nextInt();
				ms.search(n);
			} catch (Exception e) {
				System.out.println("程序已经停止");
				break;
			}
		}
	}
	
}
