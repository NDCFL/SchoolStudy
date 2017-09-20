public class zuoye5 
{
	public static void main(String[] args) 
	{
		//输入一个三位数，每个数分解出个位，十位，百位。
		int a,b,c,num=649;
		System.out.println("请输入一个三位数");		
		a=num/100%10;
		b=num/10%10;
		c=num%10;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}
}
