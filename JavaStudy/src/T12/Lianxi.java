package T12;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Lianxi {

	public static void main(String[] args) {
		try {
			File file = new File("f:\\file.txt");
			file.mkdir();
			File file1 = new File(file,"file.txt");
			file1.createNewFile();
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file1));
			String string = "hfusfdjaskkjfjsaijfjsaio0df8wenrwOUFOASNFAKSJU XOW524541654798165488743P4E-Q29O2RWU FEJSGFE";
			dos.writeUTF(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
