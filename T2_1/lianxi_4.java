import java.util.Scanner;
public class lianxi_4 
{
	public static void main(String[] args) 
	{
		/*
			4、编写一段程序，运行时向用户提问“你考了多少分？（0~100）”，接受输入后判断其等级并显示出来。判断依据如下：
			等级={优（90~100 分）；良（80~89 分）；中（60~69 分）；差（0~59 分）；}

		*/
		int num=0;
		Scanner input = new Scanner(System.in);			
		System.out.println("请输入分数");
		num=input.nextInt();	
		if(num>=90)
		{
			System.out.println("你的成绩优秀"+num);
				
		}else if(num>=80 && num<90)
		{
			System.out.println("你的成绩优良"+num);
				
		}else if(num>=70 && num<80)
		{
			System.out.println("你的成绩良好"+num);
				
		}else if(num>=60 && num<70)
		{
			System.out.println("你的成绩及格"+num);
				
		}else{
			
			System.out.println(num+"这分数不及格喔！");
		}
		
		
	}
}

