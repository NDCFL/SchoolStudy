package T7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.security.PublicKey;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Event_4 extends JFrame {

	Label area;
	//默认的构造函数
	public Event_4() {
		super("鼠标事件");
		area = new Label("鼠标的状态:",Label.CENTER);//鼠标状态显示的方向
		setBackground(Color.CYAN);
		setSize(500,500);
		addMouseListener(new MouseAdapterHandle());
		add(area,BorderLayout.SOUTH);//添加到容器里
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//鼠标点击
	public void mouseClicked(MouseEvent e) {
		//JOptionPane.showMessageDialog(this, "点击了鼠标");
		//area.setText("点击了鼠标");
		if(e.getClickCount()==1){
			if (e.getButton()==1) {
				area.setText("点击了鼠标左键");
			}else if(e.getButton()==3){
				area.setText("点击了鼠标右键");
			}
			
		}else if(e.getClickCount()==2){
			area.setText("双击了鼠标");
		}
	}
	//适配器
	class MouseAdapterHandle extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getClickCount()==1){
				if (e.getButton()==1) {
					area.setText("点击了鼠标左键");
				}else if(e.getButton()==3){
					area.setText("点击了鼠标右键");
				}
				
			}else if(e.getClickCount()==2){
				area.setText("双击了鼠标");
			}
		}
	}
	public static void main(String[] args) {
		new Event_4();
	}
	
}
