package T3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener
{
	private JLabel msg;
	private JTextField num;
	private JButton in;
	private JButton out;
	private JPanel p1,p2,p3;
	
	public LoginFrame()
	{
		msg=new JLabel("请输入最大停车数");
		num=new JTextField(20);
		in=new JButton("进入");
		out=new JButton("退出");
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		
		
		this.setFrame();
		in.addActionListener(this);
		out.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	private void setFrame()
	{
		this.setLayout(new GridLayout(3,1));
		p1.add(msg);
		p2.add(num);
		p3.add(in);p3.add(out);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setBounds(200,100,400,200);
		this.setTitle("家家乐停车场");
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==in)
		{
			String str=num.getText();
			int cartNum=Integer.parseInt(str);
			
			new Car_in_out(cartNum).show();
			this.dispose();
		}
		else if(e.getSource()==out)
		{
			System.exit(0);
		}
	}
}

