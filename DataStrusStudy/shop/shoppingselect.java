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
import javax.swing.JTextField;

public class shoppingselect extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,vip,shoppingid,shopnum,shopprice;
	JTextField vipcard,shopid,shopnumtext,shoppricetext;
	JButton shop,manager,buy;
	JPanel panel;
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
		vipcard.setBounds(100,  70, 140, 30);
		panel.add(vipcard);
		
		shoppingid = new JLabel("货物编号");
		shoppingid.setBounds(20, 110, 60, 30);
		panel.add(shoppingid);
		
		shopid = new JTextField();
		shopid.setBounds(100, 110, 140, 30);
		panel.add(shopid);
		
		shopnum = new JLabel("购买数量");
		shopnum.setBounds(20, 150, 60, 30);
		panel.add(shopnum);
		
		shopnumtext = new JTextField();
		shopnumtext.setBounds(100, 150, 140, 30);
		panel.add(shopnumtext);
		
		shopprice = new JLabel("商品价格");
		shopprice.setBounds(20, 190, 60, 30);
		panel.add(shopprice);
		
		shoppricetext = new JTextField();
		shoppricetext.setBounds(100, 190, 140, 30);
		shoppricetext.setEditable(false);
		panel.add(shoppricetext);
		
		shop = new JButton("购买");
		shop.setBounds(10, 260, 60, 30);
		panel.add(shop);
		
		manager = new JButton("货物管理");
		manager.setBounds(80, 260, 100, 30);
		panel.add(manager);
		
		buy = new JButton("交易记录");
		buy.setBounds(190, 260, 90, 30);
		panel.add(buy);
		
		add(panel);
		
		shop.addActionListener(this);
		manager.addActionListener(this);
		buy.addActionListener(this);
		setSize(300,350);
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
			if(!vipcard.getText().equals("")){
				if(isexit){
					JOptionPane.showMessageDialog(this, "欢迎会员光临！");
				}else {
					JOptionPane.showMessageDialog(this, "你不是会员！");
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
			System.out.println(shopnumber);
			double sum = Integer.parseInt(shopnumber)*Double.parseDouble(price);
			JOptionPane.showMessageDialog(this, "购买记录\n商品名称："+shopname+"\n商品价格："+price+"\n购买商品数量："+shopnumber+"\n总消费："+sum);
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
						JOptionPane.showMessageDialog(this, "你的消费超过200元获得一张会员卡，卡号为："+numcard);
					}
					
				}
				byte b[]=string.getBytes();
				fos.write(b, 0, b.length);
				dispose();
				fos.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}else if (e.getSource()==manager) {
			new shopping();
		}else if (e.getSource()==buy) {
			new buy();
		}
	}
}
