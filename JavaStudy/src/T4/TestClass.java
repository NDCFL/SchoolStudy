package T4;

public class TestClass {
	/**
	 * 1、定义TestClass类属性java中的访问控制 2、权限设置 public公有类 protected受保护的 default默认的
	 * private私有的
	 */
	public String name;
	protected int age;
	String sex;
	private int cardid;

	public TestClass() {
		String name = "刘小二";
		age = 18;
		sex = "男";
		cardid = 1001;

	}
	public TestClass(String name,int age,String sex,int cardid) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.cardid = cardid;

	}
	public void play(){
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("sex:"+sex);
		System.out.println("cardid:"+cardid);
	}
	public static void main(String [] agrs){
		TestClass testClass = new TestClass();
		//所有变量都可以在本类中访问
		testClass.play();
	} 

}
