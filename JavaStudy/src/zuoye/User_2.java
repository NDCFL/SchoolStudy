package zuoye;

import java.util.Scanner;

public class User_2 {
	public static void main(String[] agrs) {
		User_3 user = new User_3();
		User_3 user1 = new User_3();
		user.admit="学生1";
		System.out.println("用户名："+user.admit);
		Scanner in = new Scanner(System.in);
		while (user.kouling != "抢红包") {
			System.out.println("请输入口令");
			String Kouling = in.next();
			User_3.count++;
			if (Kouling.equals("抢红包")) {
				user.yuanshi();
				user1.yuanshi("学生二", "李四", "女", "2016年2月2号");
				System.out.println("用户的个数有"+User_3.count+"个");
			} else {
				System.out.println("你的口令是:"+Kouling+"\t\t"+"用户名："+user.admit+"\t\t"+"个数"+User_3.count);
				System.out.println("口令错误");

				
			}
		}
	}
}
