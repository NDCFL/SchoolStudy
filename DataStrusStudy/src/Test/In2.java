package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class In2 extends JFrame implements ActionListener { // 录入信息窗体；

	String va[][];

	int temp = 0;
	int r = 0;
	JTable table;

	String name[] = { "姓名", "性别", "生日", "爱好", "联系方式", "性格特点" };
	String[][] m = new String[20][6];
	Box box, box1;

	JButton b1, b2, b3, b4;
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t4, t5, t6;
	JPanel peast, psouth;

	JTextField input;

	public In2(String s1) {
		readfile();
		peast = new JPanel();
		psouth = new JPanel();

		b1 = new JButton("保存");
		b2 = new JButton("添加");
		b3 = new JButton("修改");
		b4 = new JButton("查询");

		l1 = new JLabel("姓名");
		l2 = new JLabel("性别");
		l3 = new JLabel("生日");
		l4 = new JLabel("爱好");
		l5 = new JLabel("联系方式");
		l6 = new JLabel("性格特点");

		t1 = new JTextField(16);
		t2 = new JTextField(16);
		t3 = new JTextField(16);
		t4 = new JTextField(16);
		t5 = new JTextField(16);
		t6 = new JTextField(16);
		input = new JTextField(10);

		psouth.add(b1);
		psouth.add(b2);
		psouth.add(b3);
		psouth.add(b4);

		box = Box.createVerticalBox();
		box.add(l1);
		box.add(Box.createVerticalStrut(5));
		box.add(t1);
		box.add(Box.createVerticalStrut(5));
		box.add(l2);
		box.add(Box.createVerticalStrut(5));
		box.add(t2);
		box.add(Box.createVerticalStrut(5));
		box.add(l3);
		box.add(Box.createVerticalStrut(5));
		box.add(t3);
		box.add(Box.createVerticalStrut(5));
		box.add(l4);
		box.add(Box.createVerticalStrut(5));
		box.add(t4);
		box.add(Box.createVerticalStrut(5));
		box.add(l5);
		box.add(Box.createVerticalStrut(5));
		box.add(t5);
		box.add(Box.createVerticalStrut(5));
		box.add(l6);
		box.add(Box.createVerticalStrut(5));
		box.add(t6);

		peast.add(box);

		table = new JTable(m, name);
		table.setRowHeight(30);
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(psouth, BorderLayout.SOUTH);
		add(peast, BorderLayout.EAST);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		validate();

		setTitle(s1);
		setBounds(400, 200, 800, 600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			dispose();
			JOptionPane.showMessageDialog(null, "保存成功", "提示",
					JOptionPane.INFORMATION_MESSAGE);
			new In2("信息");
		} else if (e.getSource() == b2) {

			if (t1.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入姓名");
				return;
			} else if (t2.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入性别");
				return;
			} else if (t3.getText().equals("")) {

				JOptionPane.showMessageDialog(this, "请输入生日");
				return;
			} else if (!t3.getText().equals("")) {
				try {
					int yy = Integer.parseInt(t3.getText());
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "生日输入有误！");
				}
			} else if (t5.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入联系方式");
				return;
			} else if (!t5.getText().equals("")) {
				try {
					int yy = Integer.parseInt(t5.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "联系方式输入有误！");
				}
			} else if (t4.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入爱好");
				return;
			} else if (t6.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入性格特点");
				return;
			}

			File file = new File("xinxiguanli.txt");// 更新数据
			try {
				FileOutputStream fos = new FileOutputStream(file, true);
				String ss = t1.getText() + "," + t2.getText() + ","
						+ t3.getText() + "," + t4.getText() + ","
						+ t5.getText() + "," + t6.getText()+";";
				byte b[] = ss.getBytes();

				if (temp == 0) {
					fos.write(b, 0, b.length);
					dispose();
					new In2("信息");
					fos.close();
				} else {
					String s3 = "";
					for (int i = 0; i < va.length; i++) {
						for (int j = 0; j < va[i].length; j++) {
							s3 = s3 + va[i][j] + ";";
						}
					}
					File file1 = new File("xinxiguanli.txt");
					try {
						FileOutputStream fos1 = new FileOutputStream(file1);
						byte b1[] = s3.getBytes();
						fos1.write(b1, 0, b1.length);
						dispose();
						new In2("信息");
						fos1.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		else if (e.getSource() == b3) {
			int iselect = table.getSelectedRow();
			t1.setText(va[iselect][0]);
			t2.setText(va[iselect][1]);
			t3.setText(va[iselect][3]);
			t4.setText(va[iselect][4]);
			t5.setText(va[iselect][5]);
			t6.setText(va[iselect][6]);
			temp = 1;
			if (temp == 1) {
				try {

					for (int i = 0; i < va.length; i++) {
						for (int j = 0; j < va[i].length; j++) {
							if (va[i][0].equals(t1.getText())) {
								va[i][0] = t1.getText();
								va[i][1] = t2.getText();
								va[i][2] = t3.getText();
								va[i][3] = t4.getText();
								va[i][4] = t5.getText();
								va[i][5] = t6.getText();
								r++;
								break;
							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "操作错误!");
				}
			}
		} else if (e.getSource() == b4) {
			for (int i = 0; i < va.length; i++) {
				for (int j = 0; j < va[i].length; j++) {
					if (va[i][0].equals(t1.getText())) {
						r++;
						table.setRowSelectionInterval(i, i);// 选定行
						JOptionPane.showMessageDialog(this, "查询成功");// 弹出消息对话框
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "查无此人");
			return;
		}
	}

	public void readfile() {
		try {
			File file = new File("xinxiguanli.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s1 = "";
			String s2 = "";
			String a[] = {};
			while ((s1 = br.readLine()) != null) {
				s2 = s2 + s2 + s1 + ";";
				a = s2.split(";");
			}
			va = new String[a.length][6];
			for (int i = 0; i < a.length; i++) {
				va[i] = a[i].split(",");
				m[i] = a[i].split(",");
			}
			br.close();
			file = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		In2 fra = new In2("信息");
	}
}
