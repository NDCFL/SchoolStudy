package T8;

public class Teacher implements Iperson{

	 String num;
	 String name;
	 int workAge;
	 String job;
	 Teacher ( String num, String name, int workAge, String job){
		 this.num = num;
		 this.name = name;
		 this.workAge = workAge;
		 this.job=job;
	 }
	 
	 public void print(){
//		 System.out.println("num="+num+";name="+name+";workage="+workAge +";job="+job);
		 System.out.println("num="+num+";workage="+workAge);
	 }
	 
	 
}
class Director extends Teacher{
	String assistantName;
	Director(String num, String name, int workAge, String job, String assistantName){
		super(num,name,workAge,job);
		this.assistantName = assistantName;
	}
	public void print(){
		System.out.println("num="+num+";assistantName="+assistantName);
	}
}
