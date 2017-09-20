package zuoye;
import java.util.Scanner;

public class CaimingziText {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Caimingzi chenfeilong = new Caimingzi();
		while (chenfeilong.name != "陈飞龙") {
			System.out.println("请输入你猜得名字三个字哦！");
			String minzi = in.next();
			Caimingzi.count++;
			if (minzi.equals("陈飞龙")) {
				System.out.println("你猜对了！");
				chenfeilong.caice();

			} else {
				System.out.println("猜了"+Caimingzi.count+"次");
				System.out.println("你输入的有误！");

			}

		}
	}
}
