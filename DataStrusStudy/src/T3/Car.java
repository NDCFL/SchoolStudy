package T3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Car extends JFrame implements ActionListener{

	JTextField tf;
	JLabel label,label2;
	JButton bt1,bt2;
	JPanel panel;
	int n=0;
	public Car() {
		setTitle("停车场管理系统");
		panel = new JPanel(null);
		tf = new JTextField(10);
		label2 = new JLabel("停车管理",JLabel.CENTER);
		label2.setBounds(200, 30, 100, 30);
		label2.setFont(new Font("华文行楷",Font.BOLD,24));
		label2.setForeground(Color.blue);
		panel.add(label2);
		
		label = new JLabel("请输入停车量:");
		label.setFont(new Font("华文行楷",Font.BOLD,16));
		label.setForeground(Color.blue);
		label.setBounds(100, 100, 160, 30);
		panel.add(label);
		
		tf.setBounds(230, 100, 180, 30);
		panel.add(tf);
		
		bt1 = new JButton("进入");
		bt1.setBounds(100, 180, 100, 30);
		bt1.setFont(new Font("华文行楷",Font.BOLD,18));
		bt1.setForeground(Color.blue);
		panel.add(bt1);
		
		bt2 = new JButton("取消");
		bt2.setBounds(310, 180, 100, 30);
		bt2.setFont(new Font("华文行楷",Font.BOLD,18));
		bt2.setForeground(Color.blue);
		panel.add(bt2);
		//监听事件
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		add(panel);
		setSize(500, 300);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Car();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
			if(tf.getText().equals("") || tf.getText()==null){
				JOptionPane.showMessageDialog(this, "请输入车量");
			}else{
				dispose();
				new Car_in_out(Integer.parseInt(tf.getText()));
			}
		}
		
	}
	
}
