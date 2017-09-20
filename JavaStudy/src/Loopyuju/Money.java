package Loopyuju;


public class Money extends Thread{
	int ticket=100;
	public static void main(String[] args) {
		Money m = new Money();
		new Thread(m,"窗口一").start();
		new Thread(m,"窗口二").start();
	}
	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				if ((ticket-1)<0) {
					System.out.println("票已买完");
					return;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ticket--;
				System.out.println(Thread.currentThread().getName()+"买了"+1+"张票"+"\t还剩余："+ticket+"张");
			}
			
		}
	}
}
