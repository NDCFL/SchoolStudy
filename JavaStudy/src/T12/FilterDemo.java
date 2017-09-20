package T12;

import java.io.File;
import java.io.FilenameFilter;


public class FilterDemo {

	public static void main(String[] args) {
		File file = new File("F:\\");
		//生成过滤器
		Filter file2 = new Filter("txt");
		String str[] = file.list(file2);
		for (int i = 0; i < str.length; i++) {
			File file1 = new File(file,str[i]);
			if (file1.isFile()) {
				System.out.println("文件："+file1.getName()+";\t文件路径："+file1.getPath()+";\t文件大小："+file1.length()+"个字节");
			}else {
				System.out.println("文件夹："+file1.getName()+";\t文件夹路径："+file1.getPath()+";\t文件大小："+file1.length()+"个字节");
			}
		}
		
	}
}
class Filter implements FilenameFilter{

	String src;
	//返回文件名
	public Filter(String src) {
		this.src = src;
	}
	public boolean accept(File dir, String name) {
		return name.endsWith("."+src);
	}
	
}
