package lunch;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import device.devicemanageradd;

public class lunchmanager extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table,table1;
	JScrollPane js,js1;
	JButton find,add,close,update,delete,sum,closeclass,addbranch;
	JLabel lbheadtitle,lb2;
	JTextField text;
	JTableHeader head,head1;
	JPanel panel;
	String title[]={"菜号","菜名称","价格"};
	String data[][]=new String[90][3];
	String value[][];
	String title1[]={"桌号","状态"};
	String data1[][]=new String[90][2];
	String value1[][];
	String temp[]= new String[3];
	String temp1[]= new String[2];
	static int row=0;
	@SuppressWarnings("deprecation")
	public lunchmanager() {
		/*
		 * 设计并编程实现一个小型餐厅管理系统。
		 * 选用Access数据库（或文件）存储餐厅里的菜单信息、
		 * 座位信息等；能实现菜单信息和座位的增、删、改、查，
		 * 以及座位保留和预订等功能。
		 * */
		//设置窗口标题
		setTitle("餐厅管理系统");
		readfile();
		//界面的控件布局
		panel = new JPanel(null);
		
		table = new JTable(data,title);
		table.setBounds(0, 60, 380, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,14));
		head = table.getTableHeader();
	    //设置表头的背景色
		head.setBackground(new Color(200, 200, 200));
	    //设置表头的文字颜色
		head.setFont(new Font("楷体",Font.BOLD,18));
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(30,80,600, 180);
		
		table1 = new JTable(data1,title1);
		table1.setBounds(460, 60, 350, 300);
		table1.setRowHeight(30);
		table1.setFont(new Font("楷体",Font.BOLD,14));
		head1 = table1.getTableHeader();
	    //设置表头的背景色
		head1.setBackground(new Color(200, 200, 200));
	    //设置表头的文字颜色
		head1.setFont(new Font("楷体",Font.BOLD,18));
		//滚动面板
		js1 = new JScrollPane(table1);
		js1.setBounds(30,270,600, 180);
		
		panel.add(js);
		panel.add(js1);
		
		lbheadtitle = new JLabel("餐厅管理系统");
		lbheadtitle.setBounds(320, 30, 200, 30);
		lbheadtitle.setFont(new Font("楷体",Font.BOLD,28));
		panel.add(lbheadtitle);
		
		add = new JButton("新增/修改菜单");
		add.setBounds(680, 80, 120, 30);
		panel.add(add);
		
		delete = new JButton("删除");
		delete.setBounds(680, 140, 120, 30);
		panel.add(delete);

		update = new JButton("修改");
		update.setBounds(680,200, 120, 30);
		panel.add(update);
		
		find = new JButton("查找");
		find.setBounds(680, 260, 120, 30);
		panel.add(find);
		
		sum = new JButton("预订餐桌");
		sum.setBounds(680, 320, 120, 30);
		panel.add(sum);
		
		
		addbranch = new JButton("新增/修改餐桌");
		addbranch.setBounds(680, 380, 120, 30);
		panel.add(addbranch);
		
		delete.addActionListener(this);
		update.addActionListener(this);
		find.addActionListener(this);
		add.addActionListener(this);
		sum.addActionListener(this);
		addbranch.addActionListener(this);
		add(panel);
		setSize(850, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new lunchmanager();
	}
	//读取文件，放入数组中，以便于后面的操作
	public void readfile(){
		try {
			File file = new File("lunch.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String username[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				username = str.split(";");
			}
			value = new String[username.length][3];
			for(int i=0;i<username.length;i++){
				try {
					value[i]=username[i].split(",");
					data[i]=username[i].split(",");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "系统繁忙，请稍后在试");
					return;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			File file = new File("banch.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String username[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				username = str.split(";");
			}
			value1 = new String[username.length][3];
			for(int i=0;i<username.length;i++){
				try {
					value1[i]=username[i].split(",");
					data1[i]=username[i].split(",");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "系统繁忙，请稍后在试");
					return;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//事件处理
	public void actionPerformed(ActionEvent e) {
		//查找设备
		if(e.getSource()==find){
			String deviceid="";
			String id = JOptionPane.showInputDialog("输入1查找菜单，输入2查找餐桌");
			try {
				if(id.equals("1")){
					deviceid = JOptionPane.showInputDialog("请输入菜单号");
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(deviceid)){
								row++;
								table.setRowSelectionInterval(i,i);
								JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示","编号查询",JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					}
					JOptionPane.showMessageDialog(this, "无此菜单");
					return;
				}else{
					deviceid = JOptionPane.showInputDialog("请输入餐桌号");
					for(int i=0;i<value1.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value1[i][0].equals(deviceid)){
								row++;
								table1.setRowSelectionInterval(i,i);
								JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示","编号查询",JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
					}
					JOptionPane.showMessageDialog(this, "无此餐桌");
					return;
				}
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "无此餐桌");
				return;
			}
			//新增设备
		}else if(e.getSource()==add){
			dispose();
			new lunchmanageradd(-2);
			//修改设备
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			int index1=table1.getSelectedRow();
			if(index==-1 && index1==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要操作的内容");
				return;
			}
			if(index!=-1 && index1!=-1){
				JOptionPane.showMessageDialog(null, "不能同时操作两个内容");
				return;
				
			}
			if(index!=-1){
				dispose();
				new lunchmanageradd(index);
			}
			if(index1!=-1){
				dispose();
				new branchmanageradd(index1);
			}
			
		}else if (e.getSource()==delete) {
			int index=table.getSelectedRow();
			int index1=table1.getSelectedRow();
			if(index==-1 && index1==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要操作的内容");
				return;
			}
			if(index!=-1){
				String string = "";
				try {
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(data[index][0])){
								value[i][0].replace(data[index][0], "");
								value[i][1].replace(data[index][1], "");
								value[i][2].replace(data[index][2], "");
								table.setValueAt("", index, 0);
								table.setValueAt("", index, 1);
								table.setValueAt("", index, 2);
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
					File file = new File("lunch.txt");
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
					JOptionPane.showMessageDialog(null, "系统繁忙！");
				}
				new lunchmanager();
				
			}else {
				String string = "";
				try {
					for(int i=0;i<value1.length;i++){
						for(int j=0;j<value1[i].length;j++){
							if(value1[i][0].equals(data1[index1][0])){
								value1[i][0].replace(data1[index1][0], "");
								value1[i][1].replace(data1[index1][1], "");
								table1.setValueAt("", index1, 0);
								table1.setValueAt("", index1, 1);
								row++;
								continue;
							}
						}
					}
					for(int i=0;i<value1.length;i++){
						for(int j=0;j<value1[i].length;j++){
							if(i!=index1){
								if(j==value1[i].length-1){
									string+=value1[i][j]+";";
								}else {
									string+=value1[i][j]+",";
								}
							}
						}
					}
					File file = new File("banch.txt");
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
					JOptionPane.showMessageDialog(null, "系统繁忙！");
					e1.printStackTrace();
				}
				new lunchmanager();
			}
			
		}else if (e.getSource()==sum) {
			String str = "";
			for(int i=0;i<value1.length;i++){
				for(int j=0;j<value1[i].length;j++){
					if(value1[i][1].equals("空桌")){
						str +=value1[i][0]+"号桌 ";
						break;
					}
					row++;
				}
			}
			String banchid = JOptionPane.showInputDialog("请输入你要的预订的餐桌,空桌有"+str);
			try {
				for(int i=0;i<value1.length;i++){
					for(int j=0;j<value1[i].length;j++){
						if(value1[i][0].equals(banchid)){
							if(!value1[i][1].equals("空桌")){
								JOptionPane.showMessageDialog(null, "下手慢了喔！餐桌已经被人占用，请输入其他餐桌");
								return;
							}
							value1[i][1]="被预订";
							row++;
							break;
						}
					}
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "数据更新失败","错误警告",JOptionPane.ERROR_MESSAGE);
			}
			String value1String="";
				for(int i=0;i<value1.length;i++){
				for(int j=0;j<value1[i].length;j++){
					if(j==value1[i].length-1){
						value1String+=value1[i][j]+";";
					}else {
						value1String+=value1[i][j]+",";
					}
				}
			}
			File file1 = new File("banch.txt");
			try {
				FileOutputStream fos1 = new FileOutputStream(file1);
				byte b1[]=value1String.getBytes();
				fos1.write(b1, 0, b1.length);
				dispose();
				new lunchmanager();
				fos1.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			return;
		}else if (e.getSource()==addbranch) {
			dispose();
			new branchmanageradd(-2);
		}
	}
}
