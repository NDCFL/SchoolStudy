package Loopyuju;

import java.util.Scanner;

public class yingbei {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		System.out.println("请输入两个数");
		int a = in.nextInt();
		int b = in.nextInt();
		int min = a>b?b:a;
		for (int i =min; i>0; i--) {
			if (a%i==0 && b%i==0) {
				System.out.println("最大公约数为："+i+"最小公倍数："+(a*b)/i);
				break;
			}
		}
	}
}
