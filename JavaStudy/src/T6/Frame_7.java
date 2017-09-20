package T6;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class Frame_7 extends java.awt.Frame{

	/**
	 * 3.	通过AWT中的基本组件与布局管理起，创建一个计算器的按钮面板（30分钟）
	 * 1 2 3 +
	 * 4 5 6 -
	 * 7 8 9 *
	 * . 0 = /
	 * 
	 * */
	Panel panel;
	TextField shuru;
	Button A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,jian;
	public Frame_7() {
		setTitle("计算器");
		setBackground(Color.CYAN);
		panel = new Panel(new GridLayout(4,4));
		//声明控件
		A1 = new Button("1");
		A2 = new Button("2");
		A3 = new Button("3");
		A4 = new Button("+");
		A5 = new Button("4");
		A6 = new Button("5");
		A7 = new Button("6");
		A8 = new Button("-");
		A9 = new Button("7");
		A10 = new Button("8");
		A11 = new Button("9");
		A12 = new Button("*");
		A13 = new Button(".");
		A14 = new Button("0");
		A15 = new Button("=");
		jian = new Button("/");
		//添加控件到窗口里
		panel.add(A1);
		panel.add(A2);
		panel.add(A3);
		panel.add(A4);
		panel.add(A5);
		panel.add(A6);
		panel.add(A7);
		panel.add(A8);
		panel.add(A9);
		panel.add(A10);
		panel.add(A11);
		panel.add(A12);
		panel.add(A13);
		panel.add(A14);
		panel.add(A15);
		panel.add(jian);
		add(panel);
		setVisible(true);
		setSize(180, 160);
		
	}
	public static void main(String[] args) {
		new Frame_7();
	}
}
