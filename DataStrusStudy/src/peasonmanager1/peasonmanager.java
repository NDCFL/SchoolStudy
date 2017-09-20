package peasonmanager1;

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
	String title[]={"工资收入","理财收入","日常支出","固定支出","投资支出"};
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
		lbheadtitle.setForeground(Color.BLUE);
		//放入面板
		panel.add(lbheadtitle);
		
		lbtitle = new JLabel("个人账单");
		lbtitle.setBounds(650, 50, 140, 30);
		lbtitle.setForeground(Color.BLUE);
		lbtitle.setFont(new Font("楷体",Font.BOLD,20));
		panel.add(lbtitle);
		
		lbgongzi = new JLabel("工资收入:");
		lbgongzi.setBounds(610, 90, 80, 30);
		lbgongzi.setForeground(Color.pink);
		panel.add(lbgongzi);
		
		gongzi = new JTextField();
		gongzi.setBounds(690, 90, 120, 30);
		panel.add(gongzi);
		
		
		lblicai = new JLabel("理财收入:");
		lblicai.setBounds(610, 130, 80, 30);
		lblicai.setForeground(Color.green);
		panel.add(lblicai);
		
		licai = new JTextField();
		licai.setBounds(690, 130, 120, 30);
		panel.add(licai);
		
		zhicu = new JLabel("                消费记录填写:");
		zhicu.setForeground(Color.gray);
		zhicu.setBounds(610, 160, 150, 30);
		panel.add(zhicu);
		
		lbrichang = new JLabel("日常消费:");
		lbrichang.setBounds(610, 200, 80, 30);
		lbrichang.setForeground(Color.LIGHT_GRAY);
		panel.add(lbrichang);
		
		richang = new JTextField();
		richang.setBounds(690, 200, 120, 30);
		panel.add(richang);
		
		lbguding = new JLabel("固定支出:");
		lbguding.setBounds(610, 240, 90, 30);
		lbguding.setForeground(Color.ORANGE);
		panel.add(lbguding);
		
		guding = new JTextField();
		guding.setBounds(690, 240, 120, 30);
		panel.add(guding);
		
		lbtouzi = new JLabel("投资支出:");
		lbtouzi.setBounds(610, 280, 90, 30);
		lbtouzi.setForeground(Color.BLUE);
		lbtouzi.setForeground(Color.WHITE);
		panel.add(lbtouzi);
		
		touzi = new JTextField();
		touzi.setBounds(690, 280, 120, 30);
		panel.add(touzi);
		
		lbsumin = new JLabel("总收入:");
		lbsumin.setBounds(610, 320, 90, 30);
		lbsumin.setForeground(Color.pink);
		panel.add(lbsumin);
		
		sumin = new JTextField();
		sumin.setBounds(690, 320, 120, 30);
		sumin.setEditable(false);
		panel.add(sumin);
		
		lbsumout = new JLabel("最后收入:");
		lbsumout.setBounds(610, 360, 90, 30);
		lbsumout.setForeground(Color.green);
		panel.add(lbsumout);
		
		sumout = new JTextField();
		sumout.setBounds(690, 360, 120, 30);
		sumout.setEditable(false);
		panel.add(sumout);

		lbsuminfo = new JLabel("消费统计:");
		lbsuminfo.setBounds(610, 400, 90, 30);
		lbsuminfo.setForeground(Color.gray);
		panel.add(lbsuminfo);
		
		suminfo = new JTextField();
		suminfo.setBounds(690, 400, 120, 30);
		suminfo.setEditable(false);
		panel.add(suminfo);

		
		add = new JButton("新增/修改");
		add.setBounds(30, 400, 100, 30);
		add.setForeground(Color.pink);
		panel.add(add);

		find = new JButton("查找账单");
		find.setBounds(350, 400, 100, 30);
		find.setForeground(Color.green);
		panel.add(find);
		
		update = new JButton("修改账单");
		update.setBounds(250, 400, 90, 30);
		update.setForeground(Color.blue);
		panel.add(update);
		
		delete = new JButton("删除账单");
		delete.setBounds(150, 400, 90, 30);
		delete.setForeground(Color.pink);
		panel.add(delete);
		
		sum = new JButton("消费统计");
		sum.setBounds(460, 400, 90, 30);
		sum.setForeground(Color.cyan);
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
			//条件语句用于合法性的验证
			if(gongzi.getText().equals("")){
				JOptionPane.showMessageDialog(this, "工资收入不能为空！","工资收入为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(licai.getText().equals("")){
				JOptionPane.showMessageDialog(this, "理财投资不能为空！","理财收入为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (richang.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "日常支出不能为空！","日常支出为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (guding.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "固定支出不能为空！","固定支出为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (touzi.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "投资支出不能为空！","投资支出为空",JOptionPane.ERROR_MESSAGE);
				return;
			}
			boolean isadd=false;
			//对新增，和修改进行区分
			if(temp[5]==null || temp[5].equals("")){
				temp[5]="新增";
			}
			//修改操作
			if(temp[5].equals("修改")){
				try {
					String usergongzi = gongzi.getText();
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(usergongzi)){
								table.setValueAt(usergongzi, row, 0);
								table.setValueAt(licai.getText(), row, 1);
								table.setValueAt(richang.getText(), row, 2);
								table.setValueAt(guding.getText(), row, 3);
								table.setValueAt(touzi.getText(), row, 4);
								value[i][0]=gongzi.getText();
								value[i][1]=licai.getText();
								value[i][2]=richang.getText();
								value[i][3]=guding.getText();
								value[i][4]=touzi.getText();
								row++;
								break;
							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "系统繁忙");
				}
				
			}
			//新增操作
			if(temp[5].equals("新增")){
				//实例化文件对象
				File file = new File("peason.txt");
				//实例化字节流
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file,true);
					//获取用户输入的数据
					String string = gongzi.getText()+","+licai.getText()+","+richang.getText()+","+guding.getText()+","+touzi.getText()+";";
					byte b[]=string.getBytes();
					//数据写入文件中
					fos.write(b, 0, b.length);
					//隐藏当前窗口
					dispose();
					//重新调用构造方法，刷新界面
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
				File file1 = new File("peason.txt");
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
			//修改账单
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要修改的账单记录");
				return;
			}
			//将用户选中的数据，放入到文本框中
			gongzi.setText(data[index][0]);
			licai.setText(data[index][1]);
			richang.setText(data[index][2]);
			guding.setText(data[index][3]);
			touzi.setText(data[index][4]);
			temp[0]=data[index][0];
			temp[1]=data[index][1];
			temp[2]=data[index][2];
			temp[3]=data[index][3];
			temp[4]=data[index][4];
			temp[5]="修改";
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
