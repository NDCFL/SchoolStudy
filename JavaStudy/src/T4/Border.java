package T4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Border extends JFrame{
	
	public Border() {
		super();
		setTitle("创建可以滚动的表格");
		setBounds(100, 100, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String [] columnName={"A","B"};//定义表格列名
		//定义表格数据数组
		String [][] tableValues={
				{"A1","B1"},
				{"A2","B2"},
				{"A3","B3"},
				{"A4","B4"},
				{"A5","B5"},
				{"A6","B6"},
				{"A7","B7"},
				{"A8","B8"},
				{"A9","B9"},
				{"A10","B10"}
		};
		//指定列名和数据的表格
		JTable table = new JTable(tableValues,columnName);
		//创建显示数据的滚动面板
		JScrollPane scrollPane = new JScrollPane(table);
		//将滚动面板加入到窗口中间去
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
	public static void main(String[] args) {
		new Border();
	}
	
}



