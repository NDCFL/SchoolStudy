//单行注释
/**
	多行注释
	编译源文件：javac 文件名称.java
	运行程序： java 文件名称

	1.JAVA程序的公有类(public)的类名必须和文件名称一致,有main函数的类一定要定义为公有类(public class )
	2.一个文件中可以定义多个类，但只能有一个类是public类
	3.一个类生成一个字节码文件

	4.java应用程序是由main函数开始，结束于main函数，一个应用程序只能有一个main函数;
	5.定义一个公有的类，类名为HelloWorld，类名一般用大写字母开头；
	public class HelloWorld{
	
	}
	6.定义一个main函数，公有的，静态的，无返回值的main函数,函数有一个字符串数组的参数，参数名称是args,
	public static void main(String[] args){
	
	}
	7.打印字符串,原样输出双引号内部的字符串,相当于C语言的printf函数;
	System.out.println("Hello World!");
	8.有main函数的类一定要定义成public 类

	标识符的命名规则：
		1.可以有字母，数字，下划线组成，不能有数字开头；
		2.不能有！，。，#等特殊字符；
		3.区分大小写；
		4.不能有关键字或者保留字；
	9.javadoc生成帮助文件


*/
public class HelloWorld
{
	public static void main(String[] args){
		System.out.println("Hello World!");
	}
}
//教师类
class Teacher
{

}
//学生类
class Student
{

}