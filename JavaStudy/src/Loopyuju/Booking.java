package Loopyuju;

public class Booking implements Runnable {

	/**
	 * @param args
	 */
	int ticket = 1000;
	public static void main(String[] args) {
		Booking bk = new Booking();
		new Thread(bk, "窗口一").start();
		new Thread(bk, "窗口二").start();
	}

	public void run() {
		while (true) {
			synchronized (this) {
				if (ticket == 0) {
					System.out.println("票已经卖完了！！");
					return;
				}
				try {
					ticket -= 100;
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "买了"
							+ 100 + "张票；" + "还剩下" + ticket + "张票");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}

}
