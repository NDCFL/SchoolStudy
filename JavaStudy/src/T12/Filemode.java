package T12;

import java.io.File;
import java.util.Date;


public class Filemode {
	
	public static void main(String[] args) {
		String fileString="F:\\学习总课程\\Java\\Java课程\\T01\\T01.txt";
		File file = new File(fileString);
		System.out.println("是否为路径:"+file.isDirectory());
		System.out.println("文件大小为:"+file.length()+"字节");
		System.out.println("文件路径是:"+file.getPath());
		System.out.println("文件路径是:"+file.getAbsolutePath());
		System.out.println("文件最后修改的时间是:"+new Date(file.lastModified()).toLocaleString());
		System.out.println("是否可读："+file.canRead());
		System.out.println("是否可写："+file.canWrite());
		System.out.println("获取文件名："+file.getName());
		System.out.println("是否存在："+file.exists());
		
	}
}
