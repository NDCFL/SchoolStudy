package zuoye;

public class Bijiao {
	String admit;
	String name;
	String sex;
	public void To(){
		this.admit ="学生1";
		this.name ="张三";
		this.sex ="男";
		System.out.println("admit："+this.admit);
		System.out.println("name："+this.name);
		System.out.println("sex："+this.sex);
	}
	public static void main(String[] args){
		Bijiao t1 = new Bijiao();
		int a=9,b=9;
		System.out.println("a==b"+(a==b)+"\t");
		System.out.println(t1);
		Bijiao t2 =t1;
		System.out.println("t1==t2\t"+(t1==t2));
		Bijiao t3 = new Bijiao();
		System.out.println("t3="+t3);
		System.out.println("t1="+t1);
		System.out.println("t2="+t2);
		System.out.println("t1==t3\t"+(t1==t3));
	}
}
