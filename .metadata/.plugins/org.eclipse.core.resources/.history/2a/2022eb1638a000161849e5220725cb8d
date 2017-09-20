package edu.ht.main;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Skin extends JFrame{
	
	JButton jl1,jl2,jl3;
	public Skin(){
		
		super("¸ü¸ÄÆ¤·ô");
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		jl1= new JButton(new ImageIcon("qqmain/main1.jpg"));
		jl2= new JButton(new ImageIcon("qqmain/main2.jpg"));
		jl3= new JButton(new ImageIcon("qqmain/main3.jpg"));
		jp.add(jl1);
		jp.add(jl2);
		jp.add(jl3);
		JLabel bgimg = new JLabel(new ImageIcon("qqmain/main.jpg"));
		jp.add(bgimg);
		setSize(176,342);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Skin();
	}
}
