package shopping;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import T6.shopping;

public class shoppingadd extends JFrame implements ActionListener{
	JPanel p1;
	JLabel bjimage;
	JLabel title, lbshoppingid, pass, lbshopname, lbnum, lbprice,lbsumnum;
	JTextField shopid, shopname, num, lbnumField,price,sumnum;
	JButton add, quxiao;
	String data[][] = new String[90][5];
	String value[][];
	static int row=0;
	public shoppingadd(int n) {
		super("货物的新增");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("shop.png");
		setIconImage(image);
		p1 = new JPanel(null);
		readfile();
		//判断是新增还是修改
		if(n==-2){
			title = new JLabel("货物的新增", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			title.setForeground(Color.blue);
			p1.add(title);

			
			lbshoppingid = new JLabel("货   号：", JLabel.LEFT);
			lbshoppingid.setFont(new Font("黑体", Font.BOLD, 14));
			lbshoppingid.setForeground(Color.blue);
			lbshoppingid.setBounds(10, 60, 80, 30);
			p1.add(lbshoppingid);

			shopid = new JTextField();
			shopid.setBounds(80, 65, 150, 25);
			p1.add(shopid);

			lbshopname = new JLabel("名   称：", JLabel.LEFT);
			lbshopname.setFont(new Font("黑体", Font.BOLD, 14));
			lbshopname.setForeground(Color.blue);
			lbshopname.setBounds(10, 100, 80, 30);
			p1.add(lbshopname);

			shopname = new JTextField();
			shopname.setBounds(80, 105, 150, 25);
			p1.add(shopname);

			lbprice = new JLabel("价   格：", JLabel.LEFT);
			lbprice.setFont(new Font("黑体", Font.BOLD, 14));
			lbprice.setForeground(Color.blue);
			lbprice.setBounds(10, 140, 80, 30);
			p1.add(lbprice);

			price = new JTextField();
			price.setBounds(80, 145, 150, 25);
			p1.add(price);

			lbnum = new JLabel("储   量：", JLabel.LEFT);
			lbnum.setFont(new Font("黑体", Font.BOLD, 14));
			lbnum.setForeground(Color.blue);
			lbnum.setBounds(10, 180, 80, 30);
			p1.add(lbnum);

			num = new JTextField();
			num.setBounds(80, 185, 150, 25);
			p1.add(num);
			
			lbsumnum = new JLabel("销   量：", JLabel.LEFT);
			lbsumnum.setFont(new Font("黑体", Font.BOLD, 14));
			lbsumnum.setForeground(Color.blue);
			lbsumnum.setBounds(10, 220, 80, 30);
			p1.add(lbsumnum);

			sumnum = new JTextField();
			sumnum.setBounds(80, 225, 150, 25);
			p1.add(sumnum);

			add = new JButton("新增");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setForeground(Color.blue);
			add.setBounds(30, 260, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setForeground(Color.blue);
			quxiao.setBounds(120, 260, 80, 30);
			
		}else {
			
			
			
			title = new JLabel("货物的修改", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			title.setForeground(Color.blue);
			p1.add(title);

			
			lbshoppingid = new JLabel("货   号：", JLabel.LEFT);
			lbshoppingid.setFont(new Font("黑体", Font.BOLD, 14));
			lbshoppingid.setForeground(Color.blue);
			lbshoppingid.setBounds(10, 60, 80, 30);
			p1.add(lbshoppingid);

			shopid = new JTextField(data[n][0]);
			shopid.setBounds(80, 65, 150, 25);
			p1.add(shopid);

			lbshopname = new JLabel("名   称：", JLabel.LEFT);
			lbshopname.setFont(new Font("黑体", Font.BOLD, 14));
			lbshopname.setForeground(Color.blue);
			lbshopname.setBounds(10, 100, 80, 30);
			p1.add(lbshopname);

			shopname = new JTextField(data[n][1]);
			shopname.setBounds(80, 105, 150, 25);
			p1.add(shopname);

			lbprice = new JLabel("价   格：", JLabel.LEFT);
			lbprice.setFont(new Font("黑体", Font.BOLD, 14));
			lbprice.setForeground(Color.blue);
			lbprice.setBounds(10, 140, 80, 30);
			p1.add(lbprice);

			price = new JTextField(data[n][2]);
			price.setBounds(80, 145, 150, 25);
			p1.add(price);

			lbnum = new JLabel("储   量：", JLabel.LEFT);
			lbnum.setFont(new Font("黑体", Font.BOLD, 14));
			lbnum.setForeground(Color.blue);
			lbnum.setBounds(10, 180, 80, 30);
			p1.add(lbnum);

			num = new JTextField(data[n][3]);
			num.setBounds(80, 185, 150, 25);
			p1.add(num);
			
			lbsumnum = new JLabel("销   量：", JLabel.LEFT);
			lbsumnum.setFont(new Font("黑体", Font.BOLD, 14));
			lbsumnum.setForeground(Color.blue);
			lbsumnum.setBounds(10, 220, 80, 30);
			p1.add(lbsumnum);

			sumnum = new JTextField(data[n][4]);
			sumnum.setBounds(80, 225, 150, 25);
			p1.add(sumnum);

			add = new JButton("修改");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setForeground(Color.blue);
			add.setBounds(30, 260, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setForeground(Color.blue);
			quxiao.setBounds(120, 260, 80, 30);
		}
		p1.add(add);
		p1.add(quxiao);

		add(p1);
		setSize(260, 350);
		add.addActionListener(this);
		quxiao.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void beijin() {
		Icon icon = new ImageIcon("1.gif");
		bjimage = new JLabel(icon);
		add(bjimage);
	}

	public static void main(String[] args) {
		new shoppingadd(-2);
	}

	public void readfile() {
		try {
			File file = new File("shopping.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String shoplbshopname[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				shoplbshopname = str.split(";");
			}
			value = new String[shoplbshopname.length][5];
			for (int i = 0; i < shoplbshopname.length; i++) {
				value[i] = shoplbshopname[i].split(",");
				data[i] = shoplbshopname[i].split(",");
				System.out.println(data[i][0] + "-----");
			}
			br.close();
			file = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			if(add.getText().equals("新增")){
				if (shopid.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "货号不能为空");
					return;
				} else if (shopname.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "货物名称不能为空");
					return;
				} else if (price.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "价格不能为空");
					return;
				} else if (num.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "货物数量不能为空");
					return;
				}else if (sumnum.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "货物销量不能为空");
					return;
				}
				File file = new File("shopping.txt");
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file, true);
					String string = shopid.getText() + "," + shopname.getText()
					+ "," + price.getText() + "," + num.getText() + ","+sumnum.getText()+";";
					byte b[] = string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					new shopping();
					fos.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else {
				try {
					String shoppingid = shopid.getText();
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(shoppingid)){
								value[i][0]=shopid.getText();
								value[i][1]=shopname.getText();
								value[i][2]=price.getText();
								value[i][3]=num.getText();
								value[i][4]=sumnum.getText();
								row++;
								break;
							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "数据更新失败","错误警告",JOptionPane.ERROR_MESSAGE);
				}
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
				File file1 = new File("shopping.txt");
				try {
					FileOutputStream fos1 = new FileOutputStream(file1);
					byte b1[]=valueString.getBytes();
					fos1.write(b1, 0, b1.length);
					dispose();
					new shopping();
					fos1.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}

	}
}
