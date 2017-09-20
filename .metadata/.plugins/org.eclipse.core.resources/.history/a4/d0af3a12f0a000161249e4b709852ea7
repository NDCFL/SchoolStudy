package edu.ht.border;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SetlblBorder extends JFrame implements MouseListener{

	JLabel label= null;
	public SetlblBorder(JLabel label){
		this.label = label;
		label.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==label){
			label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		}
		
	}

	public void mouseExited(MouseEvent e) {
		if(e.getSource()==label){
			label.setBorder(null);
		}
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
