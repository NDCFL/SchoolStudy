package T10;
import java.util.*;
public class Maxtest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入两个数");
		int A=in.nextInt();
		int B=in.nextInt();
		Max max = new Max(A,B);
		max.play();
	}
}
