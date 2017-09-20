package T12;

import java.io.File;
import java.io.IOException;

public class FileDome1 {

	public static void main(String[] args) {
		//创建文件夹
		File file = new File("f:/file");
		file.mkdir();
		File file1 = new File(file,"time.text");
		if (!file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		file1.delete();
		file.delete();
	}
}
