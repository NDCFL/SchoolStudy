package lunch;

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

public class lunchmanageradd extends JFrame implements ActionListener{
	JPanel p1;
	JLabel bjimage;
	JLabel title, lblunchid, pass, lblunchname, lbprice;
	JTextField lunchid, lunchname, depname,price;
	JButton add, quxiao;
	String data[][] = new String[90][7];
	String value[][];
	static int row=0;
	String  m="";
	public lunchmanageradd(int n) {
		super("新增菜单");
		p1 = new JPanel(null);
		readfile();
		//判断是新增还是修改
		if(n==-2){
			title = new JLabel("新增菜单", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lblunchid = new JLabel("菜单编号：", JLabel.LEFT);
			lblunchid.setFont(new Font("黑体", Font.BOLD, 14));
			lblunchid.setBounds(10, 60, 80, 30);
			p1.add(lblunchid);

			lunchid = new JTextField();
			lunchid.setBounds(80, 65, 150, 25);
			p1.add(lunchid);

			lblunchname = new JLabel("菜单名称：", JLabel.LEFT);
			lblunchname.setFont(new Font("黑体", Font.BOLD, 14));
			lblunchname.setBounds(10, 100, 80, 30);
			p1.add(lblunchname);

			lunchname = new JTextField();
			lunchname.setBounds(80, 105, 150, 25);
			p1.add(lunchname);

			lbprice = new JLabel("价格：", JLabel.LEFT);
			lbprice.setFont(new Font("黑体", Font.BOLD, 14));
			lbprice.setBounds(10, 140, 80, 30);
			p1.add(lbprice);

			price = new JTextField();
			price.setBounds(80, 145, 150, 25);
			p1.add(price);

			add = new JButton("新增");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 200, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 200, 80, 30);
			
		}else{
			title = new JLabel("修改菜单", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lblunchid = new JLabel("菜单编号：", JLabel.LEFT);
			lblunchid.setFont(new Font("黑体", Font.BOLD, 14));
			lblunchid.setBounds(10, 60, 80, 30);
			p1.add(lblunchid);

			lunchid = new JTextField(data[n][0]);
			m=data[n][0];
			lunchid.setBounds(80, 65, 150, 25);
			p1.add(lunchid);

			lblunchname = new JLabel("菜单名称：", JLabel.LEFT);
			lblunchname.setFont(new Font("黑体", Font.BOLD, 14));
			lblunchname.setBounds(10, 100, 80, 30);
			p1.add(lblunchname);

			lunchname = new JTextField(data[n][1]);
			lunchname.setBounds(80, 105, 150, 25);
			p1.add(lunchname);

			lbprice = new JLabel("菜单价格：", JLabel.LEFT);
			lbprice.setFont(new Font("黑体", Font.BOLD, 14));
			lbprice.setBounds(10, 140, 80, 30);
			p1.add(lbprice);

			price = new JTextField(data[n][2]);
			price.setBounds(80, 145, 150, 25);
			p1.add(price);

			

			
			add = new JButton("修改");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 200, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 200, 80, 30);
		}
		p1.add(add);
		p1.add(quxiao);

		add(p1);
		setSize(260, 280);
		add.addActionListener(this);
		quxiao.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public static void main(String[] args) {
		new lunchmanageradd(-2);
	}

	public void readfile() {
		try {
			File file = new File("lunch.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String shoplblunchname[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				shoplblunchname = str.split(";");
			}
			value = new String[shoplblunchname.length][7];
			for (int i = 0; i < shoplblunchname.length; i++) {
				value[i] = shoplblunchname[i].split(",");
				data[i] = shoplblunchname[i].split(",");
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
				if (lunchid.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "菜单编号不能为空");
					return;
				} else if (lunchname.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "菜单名称不能为空");
					return;
				} else if (price.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "价格不能为空");
					return;
				}
				for(int i=0;i<value.length;i++){
					for(int j=0;j<value[i].length;j++){
						if(value[i][0].equals(lunchid.getText())){
							JOptionPane.showConfirmDialog(null, "该菜单已经存在，将会做修改");
							value[i][1]=lunchname.getText();
							value[i][2]=price.getText();
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
					File file1 = new File("lunch.txt");
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
					File file = new File("lunch.txt");
					FileOutputStream fos;
					try {
						fos = new FileOutputStream(file, true);
						String string = lunchid.getText() + "," + lunchname.getText()
						+ "," + price.getText() + ";" ;
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
							if(value[i][0].equals(lunchid.getText())){
								value[i][0]=lunchid.getText();
								value[i][1]=lunchname.getText();
								value[i][2]=price.getText();
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
				File file1 = new File("lunch.txt");
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
