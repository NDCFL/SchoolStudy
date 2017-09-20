package T2;

public class Jjcfb {

	public static void main(String[] args) {
		int sum=1;
		for (int i = 1; i <=9; i++) {
			for (int j = 1; j <=i; j++) {
				sum=i*j;
				System.out.print(i+"*"+j+"="+sum+"    ");
			}
			System.out.println();
		}
	}
}
