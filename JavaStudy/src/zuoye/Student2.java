package zuoye;

public class Student2 {
	/**
	 * 2:设计一个Student类，
	 * 添加姓名(String)，年龄(int), 分数(float)等属性
	 * 两个分别将string输入转换为int和float的方法
	 * 一个输出学生信息的方法
	 * **/
	String name;
	int age;
	float score;
	public int zhuanhuan(String name){
		return Integer.parseInt(name);
	}
	public float zhuanhuan1(String name){
		return Float.parseFloat(name);
	}
	
	public static void main(String[] agrs){
		String name="3674";
		Student2 no1 = new Student2();
		int n=no1.zhuanhuan(name);
		System.out.println("转换后的整型="+n);
	}
}
