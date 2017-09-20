package T5;

public abstract class Drink {//抽象类
/**
	1、建立一个Java抽象类Drink，应当： 
	a、声明一个抽象方法taste()，该方法负责输出饮料的味道； 
	b、声明int型常量来代表不同的饮料类型（咖啡、啤酒、牛奶），如：
	c、声明静态工厂方法getDrink(int drinkType)，根据传入的参数创建不同的饮料对象
	并返回该对象，建议使用switch语句。该方法要求声明DrinkNotFoundException，
	当没有相对应的饮料类型时，抛出该异常。
 * 
 * */
	final static int coffe=1;
	final static int bir=2;
	final static int milk=3;
	public abstract void  taste();//用来输出饮料的味道
	
	
}
