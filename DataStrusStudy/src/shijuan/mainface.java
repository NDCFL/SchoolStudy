package shijuan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class mainface extends JFrame implements ActionListener{

	JLabel lbtitle,ti1,ti2,ti3,ti4,ti5,ti6,ti7,ti8,ti9,ti10,defen;
	JLabel t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JPanel panel;
	JButton in,out,up,down;
	JTextField timu1,timu2,timu3,timu4,timu5,timu6,timu7,timu8,timu9,timu10;
	int srcvlue[]=new int[10];
	int lastvlue[]=new int[10];
	int yunsuan[]=new int[10];//0:加,1:减,2:乘
	char fuhao[] = new char[10];
	int result[] = new int[10];
	public mainface() {
		setTitle("小学生测验");
		chuti();
		panel = new JPanel(null);
		
		lbtitle = new JLabel("小学生测试");
		lbtitle.setBounds(150,20, 200, 30);
		panel.add(lbtitle);
		
		in = new JButton("出题");
		in.setBounds(60, 60, 80, 30);
		panel.add(in);
		
		out = new JButton("交卷");
		out.setBounds(220, 60, 80, 30);
		panel.add(out);
	
		
		//判断生成的符号,题目1
		if((srcvlue[0]<lastvlue[0]) && fuhao[0]=='-'){
			fuhao[0]='+';
			int temp=0;
			temp = srcvlue[0];
			srcvlue[0]=lastvlue[0];
			lastvlue[0]=temp;
		}
		//显示题目
		ti1 = new JLabel("题目一："+srcvlue[0]+fuhao[0]+lastvlue[0]+"=");
		ti1.setFont(new Font("楷体",Font.BOLD,20));
		ti1.setBounds(40, 100, 200, 30);
		panel.add(ti1);
		
		timu1 = new JTextField();
		timu1.setBounds(220, 100, 100, 30);
		panel.add(timu1);
		
		t1 = new JLabel();
		t1.setBounds(330, 100, 30, 30);
		panel.add(t1);
		
		//将结果存放起来
		if(fuhao[0]=='+'){
			result[0]=(srcvlue[0]+lastvlue[0]);
		}else if(fuhao[0]=='-'){
			result[0]=(srcvlue[0]-lastvlue[04]);
		}else if(fuhao[0]=='*'){
			result[0]=(srcvlue[0]*lastvlue[0]);
		}
		System.out.println("题目一：符号："+fuhao[0]+"\t结果:"+result[0]);
		
		//判断生成的符号，题目2
		if((srcvlue[1]<lastvlue[1]) && fuhao[1]=='-'){
			fuhao[1]='+';
		}
		//显示题目
		ti2 = new JLabel("题目二："+srcvlue[1]+fuhao[1]+lastvlue[1]+"=");
		ti2.setFont(new Font("楷体",Font.BOLD,20));
		ti2.setBounds(40, 140, 200, 30);
		panel.add(ti2);
		
		timu2 = new JTextField();
		timu2.setBounds(220, 140, 100, 30);
		panel.add(timu2);
		
		t2 = new JLabel();
		t2.setBounds(330, 140, 30, 30);
		panel.add(t2);
		
		//将结果存放起来
		if(fuhao[1]=='+'){
			result[1]=(srcvlue[1]+lastvlue[1]);
		}else if(fuhao[1]=='-'){
			if(srcvlue[1]<lastvlue[1]){
				result[1]=(srcvlue[1]+lastvlue[1]);
			}else {
				result[1]=(srcvlue[1]-lastvlue[1]);
			}
		}else if(fuhao[1]=='*'){
			result[1]=(srcvlue[1]*lastvlue[1]);
		}
		System.out.println("题目二：符号："+fuhao[1]+"\t结果:"+result[1]);
		
		//判断生成的符号，题目3
		if((srcvlue[2]<lastvlue[2]) && fuhao[2]=='-'){
			fuhao[2]='+';
		}
		//显示题目
		ti3 = new JLabel("题目三："+srcvlue[2]+fuhao[2]+lastvlue[2]+"=");
		ti3.setFont(new Font("楷体",Font.BOLD,20));
		ti3.setBounds(40, 180, 200, 30);
		panel.add(ti3);
		
		timu3 = new JTextField();
		timu3.setBounds(220, 180, 100, 30);
		panel.add(timu3);
		
		t3 = new JLabel();
		t3.setBounds(330, 180, 30, 30);
		panel.add(t3);
		
		//将结果存放起来
		if(fuhao[2]=='+'){
			result[2]=(srcvlue[2]+lastvlue[2]);
		}else if(fuhao[2]=='-'){
			if(srcvlue[2]<lastvlue[2]){
				result[2]=(srcvlue[2]+lastvlue[2]);
			}else {
				result[2]=(srcvlue[2]-lastvlue[2]);
			}
		}else if(fuhao[2]=='*'){
			result[2]=(srcvlue[2]*lastvlue[2]);
		}
		System.out.println("题目三：符号："+fuhao[2]+"\t结果:"+result[2]);
		
		//判断生成的符号，题目4
		if((srcvlue[3]<lastvlue[3]) && fuhao[3]=='-'){
			fuhao[3]='+';
		}
		//显示题目
		ti4 = new JLabel("题目四："+srcvlue[3]+fuhao[3]+lastvlue[3]+"=");
		ti4.setFont(new Font("楷体",Font.BOLD,20));
		ti4.setBounds(40, 220, 200, 30);
		panel.add(ti4);
		
		timu4 = new JTextField();
		timu4.setBounds(220, 220, 100, 30);
		panel.add(timu4);
		
		t4 = new JLabel();
		t4.setBounds(330, 220, 30, 30);
		panel.add(t4);
		//将结果存放起来
		if(fuhao[3]=='+'){
			result[3]=(srcvlue[3]+lastvlue[3]);
		}else if(fuhao[3]=='-'){
			if(srcvlue[3]<lastvlue[3]){
				result[3]=(srcvlue[3]+lastvlue[3]);
			}else {
				result[3]=(srcvlue[3]-lastvlue[3]);
			}
		}else if(fuhao[3]=='*'){
			result[3]=(srcvlue[3]*lastvlue[3]);
		}
		System.out.println("题目四：符号："+fuhao[3]+"\t结果:"+result[3]);
		
		//判断生成的符号，题目5
		if((srcvlue[4]<lastvlue[4]) && fuhao[4]=='-'){
			fuhao[4]='+';
		}
		//显示题目
		ti5 = new JLabel("题目五："+srcvlue[4]+fuhao[4]+lastvlue[4]+"=");
		ti5.setFont(new Font("楷体",Font.BOLD,20));
		ti5.setBounds(40, 260, 200, 30);
		panel.add(ti5);
		
		timu5 = new JTextField();
		timu5.setBounds(220, 260, 100, 30);
		panel.add(timu5);
		
		t5 = new JLabel();
		t5.setBounds(330, 260, 30, 30);
		panel.add(t5);
		//将结果存放起来
		if(fuhao[4]=='+'){
			result[4]=(srcvlue[4]+lastvlue[4]);
		}else if(fuhao[4]=='-'){
			if(srcvlue[4]<lastvlue[4]){
				result[4]=(srcvlue[4]+lastvlue[4]);
			}else {
				result[4]=(srcvlue[4]-lastvlue[4]);
			}
		}else if(fuhao[3]=='*'){
			result[4]=(srcvlue[4]*lastvlue[4]);
		}
		System.out.println("题目五：符号："+fuhao[4]+"\t结果:"+result[4]);
		
		//判断生成的符号，题目6
		if((srcvlue[5]<lastvlue[5]) && fuhao[5]=='-'){
			fuhao[5]='+';
		}
		//显示题目
		ti6 = new JLabel("题目六："+srcvlue[5]+fuhao[5]+lastvlue[5]+"=");
		ti6.setFont(new Font("楷体",Font.BOLD,20));
		ti6.setBounds(40, 300, 200, 30);
		panel.add(ti6);
		
		timu6 = new JTextField();
		timu6.setBounds(220, 300, 100, 30);
		panel.add(timu6);
		
		t6 = new JLabel();
		t6.setBounds(330, 300, 30, 30);
		panel.add(t6);
		//将结果存放起来
		if(fuhao[5]=='+'){
			result[5]=(srcvlue[5]+lastvlue[5]);
		}else if(fuhao[5]=='-'){
			if(srcvlue[5]<lastvlue[5]){
				result[5]=(srcvlue[5]+lastvlue[5]);
			}else {
				result[5]=(srcvlue[5]-lastvlue[5]);
			}
		}else if(fuhao[5]=='*'){
			result[5]=(srcvlue[5]*lastvlue[5]);
		}
		System.out.println("题目六：符号："+fuhao[5]+"\t结果:"+result[5]);
		//判断生成的符号，题目7
		if((srcvlue[6]<lastvlue[6]) && fuhao[6]=='-'){
			fuhao[6]='+';
		}
		//显示题目
		ti7 = new JLabel("题目七："+srcvlue[6]+fuhao[6]+lastvlue[6]+"=");
		ti7.setFont(new Font("楷体",Font.BOLD,20));
		ti7.setBounds(40, 340, 200, 30);
		panel.add(ti7);
		
		timu7 = new JTextField();
		timu7.setBounds(220, 340, 100, 30);
		panel.add(timu7);
		
		t7 = new JLabel();
		t7.setBounds(330, 340, 30, 30);
		panel.add(t7);
		//将结果存放起来
		if(fuhao[6]=='+'){
			result[6]=(srcvlue[6]+lastvlue[6]);
		}else if(fuhao[6]=='-'){
			if(srcvlue[6]<lastvlue[6]){
				result[6]=(srcvlue[6]+lastvlue[6]);
			}else {
				result[6]=(srcvlue[6]-lastvlue[6]);
			}
		}else if(fuhao[6]=='*'){
			result[6]=(srcvlue[6]*lastvlue[6]);
		}
		System.out.println("题目七：符号："+fuhao[6]+"\t结果:"+result[6]);
		//判断生成的符号，题目8
		if((srcvlue[7]<lastvlue[7]) && fuhao[7]=='-'){
			fuhao[7]='+';
		}
		//显示题目
		ti8 = new JLabel("题目八："+srcvlue[7]+fuhao[7]+lastvlue[7]+"=");
		ti8.setFont(new Font("楷体",Font.BOLD,20));
		ti8.setBounds(40, 380, 200, 30);
		panel.add(ti8);
		
		timu8 = new JTextField();
		timu8.setBounds(220, 380, 100, 30);
		panel.add(timu8);
		
		t8 = new JLabel();
		t8.setBounds(330, 380, 30, 30);
		panel.add(t8);
		//将结果存放起来
		if(fuhao[7]=='+'){
			result[7]=(srcvlue[7]+lastvlue[7]);
		}else if(fuhao[7]=='-'){
			if(srcvlue[7]<lastvlue[7]){
				result[7]=(srcvlue[7]+lastvlue[7]);
			}else {
				result[7]=(srcvlue[7]-lastvlue[7]);
			}
		}else if(fuhao[7]=='*'){
			result[7]=(srcvlue[7]*lastvlue[7]);
		}
		System.out.println("题目八：符号："+fuhao[7]+"\t结果:"+result[7]);
		
		//判断生成的符号，题目9
		if((srcvlue[8]<lastvlue[8]) && fuhao[8]=='-'){
			fuhao[8]='+';
		}
		//显示题目
		ti9 = new JLabel("题目九："+srcvlue[8]+fuhao[8]+lastvlue[8]+"=");
		ti9.setFont(new Font("楷体",Font.BOLD,20));
		ti9.setBounds(40, 420, 200, 30);
		panel.add(ti9);
		
		timu9 = new JTextField();
		timu9.setBounds(220, 420, 100, 30);
		panel.add(timu9);
		
		t9 = new JLabel();
		t9.setBounds(330, 420, 30, 30);
		panel.add(t9);
		//将结果存放起来
		if(fuhao[8]=='+'){
			result[8]=(srcvlue[8]+lastvlue[8]);
		}else if(fuhao[8]=='-'){
			if(srcvlue[8]<lastvlue[8]){
				result[8]=(srcvlue[8]+lastvlue[8]);
			}else {
				result[8]=(srcvlue[8]-lastvlue[8]);
			}
		}else if(fuhao[8]=='*'){
			result[8]=(srcvlue[8]*lastvlue[8]);
		}
		System.out.println("题目九：符号："+fuhao[8]+"\t结果:"+result[8]);
		
		//判断生成的符号，题目9
		if((srcvlue[9]<lastvlue[9]) && fuhao[9]=='-'){
			fuhao[9]='+';
		}
		//显示题目
		ti10 = new JLabel("题目十："+srcvlue[9]+fuhao[9]+lastvlue[9]+"=");
		ti10.setFont(new Font("楷体",Font.BOLD,20));
		ti10.setBounds(40, 460, 200, 30);
		panel.add(ti10);
		
		timu10 = new JTextField();
		timu10.setBounds(220, 460, 100, 30);
		panel.add(timu10);
		
		t10 = new JLabel();
		t10.setBounds(330, 460, 30, 30);
		panel.add(t10);
		//将结果存放起来
		if(fuhao[9]=='+'){
			result[9]=(srcvlue[9]+lastvlue[9]);
		}else if(fuhao[9]=='-'){
			if(srcvlue[9]<lastvlue[9]){
				result[9]=(srcvlue[9]+lastvlue[9]);
			}else {
				result[9]=(srcvlue[9]-lastvlue[9]);
			}
		}else if(fuhao[9]=='*'){
			result[9]=(srcvlue[9]*lastvlue[9]);
		}
		System.out.println("题目十：符号："+fuhao[9]+"\t结果:"+result[9]);
		
		defen = new JLabel("当前得分：");
		defen.setBounds(50, 500, 100, 30);
		panel.add(defen);
		
		out.addActionListener(this);
		in.addActionListener(this);
		add(panel);
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void chuti(){
		for (int i = 0; i <srcvlue.length; i++) {
			srcvlue[i]=new Random().nextInt(89)+10;
		}
		for (int i = 0; i <srcvlue.length; i++) {
			lastvlue[i]=new Random().nextInt(89)+10;
		}
		for (int i = 0; i <yunsuan.length; i++) {
			yunsuan[i]=new Random().nextInt(3);
			if(yunsuan[i]==0){
				fuhao[i]='+';
			}else if(yunsuan[i]==1){
				fuhao[i]='-';
			}else if(yunsuan[i]==2){
				fuhao[i]='*';
			}
		}
		
	}
	public static void main(String[] args) {
		new mainface();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==out){
			if(!timu1.getText().equals("") && !timu2.getText().equals("") &&!timu3.getText().equals("") &&!timu4.getText().equals("") &&!timu5.getText().equals("") &&!timu6.getText().equals("") &&!timu7.getText().equals("") &&!timu8.getText().equals("") &&!timu9.getText().equals("") &&!timu10.getText().equals("")){
				int srcresult[] = new int[10];
				List<Integer> error=new ArrayList<Integer>();
				srcresult[0]=Integer.parseInt(timu1.getText());
				srcresult[1]=Integer.parseInt(timu2.getText());
				srcresult[2]=Integer.parseInt(timu3.getText());
				srcresult[3]=Integer.parseInt(timu4.getText());
				srcresult[4]=Integer.parseInt(timu5.getText());
				srcresult[5]=Integer.parseInt(timu6.getText());
				srcresult[6]=Integer.parseInt(timu7.getText());
				srcresult[7]=Integer.parseInt(timu8.getText());
				srcresult[8]=Integer.parseInt(timu9.getText());
				srcresult[9]=Integer.parseInt(timu10.getText());
				for(int i=0;i<10;i++){
					if(srcresult[i]!=result[i]){
						error.add(i);
					}
				}
				t1.setText(result[0]+"");
				t2.setText(result[1]+"");
				t3.setText(result[2]+"");
				t4.setText(result[3]+"");
				t5.setText(result[4]+"");
				t6.setText(result[5]+"");
				t7.setText(result[6]+"");
				t8.setText(result[7]+"");
				t9.setText(result[8]+"");
				t10.setText(result[9]+"");
				int sum = 100-(error.size()*10);
				for(int j=0;j<10;j++){
					if(error.get(j)==0){
						t1.setForeground(Color.red);
					}else if(error.get(j)==1){
						t2.setForeground(Color.red);
					}else if(error.get(j)==2){
						t3.setForeground(Color.red);
					}else if(error.get(j)==3){
						t4.setForeground(Color.red);
					}else if(error.get(j)==4){
						t5.setForeground(Color.red);
					}else if(error.get(j)==5){
						t6.setForeground(Color.red);
					}else if(error.get(j)==6){
						t7.setForeground(Color.red);
					}else if(error.get(j)==7){
						t8.setForeground(Color.red);
					}else if(error.get(j)==8){
						t9.setForeground(Color.red);
					}else if(error.get(j)==9){
						t10.setForeground(Color.red);
					}
					
				}
				
				if(sum>=90){
					JOptionPane.showMessageDialog(null, "好棒！获得了A，得分为："+sum);
					defen.setText("当前得分："+sum+"   A");
					return;
				}else if(sum>=80 && sum<90){
					JOptionPane.showMessageDialog(null, "恭喜你！获得了B，得分为："+sum);
					defen.setText("当前得分："+sum+"   B");
					return;
				}else if(sum>=70 && sum<80){
					JOptionPane.showMessageDialog(null, "再接再厉！获得了C，得分为："+sum);
					defen.setText("当前得分："+sum+"   C");
					return;
				}else if(sum>=60 && sum<70){
					JOptionPane.showMessageDialog(null, "继续努力！获得了D，得分为："+sum);
					defen.setText("当前得分："+sum+"   D");
					return;
				}else if(sum<60){
					JOptionPane.showMessageDialog(null, "很遗憾！获得了E，得分为："+sum);
					defen.setText("当前得分："+sum+"   E");
					return;
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "试卷为做完，不能交卷！");
				return;
			}
			
		}else if (e.getSource()==in) {
			dispose();
			new mainface();
		}
		
	}

	
}
