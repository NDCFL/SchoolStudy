package T12;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("F:\\FeigeDownload");
		File file_1[] = file.listFiles();
		for (int i = 0; i < file_1.length; i++) {
			if (file.isDirectory()) {
				System.out.println("文件夹名为"+file_1[i].getName()+"的路径为"+file_1[i].getPath());
			}else if(file.isFile()){
				System.out.println("文件名为"+file_1[i].getName()+"的路径为"+file_1[i].getPath());
			}
		}
	}
}
