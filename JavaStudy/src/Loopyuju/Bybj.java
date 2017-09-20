package Loopyuju;

public class Bybj {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				for (int k = 1; k <= 100; k++) {
					if (i+j+k==100 && 5*i+3*j+k/3==100 && k%3==0) {
						System.out.println("鸡翁有" + i);
						System.out.println("母鸡有" + j);
						System.out.println("小鸡有" + k);
						System.out.println("-------------------");
					}
				}
			}
		}
	}
}
