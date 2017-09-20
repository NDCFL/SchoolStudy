package T11;

import java.util.Enumeration;
import java.util.Hashtable;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Hashnlist {

	private static final String Preson = null;

	/**
	 * 创建一个Person类，该类中包含了name,age两个属性。
	 * 然后重写equals方法与hashCode方法。
	 * 然后创建多个Person类的多个对象。
	 * 将这些对象放到Hashtable中去，
	 * 然后再从Hashtable中一次读取这些信息
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		Hashtable number = new Hashtable();
		number.put(new Integer(1), new Preson("张三",18));
		number.put(new Integer(2), new Preson("李四",14));
		number.put(new Integer(3), new Preson("小小",18));
		number.put(new Integer(4), new Preson("小花",17));
		Enumeration e = number.keys();
		while (e.hasMoreElements()) {
			Integer key = (Integer) e.nextElement();
			System.out.println("编号为："+key.toString()+"的人员信息");
			Preson preson = (Preson)number.get(key);
			System.out.println(preson.toString());
			
		}
	}
	
}
class Preson{
	private String name;
	private int age;
	public Preson(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return new String(name+","+age);
	}
	public boolean equals(Object obj){
		if(obj instanceof Preson){
			Preson objTem = (Preson)obj;
			if(name.equals(objTem.name) && age==objTem.age){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	public int hashCode(){
		return name.hashCode()+age;
	}
}
