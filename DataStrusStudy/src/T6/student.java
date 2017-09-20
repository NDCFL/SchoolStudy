package T6;

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

public class student extends JFrame implements ActionListener{

	JTable table;
	JScrollPane js;
	JButton bu,buto,close;
	JLabel lb1,lb2,lbname,lbtel;
	JTextField text,name,tel;
	JTableHeader head;
	JPanel panel;
	String title[]={"学号","姓名","性别","年龄","专业","电话"};
	String data[][]=new String[90][6];
	String value[][];
	static int row=0;
	public student() {
		setTitle("学生管理");
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("tel.png");
		setIconImage(image);
		//界面的控件布局
		panel = new JPanel(null);
		table = new JTable(data,title);
		table.setBounds(0, 50, 500, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,16));
		
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(0,50,780, 292);
		
		panel.add(js);
		
		lb1 = new JLabel("学生管理");
		lb1.setBounds(160, 10, 200, 30);
		lb1.setFont(new Font("楷体",Font.BOLD,24));
		panel.add(lb1);
		
		lbname = new JLabel("姓名");
		lbname.setBounds(30, 360, 60, 30);
		panel.add(lbname);
		
		name = new JTextField();
		name.setBounds(80, 360, 120, 30);
		panel.add(name);
		
		lbtel = new JLabel("Tel");
		lbtel.setBounds(210, 360, 60, 30);
		panel.add(lbtel);
		
		tel = new JTextField();
		tel.setBounds(230, 360, 120, 30);
		panel.add(tel);
		
		buto = new JButton("新增");
		buto.setBounds(380, 360, 80, 30);
		panel.add(buto);
		
		lb2 = new JLabel("姓名");
		lb2.setBounds(30, 400, 60, 30);
		panel.add(lb2);
		
		text = new JTextField();
		text.setBounds(80, 400, 150, 30);
		panel.add(text);
		
		bu = new JButton("查找");
		bu.setBounds(270, 400, 80, 30);
		panel.add(bu);
		
		close = new JButton("关闭");
		close.setBounds(380, 400, 80, 30);
		panel.add(close);
		
		bu.addActionListener(this);
		buto.addActionListener(this);
		close.addActionListener(this);
		add(panel);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new student();
	}
	public void readfile(){
		try {
			File file = new File("student.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String Tel[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				Tel = str.split(";");
			}
			value = new String[Tel.length][6];
			for(int i=0;i<Tel.length;i++){
//				value[i]=Tel[i].split(",");
				data[i]=Tel[i].split(",");
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
			String name = text.getText();
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][1].equals(name)){
						table.setValueAt(value[i][0], row, 0);
						table.setValueAt(value[i][1], row, 1);
						row++;
						table.setRowSelectionInterval(i,i);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "无此人");
			return;
		}else if(e.getSource()==buto){
			if(name.getText().equals("")){
				JOptionPane.showMessageDialog(this, "姓名为空");
				return;
			}else if (tel.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Tel为空");
				return;
			}
			File file = new File("student.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				String string = name.getText()+","+tel.getText()+";";
				byte b[]=string.getBytes();
				fos.write(b, 0, b.length);
				dispose();
				new Telephone();
				fos.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}else if (e.getSource()==close) {
			System.exit(0);
		}
		
	}
}
