package shopping;

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
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class shoppingselect extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,vip,shoppingid,shopnum,shopprice,summoney,yuer;
	JTextField vipcard,shopid,shopnumtext,shoppricetext,sum,yu;
	JButton shop,manager,buy,zhangdan;
	JTextArea info;
	JPanel panel;
	String data[][]=new String[90][6];
	String value[][];
	static int row=0;
	double money=0.0;
	String infomsg="";
	public shoppingselect() {
		setTitle("超市收银系统");
		readfile();
		//图标显示
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("shop.png");
		setIconImage(image);
		panel = new JPanel(null);
		
		title = new JLabel("超市收银系统");
		title.setBounds(130, 20, 100, 30);
		panel.add(title);
		
		vip = new JLabel("会员卡号入口");
		vip.setBounds(20, 70, 100, 30);
		panel.add(vip);
		
		vipcard = new JTextField();
		vipcard.setBounds(100,  70, 140, 30);
		panel.add(vipcard);
		
		shoppingid = new JLabel("货物编号入口");
		shoppingid.setBounds(20, 110, 100, 30);
		panel.add(shoppingid);
		
		shopid = new JTextField();
		shopid.setBounds(100, 110, 140, 30);
		panel.add(shopid);
		
		shopnum = new JLabel("购买数量入口");
		shopnum.setBounds(20, 150, 100, 30);
		panel.add(shopnum);
		
		shopnumtext = new JTextField();
		shopnumtext.setBounds(100, 150, 140, 30);
		panel.add(shopnumtext);
		
		shopprice = new JLabel("商品价格入口");
		shopprice.setBounds(20, 190, 100, 30);
		panel.add(shopprice);
		
		shoppricetext = new JTextField();
		shoppricetext.setBounds(100, 190, 140, 30);
		shoppricetext.setEditable(false);
		panel.add(shoppricetext);
		
		summoney = new JLabel("顾客付钱入口");
		summoney.setBounds(20, 230, 100, 30);
		panel.add(summoney);
		
		sum = new JTextField();
		sum.setBounds(100, 230, 140, 30);
		panel.add(sum);

		yuer = new JLabel("找零总数入口");
		yuer.setBounds(20, 270, 100, 30);
		panel.add(yuer);
		
		yu = new JTextField();
		yu.setBounds(100, 270, 140, 30);
		panel.add(yu);
		
		shop = new JButton("结账");
		shop.setBounds(10, 330, 60, 30);
		panel.add(shop);
		
		manager = new JButton("我的仓库");
		manager.setBounds(80, 330, 100, 30);
		panel.add(manager);
		
		buy = new JButton("找零");
		buy.setBounds(190, 330, 100, 30);
		panel.add(buy);
		
		zhangdan = new JButton("更多账单");
		zhangdan.setBounds(300, 330, 100, 30);
		panel.add(zhangdan);
		
		info = new JTextArea("账单显示区");
		info.setBounds(260, 70, 200, 230);
		info.setEditable(false);
		panel.add(info);
		
		add(panel);
		
		shop.addActionListener(this);
		manager.addActionListener(this);
		buy.addActionListener(this);
		zhangdan.addActionListener(this);
		setSize(500,400);
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
				String str = "购买记录\n商品名称："+shopname+"\n商品价格："+price+"\n购买商品数量："+shopnumber+"\n总消费："+sum+"\n实付："+sum+"\n付账时间："+new Date().toLocaleString();
				infomsg=str;
				info.setText(str);
				money = sum;
			}else {
				//会员购买
				String str ="购买记录\n商品名称："+shopname+"\n商品价格："+price+"\n购买商品数量："+shopnumber+"\n总消费："+sum+"\n实付："+sum+"\nVIP专享："+(sum*0.9)+"\n付账时间："+new Date().toLocaleString();
				infomsg=str;
				info.setText(str);
				money = sum*0.9;
			}
			File file = new File("shoppingbuy.txt");
			String string="";
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				if(isexit){
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
		}else if (e.getSource()==manager) {
			new shopping();
			//找钱
		}else if (e.getSource()==buy) {
			if(sum.getText().equals("")){
				JOptionPane.showMessageDialog(null, "请输入客户付款总数");
				return;
			}
			yu.setText((Double.parseDouble(sum.getText())-money)+"");
			info.setText(infomsg+"\n客户付款总数："+sum.getText()+"\n找零："+(Double.parseDouble(sum.getText())-money));
		}else if (e.getSource()==zhangdan) {
			new buy();
		}
	}
}
