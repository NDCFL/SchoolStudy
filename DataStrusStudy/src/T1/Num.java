package T1;

import java.util.Random;

public class Num {

	public static void main(String[] args) {
		int n[]=new int[10000];
		Random r = new Random();
		for(int i=0;i<10000;i++){
			n[i]=r.nextInt(10000);
		}
		long oldtime = System.currentTimeMillis();
		int t;
		for(int i=0;i<10000;i++){
			for(int j=0;j<i;j++){
				if(n[i]<n[j]){
					t=n[i];
					n[i]=n[j];
					n[j]=t;
				}
			}
		}
		for(int i=0;i<n.length;i++){
			System.out.print(n[i]+"  ");
		}
		System.out.println();
		System.out.println("程序共花费时间："+(System.currentTimeMillis()-oldtime));
	}
}
