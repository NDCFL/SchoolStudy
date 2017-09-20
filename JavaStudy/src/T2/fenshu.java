package T2;

import java.util.Scanner; 
public class fenshu
	{ 

    public static void main(String[] args){ 

        Scanner input = new Scanner(System.in); //新建一个输入实例 

        System.out.println("请输入第一个学生的成绩：");
		 
       
		int myNumber = input.nextInt();//调用nextInt方法从键盘接收一个整数 
		//利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
		if(myNumber>=90)
		{
			System.out.println("真棒！给你个A");
		
		}else if(myNumber<90 && myNumber>=60)
		{
			System.out.println("努力哟！给你个B");	
		
		}else if(myNumber<60)
		{
			System.out.println("努力哟！给你个C");	
		
		}
    } 

} 