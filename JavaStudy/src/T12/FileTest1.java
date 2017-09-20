package T12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest1 {

	public static void main(String[] args) throws Exception {
		FileOutputStream fs = new FileOutputStream(new File("word.txt"));
		byte b[] = "你号码？gffgyhgudcortdftruytughjtsesttiyi089uiu8yuhv".getBytes();
		fs.write(b, 0, b.length);
		FileInputStream fos = new FileInputStream(new File("word.txt"));
		byte by[] = new byte[1024];
		int n = fos.read(by);		
		System.out.println("内容为："+new String(by,0,n));
	}
}
