package T4_1;

public class Director extends Teacher implements IPerson{

	String num;
	int workAge;
	String name,job;
	String assistantName;
	public Director(String num, String name, int workAge, String job,String assistantName) {
		super(num, name, workAge, job);
		this.job=job;
		this.name=name;
		this.num=num;
		this.workAge=workAge;
		this.assistantName=assistantName;
	}
	public void print(){
		System.out.println(num+"\t"+name+"\t"+workAge+"\t"+job+"\t"+assistantName);
		
	}
	
}
