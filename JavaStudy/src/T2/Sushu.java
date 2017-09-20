package T2;


public class Sushu {

	public static void main(String[] args) {
		int num=0;
		for (int i = 2; i < 100; i++) {
			num=0;
			for (int j=2; j < i; j++) {
				if (i%j==0) {
					num=1;
				}
			}
			if (num==0) {
				System.out.print(i+"\t ");
			}
		}
	}
}
