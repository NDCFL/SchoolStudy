package T2;

import java.util.Scanner;

public class Gongyinshu {

	public static void main(String[] args) {
		int n,m,t=1,max=1;
		Scanner s = new Scanner(System.in);
		System.out.println("输入两个数");
		n=s.nextInt();
		m=s.nextInt();
		if (n<m) {
			t=n;
			n=m;
			m=t;
		}
		for (int i = 1; i <=m; i++) {
			if (n%i==0 && m%i==0) {
				t=i;
			}
		}
		System.out.println("最大公因数数="+t);
		m=(n*m)/t;
		System.out.println("最大公倍数="+m);
	}
}
