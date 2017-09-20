package T5;
//创建一个Vehicle类并将它声明为抽象类。
public abstract class Vehicle {
//在Vehicle类中声明一个numOfWheels抽象方法，使它返回一个字符串值。
	String name;
	String color;
	String place;
	int num;
	public abstract String numOfWheels(String name);
}
