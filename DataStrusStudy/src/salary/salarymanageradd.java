package salary;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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

public class salarymanageradd extends JFrame implements ActionListener{
	JPanel p1;
	JLabel bjimage;
	JLabel title, lbemployeeid, pass, lbemployeename, lbsalary;
	JTextField employeeid, employeename, lbrichangField,salary;
	JButton add, quxiao;
	String data[][] = new String[90][5];
	String value[][];
	static int row=0;
	String  m="";
	public salarymanageradd(int n) {
		super("工资纳税系统");
		p1 = new JPanel(null);
		readfile();
		//判断是新增还是修改
		if(n==-2){
			title = new JLabel("工资新增", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbemployeeid = new JLabel("员工编号：", JLabel.LEFT);
			lbemployeeid.setFont(new Font("黑体", Font.BOLD, 14));
			lbemployeeid.setBounds(10, 60, 80, 30);
			p1.add(lbemployeeid);

			employeeid = new JTextField();
			employeeid.setBounds(80, 65, 150, 25);
			p1.add(employeeid);

			lbemployeename = new JLabel("员工姓名：", JLabel.LEFT);
			lbemployeename.setFont(new Font("黑体", Font.BOLD, 14));
			lbemployeename.setBounds(10, 100, 80, 30);
			p1.add(lbemployeename);

			employeename = new JTextField();
			employeename.setBounds(80, 105, 150, 25);
			p1.add(employeename);

			lbsalary = new JLabel("总工资：", JLabel.LEFT);
			lbsalary.setFont(new Font("黑体", Font.BOLD, 14));
			lbsalary.setBounds(10, 140, 80, 30);
			p1.add(lbsalary);

			salary = new JTextField();
			salary.setBounds(80, 145, 150, 25);
			p1.add(salary);

			add = new JButton("新增");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 200, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 200, 80, 30);
			
		}else {
			title = new JLabel("工资修改", JLabel.CENTER);
			title.setBounds(70, 15, 100, 30);
			title.setFont(new Font("黑体", Font.BOLD, 18));
			p1.add(title);

			
			lbemployeeid = new JLabel("员工编号：", JLabel.LEFT);
			lbemployeeid.setFont(new Font("黑体", Font.BOLD, 14));
			lbemployeeid.setBounds(10, 60, 80, 30);
			p1.add(lbemployeeid);

			employeeid = new JTextField(data[n][0]);
			m=data[n][0];
			employeeid.setBounds(80, 65, 150, 25);
			p1.add(employeeid);

			lbemployeename = new JLabel("员工姓名：", JLabel.LEFT);
			lbemployeename.setFont(new Font("黑体", Font.BOLD, 14));
			lbemployeename.setBounds(10, 100, 80, 30);
			p1.add(lbemployeename);

			employeename = new JTextField(data[n][1]);
			employeename.setBounds(80, 105, 150, 25);
			p1.add(employeename);

			lbsalary = new JLabel("总工资：", JLabel.LEFT);
			lbsalary.setFont(new Font("黑体", Font.BOLD, 14));
			lbsalary.setBounds(10, 140, 80, 30);
			p1.add(lbsalary);
			
			salary = new JTextField(data[n][2]);
			salary.setBounds(80, 145, 150, 25);
			p1.add(salary);

			add = new JButton("修改");
			add.setFont(new Font("黑体", Font.BOLD, 14));
			add.setBounds(30, 210, 80, 30);
			quxiao = new JButton("取消");
			quxiao.setFont(new Font("黑体", Font.BOLD, 14));
			quxiao.setBounds(120, 210, 80, 30);
		}
		p1.add(add);
		p1.add(quxiao);

		add(p1);
		setSize(260, 300);
		add.addActionListener(this);
		quxiao.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	public static void main(String[] args) {
		new salarymanageradd(-2);
	}

	public void readfile() {
		try {
			File file = new File("salary.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String string = "";
			String str = "";
			String shoplbemployeename[] = {};
			while ((string = br.readLine()) != null) {
				str += string + ";";
				shoplbemployeename = str.split(";");
			}
			value = new String[shoplbemployeename.length][5];
			for (int i = 0; i < shoplbemployeename.length; i++) {
				value[i] = shoplbemployeename[i].split(",");
				data[i] = shoplbemployeename[i].split(",");
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
				if (employeeid.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "员工编号不能为空");
					return;
				} else if (employeename.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "员工姓名不能为空");
					return;
				} else if (salary.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "总工资不能为空");
					return;
				} 
				File file = new File("salary.txt");
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file, true);
					String string = employeeid.getText() + "," + employeename.getText()
					+ "," + salary.getText() + ",暂缺,暂缺;";
					byte b[] = string.getBytes();
					fos.write(b, 0, b.length);
					dispose();
					new salarymanager();
					fos.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else {
				try {
					for(int i=0;i<value.length;i++){
						for(int j=0;j<value[i].length;j++){
							if(value[i][0].equals(m)){
								value[i][0]=employeeid.getText();
								value[i][1]=employeename.getText();
								value[i][2]=salary.getText();
								value[i][3]="暂缺";
								value[i][4]="暂缺";
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
				File file1 = new File("salary.txt");
				try {
					FileOutputStream fos1 = new FileOutputStream(file1);
					byte b1[]=valueString.getBytes();
					fos1.write(b1, 0, b1.length);
					dispose();
					new salarymanager();
					fos1.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}

	}
}
