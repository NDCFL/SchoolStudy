package T4;

public class Internet {
/**
 * 【练习题】09.构造方法与重载 
定义一个网络用户类，要处理的信息有用户ID、用户密码、email地址。
在建立类的实例时，把以上三个信息都作为构造函数的参数输入，
其中用户ID和用户密码时必须的，缺省的email地址是用户ID加上字符串"@gameschool.com"  
* */
	int id;
	String password;
	String email;
	public Internet(int id,String password,String email){
		this.id=id;
		this.password=password;
		this.email=email;
	}
	public Internet(int id,String password){
		this.id=id;
		this.password=password;
		System.out.println("id:"+this.id+"\t"+"password:"+password+"\t"+"email:"+id+"@gameschool.com");
	}
	public void display(){
		System.out.println("id:"+this.id+"\t"+"password:"+password+"\t"+"email:"+this.email);
	}
	public static void main(String[] agrs){
		Internet p3= new Internet(1004,"fdfdd","www.cfl.@com");
		p3.display();
		Internet p2= new Internet(1044,"frtgred");
		
		
		
	}
}
