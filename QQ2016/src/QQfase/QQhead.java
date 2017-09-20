package QQfase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QQhead extends JFrame implements ActionListener{
	JTextArea headArea;
	JButton head1,head2,head3,head4,head5,head6,head7,head8,head9,head10,head11,head12,head13,head14,head15;
	public QQhead() {
		super("QQ注册");
		headArea = new JTextArea();
		JScrollPane jp= new JScrollPane(headArea);
		head1 = new JButton(new ImageIcon("image/1111.gif"));
		head1.setBounds(50, 50, 130, 130);
		headArea.add(head1);
		
		head2 = new JButton(new ImageIcon("images/1.jpg"));
		head2.setBounds(220, 50, 130, 130);
		headArea.add(head2);
		
		head3 = new JButton(new ImageIcon("images/2.jpg"));
		head3.setBounds(390, 50, 130, 130);
		headArea.add(head3);
		
		
		head4 = new JButton(new ImageIcon("images/3.jpg"));
		head4.setBounds(50, 200, 130, 130);
		headArea.add(head4);
		
		
		head5 = new JButton(new ImageIcon("images/4.jpg"));
		head5.setBounds(220, 200, 130, 130);
		headArea.add(head5);
		
		
		head6 = new JButton(new ImageIcon("images/5.jpg"));
		head6.setBounds(390, 200, 130, 130);
		headArea.add(head6);
		
		
		head7 = new JButton(new ImageIcon("images/6.jpg"));
		head7.setBounds(50, 350, 130, 130);
		headArea.add(head7);
		
		
		head8 = new JButton(new ImageIcon("images/7.jpg"));
		head8.setBounds(220, 350, 130, 130);
		headArea.add(head8);
		
		head9 = new JButton(new ImageIcon("images/8.jpg"));
		head9.setBounds(390, 350, 130, 130);
		headArea.add(head9);
		
		head10 = new JButton(new ImageIcon("images/9.jpg"));
		head10.setBounds(50, 500, 130, 130);
		headArea.add(head10);
		
		head11 = new JButton(new ImageIcon("images/10.jpg"));
		head11.setBounds(220, 500, 130, 130);
		headArea.add(head11);
		
		head12 = new JButton(new ImageIcon("images/11.jpg"));
		head12.setBounds(390, 500, 130, 130);
		headArea.add(head12);
		
		head13 = new JButton(new ImageIcon("images/12.jpg"));
		head13.setBounds(50, 650, 130, 130);
		headArea.add(head13);
		
		head14 = new JButton(new ImageIcon("images/13.jpg"));
		head14.setBounds(220, 650, 130, 130);
		headArea.add(head14);
		
		head15 = new JButton(new ImageIcon("images/14.jpg"));
		head15.setBounds(390, 650, 130, 130);
		headArea.add(head15);
		
		head2.addActionListener(this);
		add(jp);
		add(headArea);
		setSize(600,670);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Headdemo hd=new Headdemo();
		if (e.getSource()==head2) {
			hd.setHeadface("images/2.jpg");
		}
		
	}
	public static void main(String[] args) {
		new QQhead();
	}
}
