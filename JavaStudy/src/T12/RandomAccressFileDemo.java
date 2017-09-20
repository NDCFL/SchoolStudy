package T12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.sun.imageio.spi.RAFImageInputStreamSpi;

public class RandomAccressFileDemo {

	public static void main(String[] args) {
		File file = new File("f:/file1");
		if (!file.exists()) {
			file.mkdir();
		}
		try {
			RandomAccessFile raf = new RandomAccessFile("f:/file1/time.text","rw");
			int a=111;
			String str="今天天气很好哦！";
			raf.writeInt(a);
			raf.writeUTF(str);
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			RandomAccessFile raf = new RandomAccessFile("f:/file1/time.text","r");
			System.out.println("整型值是："+raf.readInt());
			System.out.println("字符串是："+raf.readUTF());
			System.out.println("文件大小是："+raf.length()+"个字节");
			System.out.println("文件大小是："+raf.getFilePointer()+"个字节");
			System.out.println("文件地址是："+raf.hashCode());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
