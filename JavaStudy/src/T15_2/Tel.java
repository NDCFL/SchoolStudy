package T15_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import T15_1.SQLlianjie;

public class Tel extends JFrame implements ActionListener {

	JLabel name, tel, title;
	JTextField jtname, jtel;
	JButton updata, downdata, add;
	JPanel panel;

	public Tel() {
		super("通讯录");
		panel = new JPanel(null);
		title = new JLabel("通讯录");
		title.setBounds(150, 20, 100, 40);
		title.setFont(new Font("黑体", Font.BOLD, 30));
		title.setForeground(Color.CYAN);
		panel.add(title);
		name = new JLabel("姓    名");
		name.setBounds(40, 130, 80, 30);
		name.setFont(new Font("黑体", Font.BOLD, 16));
		name.setForeground(Color.CYAN);
		panel.add(name);
		jtname = new JTextField();
		jtname.setBounds(160, 130, 180, 30);
		panel.add(jtname);
		tel = new JLabel("电话号码");
		tel.setBounds(40, 200, 80, 30);
		tel.setFont(new Font("黑体", Font.BOLD, 16));
		tel.setForeground(Color.CYAN);
		panel.add(tel);
		jtel = new JTextField();
		jtel.setBounds(160, 200, 180, 30);
		panel.add(jtel);

		updata = new JButton("上一条");
		updata.setBounds(30, 280, 100, 30);
		updata.setFont(new Font("黑体", Font.BOLD, 16));
		updata.setForeground(Color.CYAN);
		panel.add(updata);
		add = new JButton("添加");
		add.setBounds(145, 280, 100, 30);
		add.setFont(new Font("黑体", Font.BOLD, 16));
		add.setForeground(Color.CYAN);
		panel.add(add);
		downdata = new JButton("下一条");
		downdata.setBounds(260, 280, 100, 30);
		downdata.setFont(new Font("黑体", Font.BOLD, 16));
		downdata.setForeground(Color.CYAN);
		panel.add(downdata);

		// 监听事件
		updata.addActionListener(this);
		add.addActionListener(this);
		downdata.addActionListener(this);

		add(panel);
		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new Tel();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updata) {
			Telbean tb = new Telbean();
			TelSQL lj = new TelImp();
			Connection con = SQLlianjie.open();
			String SQL = "select * from where name='"+name+"' and telnumber='"+jtel+"'";
			try {
				Statement sta = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
				PreparedStatement pre = con.prepareStatement(SQL);
				pre.setString(1, name.getText());
				pre.setString(2, jtel.getText());
				String str=tb.getName();
				String str1=tb.getTelnumber();
				jtname.getText();
				jtel.getText();
				System.out.println(SQL);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			JOptionPane.showMessageDialog(this, "你点击了上一条");
		} else if (e.getSource() == add) {
			// 参数bean
			Telbean tb = new Telbean();
			TelSQL lj = new TelImp();
			if (lj.isExit(jtel.getText())) {
				JOptionPane.showMessageDialog(this, "该用户已经存在！！！");
				return;
			}
			tb.setName(jtname.getText());
			tb.setTelnumber(jtel.getText());
			lj.add(tb);
			JOptionPane.showMessageDialog(this, "添加成功！！");
		} else if (e.getSource() == downdata) {
			JOptionPane.showMessageDialog(this, "你点击下一条");
		}
	}
}
