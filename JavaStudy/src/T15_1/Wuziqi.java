package T15_1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;

public class Wuziqi extends JFrame implements MouseListener{
	Vector v=new Vector();
	public Wuziqi(){
		super("五子棋游戏");
		this.addMouseListener(this);
		this.setSize(435,465);
		setVisible(true);
	}
	public void paint(Graphics g){
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Image img1=toolkit.getImage("image/Board.gif");	
		Image imgBlack=toolkit.getImage("image/black.gif");	
		Image imgWhite=toolkit.getImage("image/white.gif");
		g.drawImage(img1,0,20,this);
		for(int i=0;i<v.size();i++){
			String str=(String)v.get(i);
			String tmp[]=str.split("-");			
			int a=Integer.parseInt(tmp[0]);
			int b=Integer.parseInt(tmp[1]);						
			int x=b*25+18-12;
			int y=a*25+39-12;
			if(i%2==0)
				g.drawImage(imgBlack,x,y,this);
			else
				g.drawImage(imgWhite,x,y,this);
		}
	}
	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		int gridy=(x-18)/25+((x-18)%25>12?1:0);
		int gridx=(y-39)/25+((y-39)%25>12?1:0);
		
		System.out.println(gridx+"-"+gridy);
		
		if(!v.contains(gridx+"-"+gridy)){
			v.add(gridx+"-"+gridy);
		}
		this.repaint();
	}

	
	public static void main(String[] args) {
		new Wuziqi();
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
