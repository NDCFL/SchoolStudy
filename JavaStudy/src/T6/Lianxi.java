package T6;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class Lianxi extends Frame{

	//定义变量名称
	Choice choice;
	Panel panel;
	TextField nameLabel,passLabel;
	Label name,pass;
	Button dengru,zhuche;
	public Lianxi() {
		setTitle("QQ界面");
		setSize(200, 200);
		//声明变量
		choice = new Choice();
		panel = new Panel(null);
		panel = new Panel(new GridLayout(3,2));
		name = new Label("QQ账号",Label.RIGHT);
		name.setSize(50,20);//大小
		name.setLocation(50,50);//位置
		
		
		nameLabel = new TextField(18);
		nameLabel.setSize(50,50);
		nameLabel.setLocation(120,50);
		
		pass = new Label("QQ密码",Label.RIGHT);
		pass.setSize(50,20);
		pass.setLocation(50,80);
		
		passLabel = new TextField(18);
		passLabel.setSize(50,50);
		passLabel.setLocation(120,50);
		
		dengru = new Button("登入");
		dengru.setSize(10,10);
		dengru.setLocation(100,150);
		
		zhuche = new Button("注册");
		zhuche.setSize(20,20);
		zhuche.setLocation(130,130);
		//添加控件到容器里
		panel.add(choice);
		panel.add(name);
		panel.add(nameLabel);
		panel.add(pass);
		panel.add(passLabel);
		panel.add(dengru);
		panel.add(zhuche);
		add(panel);
		setVisible(true);
		setBackground(Color.BLUE);
		
	}	
	public static void main(String[] args) {
		new Lianxi();
	}
}
