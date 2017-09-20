package shopping;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class buy extends JFrame{

	JTable table;
	JScrollPane js;
	JTableHeader head;
	JLabel biaoti;
	JPanel panel;
	String title[]={"货号","货物名称","货物价格","货物剩余量","会员卡号(消费者)","付款时间"};
	String data[][]=new String[90][6];
	String value[][];
	static int row=0;
	public buy() {
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
		js.setBounds(0,50,780, 400);
		
		biaoti = new JLabel("购买记录");
		biaoti.setBounds(350, 20, 100, 30);
		biaoti.setFont(new Font("华文行楷",Font.BOLD,18));
		panel.add(biaoti);
		
		panel.add(js);
		add(panel);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new buy();
	}
	public void readfile(){
		try {
			File file = new File("shoppingbuy.txt");
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
}
