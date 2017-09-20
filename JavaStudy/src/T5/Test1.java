package T5;

import java.util.Scanner;

public class Test1 extends Drink{
	public  void  taste(){
		for(int i=1;i<=3;i++){
			Scanner input = new Scanner(System.in);
			System.out.println("请输入你要查找的数值");
			i=input.nextInt();
			switch (i) {
			case 1:
				System.out.println("你选的是咖啡，好苦！");
				break;
			case 2:
				System.out.println("你选的是啤酒，好辣！");
				break;
			case 3:
				System.out.println("你选的是牛奶，好甜！");
				break;
			}
		}
	}
	public static void main(String[] args) {
		Drink T1 = new Test1();
		T1.taste();
	}
}
