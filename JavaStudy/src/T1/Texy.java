package T1;

public class Texy {

	public static void main(String[] args) {
		int sum=0;
		for (int i = 1; i <=100; i++) {
			sum+=i;
			if (sum>500) {
				System.out.println(sum);
				System.out.println(i);
				return;
			}
			
		}
	}
}
