package T6;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class Frame_4 extends Frame{
	
	//声明的成员变量
	Label labelname,labelpasswordLabel;
	TextField textname,textpassword;
	Button btOK,btclose;
	Panel panel;
	public Frame_4() {
		this.setTitle("控件");
		panel = new Panel(new GridLayout(3,2,10,10));
		//创建控件
		labelname = new Label("用户名称",Label.RIGHT);
		labelname.setSize(80,50);
		labelname.setLocation(50,20);
		
		textname = new TextField(10);
		textname.setSize(100, 50);
		textname.setLocation(130,50);
		
		labelpasswordLabel = new Label("用户密码",Label.RIGHT);
		labelpasswordLabel.setSize(80, 20);
		labelpasswordLabel.setLocation(130,70); 
		
		textpassword = new TextField(10);
		textpassword.setSize(100, 50);
		textpassword.setLocation(220,70);
		
		btOK = new Button("确定");
		btOK.setSize(20, 50);
		btOK.setLocation(220,70);
		
		btclose = new Button("关闭");
		btclose.setSize(20, 50);
		btclose.setLocation(220,70);
		//添加到容器里
		panel.add(labelname);
		panel.add(textname);
		panel.add(labelpasswordLabel);
		panel.add(textpassword);
		panel.add(btOK);
		panel.add(btclose);
		add(panel);
		this.setSize(400,300);
		this.setBackground(Color.cyan);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Frame_4();
	}
	
}
