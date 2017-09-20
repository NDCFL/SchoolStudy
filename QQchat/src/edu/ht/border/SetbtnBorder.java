package edu.ht.border;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SetbtnBorder extends JFrame implements MouseListener{
	JButton button= null;
	public SetbtnBorder(JButton button){
		this.button = button;
		button.addMouseListener(this);
	}
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==button){
			button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		}
		
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==button){
			button.setBorder(null);
		}
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

}
