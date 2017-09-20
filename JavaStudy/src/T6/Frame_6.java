package T6;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class Frame_6 extends java.awt.Frame{

	Panel panel;
	Label labelname,Labelname;
	TextField textname,Textname;
	Button btOK,btclose;
	public Frame_6() {
		setTitle("布局控制");
		panel = new Panel(new GridLayout(3,1));
		Labelname = new Label("变量名(N)");
		Textname = new TextField("Temp");
		labelname = new Label("变量名(V)");
		textname = new TextField("%USERPROFILE%\\Local Settings\\Temp");
		btOK = new Button("确定");
		btclose = new Button("关闭");
		//添加到容器里
		panel.add(Labelname);
		panel.add(Textname);
		panel.add(labelname);
		panel.add(textname);
		panel.add(btOK);
		panel.add(btclose);
		add(panel);
		setSize(240,130);
		setBackground(Color.darkGray);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Frame_6();
	}
}
