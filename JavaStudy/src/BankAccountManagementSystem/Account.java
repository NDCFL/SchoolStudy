package BankAccountManagementSystem;

import java.util.Scanner;

public abstract class Account {
/**
	 * 1:(面向对象基础语法) 写一个账户类(Account), 
	属性: 
	id:账户号码    长整数 
	password:账户密码   字符串类型
	name:真实姓名   字符串类型
	personId:身份证号码   字符串类型
	email:客户的电子邮箱   字符串类型
	balance:账户余额    双精度浮点型

 * */
	String id;
	String password;
	String name;
	String personId;
	String email;
	double balance;
	/**
	 * deposit: 存款方法,参数是double型的金额
		withdraw:取款方法,参数是double型的金额
		构造方法: 有参和无参,有参构造方法用于设置必要的属性

	 * */
	//存款方法
	public void deposit(){
		double a;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要存的金额");
		a=input.nextDouble();
		balance=this.balance+a;
		System.out.println("你存了"+a+"元，你的总金额是："+balance);
	}
	//取款方法
	public void withdraw(){
		double b;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要取的金额");
		b=input.nextDouble();
		balance=this.balance-b;
		System.out.println("你的总金额是："+balance);
	}
	public Account(){
		id="6226820014201855446";
		password="12345";
		name="陈飞龙";
		personId="1";
		email="chenfeilong@.com";
		balance=200;
	}
	public void display(){
		System.out.println("户名:"+this.name);
		System.out.println("人工号:"+this.personId);
		System.out.println("人工号:"+this.personId);
		System.out.println("卡号:"+this.id);
		System.out.println("金额:"+this.balance);
		System.out.println("密码:"+this.password.replace(password, "******"));
		char cha = '\u0000';
		System.out.println(cha);
		
	}
	
}
