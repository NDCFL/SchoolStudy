package T11;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class Price {
/*
	编写一个猜商品价格的游戏，随机生成一个数字，然后由用户从控制台输入猜测的价格，
	提示用户猜的价格高了还是低了，
	直至猜中，最后输出猜测的次数和花费的时间(10分)
*/
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Price p = new Price();
		int a,n,count=0;
		Random random  = new Random();
		a = Math.abs((random.nextInt()%100));
		Date t = new Date();
		long time = t.getTime();
		do {
			count++;
			Scanner in = new Scanner(System.in);
			System.out.println("请输入价格");
			n = in.nextInt();
			if (a<n) {
				System.out.println("大了");
			}else if (a>n) {
				System.out.println("小了");
			}else if(a==n){
				Date t1 = new Date();
				long time1 = t1.getTime();
				long time2=(time1-time)/1000;
				System.out.println("猜对了,共猜了"+count+"次");
				System.out.println("一共花费"+time2+"秒");
			}
		}while (a!=n) ;
		
	}
	
}
