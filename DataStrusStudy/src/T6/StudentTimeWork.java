package T6;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

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
import javax.swing.table.JTableHeader;

import com.sun.org.apache.xml.internal.security.utils.IgnoreAllErrorHandler;

public class StudentTimeWork extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane js;
	JButton bu, buto, close, update, delete, timein, closeclass;
	JLabel lb1, lb2, lbname, lbtel, lbsex, lbage, lbtime;
	JTextField text, name, tel, age, time;
	JRadioButton man, weman;
	JTableHeader head;
	ButtonGroup bg;
	JPanel panel;
	String title[] = { "学号", "姓名", "性别", "年龄", "出勤状况", "出勤得分" };
	String data[][] = new String[90][6];
	String value[][];
	String temp[] = new String[6];
	static int row = 0;

	public StudentTimeWork() {
		setTitle("学生考勤管理");
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("time.png");
		setIconImage(image);
		// 界面的控件布局
		panel = new JPanel(null);
		table = new JTable(data, title);
		table.setBounds(0, 50, 500, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体", Font.BOLD, 16));

		// 滚动面板
		js = new JScrollPane(table);
		js.setBounds(0, 50, 780, 292);

		panel.add(js);

		lb1 = new JLabel("学生考勤子系统");
		lb1.setBounds(320, 10, 200, 30);
		lb1.setFont(new Font("楷体", Font.BOLD, 24));
		panel.add(lb1);

		lbname = new JLabel("学号");
		lbname.setBounds(30, 360, 30, 30);
		panel.add(lbname);

		name = new JTextField();
		name.setBounds(80, 360, 60, 30);
		panel.add(name);

		lbtel = new JLabel("姓名");
		lbtel.setBounds(150, 360, 30, 30);
		panel.add(lbtel);

		tel = new JTextField();
		tel.setBounds(190, 360, 60, 30);
		panel.add(tel);

		lbsex = new JLabel("性别");
		lbsex.setBounds(260, 360, 60, 30);
		panel.add(lbsex);

		man = new JRadioButton("男", true);
		man.setBounds(300, 360, 40, 30);
		panel.add(man);

		weman = new JRadioButton("女", false);
		weman.setBounds(340, 360, 40, 30);
		panel.add(weman);

		bg = new ButtonGroup();
		bg.add(man);
		bg.add(weman);

		lbage = new JLabel("年龄");
		lbage.setBounds(380, 360, 30, 30);
		panel.add(lbage);

		age = new JTextField();
		age.setBounds(420, 360, 60, 30);
		panel.add(age);

		lbtime = new JLabel("出勤");
		lbtime.setBounds(490, 360, 30, 30);
		panel.add(lbtime);

		time = new JTextField();
		time.setBounds(520, 360, 60, 30);
		panel.add(time);

		buto = new JButton("新增/修改");
		buto.setBounds(600, 360, 130, 30);
		panel.add(buto);

		lb2 = new JLabel("姓名");
		lb2.setBounds(30, 400, 60, 30);
		panel.add(lb2);

		text = new JTextField();
		text.setBounds(80, 400, 60, 30);
		panel.add(text);

		bu = new JButton("查找");
		bu.setBounds(150, 400, 80, 30);
		panel.add(bu);

		close = new JButton("关闭");
		close.setBounds(240, 400, 80, 30);
		panel.add(close);

		update = new JButton("修改");
		update.setBounds(330, 400, 80, 30);
		panel.add(update);

		delete = new JButton("删除");
		delete.setBounds(430, 400, 80, 30);
		panel.add(delete);

		timein = new JButton("出勤统计");
		timein.setBounds(520, 400, 120, 30);
		panel.add(timein);

		closeclass = new JButton("结束课程");
		closeclass.setBounds(650, 400, 100, 30);
		panel.add(closeclass);

		delete.addActionListener(this);
		update.addActionListener(this);
		bu.addActionListener(this);
		buto.addActionListener(this);
		close.addActionListener(this);
		timein.addActionListener(this);
		closeclass.addActionListener(this);
		add(panel);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new StudentTimeWork();
	}

	public void readfile() {
		try {
			File file = new File("time.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String Tel[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				Tel = str.split(";");
			}
			value = new String[Tel.length][6];
			for (int i = 0; i < Tel.length; i++) {
				value[i] = Tel[i].split(",");
				data[i] = Tel[i].split(",");
				System.out.println(data[i][0] + "-----");
			}
			br.close();
			file = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bu) {
			String name = text.getText();
			for (int i = 0; i < value.length; i++) {
				for (int j = 0; j < value[i].length; j++) {
					if (value[i][1].equals(name)) {
						table.setValueAt(value[i][0], row, 0);
						table.setValueAt(value[i][1], row, 1);
						row++;
						table.setRowSelectionInterval(i, i);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "无此人");
			return;
		} else if (e.getSource() == buto) {
			if (name.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "姓名为空");
				return;
			} else if (tel.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Tel为空");
				return;
			} else if (!"出勤".equals(time.getText())) {
				if (!"缺席".equals(time.getText())) {
					if (!"请假".equals(time.getText())) {
						JOptionPane.showMessageDialog(this,
								"考勤输入有误，请输入出勤或缺席或请假");
						return;
					}
				}
			}
			File file = new File("time.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file, true);

				String sex = "";
				if (man.isSelected()) {
					sex = "男";
				} else {
					sex = "女";
				}
				String string = name.getText() + "," + tel.getText() + ","
						+ sex + "," + age.getText() + "," + time.getText()
						+ ",未评分;";
				byte b[] = string.getBytes();
				if (temp[5] == null || temp[5].equals("")) {
					temp[5] = "新增";
				}
				if (temp[5].equals("新增")) {
					try {
						String username = name.getText();
						for (int i = 0; i < value.length; i++) {
							for (int j = 0; j < value[i].length; j++) {
								if (value[i][0].equals(username)) {
									table.setValueAt(username, row, 0);
									table.setValueAt(tel.getText(), row, 1);
									value[i][1].replace(username, name
											.getText());
									table.setValueAt(sex, row, 2);
									table.setValueAt(age.getText(), row, 3);
									table.setValueAt(time.getText(), row, 4);
									value[i][0]
											.replace(temp[0], name.getText());
									value[i][1].replace(temp[1], tel.getText());
									value[i][2].replace(temp[2], sex);
									value[i][3].replace(temp[3], age.getText());
									value[i][4]
											.replace(temp[4], time.getText());
									row++;
									return;
								}
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "系统繁忙");
					}

				}
				fos.write(b, 0, b.length);
				dispose();
				new StudentTimeWork();
				fos.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == close) {
			System.exit(0);
		} else if (e.getSource() == update) {
			int index = table.getSelectedRow();
			name.setText(data[index][0]);
			temp[0] = data[index][0];
			tel.setText(data[index][1]);
			temp[1] = data[index][1];
			if (data[index][2].equals("男")) {
				man.setSelected(true);
			} else {
				weman.setSelected(true);
			}
			temp[2] = data[index][2];
			age.setText(data[index][3]);
			temp[3] = data[index][3];
			time.setText(data[index][4]);
			temp[4] = data[index][4];
			temp[5] = "修改";
		} else if (e.getSource() == delete) {
			int index = table.getSelectedRow();
			String string = "";
			try {
				for (int i = 0; i < value.length; i++) {
					for (int j = 0; j < value[i].length; j++) {
						if (value[i][0].equals(data[index][0])) {
							value[i][0].replace(data[index][0], "");
							value[i][1].replace(data[index][1], "");
							value[i][2].replace(data[index][2], "");
							value[i][3].replace(data[index][3], "");
							value[i][4].replace(data[index][4], "");
							value[i][5].replace(data[index][5] + ";", "");
							table.setValueAt("", index, 0);
							table.setValueAt("", index, 1);
							table.setValueAt("", index, 2);
							table.setValueAt("", index, 3);
							table.setValueAt("", index, 4);
							table.setValueAt("", index, 5);
							row++;
							continue;
						}
					}
				}
				for (int i = 0; i < value.length; i++) {
					for (int j = 0; j < value[i].length; j++) {
						if (i != index) {
							if (j == value[i].length - 1) {
								string += value[i][j] + ";";
							} else {
								string += value[i][j] + ",";
							}
						}
					}
				}
				File file = new File("time.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					System.out.println("string=" + string);
					byte b[] = string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					fos.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "系统繁忙！");
			}
			new StudentTimeWork();
		} else if (e.getSource() == timein) {
			for (int i = 0; i < value.length; i++) {
				for (int j = 0; j < value[i].length; j++) {
					if (value[i][4].equals("出勤")) {
						row++;
						table.setRowSelectionInterval(i, i);
						return;
					}
				}
			}
		} else if (e.getSource() == closeclass) {
			int index = table.getSelectedRow();
			String string = "";
			int num = 0;
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "请勾选你的课程记录！");
			} else {
				if (value[index][4].equals("出勤")) {
					num = 0;
					JOptionPane.showMessageDialog(null, "恭喜你！此次得分为90分");
					num = 90;
					table.setValueAt("90", index, 5);

				} else if (value[index][4].equals("缺席")) {
					num = 0;
					JOptionPane.showMessageDialog(null, "未出勤！此次得分为0分");
					num = 0;
					table.setValueAt("0", index, 5);
				} else if (value[index][4].equals("请假")) {
					JOptionPane.showMessageDialog(null, "请假！此次未的分");
					num = 0;
					table.setValueAt("0", index, 5);
				}
				for (int i = 0; i < value.length; i++) {
					for (int j = 0; j < value[i].length; j++) {
						if(value[i][0]==data[index][0]){
							value[i][0] = data[index][0];
							value[i][1] = data[index][1];
							value[i][2] = data[index][2];
							value[i][3] = data[index][3];
							value[i][4] = data[index][4];
							value[i][5] = data[index][5];
							row++;
							
						}
					}
				}
				for (int i = 0; i < value.length; i++) {
					for (int j = 0; j < value[i].length; j++) {
						if (j == value[i].length - 1) {
							if (i == index) {
								string += num + ";";
							}else {
								string+=value[i][j]+";";
							}
						} else {
							string += value[i][j] + ",";
						}
					}
				}
				File file = new File("time.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					System.out.println("string=" + string);
					byte b[] = string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					fos.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				new StudentTimeWork();
			}
		}

	}
}
