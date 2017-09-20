package New;

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
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class First extends JFrame implements ActionListener{

	JPanel panel,panel1,panel2;
	JTabbedPane tabbedPane;
	JTable table,table1;
	JScrollPane js,js1;
	JButton bu,buto,find,delete,update;
	JLabel lbtitle,lnshoppingname,lbshopid,lbshopname,lbadd,lbprice,lbnum,bjimage;
	JTextField shoppingname,shopid,shopname,price,num;
	JTableHeader head,head1;
	JList list1,list2,list3,list4,list5; 
	String title[]={"货号","货名","价格","货余量","会员账号","付款时间"};
	String title1[]={"货号","货名","价格","储量","销量"};
	String data[][]=new String[90][6];
	String data1[][]=new String[90][6];
	String value[][];
	String value1[][];
	JLabel lbtitle1,vip,shoppingid1,shopnum,shopprice,summoney,yuer,lbinfo;
	JTextField vipcard,shopid1,shopnumtext,shoppricetext,sum,yu;
	JButton shop,manager,buy,zhangdan;
	JTextArea info;
	static int row=0;
	double money=0.0;
	String infomsg="";
	public First() {
		setTitle("卡片布局");
		readfile();
		//购买记录数据显示
		panel = new JPanel(null);
		panel1 = new JPanel(null);
		panel2 = new JPanel(null);
		
		panel.setBackground(Color.white);
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		table = new JTable(data,title);
		table.setBounds(0, 20, 100, 400);
		table.setRowHeight(30);
		table.setFont(new Font("楷体",Font.BOLD,16));
		table.setBackground(Color.white);
	
		head = table.getTableHeader();
	    //设置表头的背景色
		head.setBackground(Color.white);
	    //设置表头的文字颜色
		head.setFont(new Font("楷体",Font.BOLD,18));
		
		//滚动面板
		js = new JScrollPane(table);
		js.setBounds(0,20,780, 400);
		
		panel.add(js);
		
		
		
		//货物管理显示数据
		table1 = new JTable(data1,title1);
		table1.setBounds(0, 10, 100, 300);
		table1.setRowHeight(30);
		table1.setFont(new Font("楷体",Font.BOLD,16));
		table1.setBackground(Color.white);
		head1 = table1.getTableHeader();
	    //设置表头的背景色
		head1.setBackground(Color.white);
	    //设置表头的文字颜色
		head1.setFont(new Font("楷体",Font.BOLD,18));
		
		//滚动面板
		js1 = new JScrollPane(table1);
		js1.setBounds(0,10,780, 300);
		
		lbtitle = new JLabel("货物管理");
		lbtitle.setBounds(320, 310, 200, 30);
		lbtitle.setFont(new Font("楷体",Font.BOLD,24));
		panel1.add(lbtitle);
		
		buto = new JButton("新增货物");
		buto.setBounds(100, 360, 120, 30);
		panel1.add(buto);
		
		find = new JButton("查询货物");
		find.setBounds(260, 360, 120, 30);
		panel1.add(find);
		
		delete = new JButton("删除货物");
		delete.setBounds(440, 360, 120, 30);
		panel1.add(delete);
		
		update = new JButton("修改货物");
		update.setBounds(600, 360, 120, 30);
		panel1.add(update);
		
		//按钮事件的监听
		buto.addActionListener(this);
		find.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		
		panel1.add(js1);
	
		//客户收账操作页面
		lbtitle1 = new JLabel("超市收银系统");
		lbtitle1.setBounds(330, 20, 200, 30);
		lbtitle1.setFont(new Font("楷体",Font.BOLD,28));
		panel2.add(lbtitle1);
		
		vip = new JLabel("输入会员卡号");
		vip.setBounds(220, 70, 100, 30);
		panel2.add(vip);
		
		vipcard = new JTextField();
		vipcard.setBounds(330,  70, 240, 30);
		panel2.add(vipcard);
		
		shoppingid1 = new JLabel("输入货物编号");
		shoppingid1.setBounds(220, 110, 100, 30);
		panel2.add(shoppingid1);
		
		shopid = new JTextField();
		shopid.setBounds(330, 110, 240, 30);
		panel2.add(shopid);
		
		shopnum = new JLabel("输入购买数量");
		shopnum.setBounds(220, 150, 100, 30);
		panel2.add(shopnum);
		
		shopnumtext = new JTextField();
		shopnumtext.setBounds(330, 150, 240, 30);
		panel2.add(shopnumtext);
		
		shopprice = new JLabel("商品价格显示");
		shopprice.setBounds(220, 190, 100, 30);
		panel2.add(shopprice);
		
		shoppricetext = new JTextField();
		shoppricetext.setBounds(330, 190, 240, 30);
		shoppricetext.setEditable(false);
		panel2.add(shoppricetext);
		
		lbinfo = new JLabel("账单详情显示");
		lbinfo.setBounds(220, 230, 100, 30);
		panel2.add(lbinfo);
		
		info = new JTextArea();
		info.setBounds(330, 230, 240, 60);
		info.setBackground(Color.lightGray);
		panel2.add(info);
		
		
		shop = new JButton("结账");
		shop.setBounds(220, 330, 350, 30);
		shop.setFont(new Font("楷体",Font.BOLD,28));
		panel2.add(shop);
		
		shop.addActionListener(this);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("购买窗口", panel2);
		tabbedPane.addTab("购买记录", panel);
		tabbedPane.addTab("货物管理", panel1);
		tabbedPane.setBounds(0, 0, 800, 410);
		tabbedPane.setOpaque(false);
		add(tabbedPane);
		
		
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new First();
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
			value1 = new String[shopname.length][5];
			for(int i=0;i<shopname.length;i++){
				value1[i]=shopname[i].split(",");
				data1[i]=shopname[i].split(",");
			}
			br.close();
			file=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//处理事件
	public void actionPerformed(ActionEvent e) {
		//新增货物
		if(e.getSource()==buto){
			new shoppingadd(-2);
			dispose();
			//查找货物
		}else if (e.getSource()==find) {
			String string = JOptionPane.showInputDialog("请输入货号");
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][1].equals(string)){
						row++;
						table.setRowSelectionInterval(i,i);
						JOptionPane.showMessageDialog(this, "货物查询成功，已经为你选中");
						return;
					}
				}
			}
			//删除货物
		}else if (e.getSource()==delete) {
			int index=table1.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "请选择你要删除的数据","选择数据",JOptionPane.ERROR_MESSAGE);
				return;
				
			}
			String string = "";
			try {
				for(int i=0;i<value1.length;i++){
					for(int j=0;j<value1[i].length;j++){
						if(value1[i][0].equals(data1[index][0])){
							value1[i][0].replace(data1[index][0], "");
							value1[i][1].replace(data1[index][1], "");
							value1[i][2].replace(data1[index][2], "");
							value1[i][3].replace(data1[index][3], "");
							value1[i][4].replace(data1[index][4], "");
							table1.setValueAt("", index, 0);
							table1.setValueAt("", index, 1);
							table1.setValueAt("", index, 2);
							table1.setValueAt("", index, 3);
							table1.setValueAt("", index, 4);
							row++;
							continue;
						}
					}
				}
				for(int i=0;i<value1.length;i++){
					for(int j=0;j<value1[i].length;j++){
						if(i!=index){
							if(j==value1[i].length-1){
								string+=value1[i][j]+";";
							}else {
								string+=value1[i][j]+",";
							}
						}
					}
				}
				File file = new File("shopping.txt");
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
				JOptionPane.showMessageDialog(null, "数据出错！");
			}
			new First();
			//修改货物
		}else if (e.getSource()==update) {
			int index=table1.getSelectedRow();
			System.out.println(index+"^^^^^^^^^^");
			if(index==-1){
				JOptionPane.showMessageDialog(null, "请选择你要修改的数据","选择数据",JOptionPane.ERROR_MESSAGE);
				return;
			}
			dispose();
			//将索引传输到新增货物的窗口中
			new shoppingadd(index);
		}else if(e.getSource()==shop){
			String vipid =  vipcard.getText();
			boolean isexit=false;
			for(int i=0;i<value1.length;i++){
				for(int j=0;j<value1[i].length;j++){
					if(value1[i][1].equals(vipid)){
						isexit=true;
					}
				}
			}
			String shopnum = shopid.getText();
			String price="";
			String shopname="";
			String sumshopping="";
			for(int i=0;i<value1.length;i++){
				for(int j=0;j<value1[i].length;j++){
					if(value1[i][0].equals(shopnum)){
						price=value1[i][2];
						shopname=value1[i][1];
						sumshopping=value1[i][3];
					}
				}
			}
			shoppricetext.setText(price);
			String shopnumber = shopnumtext.getText();
			if(shopnumber.equals("")){
				JOptionPane.showMessageDialog(this, "请输入购买数量");
				return;
			}
			//购买商品总消费
			double sum = Integer.parseInt(shopnumber)*Double.parseDouble(price);
			//非会员购买
			if(sum<200 && vipcard.getText().equals("")){
				String str = "购买记录\n商品名称："+shopname+"          商品价格："+price+"元/件\n购买商品数量："+shopnumber+"件          总消费："+sum+"元";
				infomsg=str;
				info.setText(str);
				money = sum;
			}else {
				//会员购买
				String str ="购买记录\n商品名称："+shopname+"          商品价格："+price+"元/件\n购买商品数量："+shopnumber+"件          总消费(vip)："+(sum*0.9)+"元";
				infomsg=str;
				info.setText(str);
				money = sum*0.9;
			}
			File file = new File("shoppingbuy.txt");
			String string="";
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				if(!vipcard.getText().equals("")){
					string = shopnum+","+shopname+","+price+","+(Integer.parseInt(sumshopping)-Integer.parseInt(shopnumber))+","+vipcard.getText()+","+new Date().toLocaleString()+";";
				}else {
					//非会员购买获取了一张会员卡
					if(sum>=200 && vipcard.getText().equals("")){
						int numcard = new Random().nextInt(89999999)+10000000;
						string = shopnum+","+shopname+","+price+","+(Integer.parseInt(sumshopping)-Integer.parseInt(shopnumber))+","+(numcard)+";";
						JOptionPane.showMessageDialog(this, "你的消费超过200元获得一张会员卡，卡号为：vip"+numcard+"以后购买商品九折优惠");
					}
				}
				byte b[]=string.getBytes();
				fos.write(b, 0, b.length);
				fos.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			//货物管理
		}
		
	}
}
