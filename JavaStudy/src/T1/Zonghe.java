package T1;


public class Zonghe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Zonghe zh=new Zonghe();
		zh.jjcfb();
		System.out.println("-----------------------------------------------");
		zh.wanshu();
		System.out.println();
		System.out.println("-----------------------------------------------");
		zh.sushu();
		System.out.println("------------------------------------------------");
		zh.shuixianhuashu();
	}
	public void jjcfb(){
		System.out.println("九九乘法表如下：");
		for (int i = 1; i <=9; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		
	}
	public void wanshu(){
		
		int n=0;
		for (int i =6; i <1000; i++) {
			n=0;
			for (int j =2; j <=i; j++) {
				if (i%j==0) {
					n+=i/j;
				}
			}
			if (i==n) {
				System.out.print(i+"\t");
			}
			
		}
	}
	public void sushu(){
		int n=0,count=0;
		for (int i = 2; i <100; i++) {
			n=0;
			for (int j =2; j <i; j++) {
				if (i%j==0) {
					n=1;
				}
			}
			if (n==0) {
				System.out.print(i+"\t");
				count++;
				if (count%5==0) {
					System.out.println();
				}
			}
		}
	}
	public void shuixianhuashu(){
		System.out.println("水仙花数如下：");
		int a,b,c;
		for (int i =100; i <1000; i++) {
			a=i/100;
			b=i/10%10;
			c=i%10;
			if (i==a*a*a+b*b*b+c*c*c) {
				System.out.print(i+"\t");
			}
		}
		
	}

}
