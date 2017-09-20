package T8;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class AppletEventApp extends Applet implements MouseListener{
	int startX,startY;
	int endX,endY;
	public void init(){
		//setBackground(Color.black);
	}
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawLine(startX,startY,endX,endY);
	}
	public void update(Graphics g){
		this.paint(g);
	}
	public void mousePressed(MouseEvent e) {
		this.startX=e.getX();
		this.startY=e.getY();	
	}
	public void mouseReleased(MouseEvent e) {
		this.endX=e.getX();
		this.endY=e.getY();	
		this.repaint();
	}
	public void start(){
		this.addMouseListener(this);	
	}	
	public void stop(){	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}