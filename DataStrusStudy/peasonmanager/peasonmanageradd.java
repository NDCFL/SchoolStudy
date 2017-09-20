package peasonmanager;

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

public class peasonmanageradd extends JFrame implements ActionListener{
	JPanel p1;
	JLabel bjimage;
	JLabel title, lbgongzi, pass, lblicai, lbrichang, lbguding,lbtouzi;
	JTextField gongzi, licai, richang, lbrichangField,guding,touzi;
	JButton add, quxiao;
	String data[][] = new String[90][5];
	String value[][];
	static int row=0;
	String  m="";
	public peasonmanageradd(int n) {
		super("货物的新增");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("shop.png");
		setIconImage(image);
		p1 = new JPanel(null);
		readfile();
		//判断是新增还是修改
		if(n==-2){
			title = new JLabel("账单新增", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbgongzi = new JLabel("工资收入：", JLabel.LEFT);
			lbgongzi.setFont(new Font("黑体", Font.BOLD, 14));
			lbgongzi.setBounds(10, 60, 80, 30);
			p1.add(lbgongzi);

			gongzi = new JTextField();
			gongzi.setBounds(80, 65, 150, 25);
			p1.add(gongzi);

			lblicai = new JLabel("理财收入：", JLabel.LEFT);
			lblicai.setFont(new Font("黑体", Font.BOLD, 14));
			lblicai.setBounds(10, 100, 80, 30);
			p1.add(lblicai);

			licai = new JTextField();
			licai.setBounds(80, 105, 150, 25);
			p1.add(licai);

			lbguding = new JLabel("固定支出：", JLabel.LEFT);
			lbguding.setFont(new Font("黑体", Font.BOLD, 14));
			lbguding.setBounds(10, 180, 80, 30);
			p1.add(lbguding);

			guding = new JTextField();
			guding.setBounds(80, 185, 150, 25);
			p1.add(guding);

			lbrichang = new JLabel("日常消费：", JLabel.LEFT);
			lbrichang.setFont(new Font("黑体", Font.BOLD, 14));
			lbrichang.setBounds(10, 140, 80, 30);
			p1.add(lbrichang);

			richang = new JTextField();
			richang.setBounds(80, 145, 150, 25);
			p1.add(richang);
			
			lbtouzi = new JLabel("投资支出：", JLabel.LEFT);
			lbtouzi.setFont(new Font("黑体", Font.BOLD, 14));
			lbtouzi.setBounds(10, 220, 80, 30);
			p1.add(lbtouzi);

			touzi = new JTextField();
			touzi.setBounds(80, 225, 150, 25);
			p1.add(touzi);

			add = new JButton("新增");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 260, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 260, 80, 30);
			
		}else {
			title = new JLabel("账单修改", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbgongzi = new JLabel("工资收入：", JLabel.LEFT);
			lbgongzi.setFont(new Font("黑体", Font.BOLD, 14));
			lbgongzi.setBounds(10, 60, 80, 30);
			p1.add(lbgongzi);

			gongzi = new JTextField(data[n][0]);
			m=data[n][0];
			gongzi.setBounds(80, 65, 150, 25);
			p1.add(gongzi);

			lblicai = new JLabel("理财收入：", JLabel.LEFT);
			lblicai.setFont(new Font("黑体", Font.BOLD, 14));
			lblicai.setBounds(10, 100, 80, 30);
			p1.add(lblicai);

			licai = new JTextField(data[n][1]);
			licai.setBounds(80, 105, 150, 25);
			p1.add(licai);

			lbguding = new JLabel("固定支出：", JLabel.LEFT);
			lbguding.setFont(new Font("黑体", Font.BOLD, 14));
			lbguding.setBounds(10, 140, 80, 30);
			p1.add(lbguding);

			guding = new JTextField(data[n][2]);
			guding.setBounds(80, 145, 150, 25);
			p1.add(guding);

			lbrichang = new JLabel("日常支出：", JLabel.LEFT);
			lbrichang.setFont(new Font("黑体", Font.BOLD, 14));
			lbrichang.setBounds(10, 180, 80, 30);
			p1.add(lbrichang);

			richang = new JTextField(data[n][3]);
			richang.setBounds(80, 185, 150, 25);
			p1.add(richang);
			
			lbtouzi = new JLabel("投资支出：", JLabel.LEFT);
			lbtouzi.setFont(new Font("黑体", Font.BOLD, 14));
			lbtouzi.setBounds(10, 220, 80, 30);
			p1.add(lbtouzi);

			touzi = new JTextField(data[n][4]);
			touzi.setBounds(80, 225, 150, 25);
			p1.add(touzi);

			add = new JButton("修改");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 260, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
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


	public static void main(String[] args) {
		new peasonmanageradd(-2);
	}

	public void readfile() {
		try {
			File file = new File("peason.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String shoplblicai[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				shoplblicai = str.split(";");
			}
			value = new String[shoplblicai.length][5];
			for (int i = 0; i < shoplblicai.length; i++) {
				value[i] = shoplblicai[i].split(",");
				data[i] = shoplblicai[i].split(",");
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
				if (gongzi.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "工资收入不能为空");
					return;
				} else if (licai.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "理财收入不能为空");
					return;
				} else if (guding.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "固定消费支出不能为空");
					return;
				} else if (richang.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "日常消费支出不能为空");
					return;
				}else if (touzi.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "投资消费支出不能为空");
					return;
				}
				File file = new File("peason.txt");
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file, true);
					String string = gongzi.getText() + "," + licai.getText()
					+ "," + guding.getText() + "," + richang.getText() + ","+touzi.getText()+";";
					byte b[] = string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					new peasonmanager();
					fos.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else {
				try {
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(m)){
								value[i][0]=gongzi.getText();
								value[i][1]=licai.getText();
								value[i][2]=guding.getText();
								value[i][3]=richang.getText();
								value[i][4]=touzi.getText();
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
				File file1 = new File("peason.txt");
				try {
					FileOutputStream fos1 = new FileOutputStream(file1);
					byte b1[]=valueString.getBytes();
					fos1.write(b1, 0, b1.length);
					dispose();
					new peasonmanager();
					fos1.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}

	}
}
