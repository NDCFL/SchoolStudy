package T8;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JFrame;

public class Line extends JFrame{

	Label lbluser,lblpass;
	TextField txtuser,txtpass;
	Button btnOK,btnCancel;
	public Line() {
		super("GridBag布局管理器演示");
		GridBagLayout gbl= new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints bgc = new GridBagConstraints();
		bgc.fill = GridBagConstraints.VERTICAL;
		lbluser = new Label("用户名称：",Label.RIGHT);
		txtuser = new TextField(20);
		gbl.setConstraints(lbluser, bgc);
		add(lbluser);
		bgc.weightx=2;
		bgc.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(txtuser, bgc);
		add(txtuser);
		bgc.weightx=0.0;
		bgc.gridwidth = GridBagConstraints.RELATIVE;
		lblpass = new Label("登录密码：",Label.RIGHT);
		txtpass = new TextField(20);
		gbl.setConstraints(lblpass, bgc);
		add(lblpass);
		bgc.weightx=2;
		bgc.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(txtpass, bgc);
		add(txtpass);
		
		
		btnOK = new Button("确定");
		btnCancel = new Button("取消");
		bgc.weighty=1;
		bgc.gridwidth = GridBagConstraints.RELATIVE;
		gbl.setConstraints(btnOK, bgc);
		add(btnOK);
		
		bgc.gridwidth = GridBagConstraints.REMAINDER;
		gbl.setConstraints(btnCancel, bgc);
		add(btnCancel);
		
		
		setSize(400, 200);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Line();
		System.out.println("\b\b");
	}
}
