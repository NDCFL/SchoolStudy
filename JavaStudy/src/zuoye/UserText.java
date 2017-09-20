package zuoye;

import java.util.Scanner;

public class UserText {
	public static void main(String[] agrs) {
		User_1 user = new User_1();
		User_1 user1 = new User_1();
		Scanner in = new Scanner(System.in);
		while (user.kouling != "抢红包") {
			System.out.println("请输入口令");
			String Kouling = in.next();
			User_1.count++;
			if (Kouling.equals("抢红包")) {
				user.yuanshi();
				user1.yuanshi("学生二", "李四", "女", "2016年2月2号");
				System.out.println("用户的个数有"+User_1.count+"个");
			} else {
				System.out.println("口令错误");
			}
		}
	}
}
