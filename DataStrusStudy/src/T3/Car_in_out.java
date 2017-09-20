package T3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Car_in_out extends JFrame implements KeyListener, ActionListener {
	private int num;
	private ImagePanel imagePanel;
	private JPanel p;
	private JButton in;
	private JButton out;
	private LoopQueue lq;
	private int id;
	boolean isClear = false;

	public Car_in_out(int size) {
		imagePanel = new ImagePanel();
		add(imagePanel, BorderLayout.CENTER);
		this.num = num + 1;
		p = new JPanel();
		in = new JButton("进站了");
		in.setBounds(100, 400, 100, 60);
		in.setFont(new Font("华文行楷", Font.BOLD, 18));
		in.setForeground(Color.blue);
		out = new JButton("出站啦");
		out.setBounds(510, 400, 100, 60);
		out.setFont(new Font("华文行楷", Font.BOLD, 18));
		out.setForeground(Color.blue);
		lq = new LoopQueue();
		in.addActionListener(this);
		out.addActionListener(this);
//		in.addKeyListener(this);//键盘的监听事件
//		out.addKeyListener(this);
		p.add(in);
		p.add(out);
		add(p, BorderLayout.NORTH);
		setSize(1300, 500);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == in) {
			isClear = true;
			id = lq.inQueue("1");
			imagePanel.updateUI();
		} else if (e.getSource() == out) {
			isClear = false;
			id = lq.outQueue();
			imagePanel.updateUI();
		}
	}

	class ImagePanel extends JPanel {
		int width = 130;
		int height = 120;

		public void paint(Graphics g) {
			if (id > -1) {
				System.out.println(id);
				if (isClear) {
					Image icon = new ImageIcon("qq.jpg").getImage();
					g.drawImage(icon, width * (id - 1), 0, width, height,
							Color.black, null);
				} else {
					Image icon = new ImageIcon("clear.JPG").getImage();
					g.drawImage(icon, width * (id - 1), 0, width, height,
							Color.BLACK, null);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Car_in_out(10);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 38) {
			isClear = true;
			id = lq.inQueue("1");
			imagePanel.updateUI();
		} else if (e.getKeyCode() == 40) {
			isClear = false;
			id = lq.outQueue();
			imagePanel.updateUI();
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
