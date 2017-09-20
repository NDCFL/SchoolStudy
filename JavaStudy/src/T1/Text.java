package T1;

public class Text {

	public static void main(String[] args) {
		int count=0,n=0;
		for (int i = 2; i < 200; i++) {
			n=0;	
			for (int j = 2; j < i; j++) {
				if (i%j==0) {
					n=1;
				}
			}
			if (n==0) {
				System.out.print(i+"\t");
				count++;
				if (count%5==0) {
					System.out.println();
				}
				
			}
		}
		System.out.println("一共"+count+"个素数");
	}
}
