package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class AccountTableModel extends AbstractTableModel {

	String[] columnNames = {"学号","姓名","年龄","性别","专业","电话"};
	Object[][] allAccInfo = null;
	int rowNum = 0;
	List<String> list = new ArrayList<String>();
	public AccountTableModel() {
		// TODO Auto-generated constructor stub
	}
	public AccountTableModel(String condition) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("d:/student.txt"));
			String line="0";
			while((line = br.readLine()) != null){
				System.out.println(line+"");
				if(!"".equals(line)){
					String[] infos = line.split(",");
					if(null != condition && !"".equals(condition)){
						if(infos[0].contains(condition)){
							rowNum++;
							list.add(infos[0]);
							list.add(infos[1]);
							list.add(infos[2]);
							list.add(infos[3]);
							list.add(infos[4]);
							list.add(infos[5]);
						}	
					}else{
						rowNum++;
						list.add(infos[0]);
					}
				}
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list+"---------");
			}
			allAccInfo = new Object[rowNum][6];
			 
			
			int rowIndex = 0;
			for(int i=0;i<list.size();i++){
			allAccInfo[rowIndex][0] = list.get(0);
			allAccInfo[rowIndex][1] = list.get(1);
			allAccInfo[rowIndex][2] = list.get(2);
			allAccInfo[rowIndex][3] = list.get(3);
			allAccInfo[rowIndex][4] = list.get(4);
			allAccInfo[rowIndex][5] = list.get(5);
             rowIndex++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "文件读取失败！");
			e.printStackTrace();
		} 
	}
	
	//决定表格的行数
	@Override
	public int getRowCount() {
		return allAccInfo.length;
	}

	//表格的列数
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	//为表格填充数据
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return allAccInfo[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	public static void main(String[] args) {
		new AccountTableModel("");
	}
	
}
