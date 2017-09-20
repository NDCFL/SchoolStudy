package Loopyuju;

public class Bybj_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <=100; i++) {
			for (int j = 1; j <100; j++) {
				for (int k = 1; k <=100; k++) {
					if ((i*5+j*3+k/3)==100 && i+j+k==100 && k%3==0) {
						System.out.println("母鸡有："+i+"只\t公鸡有："+j+"只\t小鸡有："+k+"只");
						
					}
				}
			}
		}

	}

}
