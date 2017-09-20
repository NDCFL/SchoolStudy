package T4_1;

public class text {

	public static void main(String[] args) {
		System.out.println("工号\t姓名\t工龄\t职务\t助理");
		Director de = new Director("0411","黄思曾",3,"主任","罗琼 ");
		de.print();
		Teacher te = new Teacher("0351","蔡木生",4,"专业负责人" );
		te.display();
		Teacher te1 = new Teacher("0840","詹卫许",1,"教师" );
		te1.display();
		Teacher te2 = new Teacher("0302","黄玲玲",4,"教师");
		te2.display();
		
	}
}
