package T5.sort;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Ticket extends JFrame implements ActionListener{

	JLabel lb;
	JTextPane tex;
	JRadioButton but1,but2;
	JTextField tex1,tex2,tex3,tex4,tex5,tex6,tex7;
	JButton begin,paixu,isnull,close,kong;
	JPanel panel;
	ButtonGroup bg;
	int height=15;
	int width=15;
	int  data[]=new int[7];
	public Ticket() {
		setTitle("家家乐彩票");
		panel = new JPanel(null);
		lb = new JLabel("家家乐彩票");
		lb.setFont(new Font("宋体",Font.BOLD,20));
		lb.setBounds(200, 20, 200, 30);
		panel.add(lb);
		
		tex = new JTextPane();
		tex.setBounds(0, 60, 380, 200);
		panel.add(tex);
		bg = new ButtonGroup();
		but1 = new JRadioButton("机选",true);
		but1.setBounds(400, 80, 60, 30);
		but2 = new JRadioButton("手选");
		but2.setBounds(400, 120, 60, 30);
		bg.add(but1);
		bg.add(but2);
		panel.add(but1);
		panel.add(but2);
		
		tex1 = new JTextField();
		tex1.setBounds(10, 320, 60, 30);
		panel.add(tex1);
		
		tex2 = new JTextField();
		tex2.setBounds(80, 320, 60, 30);
		panel.add(tex2);
		
		tex3 = new JTextField();
		tex3.setBounds(150, 320, 60, 30);
		panel.add(tex3);
		
		tex4 = new JTextField();
		tex4.setBounds(220, 320, 60, 30);
		panel.add(tex4);
		
		tex5 = new JTextField();
		tex5.setBounds(290, 320, 60, 30);
		panel.add(tex5);
		
		tex6 = new JTextField();
		tex6.setBounds(360, 320, 60, 30);
		panel.add(tex6);
		
		tex7 = new JTextField();
		tex7.setBounds(430, 320, 60, 30);
		panel.add(tex7);
		
		begin = new JButton("开始");
		begin.setBounds(30, 400, 60, 30);
		panel.add(begin);
		
		paixu = new JButton("排序");
		paixu.setBounds(130, 400, 60, 30);
		panel.add(paixu);
		paixu.setEnabled(false);
		
		isnull = new JButton("清除");
		isnull.setBounds(230, 400, 60, 30);
		panel.add(isnull);
		
		close = new JButton("关闭");
		close.setBounds(330, 400, 60, 30);
		panel.add(close);
		
		kong = new JButton("清空");
		kong.setBounds(430, 400, 60, 30);
		panel.add(kong);
		
		close.addActionListener(this);
		isnull.addActionListener(this);
		kong.addActionListener(this);
		begin.addActionListener(this);
		paixu.addActionListener(this);
		
		add(panel);
		this.setSize(520,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
//		int n=tex.getText().length();
//		String str = tex.getText();
		if(e.getSource()==close){
			System.exit(0);
		}else if(e.getSource()==isnull){
//			n--;
//			try {
//				tex.setText(str.substring(0,n));
//			} catch (Exception e1) {
//				JOptionPane.showMessageDialog(this, "数据已为空！");
//				return;
//			}
//			if(tex.getText()==null){
//				JOptionPane.showMessageDialog(this, "数据已为空！");
//				return;
//			}
				if(tex7.getText()!=null && !tex7.getText().equals("")){
					tex7.setText(null);
					System.out.println("---------");
				}else if(tex7.getText().equals("") && tex6.getText()!=null && !tex6.getText().equals("")){
					tex6.setText(null);
				}else if(tex6.getText().equals("")  && tex5.getText()!=null  && !tex5.getText().equals("")){
					tex5.setText(null);
				}else if(tex5.getText().equals("")  && tex4.getText()!=null  && !tex4.getText().equals("")){
					tex4.setText(null);
				}else if(tex4.getText().equals("")  && tex3.getText()!=null  && !tex3.getText().equals("")){
					tex3.setText(null);
				}else if(tex3.getText().equals("")  && tex2.getText()!=null  && !tex2.getText().equals("")){
					tex2.setText(null);
				}else if(tex2.getText().equals("")  && tex1.getText()!=null  && !tex1.getText().equals("")){
					tex1.setText(null);
				}else {
					JOptionPane.showMessageDialog(this, "数据已为空！");
					return;
				}
				
		}else if(e.getSource()==kong){
			tex.setText(null);
			tex1.setText(null);
			tex2.setText(null);
			tex3.setText(null);
			tex4.setText(null);
			tex5.setText(null);
			tex6.setText(null);
			tex7.setText(null);
		}else if(e.getSource()==begin){
			if(but1.isSelected()){
				if(!tex1.getText().equals("") || !tex2.getText().equals("") ||!tex3.getText().equals("") ||!tex4.getText().equals("") ||!tex5.getText().equals("") ||!tex6.getText().equals("") ||!tex7.getText().equals("")){
					JOptionPane.showMessageDialog(this, "你选择了机选，但你输入了数据是否机选,机选按确认，否则关闭重选");
				}else{
					Random random = new Random();
					for(int i=0;i<data.length;i++){
						data[i]=Math.abs(random.nextInt(100));
					}
					tex1.setText(data[0]+"");
					tex2.setText(data[1]+"");
					tex3.setText(data[2]+"");
					tex4.setText(data[3]+"");
					tex5.setText(data[4]+"");
					tex6.setText(data[5]+"");
					tex7.setText(data[6]+"");
				}
			}else {
				try {
					if(tex7.getText().equals("") || tex7.getText()==null){
						JOptionPane.showMessageDialog(this, "最后一个文本框为空！请输入！");
					}else if (tex6.getText().equals("") || tex6.getText()==null) {
						JOptionPane.showMessageDialog(this, "第六个文本框为空！请输入！");
					}else if (tex5.getText().equals("") || tex5.getText()==null) {
						JOptionPane.showMessageDialog(this, "第五个文本框为空！请输入！");
					}else if (tex4.getText().equals("") || tex4.getText()==null) {
						JOptionPane.showMessageDialog(this, "第四六个文本框为空！请输入！");
					}else if (tex3.getText().equals("") || tex3.getText()==null) {
						JOptionPane.showMessageDialog(this, "第三个文本框为空！请输入！");
					}else if (tex2.getText().equals("") || tex2.getText()==null) {
						JOptionPane.showMessageDialog(this, "第二个文本框为空！请输入！");
					}else if (tex1.getText().equals("") || tex1.getText()==null) {
						JOptionPane.showMessageDialog(this, "第一个文本框为空！请输入！");
					}else {
						data[0]=Integer.parseInt(tex1.getText());
						data[2]=Integer.parseInt(tex2.getText());
						data[3]=Integer.parseInt(tex3.getText());
						data[4]=Integer.parseInt(tex4.getText());
						data[5]=Integer.parseInt(tex5.getText());
						data[6]=Integer.parseInt(tex6.getText());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "你输入的值含有非法字符！请重新输入！");
					tex1.setText(null);
					tex2.setText(null);
					tex3.setText(null);
					tex4.setText(null);
					tex5.setText(null);
					tex6.setText(null);
					tex7.setText(null);
				}
			}
			paixu.setEnabled(true);
		}else if (e.getSource()==paixu) {
			long oldtime = System.currentTimeMillis();
			Arrays.sort(data);
			String str="",str1=tex.getText();
			for(int i : data){
				str+=i+"    ";
			}
			str1+=str;
			tex.setText(str1+"\n本次彩票选取共花费时间"+(System.currentTimeMillis()-oldtime)+"毫秒\n");
			JOptionPane.showMessageDialog(this, "本次彩票选取共花费时间"+(System.currentTimeMillis()-oldtime)+"毫秒");
		}
		
	}
	public static void main(String[] args) {
		new Ticket();
	}
}
