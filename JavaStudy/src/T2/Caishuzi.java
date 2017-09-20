package T2;

import java.util.Random;
import java.util.Scanner;

public class Caishuzi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count=0;
		long time=System.currentTimeMillis();//获取当前时间
		Scanner in = new Scanner(System.in);
		int num=0;
		int randomnum=Math.abs(new Random().nextInt(100));
		System.out.println("猜吧！！1");
		while (true) {
			System.out.println("猜错了，重新猜！！");
			num=in.nextInt();
			if(num>randomnum){
				System.out.println("大了！！");
				count++;
				
			}else if (num<randomnum) {
				System.out.println("小了！！");
				count++;
			}else {
				long stoptime=(System.currentTimeMillis()-time)/1000;
				System.out.println("恭喜你猜对了！！"+"共猜了"+count+"次；"+"花费时间"+stoptime+"秒");
				
			}
			
		}
		

	}

}
