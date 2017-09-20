package device;

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

import device.devicemanageradd;

import java.util.Date;

public class devicemanager extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane js;
	JButton find,add,close,update,delete,sum,closeclass;
	JLabel lbheadtitle,lb2;
	JTextField text;
	JTableHeader head;
	JPanel panel;
	String title[]={"设备编号","设备名称","领用人","所属部门","数量（件）","购买时间","价格(美元)"};
	String data[][]=new String[90][7];
	String value[][];
	String temp[]= new String[7];
	static int row=0;
	@SuppressWarnings("deprecation")
	public devicemanager() {
		//设置窗口标题
		setTitle("设备管理系统");
		readfile();
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
		js.setBounds(30,80,780, 292);
		
		panel.add(js);
		
		lbheadtitle = new JLabel("设备管理系统");
		lbheadtitle.setBounds(320, 30, 200, 30);
		lbheadtitle.setFont(new Font("楷体",Font.BOLD,28));
		panel.add(lbheadtitle);
		
		add = new JButton("新增/修改");
		add.setBounds(60, 400, 100, 30);
		panel.add(add);

		find = new JButton("查找设备");
		find.setBounds(500, 400, 90, 30);
		panel.add(find);
		
		update = new JButton("修改设备");
		update.setBounds(360, 400, 90, 30);
		panel.add(update);
		
		delete = new JButton("删除设备");
		delete.setBounds(220, 400, 90, 30);
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
		new devicemanager();
	}
	//读取文件，放入数组中，以便于后面的操作
	public void readfile(){
		try {
			File file = new File("device.txt");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//事件处理
	public void actionPerformed(ActionEvent e) {
		//查找设备
		if(e.getSource()==find){
			String deviceid = JOptionPane.showInputDialog("请输入设备编号");
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
			JOptionPane.showMessageDialog(this, "无此设备");
			return;
			//新增设备
		}else if(e.getSource()==add){
			dispose();
			new devicemanageradd(-2);
			//修改设备
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要修改的设备");
				return;
			}
			dispose();
			new devicemanageradd(index);
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
				File file = new File("device.txt");
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
			new devicemanager();
		}else if (e.getSource()==sum) {
			JOptionPane.showMessageDialog(null, "该功能在新增时已经注入，统计完成！");
			return;
		}
	}
}
