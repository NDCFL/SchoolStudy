package Loopyuju;

public class Wanshu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum=0;
		for (int i =2; i <1000; i++) {
			sum=0;
			for (int j =2; j <=i; j++) {
				if (i%j==0) {
					sum+=i/j;
				}
			}
			if (sum==i) {
				System.out.println(sum);
			}
		}
	}

}
