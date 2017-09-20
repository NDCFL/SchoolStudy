package T10;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

public class Tableevent extends JFrame {

	JLabel bijintupianLabel;

	public Tableevent() {
		super("表格事件");
		getContentPane().setLayout(new GridLayout(2, 1));
		Login();
		bjpictry();
		JTable jTable = new JTable(new Modle());
		JTableHeader th = jTable.getTableHeader();
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		JScrollPane gundong = new JScrollPane(jTable);
		add(gundong);
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Tableevent();
	}

	public void bjpictry() {
		Icon icon = new ImageIcon("image/42.gif");
		bijintupianLabel = new JLabel(icon);
		add(bijintupianLabel);
	}

	public void Login() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/1.jpg");
		setIconImage(image);
	}

	class Modle extends AbstractTableModel {
		private String[] biaotou = { "学号", "姓名", "性别", "年龄", "生日", "住址", "成绩",
				"是否抄袭" };
		private Object[][] mean = {
				{ "1001", "王亮", "男", new Integer(18), "1981-08-21", "北京", "96",
						new Boolean(true) },
				{ "1002", "王小", "男", new Integer(19), "1986-05-24", "上海", "40",
						new Boolean(false) },
				{ "1003", "小花", "女", new Integer(21), "1991-10-11", "长留", "48",
						new Boolean(true) },
				{ "1004", "花骨", "女", new Integer(22), "1995-05-18", "吴清雅",
						"60", new Boolean(false) },
				{ "1005", "杨紫", "女", new Integer(24), "1997-09-23", "熬上", "68",
						new Boolean(true) },
				{ "1006", "杨幂", "女", new Integer(19), "1991-08-01", "必火天滨湖",
						"72", new Boolean(false) },
				{ "1001", "字画", "男", new Integer(20), "1980-06-09", "观星崖",
						"55", new Boolean(true) },
				{ "1001", "小凡", "男", new Integer(22), "1981-12-20", "天湖", "4",
						new Boolean(false) }

		};

		public int getColumnCount() {
			return biaotou.length;
		}

		public int getRowCount() {
			return mean.length;
		}

		public Object getValueAt(int a, int b) {
			System.out.println(" 该单元的值为data[" + a + "][" + b + "] ："+ mean[a][b]);
			return mean[a][b];
		}

		public String getColumnName(int col) {
			System.out.println(" 该列的列名为：" + biaotou[col]);
			return biaotou[col];
		}

	}

}
