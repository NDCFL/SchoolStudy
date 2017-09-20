package T6;

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

public class peasonmanager extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane js;
	JButton find,add,close,update,delete,sum,closeclass;
	JLabel lbheadtitle,lb2,lbdevice,lbusername,lbdevicename,lbdeptname,lbnumber,lbtitle,lbdate,lbprice;
	JTextField text,device,username,deptname,number,date,devicename,price;
	JRadioButton man,weman;
	JTableHeader head;
	ButtonGroup bg;
	JPanel panel;
	String title[]={"设备号","设备名称","领用人","所属部门","数量","购买时间","价格"};
	String data[][]=new String[90][7];
	String value[][];
	String temp[]= new String[7];
	static int row=0;
	@SuppressWarnings("deprecation")
	public peasonmanager() {
		//设置窗口标题
		setTitle("设备管理系统");
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("281128.jpg");
		setIconImage(image);
		//界面的控件布局
		panel = new JPanel(null);
		table = new JTable(data,title);
		table.setBounds(0, 60, 500, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,14));
		head = table.getTableHeader();
	    //设置表头的背景色
		head.setBackground(new Color(200, 200, 200));
	    //设置表头的文字颜色
		head.setFont(new Font("楷体",Font.BOLD,18));
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(200,80,630, 292);
		
		panel.add(js);
		
		lbheadtitle = new JLabel("设备管理系统");
		lbheadtitle.setBounds(420, 30, 200, 30);
		lbheadtitle.setFont(new Font("楷体",Font.BOLD,24));
		panel.add(lbheadtitle);
		
		lbtitle = new JLabel("新增设备区");
		lbtitle.setBounds(50, 50, 120, 30);
		lbtitle.setFont(new Font("楷体",Font.BOLD,20));
		panel.add(lbtitle);
		
		lbdevice = new JLabel("编号:");
		lbdevice.setBounds(10, 90, 50, 30);
		panel.add(lbdevice);
		
		device = new JTextField();
		device.setBounds(60, 90, 120, 30);
		panel.add(device);
		
		
		lbdevicename = new JLabel("名称:");
		lbdevicename.setBounds(10, 130, 50, 30);
		panel.add(lbdevicename);
		
		devicename = new JTextField();
		devicename.setBounds(60, 130, 120, 30);
		panel.add(devicename);
		
		lbusername = new JLabel("领用人:");
		lbusername.setBounds(10, 170, 50, 30);
		panel.add(lbusername);
		
		username = new JTextField();
		username.setBounds(60, 170, 120, 30);
		panel.add(username);
		
		lbdeptname = new JLabel("部门:");
		lbdeptname.setBounds(10, 210, 60, 30);
		panel.add(lbdeptname);
		
		deptname = new JTextField();
		deptname.setBounds(60, 210, 120, 30);
		panel.add(deptname);
		
		lbnumber = new JLabel("数量:");
		lbnumber.setBounds(10, 250, 60, 30);
		panel.add(lbnumber);
		
		number = new JTextField();
		number.setBounds(60, 250, 120, 30);
		panel.add(number);
		
		lbdate = new JLabel("时间:");
		lbdate.setBounds(10, 290, 60, 30);
		panel.add(lbdate);
		
		date = new JTextField("自动生成");
		date.setBounds(60, 290, 120, 30);
		date.setEditable(false);
		panel.add(date);
		
		lbprice = new JLabel("价格:");
		lbprice.setBounds(10, 330, 60, 30);
		panel.add(lbprice);
		
		price = new JTextField();
		price.setBounds(60, 330, 120, 30);
		panel.add(price);
		
		add = new JButton("新增/修改");
		add.setBounds(60, 400, 100, 30);
		panel.add(add);

		find = new JButton("查找");
		find.setBounds(500, 400, 80, 30);
		panel.add(find);
		
		update = new JButton("修改");
		update.setBounds(360, 400, 80, 30);
		panel.add(update);
		
		delete = new JButton("删除");
		delete.setBounds(220, 400, 80, 30);
		panel.add(delete);
		
		sum = new JButton("设备统计");
		sum.setBounds(630, 400, 120, 30);
		panel.add(sum);
		
		
		delete.addActionListener(this);
		update.addActionListener(this);
		find.addActionListener(this);
		add.addActionListener(this);
		sum.addActionListener(this);
		add(panel);
		setSize(850, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new peasonmanager();
	}
	//读取文件，放入数组中，以便于后面的操作
	public void readfile(){
		try {
			File file = new File("info.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String username[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				username = str.split(";");
			}
			value = new String[username.length][7];
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
			file=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//事件处理
	public void actionPerformed(ActionEvent e) {
		//查找好友
		if(e.getSource()==find){
			String deviceid = device.getText();
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][0].equals(deviceid)){
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示","编号查询",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else if (value[i][1].equals(username.getText())) {
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示","名称查询",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "无此设备");
			return;
			//新增好友
		}else if(e.getSource()==add){
			if(device.getText().equals("")){
				JOptionPane.showMessageDialog(this, "设备编号为空！","编号为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (username.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "设备名称不能为空！","设备名称为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (deptname.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "部门名称不能为空！","部门名称为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (number.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "购买数量不能为空！","购买数量为空",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(!number.getText().equals("")){
				try {
					int num = Integer.parseInt(number.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "购买数量输入有误，只能输入整数！","购买数量输入错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			boolean isadd=false;
			String date = new Date().toLocaleString();
			if(temp[6]==null || temp[6].equals("")){
				temp[6]="新增";
			}
			if(temp[6].equals("新增")){
				try {
					//判断是否有重复的
					String userdevice = device.getText();
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(userdevice)){
								isadd=true;
								int num1 = Integer.parseInt(number.getText());
								int num2 = Integer.parseInt(value[i][4]);
								System.out.println("num1="+num1+";num2="+num2);
								table.setValueAt(userdevice, row, 0);
								table.setValueAt(devicename.getText(), row, 1);
								table.setValueAt(username.getText(), row, 2);
								table.setValueAt(deptname.getText(), row, 3);
								table.setValueAt((num1+num2)+"", row, 4);
								table.setValueAt(date, row, 5);
								table.setValueAt(price.getText(), row, 6);
								value[i][0]=device.getText();
								value[i][1]=devicename.getText();
								value[i][2]=username.getText();
								value[i][3]=deptname.getText();
								value[i][4]=(num1+num2)+"";
								value[i][5]=date;
								value[i][6]=price.getText();
								row++;
								break;
							}
						}
					}
					String valueString="";
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(j==value[i].length-1){
								valueString+=value[i][j]+";";
							}else {
								valueString+=value[i][j]+",";
							}
						}
					}
					if(isadd){
						File file1 = new File("info.txt");
						try {
							FileOutputStream fos1 = new FileOutputStream(file1);
							byte b1[]=valueString.getBytes();
							fos1.write(b1, 0, b1.length);
							dispose();
							new peasonmanager();
							fos1.close();
						}catch (Exception e1) {
							e1.printStackTrace();
						}
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "系统繁忙");
					return;
				}
				
			}
			if(temp[6].equals("修改")){
				try {
					String userdevice = device.getText();
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(userdevice)){
								table.setValueAt(userdevice, row, 0);
								table.setValueAt(devicename.getText(), row, 1);
								table.setValueAt(username.getText(), row, 2);
								table.setValueAt(deptname.getText(), row, 3);
								table.setValueAt(number.getText(), row, 4);
								table.setValueAt(date, row, 5);
								table.setValueAt(price.getText(), row, 6);
								value[i][0]=device.getText();
								value[i][1]=devicename.getText();
								value[i][2]=username.getText();
								value[i][3]=deptname.getText();
								value[i][4]=number.getText();
								value[i][5]=date;
								value[i][6]=price.getText();
								row++;
								break;
							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "系统繁忙");
				}
				
			}
			if(temp[6].equals("新增")){
				File file = new File("info.txt");
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file,true);
					String string = device.getText()+","+devicename.getText()+","+username.getText()+","+deptname.getText()+","+number.getText()+","+date+","+price.getText()+";";
					byte b[]=string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					new peasonmanager();
					fos.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else {
				String valueString="";
				for(int i=0;i<value.length;i++){
					for(int j=0;j<value[i].length;j++){
						if(j==value[i].length-1){
							valueString+=value[i][j]+";";
						}else {
							valueString+=value[i][j]+",";
						}
					}
				}
				File file1 = new File("info.txt");
				try {
					FileOutputStream fos1 = new FileOutputStream(file1);
					byte b1[]=valueString.getBytes();
					fos1.write(b1, 0, b1.length);
					dispose();
					new peasonmanager();
					fos1.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			//更新好友
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要修改的好友");
				return;
			}
			device.setText(data[index][0]);
			devicename.setText(data[index][1]);
			username.setText(data[index][2]);
			deptname.setText(data[index][3]);
			number.setText(data[index][4]);
			date.setText(data[index][5]);
			price.setText(data[index][6]);
			temp[0]=data[index][0];
			temp[1]=data[index][1];
			temp[2]=data[index][2];
			temp[3]=data[index][3];
			temp[4]=data[index][4];
			temp[5]=data[index][5];
			temp[6]="修改";
			//删除好友
		}else if (e.getSource()==delete) {
			int index=table.getSelectedRow();
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
							value[i][5].replace(data[index][5]+";","");
							value[i][6].replace(data[index][6]+";","");
							table.setValueAt("", index, 0);
							table.setValueAt("", index, 1);
							table.setValueAt("", index, 2);
							table.setValueAt("", index, 3);
							table.setValueAt("", index, 4);
							table.setValueAt("", index, 5);
							table.setValueAt("", index, 6);
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
				File file = new File("info.txt");
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
			new peasonmanager();
		}else if (e.getSource()==sum) {
			JOptionPane.showMessageDialog(null, "统计功能会自动实现");
			return;
		}
	}
}
