package Loopyuju;

public class Birld {

	public static void main(String[] args) {
//		马戏团有鸟和大象，它们共有36个头和100只脚，问分别有多少鸟和大象？
		for (int i = 0; i <36 ; i++) {
			for (int j = 0; j < 36; j++) {
				if ((i+j==36) && (2*i+4*j==100)) {
					System.out.println("鸟的个数="+i);
					System.out.println("大象的个数="+j);
				}
			}
		}
	}
}
