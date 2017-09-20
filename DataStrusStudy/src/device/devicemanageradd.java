package device;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lunch.lunchmanager;

public class devicemanageradd extends JFrame implements ActionListener{
	JPanel p1;
	JLabel bjimage;
	JLabel title, lbdeviceid, pass, lbdevicename, lbdepname, lbusername,lbnum,lbdate,lbprice;
	JTextField deviceid, devicename, depname, lbdepnameField,username,num,date,price;
	JButton add, quxiao;
	String data[][] = new String[90][7];
	String value[][];
	static int row=0;
	String  m="";
	public devicemanageradd(int n) {
		super("新增设备");
		p1 = new JPanel(null);
		readfile();
		//判断是新增还是修改
		if(n==-2){
			title = new JLabel("新增设备", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbdeviceid = new JLabel("设备编号：", JLabel.LEFT);
			lbdeviceid.setFont(new Font("黑体", Font.BOLD, 14));
			lbdeviceid.setBounds(10, 60, 80, 30);
			p1.add(lbdeviceid);

			deviceid = new JTextField();
			deviceid.setBounds(80, 65, 150, 25);
			p1.add(deviceid);

			lbdevicename = new JLabel("设备名称：", JLabel.LEFT);
			lbdevicename.setFont(new Font("黑体", Font.BOLD, 14));
			lbdevicename.setBounds(10, 100, 80, 30);
			p1.add(lbdevicename);

			devicename = new JTextField();
			devicename.setBounds(80, 105, 150, 25);
			p1.add(devicename);

			lbusername = new JLabel("领用人名：", JLabel.LEFT);
			lbusername.setFont(new Font("黑体", Font.BOLD, 14));
			lbusername.setBounds(10, 180, 80, 30);
			p1.add(lbusername);

			username = new JTextField();
			username.setBounds(80, 185, 150, 25);
			p1.add(username);

			lbdepname = new JLabel("所属部门：", JLabel.LEFT);
			lbdepname.setFont(new Font("黑体", Font.BOLD, 14));
			lbdepname.setBounds(10, 140, 80, 30);
			p1.add(lbdepname);

			depname = new JTextField();
			depname.setBounds(80, 145, 150, 25);
			p1.add(depname);
			
			lbnum = new JLabel("购买数量：", JLabel.LEFT);
			lbnum.setFont(new Font("黑体", Font.BOLD, 14));
			lbnum.setBounds(10, 220, 80, 30);
			p1.add(lbnum);

			num = new JTextField();
			num.setBounds(80, 225, 150, 25);
			p1.add(num);
			
			lbdate = new JLabel("购买时间：", JLabel.LEFT);
			lbdate.setFont(new Font("黑体", Font.BOLD, 14));
			lbdate.setBounds(10, 260, 80, 30);
			p1.add(lbdate);

			date = new JTextField();
			date.setBounds(80, 265, 150, 25);
			p1.add(date);
			
			lbprice = new JLabel("设备价格：", JLabel.LEFT);
			lbprice.setFont(new Font("黑体", Font.BOLD, 14));
			lbprice.setBounds(10, 300, 80, 30);
			p1.add(lbprice);

			price = new JTextField();
			price.setBounds(80, 305, 150, 25);
			p1.add(price);

			add = new JButton("新增");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 360, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 360, 80, 30);
			
		}else {
			title = new JLabel("修改设备", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbdeviceid = new JLabel("设备编号：", JLabel.LEFT);
			lbdeviceid.setFont(new Font("黑体", Font.BOLD, 14));
			lbdeviceid.setBounds(10, 60, 80, 30);
			p1.add(lbdeviceid);

			deviceid = new JTextField(data[n][0]);
			m=data[n][0];
			deviceid.setBounds(80, 65, 150, 25);
			p1.add(deviceid);

			lbdevicename = new JLabel("设备名称：", JLabel.LEFT);
			lbdevicename.setFont(new Font("黑体", Font.BOLD, 14));
			lbdevicename.setBounds(10, 100, 80, 30);
			p1.add(lbdevicename);

			devicename = new JTextField(data[n][1]);
			devicename.setBounds(80, 105, 150, 25);
			p1.add(devicename);

			lbusername = new JLabel("领用人名：", JLabel.LEFT);
			lbusername.setFont(new Font("黑体", Font.BOLD, 14));
			lbusername.setBounds(10, 140, 80, 30);
			p1.add(lbusername);

			username = new JTextField(data[n][2]);
			username.setBounds(80, 145, 150, 25);
			p1.add(username);

			lbdepname = new JLabel("所属部门：", JLabel.LEFT);
			lbdepname.setFont(new Font("黑体", Font.BOLD, 14));
			lbdepname.setBounds(10, 180, 80, 30);
			p1.add(lbdepname);

			depname = new JTextField(data[n][3]);
			depname.setBounds(80, 185, 150, 25);
			p1.add(depname);
			
			lbnum = new JLabel("购买数量：", JLabel.LEFT);
			lbnum.setFont(new Font("黑体", Font.BOLD, 14));
			lbnum.setBounds(10, 220, 80, 30);
			p1.add(lbnum);

			num = new JTextField(data[n][4]);
			num.setBounds(80, 225, 150, 25);
			p1.add(num);

			lbdate = new JLabel("购买时间：", JLabel.LEFT);
			lbdate.setFont(new Font("黑体", Font.BOLD, 14));
			lbdate.setBounds(10, 260, 80, 30);
			p1.add(lbdate);

			date = new JTextField(data[n][5]);
			date.setBounds(80, 265, 150, 25);
			p1.add(date);
			
			lbprice = new JLabel("设备价格：", JLabel.LEFT);
			lbprice.setFont(new Font("黑体", Font.BOLD, 14));
			lbprice.setBounds(10, 300, 80, 30);
			p1.add(lbprice);
			
			price = new JTextField(data[n][6]);
			price.setBounds(80, 305, 150, 25);
			p1.add(price);

			
			add = new JButton("修改");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 360, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 360, 80, 30);
		}
		p1.add(add);
		p1.add(quxiao);

		add(p1);
		setSize(260, 450);
		add.addActionListener(this);
		quxiao.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public static void main(String[] args) {
		new devicemanageradd(-2);
	}

	public void readfile() {
		try {
			File file = new File("device.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String shoplbdevicename[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				shoplbdevicename = str.split(";");
			}
			value = new String[shoplbdevicename.length][7];
			for (int i = 0; i < shoplbdevicename.length; i++) {
				value[i] = shoplbdevicename[i].split(",");
				data[i] = shoplbdevicename[i].split(",");
			}
			br.close();
			file = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		boolean isexit=false;
		if (e.getSource() == add) {
			if(add.getText().equals("新增")){
				if (deviceid.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "设备编号不能为空");
					return;
				} else if (devicename.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "设备名称不能为空");
					return;
				} else if (username.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "领用人不能为空");
					return;
				} else if (depname.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "部门名称不能为空");
					return;
				}else if (num.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "购买数量不能为空");
					return;
				}else if (date.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "购买时间不能为空");
					return;
				}else if (price.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "购买价格不能为空");
					return;
				}
				for(int i=0;i<value.length;i++){
					for(int j=0;j<value[i].length;j++){
						if(value[i][0].equals(deviceid.getText())){
							JOptionPane.showConfirmDialog(null, "该设备已经存在，确认购买将会叠加");
							value[i][4]=(Integer.parseInt(value[i][4])+Integer.parseInt(num.getText()))+"";
							row++;
							isexit=true;
							break;
						}
					}
				}
				//购买的设已经存在了
				if(isexit){
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
					File file1 = new File("device.txt");
					try {
						FileOutputStream fos1 = new FileOutputStream(file1);
						byte b1[]=valueString.getBytes();
						fos1.write(b1, 0, b1.length);
						dispose();
						new lunchmanager();
						fos1.close();
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}else{
					File file = new File("device.txt");
					FileOutputStream fos;
					try {
						fos = new FileOutputStream(file, true);
						String string = deviceid.getText() + "," + devicename.getText()
						+ "," + username.getText() + "," + depname.getText() + ","+num.getText()+","+date.getText()+","+price.getText()+";";
						byte b[] = string.getBytes();
						fos.write(b, 0, b.length);
						dispose();
						new lunchmanager();
						fos.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}else {
				try {
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(deviceid.getText())){
								value[i][0]=deviceid.getText();
								value[i][1]=devicename.getText();
								value[i][2]=username.getText();
								value[i][3]=depname.getText();
								value[i][4]=num.getText();
								value[i][5]=date.getText();
								value[i][6]=price.getText();
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
				File file1 = new File("device.txt");
				try {
					FileOutputStream fos1 = new FileOutputStream(file1);
					byte b1[]=valueString.getBytes();
					fos1.write(b1, 0, b1.length);
					dispose();
					new lunchmanager();
					fos1.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}

	}
}
