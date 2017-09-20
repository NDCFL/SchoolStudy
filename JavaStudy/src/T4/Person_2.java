package T4;

public class Person_2 {
	private String name;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public static void main(String[] agrs){
		Person_2 people = new Person_2();
		people.setName("卷烟");
		System.out.println("name:"+people.getName());
		
	}
}
