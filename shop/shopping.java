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

public class shopping extends JFrame implements ActionListener{

	JTable table;
	JScrollPane js;
	JButton bu,buto,close;
	JLabel lbtitle,lnshoppingname,lbshopid,lbshopname,lbadd,lbprice,lbnum;
	JTextField shoppingname,shopid,shopname,price,num;
	JTableHeader head;
	JPanel panel;
	String title[]={"货号","货物名称","货物价格(元/千克)","货物储量(件)","销售总量(件)"};
	String data[][]=new String[90][5];
	String value[][];
	static int row=0;
	public shopping() {
		setTitle("货物管理");
		readfile();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("shop.png");
		setIconImage(image);
		//界面的控件布局
		panel = new JPanel(null);
		table = new JTable(data,title);
		table.setBounds(0, 50, 500, 300);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,16));
		
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(200,50,780, 292);
		
		panel.add(js);
		
		lbtitle = new JLabel("货物管理");
		lbtitle.setBounds(420, 10, 200, 30);
		lbtitle.setFont(new Font("楷体",Font.BOLD,24));
		panel.add(lbtitle);
		
		lbadd = new JLabel("新增货物");
		lbadd.setBounds(80, 60, 100, 30);
		panel.add(lbadd);
		
		lbshopid = new JLabel("货号:");
		lbshopid.setBounds(20, 120, 60, 30);
		panel.add(lbshopid);
		
		shopid = new JTextField();
		shopid.setBounds(60, 120, 120, 30);
		panel.add(shopid);
		
		lbshopname = new JLabel("名称");
		lbshopname.setBounds(20, 160, 60, 30);
		panel.add(lbshopname);
		
		shopname = new JTextField();
		shopname.setBounds(60, 160, 120, 30);
		panel.add(shopname);
		
		lbprice = new JLabel("价格");
		lbprice.setBounds(20, 200, 60, 30);
		panel.add(lbprice);
		
		price = new JTextField();
		price.setBounds(60, 200, 120, 30);
		panel.add(price);
		
		lbnum = new JLabel("储量");
		lbnum.setBounds(20, 240, 60, 30);
		panel.add(lbnum);
		
		num = new JTextField();
		num.setBounds(60, 240, 120, 30);
		panel.add(num);
		
		lnshoppingname = new JLabel("货物名称");
		lnshoppingname.setBounds(30, 400, 60, 30);
		panel.add(lnshoppingname);
		
		shoppingname = new JTextField();
		shoppingname.setBounds(100, 400, 150, 30);
		panel.add(shoppingname);
		
		bu = new JButton("查找");
		bu.setBounds(270, 400, 80, 30);
		panel.add(bu);
		
		close = new JButton("关闭");
		close.setBounds(380, 400, 80, 30);
		panel.add(close);
		
		buto = new JButton("新增货物");
		buto.setBounds(50, 300, 100, 30);
		panel.add(buto);
		
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
		new shopping();
	}
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
			String shopname = shoppingname.getText();
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][1].equals(shopname)){
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "货物存在，已经为你高亮显示");
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "货物不存在");
			return;
		}else if(e.getSource()==buto){
			if(shopid.getText().equals("")){
				JOptionPane.showMessageDialog(this, "货号不能为空");
				return;
			}else if (shopname.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "货物名称不能为空");
				return;
			}else if (price.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "价格不能为空");
				return;
			}else if (num.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "货物数量不能为空");
				return;
			}
			File file = new File("shopping.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				String string = shopid.getText()+","+shopname.getText()+","+price.getText()+","+num.getText()+";";
				byte b[]=string.getBytes();
				fos.write(b, 0, b.length);
				dispose();
				new shopping();
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
