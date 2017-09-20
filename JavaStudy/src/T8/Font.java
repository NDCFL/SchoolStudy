package T8;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Font extends JFrame implements ItemListener,ActionListener{
	JLabel title;
	JPanel p1,p2,p3;
	JCheckBox cuti,xieti;
	JComboBox cbSize,cbFont;
	String sFontName="宋体";
	java.awt.Font font;
	int setFont=8,cxieti=java.awt.Font.PLAIN,ccuti=java.awt.Font.PLAIN;
	public Font() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		setTitle("字体风格");
		setSize(500, 500);
		p1 = new JPanel();
		title = new JLabel("字体风格",JLabel.CENTER);
		setFont();
		p1.add(title);
		
		p2 = new JPanel(null);
		xieti = new JCheckBox("斜体");
		cuti = new JCheckBox("粗体");
		
		xieti.setBounds(100, 100, 100, 30);
		cuti.setBounds(300, 100, 100, 30);
		p2.add(xieti);
		p2.add(cuti);
		
		
		String nsize[]={"8","10","12","14","16","18","20","24","28","32","36","48","72"};
		String sFont[]={"宋体","楷体","黑体","隶书"};
		cbSize = new JComboBox(nsize);
		cbFont = new JComboBox(sFont);
		JPanel centerPanel = new JPanel(null);
		cbSize.setBounds(100, 150, 100, 30);
		cbFont.setBounds(300, 150, 100, 30);
		p2.add(cbSize);
		p2.add(cbFont);
		
		cbFont.addItemListener(this);
		cbSize.addItemListener(this);
		xieti.addActionListener(this);
		cuti.addActionListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==cbFont) {
			sFontName=cbFont.getSelectedItem().toString();
		} else if(e.getSource()==cbSize){
			setFont = Integer.parseInt(cbSize.getSelectedItem().toString());
			
		}
		setFont();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==xieti) {
			if(xieti.isSelected()){
				cxieti =java.awt.Font.ITALIC;//粗体;
			}else{
				cxieti = java.awt.Font.PLAIN;//正常
			}
		} else if(cuti.isSelected()){
			if(cuti.isSelected()){
				
				ccuti =java.awt.Font.BOLD;//粗体;
			}else{
				ccuti = java.awt.Font.PLAIN;//正常
			}
		}
		setFont();
		
	}
	public void setFont(){
		font = new java.awt.Font(sFontName,cxieti+ccuti,setFont);
		title.setFont(font);
	}
	public static void main(String[] args) {
		new Font();
	}
}
