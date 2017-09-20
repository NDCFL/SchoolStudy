package salary;

import java.awt.Color;
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

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
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

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Date;

public class salarymanager extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane js;
	JButton find, add, close, update, delete, sum, closeclass;
	JLabel  lbsuminfo, lbheadtitle, lb2,
			lbguding, lbtouzi, lbtitle, lbsumin, lbsumout;
	JTextField text, sumin,sumout,suminfo;
	JTableHeader head;
	ButtonGroup bg;
	JPanel panel;
	String title[] = { "员工编号", "员工姓名", "总工资", "所交税额", "实际工资" };
	String data[][] = new String[90][5];
	String value[][];
	String temp[] = new String[6];
	static int row = 0;

	@SuppressWarnings("deprecation")
	public salarymanager() {
		// 设置窗口标题
		setTitle("工资纳税系统 ");
		readfile();
		// 实例化一个面板，null代表的是绝对布局
		panel = new JPanel(null);
		// 实例化表格控件，存放数据
		table = new JTable(data, title);
		// 设置表格显示的位置，绝对布局
		table.setBounds(0, 60, 500, 300);
		// 设置表格的行高为30个像素
		table.setRowHeight(30);
		// 设置表格的字体，楷体，加粗，14号字体
		table.setFont(new Font("楷体", Font.BOLD, 14));
		// 获取表头
		head = table.getTableHeader();
		// 设置表头的背景色
		head.setBackground(new Color(200, 200, 200));
		// 设置表头的文字颜色
		head.setFont(new Font("楷体", Font.BOLD, 18));
		// 滚动面板
		js = new JScrollPane(table);
		// 设置面板的位置
		js.setBounds(240, 80, 560, 292);

		// 将滚动面板放入到panal面板中
		panel.add(js);

		// 窗口中的标题
		lbheadtitle = new JLabel("工资纳税系统 ");
		// 标题的位置
		lbheadtitle.setBounds(420, 30, 200, 30);
		// 标题的字体
		lbheadtitle.setFont(new Font("楷体", Font.BOLD, 28));
		// 放入面板
		panel.add(lbheadtitle);

		lbtitle = new JLabel("个人账单");
		lbtitle.setBounds(50, 50, 140, 30);
		lbtitle.setFont(new Font("楷体", Font.BOLD, 20));
		panel.add(lbtitle);

		lbsumin = new JLabel("总工资:");
		lbsumin.setBounds(10, 120, 90, 30);
		panel.add(lbsumin);

		sumin = new JTextField();
		sumin.setBounds(90, 120, 120, 30);
		sumin.setEditable(false);
		panel.add(sumin);

		lbsumout = new JLabel("所交税额:");
		lbsumout.setBounds(10, 220, 90, 30);
		panel.add(lbsumout);

		sumout = new JTextField();
		sumout.setBounds(90, 220, 120, 30);
		sumout.setEditable(false);
		panel.add(sumout);

		lbsuminfo = new JLabel("实际工资:");
		lbsuminfo.setBounds(10, 320, 90, 30);
		panel.add(lbsuminfo);

		suminfo = new JTextField();
		suminfo.setBounds(90, 320, 120, 30);
		suminfo.setEditable(false);
		panel.add(suminfo);

		add = new JButton("新增/修改");
		add.setBounds(230, 400, 100, 30);
		panel.add(add);

		find = new JButton("查找账单");
		find.setBounds(550, 400, 100, 30);
		panel.add(find);

		update = new JButton("修改账单");
		update.setBounds(450, 400, 90, 30);
		panel.add(update);

		delete = new JButton("删除账单");
		delete.setBounds(350, 400, 90, 30);
		panel.add(delete);

		sum = new JButton("税率计算");
		sum.setBounds(660, 400, 90, 30);
		panel.add(sum);

		// 对按钮进行监听
		delete.addActionListener(this);
		update.addActionListener(this);
		find.addActionListener(this);
		add.addActionListener(this);
		sum.addActionListener(this);
		add(panel);
		// 设置窗口大小
		setSize(850, 500);
		// 显示窗口
		setVisible(true);
		// 窗口在屏幕中间显示
		setLocationRelativeTo(null);
		// 关闭窗口，关闭程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 主函数
	public static void main(String[] args) {
		new salarymanager();
	}

	// 读取文件，放入数组中，以便于后面的操作
	public void readfile() {
		try {
			File file = new File("salary.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String richang[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				richang = str.split(";");
			}
			value = new String[richang.length][5];
			for (int i = 0; i < richang.length; i++) {
				try {
					value[i] = richang[i].split(",");
					data[i] = richang[i].split(",");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "数据读取失败，请稍后在试");
					return;
				}
			}
			br.close();
			file = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 事件处理
	public void actionPerformed(ActionEvent e) {
		// 查找记录
		if (e.getSource() == find) {
			String gongziid = JOptionPane.showInputDialog("请输入员工编号");
			for (int i = 0; i < value.length; i++) {
				for (int j = 0; j < value[i].length; j++) {
					if (value[i][0].equals(gongziid)) {
						row++;
						table.setRowSelectionInterval(i, i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示",
								"账单查询", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "员工不存在");
			return;
			// 新增记录
		} else if (e.getSource() == add) {
			dispose();
			new salarymanageradd(-2);
		} else if (e.getSource() == update) {
			int index = table.getSelectedRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "还未选择所要修改的账单记录");
				return;
			}
			dispose();
			new salarymanageradd(index);
			// 删除员工
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
							table.setValueAt("", index, 0);
							table.setValueAt("", index, 1);
							table.setValueAt("", index, 2);
							table.setValueAt("", index, 3);
							table.setValueAt("", index, 4);
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
				File file = new File("salary.txt");
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
			new salarymanager();
			//计算税收
		} else if (e.getSource() == sum) {
			int index = table.getSelectedRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "请选择要计算的员工");
				return;
			} else {
				float summoney = Float.parseFloat(data[index][2]);
				sumin.setText(summoney + "");
				float Y = summoney - 3500;
				if (Y <= 0) {
					JOptionPane.showMessageDialog(null,
							"你工资也太低了吧！还没有交税的资格，好好赚钱");
					sumout.setText("0");
					suminfo.setText("0");
				} else if (Y > 0 && Y <= 1500) {
					sumout.setText("45");
					suminfo.setText((Float.parseFloat(sumin.getText()) - 45)
							+ "");
				} else if (Y > 1500 && Y <= 4000) {
					sumout.setText((45 + (Y - 1500) * 0.1) + "");
					suminfo
							.setText((Float.parseFloat(sumin.getText()) - (45 + (Y - 1500) * 0.1))
									+ "");
				} else if (Y > 4000 && Y <= 9000) {
					sumout.setText((445 + (Y - 4000) * 0.2) + "");
					suminfo
							.setText((Float.parseFloat(sumin.getText()) - (445 + (Y - 4000) * 0.2))
									+ "");
				} else if (Y > 9000 && Y <= 35000) {
					sumout.setText((1945 + (Y - 8000) * 0.25) + "");
					suminfo
							.setText((Float.parseFloat(sumin.getText()) - (1945 + (Y - 8000) * 0.25))
									+ "");
				} else if (Y > 35000 && Y <= 55000) {
					sumout.setText((6945 + (Y - 20000) * 0.3) + "");
					suminfo
							.setText((Float.parseFloat(sumin.getText()) - (6945 + (Y - 20000) * 0.3))
									+ "");
				} else if (Y > 55000 && Y <= 80000) {
					sumout.setText((15945 + (Y - 30000) * 0.35) + "");
					suminfo
							.setText((Float.parseFloat(sumin.getText()) - (15945 + (Y - 30000) * 0.4))
									+ "");
				} else {
					sumout.setText((51945 + (Y - 80000) * 0.45) + "");
					suminfo
							.setText((Float.parseFloat(sumin.getText()) - (51945 + (Y - 80000) * 0.5))
									+ "");
				}
				for (int i = 0; i < value.length; i++) {
					for (int j = 0; j < value[i].length; j++) {
						if (value[i][0].equals(data[index][0])) {
							value[i][0] = data[index][0];
							value[i][1] = data[index][1];
							value[i][2] = data[index][2];
							value[i][3] = sumout.getText();
							value[i][4] = suminfo.getText();
							table.setValueAt(sumout.getText(), index, 3);
							table.setValueAt(suminfo.getText(), index, 4);
							row++;
							break;
						}
					}
				}
				String valueString = "";
				for (int i = 0; i < value.length; i++) {
					for (int j = 0; j < value[i].length; j++) {
						if (j == value[i].length - 1) {
							valueString += value[i][j] + ";";
						} else {
							valueString += value[i][j] + ",";
						}
					}
				}
				File file1 = new File("salary.txt");
				try {
					FileOutputStream fos1 = new FileOutputStream(file1);
					byte b1[] = valueString.getBytes();
					fos1.write(b1, 0, b1.length);
					fos1.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		}
	}
}
