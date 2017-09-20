package Test;

public class StudTest {

	public static void main(String[] args) {
		StrusStud ss = new StrusStud();
		ss.addnode("小明", 1601,21, 1);
		ss.addnode("小红", 1602,20, 2);
		ss.addnode("小丽", 1603,12, 3);
		ss.addnode("李四", 1604,11, 4);
		ss.sysplay();
		System.out.println("------------------");
		ss.delstudent();
		
	}
}
