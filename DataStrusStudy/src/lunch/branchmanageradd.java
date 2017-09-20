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

public class branchmanageradd extends JFrame implements ActionListener{
	JPanel p1;
	JLabel bjimage;
	JLabel title, lbbanchid, pass, lbbanchname, lbprice;
	JTextField banchid, banchname, depname,price;
	JButton add, quxiao;
	String data1[][] = new String[90][7];
	String value1[][];
	static int row=0;
	String  m="";
	public branchmanageradd(int n) {
		super("新增餐桌");
		p1 = new JPanel(null);
		readfile();
		//判断是新增还是修改
		if(n==-2){
			title = new JLabel("新增餐桌", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbbanchid = new JLabel("餐桌编号：", JLabel.LEFT);
			lbbanchid.setFont(new Font("黑体", Font.BOLD, 14));
			lbbanchid.setBounds(10, 60, 80, 30);
			p1.add(lbbanchid);

			banchid = new JTextField();
			banchid.setBounds(80, 65, 150, 25);
			p1.add(banchid);

			lbbanchname = new JLabel("餐桌状态：", JLabel.LEFT);
			lbbanchname.setFont(new Font("黑体", Font.BOLD, 14));
			lbbanchname.setBounds(10, 100, 80, 30);
			p1.add(lbbanchname);

			banchname = new JTextField();
			banchname.setBounds(80, 105, 150, 25);
			p1.add(banchname);

			add = new JButton("新增");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 200, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 200, 80, 30);
			
		}else{
			title = new JLabel("修改餐桌状态", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbbanchid = new JLabel("餐桌编号：", JLabel.LEFT);
			lbbanchid.setFont(new Font("黑体", Font.BOLD, 14));
			lbbanchid.setBounds(10, 60, 80, 30);
			p1.add(lbbanchid);

			banchid = new JTextField(data1[n][0]);
			banchid.setEditable(false);
			m=data1[n][0];
			banchid.setBounds(80, 65, 150, 25);
			p1.add(banchid);

			lbbanchname = new JLabel("状态：", JLabel.LEFT);
			lbbanchname.setFont(new Font("黑体", Font.BOLD, 14));
			lbbanchname.setBounds(10, 100, 80, 30);
			p1.add(lbbanchname);

			banchname = new JTextField(data1[n][1]);
			banchname.setBounds(80, 105, 150, 25);
			p1.add(banchname);

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
		new branchmanageradd(-2);
	}

	public void readfile() {
		try {
			File file = new File("banch.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String shoplbbanchname[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				shoplbbanchname = str.split(";");
			}
			value1 = new String[shoplbbanchname.length][7];
			for (int i = 0; i < shoplbbanchname.length; i++) {
				value1[i] = shoplbbanchname[i].split(",");
				data1[i] = shoplbbanchname[i].split(",");
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
				if (banchid.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "餐桌号不能为空");
					return;
				} else if (banchname.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "餐桌状态不能为空");
					return;
				}
				for(int i=0;i<value1.length;i++){
					for(int j=0;j<value1[i].length;j++){
						if(value1[i][0].equals(banchid.getText())){
							JOptionPane.showConfirmDialog(null, "该餐桌已经存在，将会做修改");
							value1[i][0]=banchid.getText();
							value1[i][1]=banchname.getText();
							row++;
							isexit=true;
							break;
						}
					}
				}
				//购买的设已经存在了
				if(isexit){
					String value1String="";
					for(int i=0;i<value1.length;i++){
						for(int j=0;j<value1[i].length;j++){
							if(j==value1[i].length-1){
								value1String+=value1[i][j]+";";
							}else {
								value1String+=value1[i][j]+",";
							}
						}
					}
					File file1 = new File("banch.txt");
					try {
						FileOutputStream fos1 = new FileOutputStream(file1);
						byte b1[]=value1String.getBytes();
						fos1.write(b1, 0, b1.length);
						dispose();
						new lunchmanager();
						fos1.close();
					}catch (Exception e1) {
						e1.printStackTrace();
					}
				}else{
					File file = new File("banch.txt");
					FileOutputStream fos;
					try {
						fos = new FileOutputStream(file, true);
						String string = banchid.getText() + "," + banchname.getText()
						+ ";";
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
					for(int i=0;i<value1.length;i++){
						for(int j=0;j<value1[i].length;j++){
							if(value1[i][0].equals(banchid.getText())){
								value1[i][0]=banchid.getText();
								value1[i][1]=banchname.getText();
								row++;
								break;
							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "数据更新失败","错误警告",JOptionPane.ERROR_MESSAGE);
				}
				String value1String="";
					for(int i=0;i<value1.length;i++){
					for(int j=0;j<value1[i].length;j++){
						if(j==value1[i].length-1){
							value1String+=value1[i][j]+";";
						}else {
							value1String+=value1[i][j]+",";
						}
					}
				}
				File file1 = new File("banch.txt");
				try {
					FileOutputStream fos1 = new FileOutputStream(file1);
					byte b1[]=value1String.getBytes();
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
