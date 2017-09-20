package T6;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;

public class Frame extends java.awt.Frame{

	/**
	 * 1.	创建一个Frame类的对象，设置该Frame的背景色为Blue设置Title为“这是一个Frame”,
	 * 设置大小为（180，160）。并添加两个按钮到该Frame中（30分钟）
	 * 
	 * */
	Button btoppen,btclose;
	Panel panel;
	public Frame() {
		setTitle("这是一个Frame");
		panel = new Panel(new FlowLayout());
		setBackground(Color.BLUE);
		setSize(180, 160);
		btoppen = new Button("确定");
		btclose = new Button("关闭");
		panel.add(btoppen);
		panel.add(btclose);
		add(panel);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Frame();
	}
}
