package T6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class DMiddleSearch {

	int data[];
	int len=0;
	public DMiddleSearch() {
		data = new int[100];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i]=r.nextInt(1000);
		}
		Arrays.sort(data);
		for (int sa : data) {
			System.out.print(sa+"\t");
		}
	}
	public DMiddleSearch(int size) {
		data = new int[size];
		len = data.length;
		Random r = new Random();
		for(int i=0;i<len;i++){
			data[i]=r.nextInt(1000);
		}
		Arrays.sort(data);
		for (int sa : data) {
			System.out.print(sa+"\t");
		}
	}
	int count=0;
	public void search(int leftindex,int rightindex,int key){
		int middle=0;
		count++;
		if(data[leftindex]==key){
			System.out.print("===ll=====在第"+(leftindex+1)+"个位置找到了===ll========");
			System.out.println("leftindex="+leftindex+";middle="+middle+";rightindex="+rightindex+";data[middle]="+data[middle]);
			System.out.println("找了"+count+"次");
			return;
		}
		if(data[rightindex]==key){
			System.out.print("===r=====在第"+(rightindex+1)+"个位置找到了===r=====");
			System.out.println("leftindex="+leftindex+";middle="+middle+";rightindex="+rightindex+";data[middle]="+data[middle]);
			System.out.println("找了"+count+"次");
			return;
		}
		if(data[middle]==key){
			System.out.println("=====mmm=====在第"+(middle+1)+"个位置找到了====mm====");
			System.out.println("leftindex="+leftindex+";middle="+middle+";rightindex="+rightindex+";data[middle]="+data[middle]);
			System.out.println("找了"+count+"次");
			return;
		}
		if(leftindex>rightindex){
			System.out.println("查不到该数据");
			return;
		}else {
			middle = (leftindex+rightindex)/2;
			System.out.println("leftindex="+leftindex+";middle="+middle+";rightindex="+rightindex+";data[middle]="+data[middle]);
			if(key>data[middle]){
				leftindex = middle+1;
				search(leftindex, rightindex, key);
			}else if(data[middle]>key){
				rightindex = middle -1;
				search(leftindex, rightindex, key);
			}else{
				System.out.println("----------在第"+(middle+1)+"个位置找到了------------");
				System.out.println("找了"+count+"次");
				return;
			}
		}
	}
	public static void main(String[] args) {
		DMiddleSearch ms = new DMiddleSearch(100);
		System.out.println();
		int n=0;
		while(n!='a'){
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("请输入你要查找的数据，按a停止程序\n");
				n=s.nextInt();
				ms.search(0,ms.len-1,n);
				ms.count=0;
			} catch (Exception e) {
				System.out.println("程序已经停止");
				break;
			}
		}
	}
	
}
