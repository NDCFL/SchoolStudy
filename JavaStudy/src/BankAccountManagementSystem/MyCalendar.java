package BankAccountManagementSystem;

import java.util.*;

public class MyCalendar {
	public static void main(String[] args) {
		new MyCalendar().makeCalendar();
	}

	public void makeCalendar() {
		int i;
		int j;
		int year = 0;
		int month = 0;
		int week = 0;
		int totalDay = 0;

		Scanner scanner = new Scanner(System.in);
		Calendar ca = Calendar.getInstance();
		printAsterisk();
		System.out.print("欢 迎 使 用 万 年 历");
		printAsterisk();

		System.out.print("\n\n请输入年份:");
		year = scanner.nextInt();
		System.out.print("\n\n请输入月份:");
		month = scanner.nextInt();

		ca.set(year, month - 1, 1);
		week = ca.get(Calendar.DAY_OF_WEEK) - 1;// 获取输入月第一天是星期几

		if (month != 2)
			totalDay = calculatetotalDay(year, month);
		else {
			if (judgeLeap_year(year))
				totalDay = calculatetotalDay(year, month) + 1;// 如果是闰年，加一天
			else
				totalDay = calculatetotalDay(year, month);
		}

		System.out.println("\n\n\n星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");

		for (i = 0; i < week; i++) {
			System.out.print("\t");
		}

		for (i = 1; i < (8 - week); i++)
			System.out.print(i + "\t");

		for (i = (8 - week), j = 0; i <= totalDay; i++, j++) {
			if (j % 7 == 0)
				System.out.println();
			System.out.print(i + "\t");
		}

	}

	public void printAsterisk() {
		int i;
		for (i = 0; i < 18; i++)
			System.out.print("*");
	}

	// 获取输入月的天数
	public int calculatetotalDay(int year, int month) {
		int result = 0;

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			result = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			result = 30;
			break;
		default:
			result = 28;
			break;
		}
		return result;
	}

	// 判断闰年
	public boolean judgeLeap_year(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		else
			return false;
	}
}
