package T12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class File_1 {

	public static void main(String[] args) throws IOException {
		File file_2 = new File("F:\\file");
		if (!file_2.exists()) {
			file_2.mkdir();
		}
		File file = new File("F:\\文件");
		System.out.println("文件名为："+file.getName());
		File file1 = new File("F:\\file");
		System.out.println("更改的名字为："+file.renameTo(file1));
		System.out.println("文件名为："+file1.getName());
		File file4 = new File(file1,"time");
		try {
			file4.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		file4.deleteOnExit();
		if (!file4.isFile()) {
			System.out.println("文件不存在");
		}else {
			System.out.println("文件存在");
		}
		File file2 = new File("F:\\学习总课程\\综合笔记.txt");
		FileInputStream fis1 = new FileInputStream(file2);
		InputStreamReader isr1 = new InputStreamReader(fis1); 
		BufferedReader br1 = new BufferedReader(isr1);
		File file3 = new File("F:\\学习总课程\\综合笔记1.txt");
		FileOutputStream fps1 = new FileOutputStream(file3,true);
		PrintWriter pw1 = new PrintWriter(fps1,true);
		String str = "";
		while ((str=br1.readLine())!=null) {
			pw1.println();
		}

	
	}
}
