package T4;
import java.util.*;
public class VehicleText {
	public static void main(String [] agrs){
		int q,o;
		Scanner in = new Scanner(System.in);
		Vehicle t1 =new Vehicle();
		t1.move();
		System.out.println("请输入速度");
		int e=in.nextInt();
		t1.setSpeed(e);
		System.out.println("-------------");
		q=t1.spreedUp(t1.spreed);
		System.out.println("加速后的速度是："+q);
		System.out.println("-------------");
		o=t1.spreedDown(t1.spreed);
		System.out.println("减速后的速度是："+o);
		
	}
}
