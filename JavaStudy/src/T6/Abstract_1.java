package T6;

import sun.nio.cs.ext.TIS_620;

public abstract class Abstract_1 {//抽象类
	int a,b;
	public  void max(int a,int b){
		this.a=a;
		this.b=b;
		if(a>b){
			System.out.println("a>b");
		}else {
			System.out.println("a<b");
		}
		
	}
	public abstract void min();
	
}
