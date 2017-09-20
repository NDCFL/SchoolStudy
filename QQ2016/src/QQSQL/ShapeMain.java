package QQSQL;

//#8.15 
//#filename: ShapeMain.java 
import java.awt.BorderLayout; //布局管理器的一种，一个面板分东南西北中五个区，       用于放置控间，这样GUI在放大缩小，移植的时候方便
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;// 一般的 Abstract Window Toolkit(AWT) 容器对象是一个可包含其他 AWT 组件的组件
import java.awt.Graphics; //定义一个真正的工具,用来接受图形操作
import java.awt.Panel; // Panel 是最简单的容器类
import java.awt.event.ActionEvent; //知道如何对自身进行指派的事件的接口
import java.awt.event.ActionListener; //用于接收操作事件的侦听器接口
import java.awt.event.MouseAdapter; //接收鼠标事件的抽象适配器类
import java.awt.event.MouseEvent; //鼠标事件
import java.awt.event.MouseListener; //用于接收组件上“感兴趣”的鼠标事件（按下、释放、单击、进入或离开）的侦听器接口。
import java.awt.event.MouseMotionAdapter; //接收鼠标移动事件的适配器
import java.awt.event.MouseMotionListener; //用于接收组件上的鼠标移动事件的侦听器接口

import javax.swing.ButtonGroup; //此类用于为一组按钮创建一个多斥（multiple-exclusion）作用域
import javax.swing.JFrame; //java.awt.Frame 的扩展版本，该版本添加了对 JFC/Swing 组件架构的支持
import javax.swing.JPanel;//是一般轻量级容器
import javax.swing.UIManager; //此类跟踪当前的外观及其默认设置
//import javax.swing.Component; //对数据和方法的简单封装

class ShapeMain extends JFrame implements ActionListener, MouseListener,
		MouseMotionListener {
	int x, y, x1, y1, x2, y2, width, height;
	boolean isFirstPoint = true;
	// 初始化开始画的是线
	int drawType = PaintingGround.LINE;
	// 初始化开始不是填充
	boolean isFill = false;
	// 添加控件
	ButtonGroup btg = new ButtonGroup();
	Button btLine = new Button("线");
	Button btRectangle = new Button("矩形");
	Button btRound = new Button("圆");
	Button btEllipse = new Button("椭圆");
	Button tbFillState = new Button("填充");
	Button button3 = new Button("文本操作");
	Button button2 = new Button("清除");
	Button button1 = new Button("选择颜色");

	Panel buttonPanel = new Panel();
	PaintingGround paintingGround = new PaintingGround();

	// Main Method
	public static void main(String[] args) {
		// 设置显示外观
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new ShapeMain();
	}

	// 构造函数
	public ShapeMain() {
		// 控件添加到控件组中
		// btg.add(btLine);
		// btg.add(btRectangle);
		// btg.add(btRound);
		// btg.add(btEllipse);

		buttonPanel.add(btLine);
		buttonPanel.add(btRectangle);
		buttonPanel.add(btRound);
		buttonPanel.add(btEllipse);
		buttonPanel.add(tbFillState);

		// 设置容器及容器的整体布局
		Container cp = this;

		cp.setLayout(new BorderLayout());

		cp.add(BorderLayout.NORTH, buttonPanel);
		cp.add(BorderLayout.CENTER, paintingGround);
		// cp.add(BorderLayout.SOUTH,jf);
		// jf.setJMenuBar(mb);
		setLocation(300, 150);
		setSize(600, 480);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 添加鼠标触发事件
		paintingGround.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent evn) {
				isFirstPoint = true;
			}
		});
		// 对鼠标的输入进行判断并调用画图程序
		paintingGround.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evn) {
				if (isFirstPoint) {
					x1 = evn.getX();
					y1 = evn.getY();
					isFirstPoint = false;
				} else {
					x2 = evn.getX();
					y2 = evn.getY();
					switch (drawType) {
					case PaintingGround.LINE:
						// 画线
						paintingGround.drawLine(x1, y1, x2, y2);
						break;
					case PaintingGround.RECTANGLE:
						// 画矫形
						paintingGround.drawRect(x1, y1, x2 - x1, y2 - y1);
						break;
					case PaintingGround.ROUND:
						// 画圆
						// 两点距离公式
						int size = Math.abs((int) Math.sqrt((x2 - x1)
								* (x2 - x1) + (y2 - y1) * (y2 - y1)));
						paintingGround.drawRound(x1, y1, size);
						break;
					case PaintingGround.ELLIPSE:
						// 画椭圆
						paintingGround.drawEllipse(x1, y1, x2 - x1, y2 - y1);
						break;
					default:
						break;
					}
				}
			}
		});
		// 各个控件的触发事件
		btLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				drawType = PaintingGround.LINE;
			}
		});

		btRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				drawType = PaintingGround.RECTANGLE;
			}
		});

		btRound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				drawType = PaintingGround.ROUND;
			}
		});

		btEllipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				drawType = PaintingGround.ELLIPSE;
			}
		});

		tbFillState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evn) {
				isFill = tbFillState.isShowing();
				paintingGround.setFillState(isFill);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

class PaintingGround extends JPanel {
	public static final int LINE = 1;
	public static final int RECTANGLE = 2;
	public static final int ROUND = 3;
	public static final int ELLIPSE = 4;

	private int x, y;
	private int x1, y1, x2, y2;
	private int width, height, size;
	private int drawType = 0;
	private boolean isFill = false;

	// 构造函数
	public PaintingGround() {
		setBackground(Color.black);
	}

	// 判断是用实心还是空心的,
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		if (isFill) {
			switch (drawType) {
			case LINE:
				g.drawLine(x1, y1, x2, y2);
				break;
			case RECTANGLE:
				g.fillRect(x, y, width, height);
				break;
			case ROUND:
				g.fillOval(x, y, size, size);
				break;
			case ELLIPSE:
				g.fillOval(x, y, width, height);
				break;
			default:
				break;
			}
		} else {
			switch (drawType) {
			case LINE:
				g.drawLine(x1, y1, x2, y2);
				break;
			case RECTANGLE:
				g.drawRect(x, y, width, height);
				break;
			case ROUND:
				g.drawOval(x, y, size, size);
				break;
			case ELLIPSE:
				g.drawOval(x, y, width, height);
				break;
			default:
				break;
			}
		}
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

		drawType = LINE;
		repaint();
	}

	// 具体的实现方式
	public void drawRect(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		drawType = RECTANGLE;
		repaint();
	}

	public void drawRound(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		drawType = ROUND;
		repaint();
	}

	public void drawEllipse(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		drawType = ELLIPSE;
		repaint();
	}

	public void setFillState(boolean isFill) {
		this.isFill = isFill;
	}

}