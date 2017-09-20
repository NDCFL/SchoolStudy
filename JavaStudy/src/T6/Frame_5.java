package T6;

import java.awt.*;
public class Frame_5 extends Frame{
		
		public Frame_5(){
			
			Panel p3=new Panel();
			
			Label label1=new Label("变量名(N)");
			Label label2=new Label("变量名(V)");
			Label label3=new Label("                             ");
			
			TextField text1=new TextField("TEMP",18);
			TextField text2=new TextField("%USERPROFILE%\\Local Settings\\Temp",18);
			
			Button submit=new Button("确定");
			Button cancel=new Button("取消");
			setTitle("布局控制");
			this.setLayout(new BorderLayout());
			p3.add(label1);
			p3.add(text1);
			
			p3.add(label2);
			p3.add(text2);

			p3.add(label3);
			p3.add(submit);
			p3.add(cancel);
			
			
			this.add(p3);
			//this.setBackground(Color.gray);
			this.setSize(240,130);
			this.setVisible(true);
		}
		
		public static void main(String args[]){
			new Frame_5();	
		}
	}


