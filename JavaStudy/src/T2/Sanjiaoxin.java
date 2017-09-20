package T2;

import java.util.Scanner;

public class Sanjiaoxin {

	public static void main(String[] args) {
		System.out.println("请输入行数");
		Scanner s = new Scanner(System.in);
		int hang=s.nextInt();
		for (int i = 0; i <=hang; i++) {
			for (int j = 0; j <=hang-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <=2*i-1; k++) {
				if (i==1) {
					System.out.print("*");
				}else {
					if (k==1 || k==2*i-1) {
						System.out.print("*");
					}else {
						
						System.out.print(" ");
					}
				}
			}
			System.out.print("\n");
		}
		for (int i = hang-1; i >0; i--) {
			for (int j = 0; j <=hang-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <=2*i-1; k++) {
				if (i==1) {
					
					System.out.print("*");
				}else {
					if (k==1 || k==2*i-1) {
						System.out.print("*");
					}else {
						
						System.out.print(" ");
					}
				}
			}
			System.out.print("\n");
		}
	}
}
