package T9;

import java.util.Calendar;
import java.util.Date;

public class Person {


	public static void main(String a[]) {
	/**
	* 
	* 
	* 5.	如何得到一年的所有星期二的日期？
	* 
	* 
	* */
		Date d = new Date(116,0,1);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int week=cal.get(Calendar.DAY_OF_WEEK);
		if(week>5){
			week=week-5;
			d.setDate(d.getDate()+week);
			cal.setTime(d);
		}else{
			week=5-week;
			d.setDate(d.getDate()+week);
			cal.setTime(d);
		}
		System.out.println("星期1是"+d.toLocaleString());
		for(int i=0;i<365-d.getDate();i+=7){
			d.setDate(d.getDate()+7);
			System.out.println("星期1是"+d.toLocaleString());
		}
	}
}
