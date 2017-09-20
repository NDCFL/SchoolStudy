package T5;

	public  class Man {
	public static void display(){
		System.out.println("我是外部类");
	}
	public static class Women{
		public  void play(){
			System.out.println("我是静态内部类");
		}
	}
}
