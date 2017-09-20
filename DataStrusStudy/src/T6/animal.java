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

public class animal extends JFrame implements ActionListener{

	JTable table;
	JScrollPane js;
	JButton bu,buto,close;
	JLabel lb1,lb2,lbname,lbtel,lbcolor,lbweight;
	JTextField text,name,tel,color,weight;
	JTableHeader head;
	JPanel panel;
	String title[]={"类型名称","年龄","毛色","重量"};
	String data[][]=new String[90][4];
	String value[][];
	static int row=0;
	public animal() {
		setTitle("动物管理");
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
		
		lb1 = new JLabel("动物管理");
		lb1.setBounds(360, 10, 200, 30);
		lb1.setFont(new Font("楷体",Font.BOLD,24));
		panel.add(lb1);
		
		lbname = new JLabel("名称");
		lbname.setBounds(30, 360, 60, 30);
		panel.add(lbname);
		
		name = new JTextField();
		name.setBounds(80, 360, 120, 30);
		panel.add(name);
		
		lbtel = new JLabel("年龄");
		lbtel.setBounds(210, 360, 60, 30);
		panel.add(lbtel);
		
		tel = new JTextField();
		tel.setBounds(230, 360, 120, 30);
		panel.add(tel);
		
		lbcolor = new JLabel("毛色");
		lbcolor.setBounds(360, 360, 60, 30);
		panel.add(lbcolor);
		
		color = new JTextField();
		color.setBounds(390, 360, 120, 30);
		panel.add(color);
		
		lbweight = new JLabel("重量");
		lbweight.setBounds(520, 360, 60, 30);
		panel.add(lbweight);
		
		weight = new JTextField();
		weight.setBounds(550, 360, 120, 30);
		panel.add(weight);
		
		buto = new JButton("新增");
		buto.setBounds(680, 360, 80, 30);
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
		new animal();
	}
	public void readfile(){
		try {
			File file = new File("animal.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str="";
			String Tel[]={};
			while ((string=br.readLine())!=null) {
				str+=string+";";
				Tel = str.split(";");
			}
			value = new String[Tel.length][4];
			for(int i=0;i<Tel.length;i++){
				value[i]=Tel[i].split(",");
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
					if(value[i][0].equals(name)){
						table.setValueAt(value[i][0], row, 0);
						table.setValueAt(value[i][1], row, 1);
						row++;
						table.setRowSelectionInterval(i,i);
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "无此动物");
			return;
		}else if(e.getSource()==buto){
			if(name.getText().equals("")){
				JOptionPane.showMessageDialog(this, "姓名为空");
				return;
			}else if (tel.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "年龄为空");
				return;
			}
			File file = new File("animal.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				String string = name.getText()+","+tel.getText()+","+color.getText()+","+weight.getText()+";";
				byte b[]=string.getBytes();
				fos.write(b, 0, b.length);
				dispose();
				new animal();
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
