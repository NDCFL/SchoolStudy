package StudentManger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class studentadd extends JFrame{
	JPanel p1;
	JLabel bjimage;
	JLabel title,id,pass,name,email,sex,dizhi;
	JTextField idField,nameField,emaiField,dizhiField,passwordField,classFile;
	JButton ok,quxiao;
	JRadioButton man,weman;
	ButtonGroup btsex;
	BaseDAOimp sql = new BaseDAOimp();
	public studentadd(){
		super("学生新增");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("image/qt.png");
		setIconImage(image);
		p1 = new JPanel(null);
		title = new JLabel("学生新增",JLabel.CENTER);
		title.setBounds(70, 15, 100, 30);
		title.setFont(new Font("黑体",Font.BOLD,18));
		title.setForeground(Color.blue);
		p1.add(title);
		
		
		id = new JLabel("学   号：",JLabel.LEFT);
		id.setFont(new Font("黑体",Font.BOLD,14));
		id.setForeground(Color.blue);
		id.setBounds(10, 60, 80, 30);
		p1.add(id);
		
		idField = new JTextField();
		idField.setBounds(80, 65, 150, 25);
		p1.add(idField);
		
		name = new JLabel("姓   名：",JLabel.LEFT);
		name.setFont(new Font("黑体",Font.BOLD,14));
		name.setForeground(Color.blue);
		name.setBounds(10, 100, 80, 30);
		p1.add(name);
		
		nameField = new JTextField();
		nameField.setBounds(80, 105, 150, 25);
		p1.add(nameField);
		
		sex = new JLabel("班   级：",JLabel.LEFT);
		sex.setFont(new Font("黑体",Font.BOLD,14));
		sex.setForeground(Color.blue);
		sex.setBounds(10, 140, 80, 30);
		p1.add(sex);
		
		classFile = new JTextField();
		classFile.setBounds(80, 145, 150, 25);
		p1.add(classFile);
		
		email = new JLabel("语文成绩：",JLabel.LEFT);
		email.setFont(new Font("黑体",Font.BOLD,14));
		email.setForeground(Color.blue);
		email.setBounds(10, 180, 80, 30);
		p1.add(email);
		
		emaiField = new JTextField();
		emaiField.setBounds(80, 185, 150, 25);
		p1.add(emaiField);
		
		dizhi = new JLabel("数学成绩：",JLabel.LEFT);
		dizhi.setFont(new Font("黑体",Font.BOLD,14));
		dizhi.setForeground(Color.blue);
		dizhi.setBounds(10, 220, 80, 30);
		p1.add(dizhi);
		
		dizhiField = new JTextField();
		dizhiField.setBounds(80, 225, 150, 25);
		p1.add(dizhiField);
		
		pass = new JLabel("英语成绩：",JLabel.LEFT);
		pass.setFont(new Font("黑体",Font.BOLD,14));
		pass.setForeground(Color.blue);
		pass.setBounds(10, 260, 80, 30);
		p1.add(pass);
		
		passwordField = new JTextField();
		passwordField.setBounds(80, 265, 150, 25);
		p1.add(passwordField);
		
		ok = new JButton("新增");
		ok.setFont(new Font("黑体",Font.BOLD,14));
		ok.setForeground(Color.blue);
		ok.setBounds(30, 330, 80, 30);
		quxiao = new JButton("取消");
		quxiao.setFont(new Font("黑体",Font.BOLD,14));
		quxiao.setForeground(Color.blue);
		quxiao.setBounds(120, 330, 80, 30);
		p1.add(ok);
		p1.add(quxiao);
		
		add(p1);
		setSize(260, 450);
		ActionHandle a = new ActionHandle();
		ok.addActionListener(a);
		quxiao.addActionListener(a);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void beijin(){
		Icon icon = new ImageIcon("image/42.gif");
		bjimage = new JLabel(icon);
		add(bjimage);
	}
	public static void main(String[] args) {
		new studentadd();
	}
	class ActionHandle implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==ok) {
				
				if(idField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "账号不能为空");
					idField.requestFocus();
					return;
				}
				if (idField.getText().equals("275300091")) {
					JOptionPane.showMessageDialog(null, "该号码已被占用");
					id.requestFocus();
					return;
				}
				if (emaiField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "email不能为空");
					emaiField.requestFocus();
					return;
				}
				if (dizhiField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "地址不能为空");
					dizhiField.requestFocus();
					return;
				}
				if (idField.getText().length()>10) {
					JOptionPane.showMessageDialog(null, "身份证号码为10位以内数");
					idField.requestFocus();
					return;
				}
				StudentVo studentVo = new StudentVo();
				studentVo.setSno(Integer.parseInt(idField.getText()));
				studentVo.setSage(Integer.parseInt(emaiField.getText()));
				studentVo.setSsex(classFile.getText());
				studentVo.setStudentname(nameField.getText());
				studentVo.setShobit(dizhiField.getText());
				studentVo.setSzhuanye(passwordField.getText());
				sql.addstudent(studentVo);
				dispose();
				new StudentFace();
			}else if (e.getSource()==quxiao) {
				System.exit(0);
			}
		}
		
	}
}
