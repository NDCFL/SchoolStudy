package T7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Event_3 extends JFrame implements MouseListener,MouseMotionListener{

	Label area;
	//默认的构造函数
	public Event_3() {
		super("鼠标事件");
		area = new Label("鼠标的状态:",Label.CENTER);//鼠标状态显示的方向
		setBackground(Color.CYAN);
		setSize(500,500);
		addMouseListener(this);
		addMouseMotionListener(this);
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
	//鼠标进入某个控制区域
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//area.setText("进入了区域");
	}
	//鼠标离开
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//area.setText("离开了区域");
	}
	//鼠标按键，左右键，单击键，双击键
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//area.setText("按下了鼠标");
	}
	//鼠标的放开
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//area.setText("放开了鼠标");
	}
	//鼠标的拖动
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//area.setText("拖动了鼠标");
	}
	//鼠标的移动
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		area.setText("移动了鼠标:X的坐标="+e.getX()+",Y的坐标="+e.getY());
	}
	public static void main(String[] args) {
		new Event_3();
	}
	
}
