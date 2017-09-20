package T6;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Kabuju extends JFrame{

	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane jspl;
	public Kabuju(){
		
		jphy_jb1 = new JButton("损友");
		jphy_jb2 = new JButton("同学");
		jphy_jb3 = new JButton("黑名单");
		
		jphy1 = new JPanel(new BorderLayout());
		jphy2 = new JPanel(new GridLayout(50,1,4,4));
		JLabel []jbls = new JLabel[50];
		
		 
		 for (int i = 0; i < jbls.length; i++) {
			jbls[i] = new JLabel((i+1)+"",new ImageIcon("image/2.png"),JLabel.LEFT);
			jphy2.add(jbls[i]);
			 
		 }
		 jphy3 = new JPanel(new GridLayout(2,1));
		 
		 jphy3.add(jphy_jb2);
		 jphy3.add(jphy_jb3);
		 jspl = new JScrollPane(jphy2);
		 jphy1.add(jphy_jb1,"North");
		 jphy1.add(jspl,"Center");
		 jphy1.add(jphy3,"South");
		 this.add(jphy1,"Center");
		 setSize(200,400);
		 setVisible(true);
		 
	}
	public static void main(String[] args) {
		new Kabuju();
	}
}
