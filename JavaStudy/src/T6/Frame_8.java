package T6;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame_8 extends JFrame implements ActionListener {

	JButton read, write, copy;
	JTextArea jread, jwrite;
	JPanel center, down;

	public Frame_8() {
		super("读写文件窗口");
		center = new JPanel(new GridLayout(2, 1, 10, 10));
		down = new JPanel(new GridLayout(1, 2, 10, 10));
		jread = new JTextArea();
		jread.setEditable(false);
		jwrite = new JTextArea();
		JScrollPane jp = new JScrollPane(jread);
		JScrollPane jp1 = new JScrollPane(jwrite);
		read = new JButton("读取文件");
		write = new JButton("写入文件");
		copy = new JButton("清空");
		center.add(jp);
		center.add(jp1);
		down.add(read);
		down.add(write);
		down.add(copy);
		// 监听
		read.addActionListener(this);
		write.addActionListener(this);
		copy.addActionListener(this);
		add(center);
		add(down, BorderLayout.SOUTH);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Frame_8();
	}

	public void actionPerformed(ActionEvent e) {
		File file = new File("f:\\美句1.txt");
		if (e.getSource() == read) {
			try {
				FileReader fr = new FileReader(file);
				char ch[] = new char[1024];
				int len = fr.read(ch);
				jread.setText(new String(ch, 0, ch.length));
				fr.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource()==write) {
			try {
				FileWriter fw = new FileWriter(file,true);
				String str = jwrite.getText();
				fw.write(str);
				jwrite.setText("");
				fw.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource()==copy) {
			jread.setText("");
		}

	}

}
