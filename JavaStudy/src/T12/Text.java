package T12;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Text {

	public static void main(String[] args) {
		File file = new File("f:\\file");
		file.mkdir();
		//file.delete();
		File file1 = new File("f:\\file\\text.txt");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File fiel2 = new File("f:\\文件");
		file.renameTo(fiel2);
		System.out.println("路径为："+file.getPath());
		System.out.println("文件名："+fiel2.getName());
		System.out.println("父路径"+file.getParent());
		System.out.println("文件大小"+file.length()+"个字节");
		System.out.println("文件最后一次被修改的时间为："+new Date(file.lastModified()).toLocaleString());
		System.out.println("文件可读性"+file.canRead());
		System.out.println("文件可写性"+file.canWrite());
		System.out.println("文件地址"+file.hashCode());
		File file4 = new File("F:\\美句.txt");
		System.out.println("美句.txt的大小是："+file4.length()+"个字节");
	}
}
