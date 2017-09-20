package shop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class shoppingselect extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,vip,shoppingid,shopnum,shopprice,lbinfo;
	JTextField vipcard,shopid,shopnumtext,shoppricetext;
	JButton shop,manager,buy;
	JPanel panel;
	JTextArea info;
	String data[][]=new String[90][6];
	String value[][];
	static int row=0;
	public shoppingselect() {
		setTitle("收银系统");
		readfile();
		panel = new JPanel(null);
		
		title = new JLabel("收银系统");
		title.setBounds(130, 20, 100, 30);
		panel.add(title);
		
		vip = new JLabel("会员卡号");
		vip.setBounds(20, 70, 60, 30);
		panel.add(vip);
		
		vipcard = new JTextField();
		vipcard.setBounds(100,  70, 240, 30);
		panel.add(vipcard);
		
		shoppingid = new JLabel("货物编号");
		shoppingid.setBounds(20, 110, 60, 30);
		panel.add(shoppingid);
		
		shopid = new JTextField();
		shopid.setBounds(100, 110, 240, 30);
		panel.add(shopid);
		
		shopnum = new JLabel("购买数量");
		shopnum.setBounds(20, 150, 60, 30);
		panel.add(shopnum);
		
		shopnumtext = new JTextField();
		shopnumtext.setBounds(100, 150, 240, 30);
		panel.add(shopnumtext);
		
		shopprice = new JLabel("商品价格");
		shopprice.setBounds(20, 190, 60, 30);
		panel.add(shopprice);
		
		shoppricetext = new JTextField();
		shoppricetext.setBounds(100, 190, 240, 30);
		shoppricetext.setEditable(false);
		panel.add(shoppricetext);
		
		lbinfo = new JLabel("购买信息");
		lbinfo.setBounds(20, 230, 60, 30);
		panel.add(lbinfo);
		
		info = new JTextArea();
		info.setBounds(100, 230, 240, 60);
		info.setEditable(false);
		panel.add(info);
		
		shop = new JButton("购买");
		shop.setBounds(10, 300, 100, 30);
		panel.add(shop);
		
		manager = new JButton("货物管理");
		manager.setBounds(130, 300, 100, 30);
		panel.add(manager);
		
		buy = new JButton("交易记录");
		buy.setBounds(240, 300, 90, 30);
		panel.add(buy);
		
		add(panel);
		
		shop.addActionListener(this);
		manager.addActionListener(this);
		buy.addActionListener(this);
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new shoppingselect();
	}
	public void readfile(){
		try {
			File file = new File("shopping.txt");
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
			}
			br.close();
			file=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==shop){
			String vipid =  vipcard.getText();
			boolean isexit=false;
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][1].equals(vipid)){
						isexit=true;
					}
				}
			}
			String shopnum = shopid.getText();
			String price="";
			String shopname="";
			String sumshopping="";
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][0].equals(shopnum)){
						price=value[i][2];
						shopname=value[i][1];
						sumshopping=value[i][3];
					}
				}
			}
			if(price.equals("")){
				JOptionPane.showMessageDialog(null, "货物不存在，请新增");
				return;
				
			}
			//查询仓库中关于此商品的数据
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					if(value[i][0].equals(shopnum)){
						//如果你购买的商品数量查过仓库储量，提示库存不足，停止运行
						value[i][3]=Integer.parseInt(value[i][3])-Integer.parseInt(shopnumtext.getText())+"";
						if(Integer.parseInt(value[i][3])<0){
							JOptionPane.showMessageDialog(null, "购买失败，库存不足");
							return;
						}
						//销量增加购买的数量值
						value[i][4]=Integer.parseInt(value[i][4])+Integer.parseInt(shopnumtext.getText())+"";
						row++;
						break;
					}
				}
			}
			//将修改后的储量，和销量更新到文件中
			String valueString="";
			for(int i=0;i<value.length;i++){
				for(int j=0;j<value[i].length;j++){
					//判断是否是最后一个字段，如果是加分号，否则用逗号分割
					if(j==value[i].length-1){
						valueString+=value[i][j]+";";
					}else {
						valueString+=value[i][j]+",";
					}
				}
			}
			File file1 = new File("shopping.txt");
			try {
				FileOutputStream fos1 = new FileOutputStream(file1);
				byte b1[]=valueString.getBytes();
				fos1.write(b1, 0, b1.length);
				fos1.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			shoppricetext.setText(price);
			String shopnumber = shopnumtext.getText();
			if(shopnumber.equals("")){
				JOptionPane.showMessageDialog(this, "请输入购买数量");
				return;
			}
			//计算总消费
			double sum = Integer.parseInt(shopnumber)*Double.parseDouble(price);
			//vip购买九折优惠
			if(!vipcard.getText().equals("")){
				info.setText("购买记录\n商品名称："+shopname+"      商品价格："+price+"元\n购买商品数量："+shopnumber+"件      总消费(VIP)："+sum*0.9+"元");
			}else{
				//非vip购买大于200元消费赠送vip会员卡，否则视为普通消费
				if(sum>=200){
					info.setText("购买记录\n商品名称："+shopname+"      商品价格："+price+"元\n购买商品数量："+shopnumber+"件      总消费(VIP)："+sum*0.9+"元");
				}else {
					info.setText("购买记录\n商品名称："+shopname+"      商品价格："+price+"元\n购买商品数量："+shopnumber+"件     总消费："+sum+"元");
				}
			}
			File file = new File("shoppingbuy.txt");
			String string="";
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				if(isexit){
					string = shopnum+","+shopname+","+price+","+(Integer.parseInt(sumshopping)-Integer.parseInt(shopnumber))+","+vipcard.getText()+";";
				}else {
					if(sum>=200){
						int numcard = new Random().nextInt(89999999)+10000000;
						string = shopnum+","+shopname+","+price+","+(Integer.parseInt(sumshopping)-Integer.parseInt(shopnumber))+","+(numcard)+";";
						JOptionPane.showMessageDialog(this, "你的消费超过200元获得一张会员卡，卡号为：vip"+numcard);
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
		}else if (e.getSource()==manager) {
			//进入货物管理
			new shopping();
		}else if (e.getSource()==buy) {
			//进入购买记录
			new buy();
		}
	}
}
