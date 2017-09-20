import java.util.Scanner; 
public class gongyinshu
	{ 

    public static void main(String[] args){ 

		
        Scanner input = new Scanner(System.in); //新建一个输入实例 

        System.out.println("请输入第两个数：");
		int x = input.nextInt();//调用nextInt方法从键盘接收一个整数 
		int y = input.nextInt();//调用nextInt方法从键盘接收一个整数 
		//输入两个正整数m和n，求其最大公约数和最小公倍
		int m,i,a=1;//a为公约数，m为最大公倍数
		
		if(x<y){
			m=x;
			x=y;
			y=m;  	
		}
		for(i=1;i<=y;i++){

			if(x%i==0&&y%i==0)

				a=i; 	
		}
		System.out.println("两数的最大公因数是:"+a);
			m=(x*y)/a;
		System.out.println("两数的最大公倍数是:"+m);
    } 

} 