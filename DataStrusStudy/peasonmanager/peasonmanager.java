package peasonmanager;

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
	JLabel zhicu,lbsuminfo,lbheadtitle,lb2,lbgongzi,lbrichang,lblicai,lbguding,lbtouzi,lbtitle,lbsumin,lbsumout;
	JTextField text,gongzi,richang,guding,touzi,sumin,licai,sumout,suminfo;
	JRadioButton man,weman;
	JTableHeader head;
	ButtonGroup bg;
	JPanel panel;
	String title[]={"工资进账","理财进账","日常出账","固定出账","投资出账"};
	String data[][]=new String[90][5];
	String value[][];
	String temp[]= new String[6];
	static int row=0;
	@SuppressWarnings("deprecation")
	public peasonmanager() {
		//设置窗口标题
		setTitle("个人小管家");
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("281128.jpg");
		setIconImage(image);
		//实例化一个面板，null代表的是绝对布局
		panel = new JPanel(null);
		//实例化表格控件，存放数据
		table = new JTable(data,title);
		//设置表格显示的位置，绝对布局
		table.setBounds(0, 60, 500, 300);
		//设置表格的行高为30个像素
		table.setRowHeight(30);
		//设置表格的字体，楷体，加粗，14号字体
		table.setFont(new Font("楷体",Font.BOLD,14));
		//获取表头
		head = table.getTableHeader();
	    //设置表头的背景色
		head.setBackground(new Color(200, 200, 200));
	    //设置表头的文字颜色
		head.setFont(new Font("楷体",Font.BOLD,18));
		//滚动面板
		js = new JScrollPane(table);
		//设置面板的位置
		js.setBounds(10,80,560, 292);
		
		//将滚动面板放入到panal面板中
		panel.add(js);
		
		//窗口中的标题
		lbheadtitle = new JLabel("个人小管家");
		//标题的位置
		lbheadtitle.setBounds(320, 30, 200, 30);
		//标题的字体
		lbheadtitle.setFont(new Font("楷体",Font.BOLD,28));
		//放入面板
		panel.add(lbheadtitle);
		
		lbtitle = new JLabel("个人账单");
		lbtitle.setBounds(650, 50, 140, 30);
		lbtitle.setFont(new Font("楷体",Font.BOLD,20));
		panel.add(lbtitle);
		
		
		lbsumin = new JLabel("总收入:");
		lbsumin.setBounds(610, 120, 90, 30);
		panel.add(lbsumin);
		
		sumin = new JTextField();
		sumin.setBounds(690, 120, 120, 30);
		sumin.setEditable(false);
		panel.add(sumin);
		
		lbsumout = new JLabel("最后收入:");
		lbsumout.setBounds(610, 220, 90, 30);
		panel.add(lbsumout);
		
		sumout = new JTextField();
		sumout.setBounds(690, 220, 120, 30);
		sumout.setEditable(false);
		panel.add(sumout);

		lbsuminfo = new JLabel("消费统计:");
		lbsuminfo.setBounds(610, 320, 90, 30);
		panel.add(lbsuminfo);
		
		suminfo = new JTextField();
		suminfo.setBounds(690, 320, 120, 30);
		suminfo.setEditable(false);
		panel.add(suminfo);

		
		add = new JButton("新增/修改");
		add.setBounds(30, 400, 100, 30);
		panel.add(add);

		find = new JButton("查找账单");
		find.setBounds(350, 400, 100, 30);
		panel.add(find);
		
		update = new JButton("修改账单");
		update.setBounds(250, 400, 90, 30);
		panel.add(update);
		
		delete = new JButton("删除账单");
		delete.setBounds(150, 400, 90, 30);
		panel.add(delete);
		
		sum = new JButton("消费统计");
		sum.setBounds(460, 400, 90, 30);
		panel.add(sum);
		
		//对按钮进行监听
		delete.addActionListener(this);
		update.addActionListener(this);
		find.addActionListener(this);
		add.addActionListener(this);
		sum.addActionListener(this);
		add(panel);
		//设置窗口大小
		setSize(850, 500);
		//显示窗口
		setVisible(true);
		//窗口在屏幕中间显示
		setLocationRelativeTo(null);
		//关闭窗口，关闭程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//主函数
	public static void main(String[] args) {
		new peasonmanager();
	}
	//读取文件，放入数组中，以便于后面的操作
	public void readfile(){
		try {
			File file = new File("peason.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String richang[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				richang = str.split(";");
			}
			value = new String[richang.length][5];
			for(int i=0;i<richang.length;i++){
				try {
					value[i]=richang[i].split(",");
					data[i]=richang[i].split(",");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "数据读取失败，请稍后在试");
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
		//查找记录
		if(e.getSource()==find){
			String gongziid = gongzi.getText();
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][0].equals(gongziid)){
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示","账单查询",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else if (value[i][1].equals(richang.getText())) {
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示","账单查询",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "无此设备");
			return;
			//新增记录
		}else if(e.getSource()==add){
			dispose();
			new peasonmanageradd(-2);
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要修改的账单记录");
				return;
			}
			dispose();
			new peasonmanageradd(index);
			//删除账单
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
				File file = new File("peason.txt");
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
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "请选择要统计的账单");
				return;
			}else{
				sumin.setText((Integer.parseInt(data[index][0])+Integer.parseInt(data[index][1]))+"");
				sumout.setText((Integer.parseInt(data[index][2])+Integer.parseInt(data[index][3])+Integer.parseInt(data[index][4]))+"");
				suminfo.setText((Integer.parseInt(sumin.getText())-Integer.parseInt(sumout.getText()))+"");
			}
			
		}
	}
}
