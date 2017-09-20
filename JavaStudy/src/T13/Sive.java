package T13;

public class Sive implements Runnable{
	int piao=10000;
	public static void main(String[] args) {
		Sive s = new Sive();
		new Thread(s,"卡").start();
		new Thread(s,"存折").start();
//		new Thread(s,"三号窗口").start();
//		new Thread(s,"四号窗口").start();
		
	}

	public void run() {
		while (true) {
			synchronized (this) {
				//获取线程名字
				String name=Thread.currentThread().getName();
				if (piao==0) {
					System.out.println("对不起！金额不足！");
					break;
				}
				piao-=100;
				System.out.println(name+"取了"+100+"元"+"\t还剩下："+piao+"元");
			}
			
		}
		
		
	}
}
