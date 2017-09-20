package T4.T41;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Test implements ActionListener {
	public static void main(String args[]) throws IOException {

		try {
			String s = "ABC";
			byte b[] = s.getBytes();
			FileOutputStream file = new FileOutputStream("f:\\test.txt", true);
			file.write(b);
			file.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
