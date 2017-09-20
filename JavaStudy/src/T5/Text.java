package T5;

public class Text {
	public static void main(String[] agrs) {
		Vehicle t1 = new Vehicle_1();
		System.out.println("字符串为：" + t1.numOfWheels("我是Vehicle_1实现的"));
		Car t2 = new Car();
		System.out.println("字符串为：" + t2.numOfWheels("我是Car中的四轮车,信息如下："));
		t2.silunche("宝马", "白色", "30万", 4);
		t2.display();
		Motorbike t3 = new Motorbike();
		System.out.println("字符串为：" + t3.numOfWheels("我是Motorbike的双轮车,信息如下："));
		t3.shuanglunche("自行车", "灰色", "100百", 2);
		t3.play();
	}
}
