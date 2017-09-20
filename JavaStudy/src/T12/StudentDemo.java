package T12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentDemo {

	public static void main(String[] args) {
		
		try {
			
			Student stu1 = new Student(1001,"长留",18,'男');
			Student stu2 = new Student(1002,"蜀山",17,'女');
			Student stu3 = new Student(1003,"按留",16,'男');
			Student stu4 = new Student(1004,"赤铁",19,'女');
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("f:\\美句1.txt")));
			oos.writeObject(stu1);
			oos.writeObject(stu2);
			oos.writeObject(stu3);
			oos.writeObject(stu4);
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("f:\\美句1.txt")));
			for (int i = 0; i < 4; i++) {
				Student stui = (Student)ois.readObject();
				System.out.println(stui);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
