package T4_1;

public class Teacher implements IPerson{

	String num;
	int workAge;
	String name,job;
	public Teacher ( String num, String name, int workAge, String job){
		this.job=job;
		this.name=name;
		this.num=num;
		this.workAge=workAge;
	}
	public  Teacher( String num, double workAge){
		this.num=num;
		this.workAge=(int)workAge;
	}
	public void display() {
		System.out.println(num+"\t"+name+"\t"+workAge+"\t"+job);
		
	}
}
