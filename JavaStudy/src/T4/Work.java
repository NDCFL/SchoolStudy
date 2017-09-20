package T4;

public class Work {
	/**
	 * 1:编写外部类Worker和内部类Student,在Worker中定义方法调用内部类Student方法
  	在外部再定义个类调用外部类的方法

	 * */
	public void work(){
		System.out.println("我是外部类");
		
	}
	public class Student{
		public void student(){
			System.out.println("我是内部类");
			work();//访问到了内部类
		}
	}
	
}
