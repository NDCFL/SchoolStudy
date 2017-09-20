package shopping;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import shopping.shoppingadd;

public class shopping extends JFrame implements ActionListener{

	JTable table;
	JScrollPane js;
	JButton bu,buto,find,delete,update;
	JLabel lbtitle,lnshoppingname,lbshopid,lbshopname,lbadd,lbprice,lbnum;
	JTextField shoppingname,shopid,shopname,price,num;
	JTableHeader head;
	JPanel panel;
	//页面表格的标题
	String title[]={"货号","货物名称","货物价格(元/千克)","货物储量(件)","销售总量(件)"};
	//页面的数据
	public String data[][]=new String[90][5];
	public String value[][];
	//临时存储的临时数组
	public String temp[]=new String[6];;
	static int row=0;
	public shopping() {
		//设置标题
		setTitle("货物管理");
		//读取文件，将文件中的数据放入到data二维数组中，显示在表格中
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("shop.png");
		setIconImage(image);
		//界面的控件布局，绝对布局，实例化面板
		panel = new JPanel(null);
		//将表头文字和数据放入到表格控件中
		table = new JTable(data,title);
		//设置位置
		table.setBounds(0, 50, 500, 300);
		//设置行高
		table.setRowHeight(30);
		//设置字体，楷体，加粗，16号字体
		table.setFont(new Font("楷体",Font.BOLD,16));
		
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(10,120,760, 322);
		
		panel.add(js);
		
		/*
		 * new J控件：new JLabel("货物管理");都是进行控件的实例化
		 * setBounds(320, 10, 200, 30);都是进行控件的位置设置
		 * panel.add(find);将控件放入到面板中
		 * */
		
		lbtitle = new JLabel("货物管理");
		lbtitle.setBounds(320, 10, 200, 30);
		lbtitle.setFont(new Font("楷体",Font.BOLD,24));
		panel.add(lbtitle);
		
		buto = new JButton("新增货物");
		buto.setBounds(100, 60, 120, 30);
		panel.add(buto);
		
		find = new JButton("查询货物");
		find.setBounds(260, 60, 120, 30);
		panel.add(find);
		
		delete = new JButton("删除货物");
		delete.setBounds(440, 60, 120, 30);
		panel.add(delete);
		
		update = new JButton("修改货物");
		update.setBounds(600, 60, 120, 30);
		panel.add(update);
		
		//按钮事件的监听
		buto.addActionListener(this);
		find.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		add(panel);
		//窗口大小的设置长800,宽500
		setSize(800, 500);
		//显示窗口
		setVisible(true);
		//居中显示
		setLocationRelativeTo(null);
		//关闭窗口，就关闭程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new shopping();
	}
	//读取文件
	public void readfile(){
		try {
			File file = new File("shopping.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String shopname[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				shopname = str.split(";");
			}
			value = new String[shopname.length][5];
			for(int i=0;i<shopname.length;i++){
				value[i]=shopname[i].split(",");
				data[i]=shopname[i].split(",");
			}
			br.close();
			file=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//处理事件
	public void actionPerformed(ActionEvent e) {
		//新增货物
		if(e.getSource()==buto){
			new shoppingadd(-2);
			dispose();
			//查找货物
		}else if (e.getSource()==find) {
			String string = JOptionPane.showInputDialog("请输入货号");
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][1].equals(string)){
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "货物查询成功，已经为你选中");
						return;
					}
				}
			}
			//删除货物
		}else if (e.getSource()==delete) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "请选择你要删除的数据","选择数据",JOptionPane.ERROR_MESSAGE);
				return;
				
			}
			String string = "";
			try {
				for(int i=0;i<value.length;i++){
					for(int j=0;j<value[i].length;j++){
						if(value[i][0].equals(data[index][0])){
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
				for(int i=0;i<value.length;i++){
					for(int j=0;j<value[i].length;j++){
						if(i!=index){
							if(j==value[i].length-1){
								string+=value[i][j]+";";
							}else {
								string+=value[i][j]+",";
							}
						}
					}
				}
				File file = new File("shopping.txt");
				try {
					FileOutputStream fos = new FileOutputStream(file);
					System.out.println("string="+string);
					byte b[]=string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					fos.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "数据出错！");
			}
			new shopping();
			//修改货物
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "请选择你要修改的数据","选择数据",JOptionPane.ERROR_MESSAGE);
				return;
			}
			dispose();
			//将索引传输到新增货物的窗口中
			new shoppingadd(index);
		}
		
	}
}
