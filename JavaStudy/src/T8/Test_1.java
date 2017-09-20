package T8;
public class Test_1 {

	public static void main(String[] args) {

		Teacher t1 = new Teacher("0411","张三",3, "主任");
		Director d1 = new Director("0412", "张三", 13, "主任", "罗琼");
		t1.print();
		d1.print();

	}
}
