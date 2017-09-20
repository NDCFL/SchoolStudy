package T4;

public class WorkText {
	public static void main(String[] agrgs){
		Work t1= new Work();
		Work.Student t2 = t1.new Student();
		t1.work();
		t2.student();
	}
}
