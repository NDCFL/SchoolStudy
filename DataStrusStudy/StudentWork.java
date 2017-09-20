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

import com.sun.org.apache.xml.internal.security.utils.IgnoreAllErrorHandler;

public class StudentWork extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane js;
	JButton bu,add,close,update,delete,sumgread,closeclass;
	JLabel lbheadtitle,lbstudentid,lbname,lbsex,lbmath,lbenglish;
	JTextField text,studentid,name,math,english;
	JRadioButton man,weman;
	JTableHeader head;
	ButtonGroup bg;
	JPanel panel;
	String title[]={"学生学号","学生姓名","学生性别","专业课出勤","其他课程出勤","出勤总分"};
	String data[][]=new String[90][6];
	String value[][];
	String temp[]= new String[6];
	static int row=0;
	public StudentWork() {
		setTitle("学生考勤管理");
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("8.JPG");
		setIconImage(image);
		//界面的控件布局
		panel = new JPanel(null);
		table = new JTable(data,title);
		table.setBounds(0, 50, 500, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,16));
		
		head = table.getTableHeader();
	    //设置表头的背景色
		head.setBackground(new Color(200, 200, 200));
	    //设置表头的文字颜色
		head.setForeground(Color.blue);
		head.setFont(new Font("楷体",Font.BOLD,18));
		table.setForeground(Color.blue);
		table.setFont(new Font("楷体",Font.BOLD,18));
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(10,150,765, 292);
		
		panel.add(js);
		
		lbheadtitle = new JLabel("学生考勤子系统");
		lbheadtitle.setBounds(320, 10, 200, 30);
		lbheadtitle.setFont(new Font("楷体",Font.BOLD,24));
		lbheadtitle.setForeground(Color.red);
		panel.add(lbheadtitle);
		
		lbstudentid = new JLabel("学号:");
		lbstudentid.setBounds(30, 50, 30, 30);
		lbstudentid.setForeground(Color.blue);
		panel.add(lbstudentid);
		
		studentid = new JTextField();
		studentid.setBounds(70, 50, 60, 30);
		panel.add(studentid);
		
		lbname = new JLabel("姓名:");
		lbname.setBounds(150, 50, 30, 30);
		lbname.setForeground(Color.red);
		panel.add(lbname);
		
		name = new JTextField();
		name.setBounds(190, 50, 60, 30);
		panel.add(name);
		
		lbsex = new JLabel("性别:");
		lbsex.setBounds(270, 50, 60, 30);
		lbsex.setForeground(Color.pink);
		panel.add(lbsex);
		
		man = new JRadioButton("男",true);
		man.setBounds(310, 50, 40, 30);
		man.setForeground(Color.pink);
		panel.add(man);
		
		weman = new JRadioButton("女",false);
		weman.setBounds(360, 50, 40, 30);
		weman.setForeground(Color.pink);
		panel.add(weman);
		
		bg = new ButtonGroup();
		bg.add(man);
		bg.add(weman);
		
		lbmath = new JLabel("专业课考勤:");
		lbmath.setBounds(410, 50, 80, 30);
		lbmath.setForeground(Color.CYAN);
		panel.add(lbmath);
		
		math = new JTextField();
		math.setBounds(490, 50, 70, 30);
		panel.add(math);
		
		lbenglish = new JLabel("其他课考勤:");
		lbenglish.setBounds(570, 50, 80, 30);
		lbenglish.setForeground(Color.green);
		panel.add(lbenglish);
		
		english = new JTextField();
		english.setBounds(650, 50, 70, 30);
		panel.add(english);
		
		add = new JButton("注册/修改");
		add.setBounds(30, 100, 120, 30);
		add.setForeground(Color.blue);
		add.setFont(new Font("楷体",Font.BOLD,18));
		panel.add(add);

		bu = new JButton("查找");
		bu.setBounds(470, 100, 80, 30);
		bu.setForeground(Color.CYAN);
		bu.setFont(new Font("楷体",Font.BOLD,18));
		panel.add(bu);
		
		update = new JButton("修改");
		update.setBounds(330, 100, 80, 30);
		update.setForeground(Color.pink);
		update.setFont(new Font("楷体",Font.BOLD,18));
		panel.add(update);
		
		delete = new JButton("删除");
		delete.setBounds(200, 100, 80, 30);
		delete.setForeground(Color.RED);
		delete.setFont(new Font("楷体",Font.BOLD,18));
		panel.add(delete);
		
		sumgread = new JButton("统计考勤");
		sumgread.setBounds(600, 100, 120, 30);
		sumgread.setForeground(Color.green);
		sumgread.setFont(new Font("楷体",Font.BOLD,18));
		panel.add(sumgread);
		
		
		delete.addActionListener(this);
		update.addActionListener(this);
		bu.addActionListener(this);
		add.addActionListener(this);
		sumgread.addActionListener(this);
		add(panel);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new StudentWork();
	}
	public void readfile(){
		try {
			File file = new File("timework.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String name[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				name = str.split(";");
			}
			value = new String[name.length][6];
			for(int i=0;i<name.length;i++){
				value[i]=name[i].split(",");
				data[i]=name[i].split(",");
				System.out.println(data[i][0]+"-----");
			}
			br.close();
			file=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bu){
			String studentidid = studentid.getText();
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][0].equals(studentidid)){
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示");
						return;
					}else if (value[i][1].equals(name.getText())) {
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示");
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "无此人");
			return;
		}else if(e.getSource()==add){
			if(studentid.getText().equals("")){
				JOptionPane.showMessageDialog(this, "学号不能为空","合法性验证",JOptionPane.WARNING_MESSAGE);
				return;
			}else if (name.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "姓名不能为空","合法性验证",JOptionPane.WARNING_MESSAGE);
				return;
			}else if (math.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "专业课程评分不能为空","合法性验证",JOptionPane.WARNING_MESSAGE);
				return;
			}else if (english.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "其他课程评分不能为空","合法性验证",JOptionPane.WARNING_MESSAGE);
				return;
			}else if (math.getText()!=null) {
				try{
					int num = Integer.parseInt(math.getText());
					if(num<0 || num>10){
						JOptionPane.showMessageDialog(this, "专业课程考勤输入有误,评分为10分以内的整数！","合法性验证",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "专业课程考勤输入有误！","合法性验证",JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			if (english.getText()!=null) {
				try{
					int num = Integer.parseInt(english.getText());
					System.out.println(num);
					if(num<0 || num>5){
						JOptionPane.showMessageDialog(this, "其他课程考勤输入有误,评分为5分以内的整数！","合法性验证",JOptionPane.WARNING_MESSAGE);
						return;
					}
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "其他课程考勤输入有误！","合法性验证",JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			File file = new File("timework.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				
				String sex="";
				if(man.isSelected()){
					sex="男";
				}else {
					sex="女";
				}
				String string = studentid.getText()+","+name.getText()+","+sex+","+math.getText()+","+english.getText()+",未评分;";
				byte b[]=string.getBytes();
				if(temp[5]==null || temp[5].equals("")){
					temp[5]="新增";
				}
				if(temp[5].equals("修改")){
					try {
						String userstudentid = studentid.getText();
						for(int i=0;i<value.length;i++){
							for(int j=0;j<value[i].length;j++){
								if(value[i][0].equals(userstudentid)){
									table.setValueAt(userstudentid, row, 0);
									table.setValueAt(name.getText(), row, 1);
									table.setValueAt(sex, row, 2);
									table.setValueAt(math.getText(), row, 3);
									table.setValueAt(english.getText(), row, 4);
									value[i][0]=studentid.getText();
									value[i][1]=name.getText();
									value[i][2]=sex;
									value[i][3]=math.getText();
									value[i][4]=english.getText();
									row++;
									break;
								}
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "系统繁忙","错误警告",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				if(temp[5].equals("新增")){
					fos.write(b, 0, b.length);
					dispose();
					new StudentWork();
					fos.close();
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
					File file1 = new File("timework.txt");
					try {
						FileOutputStream fos1 = new FileOutputStream(file1);
						byte b1[]=valueString.getBytes();
						fos1.write(b1, 0, b1.length);
						dispose();
						new StudentWork();
						fos1.close();
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}else if (e.getSource()==close) {
			System.exit(0);
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			studentid.setText(data[index][0]);
			name.setText(data[index][1]);
			if(data[index][2].equals("男")){
				man.setSelected(true);
			}else {
				weman.setSelected(true);
			}
			math.setText(data[index][3]);
			english.setText(data[index][4]);
			temp[0]=data[index][0];
			temp[1]=data[index][1];
			temp[2]=data[index][2];
			temp[3]=data[index][3];
			temp[4]=data[index][4];
			temp[5]="修改";
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
							table.setValueAt("", index, 0);
							table.setValueAt("", index, 1);
							table.setValueAt("", index, 2);
							table.setValueAt("", index, 3);
							table.setValueAt("", index, 4);
							table.setValueAt("", index, 5);
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
				File file = new File("timework.txt");
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
			new StudentWork();
		}else if (e.getSource()==sumgread) {
			String valueString="";
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(j==value[i].length-1){
						valueString+=(Integer.parseInt(value[i][3])+Integer.parseInt(value[i][4]))+";";
					}else {
						valueString+=value[i][j]+",";
					}
				}
			}
			File file1 = new File("timework.txt");
			try {
				FileOutputStream fos1 = new FileOutputStream(file1);
				byte b1[]=valueString.getBytes();
				fos1.write(b1, 0, b1.length);
				dispose();
				new StudentWork();
				fos1.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
