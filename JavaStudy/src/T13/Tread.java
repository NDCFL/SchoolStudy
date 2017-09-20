package T13;

import java.net.DatagramPacket;

public class Tread extends Thread{

	@Override
	public void run() {
		String str[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		for (int i = 0; i <26; i++) {
			if (Thread.currentThread().getName().equals("小写字母：")) {
				System.out.println(Thread.currentThread().getName()+"\t"+str[i]);
			}else if(Thread.currentThread().getName().equals("大写字母：")){
				//转换大小写
				System.out.println(Thread.currentThread().getName()+"\t"+str[i].toUpperCase());
			}
		}
	}
	public static void main(String[] args) {
		Tread tread1 = new Tread();
		Tread tread2 = new Tread();
		tread1.setName("小写字母：");
		tread2.setName("大写字母：");
		tread1.start();
		tread2.start();
	}
	
}
