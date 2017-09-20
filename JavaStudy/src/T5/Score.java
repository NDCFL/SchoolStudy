package T5;

import java.util.Scanner;

public class Score {
	static int score;
	static String scoreString(int score) throws IllegalStateException{
		if(score>=90 && score<=100){
			return "A";
		}else if(score<90 && score>=80){
			return "B";
		}else if(score<80 && score>=60){
			return "C";
		}else if(score<60 && score>0){
			return "D";
		}else {
			throw new IllegalStateException("非法的分数");
		}
	}
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("请输入一个分数");
			int score=input.nextInt();
			System.out.println(scoreString(score));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			System.out.println("你输入的分数大于100或者小于0");
		}
	}
}
