package Yuxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDemo {

	/**
	 * 1、io流分为字节流，字符流
	 * 2、字节流逝reader,write
	 * 3、字符流是inputstream,outputstream
	 * 4、对象流是datainputstream,dataoutputsstream
	 * 
	 * */
	//成员变量
	File file = new File("f:\\test.txt");
	public static void main(String[] args) {
		new IoDemo().write();
		new IoDemo().read();
		
	}
	public void write(){
		//追加文件或者覆盖文件
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			byte[] str = "用我霓裳羽衣换你一世执念，许你三生爱意青丝白发；用我无上地位换你胭脂素寰，许你相濡与沫共享繁华；用我马革裹尸换你素世安然，许你来世相遇不在牵挂；".getBytes();
			fos.write(str, 0, str.length);
			fos.close();
			System.out.println("保存成功！！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void read(){
		//读取文件
		try {
			FileInputStream fis = new FileInputStream(file);
			byte b[] = new byte[1024];
			int n=0;
			System.out.println("读取成功！！！！内容如下：");
			while ((n=fis.read(b, 0, b.length))!=-1) {
				System.out.println(new String(b,0,n));
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			//捕获异常
			System.out.println("文件不存在！！！");
		} catch (IOException e) {
			//io语句错误
			System.out.println("io语句错误");
		}
	}
}
