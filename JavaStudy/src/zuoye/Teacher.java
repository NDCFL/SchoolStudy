package zuoye;

public class Teacher {

	String name;
	String sex;
	String shengri;
	static int count = 0;

	public Teacher() {
		// 初始化变量
		name = "长留";
		sex = "男";
		shengri = "1990年2月2号";
		count++;
	}

	public Teacher(String name, String sex, String shengri) {

		System.out.println("姓名" + this.name);
		System.out.println("性别" + this.sex);
		System.out.println("生日" + this.shengri);
		count++;

	}
	public void text() {
		System.out.println("人数" + count);
	}
}
