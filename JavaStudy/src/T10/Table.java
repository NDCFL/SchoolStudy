package T10;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

public class Table extends JFrame{

	public Table() {
		super("表格制作");
		//设置布局
		getContentPane().setLayout(new GridLayout(1,0));
		//建立表格
		JTable tab = new JTable(new table());
		JTableHeader hangHeader = tab.getTableHeader();
		tab.setAutoResizeMode(JTable.ERROR);
        //将该表格放到一个滚动面板中去
        JScrollPane scrollPane = new JScrollPane(tab);
        add(scrollPane);
        pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Table();
	}
	class table extends AbstractTableModel{
		private String [] title={"姓名","性别","年龄","住址","联系方式","爱好"};
		private Object [][] neirong = {
				{"张三","男",new Integer(30),"北京","1234634","运动"},
				{"李四","女",new Integer(32),"上海","1734634","跑步"},
				{"马六","男",new Integer(36),"青岛","1234634","跳高"},
				{"马华","女",new Integer(32),"广州","1434634","游泳"}
		};
		public int getColumnCount() {
			return title.length;
		}
		public int getRowCount() {
			return neirong.length;
		}
		public Object getValueAt(int a, int b) {
			System.out.println(" 该单元的值为data["+a+"]["+b+"] ："+neirong[a][b]);
            return neirong[a][b];
		
		}
		public String getColumnName(int col) {
	            System.out.println(" 该列的列名为："+title[col]);
	            return title[col];
	    }
	}
}
