package T2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// 5.1.写一个代码检查器，检查Java源程序中的括号是否匹配，即每个“{”都有对应的“}”、每个“（”都有对应的“）”，使用栈实现
		Stack<Character> stack = new Stack<Character>();
		int n=0,n1=0,n2=0,n11=0,n22=0;
		//读取一个Java代码
		File file = new File("F:\\java1.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (Exception e) {
				System.out.println("建立文件失败！");
			}
		}
		String string="";
		String ch="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((string=br.readLine())!=null) {
//				System.out.println(ch);
				ch+=string;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(string);
//		System.out.println("请书写语句！");
//		Scanner s = new Scanner(System.in);
//		String ch=s.next().trim();//自动输入一个程序
//		System.out.println(ch);
		for(int i=0;i<ch.length();i++){
			if(ch.charAt(i)=='{'){
				stack.push(ch.charAt(i));
				n1++;
				System.err.println("n1="+ch.charAt(i));
			}else if(ch.charAt(i)=='}'){
				stack.push(ch.charAt(i));
				n11++;
				System.err.println("n11="+ch.charAt(i));
			}else if (ch.charAt(i)=='(') {
				stack.push(ch.charAt(i));
				n2++;
				System.err.println("n2="+ch.charAt(i));
			}else if (ch.charAt(i)==')') {
				stack.push(ch.charAt(i));
				n22++;
				System.err.println("n22="+ch.charAt(i));
			}
//			else if(ch.charAt(i)=='}'){
//				stack.pop();
//			}else if(ch.charAt(i)==')'){
//				stack.pop();
//			}
		}
		if(n1==n11 && n22==n2){
			System.out.println("语法正确！");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n1<n11){
			System.out.println("语法错误！少了{");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n1>n11){
			System.out.println("语法错误！少了}");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n2<n22){
			System.out.println("语法错误！少了(");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n2>n22){
			System.out.println("语法错误！少了)");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}
	}
}
