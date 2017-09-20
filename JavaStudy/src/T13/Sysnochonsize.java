package T13;

public class Sysnochonsize implements Runnable{

	public void run() {
		int count=10;
		while (true) {

			System.out.print(Thread.currentThread().getName()+count+" ");
			if (--count==0) {
				return;
			}
		}
		
	}
	public static void main(String[] args) {
		Sysnochonsize ra= new Sysnochonsize();
		Thread thread = new Thread(ra);
		thread.getName();
		thread.start();
		
	}

	

	
	
}
