package T17;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringDemo {

	public static void main(String[] args) {
		String str = "abc";
		Class classes=null;
		try {
			classes = Class.forName("T16_1.QQChatEach");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//所有的构造函数
//		Constructor [] cs = classes.getDeclaredConstructors();
		//共有的构造函数
		Constructor [] cs = classes.getDeclaredConstructors();
		for (int i = 0; i < cs.length; i++) {
			System.out.print(cs[i].getName()+"(");
			Class [] cs1 = cs[i].getParameterTypes();
			for (int j = 0; j < cs1.length; j++) {
				if (j==(cs1.length-1)) {
					System.out.print(cs1[j].getClass().getName());
				}else {
					System.out.print(cs1[j].getClass().getName()+",");
				}
			}
			System.out.println(")");
		}
		System.out.println("==============================");
//		Method [] methods = classes.getDeclaredMethods();
		Method [] methods = classes.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.print(methods[i].getName()+"(");
			Class [] cs1 = methods[i].getParameterTypes();
			for (int j = 0; j < cs1.length; j++) {
				if (j==(cs1.length-1)) {
					System.out.print(cs1[j].getClass().getName());
				}else {
					System.out.print(cs1[j].getClass().getName()+",");
				}
			}
			System.out.println(")");
		}
		System.out.println("===============================");
		Field [] fields = classes.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
	}
}
