package zuoye;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.PageAttributes.ColorType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sun.java_cup.internal.internal_error;
import com.sun.org.apache.bcel.internal.generic.StackConsumer;

public class Txz {
	public static void main(String[] args) {
		new Game();
		// new ReadMap(1);
	}
}

// 界面类
class Game extends JFrame implements ActionListener {
	JButton regret, first, next, top;
	JButton last, select, musicclose, again;
	JComboBox cbMusic;
	JMenuBar menuBar;
	JMenu mnuOption, mnuSet, mnuHelp;
	JMenuItem miReset, miPrev, miNext, miSelect, miExit, miBack;
	JMenuItem miMusic1, miMusic2, miMusic3, miMusic4, miMusic5;
	JMenuItem miHelp;
	final int MAXLEVEL = 50;
	// 音乐文件
	String sMusicFile[] = { "nor.mid", "qin.mid", "popo.mid", "guang.mid",
			"eyes on me.mid" };
	String sMusic[] = { "默认", "琴箫合奏", "泡泡堂", "灌篮高手", "eyes on me" };
	// 创建MyPanel类
	MyPanel mainPanel;

	public Game() {
		super("PLAY  GAME");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("pic/3.gif");
		// 设置图标
		setIconImage(image);
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		JLabel lblTitle = new JLabel("推箱子2016版", JLabel.CENTER);
		lblTitle.setFont(new Font("华文行楷", Font.BOLD, 32));
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setBounds(170, 20, 200, 50);
		c.add(lblTitle);
		// 调用创建按钮的函数
		createButton(c);
		// 调用创建菜单的函数
		createMenus();

		mainPanel = new MyPanel();
		mainPanel.setBounds(0, 60, 600, 600);
		c.add(mainPanel);
		setSize(720, 720);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置默认焦点
		mainPanel.requestFocus();
	}

	// 创建按钮函数
	public void createButton(Container c) {
		// 右边放一排按钮
		again = new JButton("重 来");
		again.setForeground(Color.black);
		again.setFont(new Font("华文行楷", Font.BOLD, 20));
		regret = new JButton("悔一步");
		regret.setForeground(Color.blue);
		regret.setFont(new Font("华文行楷", Font.BOLD, 20));
		first = new JButton("第一关");
		first.setForeground(Color.cyan);
		first.setFont(new Font("华文行楷", Font.BOLD, 20));
		next = new JButton("下一关");
		next.setForeground(Color.DARK_GRAY);
		next.setFont(new Font("华文行楷", Font.BOLD, 20));
		top = new JButton("上一关");
		top.setForeground(Color.gray);
		top.setFont(new Font("华文行楷", Font.BOLD, 20));
		last = new JButton("最终关");
		last.setForeground(Color.green);
		last.setFont(new Font("华文行楷", Font.BOLD, 20));
		select = new JButton("选 关");
		select.setForeground(Color.LIGHT_GRAY);
		select.setFont(new Font("华文行楷", Font.BOLD, 20));
		musicclose = new JButton("音乐关");
		musicclose.setForeground(Color.magenta);
		musicclose.setFont(new Font("华文行楷", Font.BOLD, 20));
		JLabel lblMusic = new JLabel("选择音乐");
		lblMusic.setForeground(Color.magenta);
		lblMusic.setFont(new Font("华文行楷", Font.BOLD, 20));
		cbMusic = new JComboBox(sMusic);
		cbMusic.setForeground(Color.green);
		cbMusic.setFont(new Font("华文行楷", Font.BOLD, 20));

		again.setBounds(610, 70, 98, 30);
		regret.setBounds(610, 130, 98, 30);
		first.setBounds(610, 180, 98, 30);
		next.setBounds(610, 230, 98, 30);
		top.setBounds(610, 280, 98, 30);
		last.setBounds(610, 330, 98, 30);
		select.setBounds(610, 380, 98, 30);
		musicclose.setBounds(610, 430, 98, 30);
		lblMusic.setBounds(610, 480, 98, 20);
		cbMusic.setBounds(610, 500, 80, 30);
		// 监听
		again.addActionListener(this);
		regret.addActionListener(this);
		first.addActionListener(this);
		next.addActionListener(this);
		top.addActionListener(this);
		last.addActionListener(this);
		select.addActionListener(this);
		musicclose.addActionListener(this);
		cbMusic.addActionListener(this);

		c.add(again);
		c.add(regret);
		c.add(first);
		c.add(next);
		c.add(top);
		c.add(last);
		c.add(select);
		c.add(musicclose);
		c.add(lblMusic);
		c.add(cbMusic);
	}

	// 创建菜单函数
	public void createMenus() {
		// 创建选项子菜单
		mnuOption = new JMenu("Option");
		mnuOption.setForeground(Color.green);
		mnuOption.setFont(new Font("宋体", Font.BOLD, 20));
		miBack = new JMenuItem("悔一步");
		miReset = new JMenuItem("重置");
		miPrev = new JMenuItem("上一关");
		miNext = new JMenuItem("下一关");
		miSelect = new JMenuItem("选关");
		miExit = new JMenuItem("退出");

		mnuOption.add(miBack);
		mnuOption.add(miReset);
		mnuOption.add(miPrev);
		mnuOption.add(miNext);
		mnuOption.add(miSelect);
		mnuOption.addSeparator();
		mnuOption.add(miExit);
		// 设置子菜单
		mnuSet = new JMenu("Set");
		mnuSet.setForeground(Color.blue);
		mnuSet.setFont(new Font("宋体", Font.BOLD, 20));
		miMusic1 = new JMenuItem(sMusic[0]);
		miMusic2 = new JMenuItem(sMusic[1]);
		miMusic3 = new JMenuItem(sMusic[2]);
		miMusic4 = new JMenuItem(sMusic[3]);
		miMusic5 = new JMenuItem(sMusic[4]);
		mnuSet.add(miMusic1);
		mnuSet.add(miMusic2);
		mnuSet.add(miMusic3);
		mnuSet.add(miMusic4);
		mnuSet.add(miMusic5);
		// 帮助子菜单
		mnuHelp = new JMenu("Help(H)");
		mnuHelp.setForeground(Color.magenta);
		mnuHelp.setFont(new Font("宋体", Font.BOLD, 20));
		mnuHelp.setMnemonic('H');

		miHelp = new JMenuItem("关于我们...");
		mnuHelp.add(miHelp);

		// 监听
		miBack.addActionListener(this);
		miReset.addActionListener(this);
		miNext.addActionListener(this);
		miPrev.addActionListener(this);
		miExit.addActionListener(this);
		miSelect.addActionListener(this);
		miMusic1.addActionListener(this);
		miMusic2.addActionListener(this);
		miMusic3.addActionListener(this);
		miMusic4.addActionListener(this);
		miMusic5.addActionListener(this);
		miHelp.addActionListener(this);

		menuBar = new JMenuBar();
		menuBar.add(mnuOption);
		menuBar.add(mnuSet);
		menuBar.add(mnuHelp);
		setJMenuBar(menuBar);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == miHelp) {
			String str = "作者:乐荣萍\n";
			str += "Q Q:1654905415\n";
			JOptionPane.showMessageDialog(this, str, "帮助",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == miExit) {
			System.exit(0);
		} else if (e.getSource() == first) {
			mainPanel.setLevel(0);
		} else if (e.getSource() == next) {
			mainPanel.setLevel(1);
		} else if (e.getSource() == top) {
			mainPanel.setLevel(-1);
		} else if (e.getSource() == last) {
			mainPanel.setLevel(MAXLEVEL);
		} else if (e.getSource() == select) {
			String slevel = JOptionPane.showInputDialog(this, "请输入1~50之间的关卡编号",
					"选关", JOptionPane.OK_CANCEL_OPTION);
			if (slevel != null) {
				try {
					int level = Integer.parseInt(slevel);
					if (level <= 0 || level >= 50) {
						JOptionPane.showMessageDialog(this,
								"关卡不存在，请输入1~50之间的数字");
						return;
					}
					mainPanel.setLevel(level);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "非法字符，请输入1~50之间的数字");
					return;
				}
			}
			System.out.println(slevel);
		} else if (e.getSource() == regret) {
			mainPanel.regret();
			mainPanel.requestFocus(); // 焦点

		}
	}

	// 游戏面板
	class MyPanel extends JPanel implements KeyListener {
		private int level = 1;
		private int mx;
		private int my;
		// 原始数据
		private int map[][];
		// 临时数据
		private int tempMap[][];
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image mapimg[] = { kit.getImage("pic/0.gif"),
				kit.getImage("pic/1.gif"), kit.getImage("pic/2.gif"),
				kit.getImage("pic/3.gif"), kit.getImage("pic/4.gif"),
				kit.getImage("pic/5.gif"), kit.getImage("pic/6.gif"),
				kit.getImage("pic/7.gif"), kit.getImage("pic/8.gif"),
				kit.getImage("pic/9.gif"), };
		/*
		 * 堆栈，保存推箱子过程中的每一个步骤 向左：(向左没推箱子保存1，若向左推了箱子则保存11) 没有推箱子 1 推箱子 11 向上：
		 * 没有推箱子 2 推箱子 22 向右： 没有推箱子 3 推箱子 33 向下： 没有推箱子 4 推箱子 44
		 */
		Stack<Integer> step = new Stack<Integer>();

		// 读取地图；
		public void readFile(int level) {

			Read readMap = new Read(level);
			// 原始数据
			this.map = readMap.getMap();
			this.mx = readMap.getMx();
			this.my = readMap.getMy();
			// 临时数据，推箱子的过程中，该数组的值会发生变化
			this.tempMap = new Read(level).getMap();
			// 重画
			repaint();
		}

		public MyPanel() {
			// 监听键盘事件
			this.addKeyListener(this);
			setSize(600, 600);
			readFile(level);
		}

		@Override
		public void paint(Graphics g) {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					g.drawImage(mapimg[tempMap[j][i]], i * 30, j * 30, 30, 30,
							this);
				}
			}
			// 白色RGB;255*255*255
			g.setColor(new Color(255, 0, 255));
			g.setFont(new Font("华文行楷", Font.BOLD, 20));
			g.drawString("现在是第" + level + "关", 210, 40);
		}

		// 判断箱子是否已经全部推到位了
		public boolean isWin() {
			boolean isok = true;
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					if ((map[i][j] == 4 || map[i][j] == 9)
							&& tempMap[i][j] != 9) {
						isok = false;
						break;
					}
				}
				if (!isok)
					break;
			}
			return isok;
		}

		// 设置关卡
		public void setLevel(int level) {
			if (level == 0) {// 第一关
				this.level = 1;
			} else if (level == 50) {// 最后一关
				this.level = 50;
			} else if (level > 1) {// 选关
				this.level = level;
			} else {
				this.level = this.level + level;
			}
			if (this.level <= 0) {
				this.level = 1;
			} else if (this.level >= 50) {
				this.level = 50;
			}
			readFile(this.level);
			// 清空上一关保存在堆栈中的步骤
			step.clear();
			// 设置焦点
			requestFocus();
		}

		public void keyPressed(KeyEvent e) {
			// 方向键左键的值
			if (e.getKeyCode() == 37) {
				goLeft();
			} else if (e.getKeyCode() == 38) {// 方向键向上键的值
				goUp();
			} else if (e.getKeyCode() == 39) {// 方向键向右键的值
				goRight();
			} else if (e.getKeyCode() == 40) {// 方向键向下键的值
				goDown();
			}
			if (isWin()) {
				JOptionPane.showMessageDialog(null, "恭喜您过关了，进入下一关");
				setLevel(1);
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}

		// 0-地图 1-房子 2-草地 3-需要推的箱子 4-目标 9-红色箱
		public void goLeft() {
			// 人的左边有箱子
			if (tempMap[mx][my - 1] == 3 || tempMap[mx][my - 1] == 9) {
				// 箱子的左边是草地2或者4就可以左边推箱子
				if (tempMap[mx][my - 2] == 2 || tempMap[mx][my - 2] == 4) {
					if (tempMap[mx][my - 2] == 2) {
						tempMap[mx][my - 2] = 3;
						tempMap[mx][my - 1] = 6;
					} else {
						tempMap[mx][my - 2] = 9;
						tempMap[mx][my - 1] = 6;
					}
					// 原来站人的地方要与原始地图进行比较(map数组)
					if (map[mx][my] == 4 || map[mx][my] == 9) {
						tempMap[mx][my] = 4;
					} else {
						tempMap[mx][my] = 2;
					}
					my--;
					step.push(11); // 向左推了箱子则保存11
				}
				// 前面是草地
			} else if (tempMap[mx][my - 1] == 2 || tempMap[mx][my - 1] == 4
					|| tempMap[mx][my - 1] == 5) {
				tempMap[mx][my - 1] = 6;
				// 原来站人的地方要与原始地图进行比较(map数组)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
				}
				my--;
				step.push(1); // 向左没推箱子则保存1
			}
			repaint();

		}

		public void goUp() {
			// 人的上面有箱子
			if (tempMap[mx - 1][my] == 3 || tempMap[mx - 1][my] == 9) {
				// 箱子的上面是草地2或者4就可以向上推箱子
				if (tempMap[mx - 2][my] == 2 || tempMap[mx - 2][my] == 4) {
					if (tempMap[mx - 2][my] == 2) {
						tempMap[mx - 2][my] = 3;
						tempMap[mx - 1][my] = 8;
					} else {
						tempMap[mx - 2][my] = 9;
						tempMap[mx - 1][my] = 8;
					}
					// 原来站人的地方要与原始地图进行比较(map数组)
					if (map[mx][my] == 4 || map[mx][my] == 9) {
						tempMap[mx][my] = 4;
					} else {
						tempMap[mx][my] = 2;
					}
					mx--;
					step.push(22);
				}
				// 前面是草地
			} else if (tempMap[mx - 1][my] == 2 || tempMap[mx - 1][my] == 4
					|| tempMap[mx - 1][my] == 5) {
				tempMap[mx - 1][my] = 8;
				// 原来站人的地方要与原始地图进行比较(map数组)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
				}
				mx--;
				step.push(2);
			}
			repaint();
		}

		public void goRight() {
			// 人的右边有箱子
			if (tempMap[mx][my + 1] == 3 || tempMap[mx][my + 1] == 9) {
				// 箱子的右边是草地2或者4就可以右边推箱子
				if (tempMap[mx][my + 2] == 2 || tempMap[mx][my + 2] == 4) {
					if (tempMap[mx][my + 2] == 2) {
						tempMap[mx][my + 2] = 3;
						tempMap[mx][my + 1] = 7;
					} else {
						tempMap[mx][my + 2] = 9;
						tempMap[mx][my + 1] = 7;
					}
					// 原来站人的地方要与原始地图进行比较(map数组)
					if (map[mx][my] == 4 || map[mx][my] == 9) {
						tempMap[mx][my] = 4;
					} else {
						tempMap[mx][my] = 2;
					}
					my++;
					step.push(33);
				}
				// 右面是草地
			} else if (tempMap[mx][my + 1] == 2 || tempMap[mx][my + 1] == 4
					|| tempMap[mx][my + 1] == 5) {
				tempMap[mx][my + 1] = 7;
				// 原来站人的地方要与原始地图进行比较(map数组)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
				}
				my++;
				step.push(3);
			}
			repaint();

		}

		public void goDown() {
			// 人的下面有箱子
			if (tempMap[mx + 1][my] == 3 || tempMap[mx + 1][my] == 9) {
				// 箱子的下面是草地2或者4就可以向下推箱子
				if (tempMap[mx + 2][my] == 2 || tempMap[mx + 2][my] == 4) {
					if (tempMap[mx + 2][my] == 2) {
						tempMap[mx + 2][my] = 3;
						tempMap[mx + 1][my] = 5;
					} else {
						tempMap[mx + 2][my] = 9;
						tempMap[mx + 1][my] = 5;
					}
					// 原来站人的地方要与原始地图进行比较(map数组)
					if (map[mx][my] == 4 || map[mx][my] == 9) {
						tempMap[mx][my] = 4;
					} else {
						tempMap[mx][my] = 2;
					}
					mx++;
					step.push(44);
				}
				// 前面是草地
			} else if (tempMap[mx + 1][my] == 2 || tempMap[mx + 1][my] == 4
					|| tempMap[mx + 1][my] == 5) {
				tempMap[mx + 1][my] = 5;
				// 原来站人的地方要与原始地图进行比较(map数组)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
				}
				mx++;
				step.push(4);
			}
			repaint();
		}

		// 当点击悔一步按钮时,该函数会被调用(这是按钮,需要在按钮事件中调用这个函数)
		public void regret() {
			if (step.isEmpty()) { // 首先判断堆栈是否为空,若为空则终止 isEmpty判断堆栈中是否有元素
				JOptionPane.showMessageDialog(null, "已是初始状态");
				return;
			}
			int n = step.pop(); // 若不为空，则取出数据 堆栈中push为新增元素,pop为取出元素
			switch (n) { // 判断元素的值
			case 1:
			case 11:
				regretLeft(n);
				break;
			case 2:
			case 22:
				regretUp(n);
				break;
			case 3:
			case 33:
				regretRight(n);
				break;
			case 4:
			case 44:
				regretDown(n);
				break;
			}
			// 设置焦点
			requestFocus();
		}

		// 创建悔一步函数
		public void regretLeft(int step) { // 没有推箱子
			if (step == 1) { // 没有推箱子
				tempMap[mx][my + 1] = 6;
				// 原来站人的地方，后退一步后变成空地(4-目标 或者 2-草地)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
					my++;
				}
			} else { // 推了箱子
				tempMap[mx][my + 1] = 6;
				// 后退后,原来站人的地方现在变成了箱子
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 9;
				} else {
					tempMap[mx][my] = 3;
				}
				// 原来放箱子的地方,现在变成空地
				if (map[mx][my - 1] == 4 || map[mx][my - 1] == 9) {
					tempMap[mx][my - 1] = 4;
				} else {
					tempMap[mx][my - 1] = 2;
				}
				my++;
			}
			// 重画界面
			repaint();
		}

		public void regretUp(int step) {
			if (step == 2) { // 没有推箱子
				tempMap[mx + 1][my] = 8;
				// 原来站人的地方，后退一步后变成空地(4-目标 或者 2-草地)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
					mx++;
				}
			} else { // 推了箱子
				tempMap[mx + 1][my] = 6;
				// 后退后,原来站人的地方现在变成了箱子
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 9;
				} else {
					tempMap[mx][my] = 3;
				}
				// 原来放箱子的地方,现在变成空地
				if (map[mx - 1][my] == 4 || map[mx - 1][my] == 9) {
					tempMap[mx - 1][my] = 4;
				} else {
					tempMap[mx - 1][my] = 2;
				}
				mx++;
			}
			// 重画界面
			repaint();
		}

		public void regretRight(int step) {
			if (step == 3) { // 没有推箱子
				tempMap[mx][my - 1] = 7;
				// 原来站人的地方，后退一步后变成空地(4-目标 或者 2-草地)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
					my--;
				}
			} else { // 推了箱子
				tempMap[mx][my - 1] = 8;
				// 后退后,原来站人的地方现在变成了箱子
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 9;
				} else {
					tempMap[mx][my] = 3;
				}
				// 原来放箱子的地方,现在变成空地
				if (map[mx][my + 1] == 4 || map[mx][my + 1] == 9) {
					tempMap[mx][my + 1] = 4;
				} else {
					tempMap[mx][my + 1] = 2;
				}
				my--;
			}
			// 重画界面
			repaint();

		}

		public void regretDown(int step) {
			if (step == 4) { // 没有推箱子
				tempMap[mx - 1][my] = 5;
				// 原来站人的地方，后退一步后变成空地(4-目标 或者 2-草地)
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 4;
				} else {
					tempMap[mx][my] = 2;
					mx--;
				}
			} else { // 推了箱子
				tempMap[mx - 1][my] = 5;
				// 后退后,原来站人的地方现在变成了箱子
				if (map[mx][my] == 4 || map[mx][my] == 9) {
					tempMap[mx][my] = 9;
				} else {
					tempMap[mx][my] = 3;
				}
				// 原来放箱子的地方,现在变成空地
				if (map[mx + 1][my] == 4 || map[mx + 1][my] == 9) {
					tempMap[mx + 1][my] = 4;
				} else {
					tempMap[mx + 1][my] = 2;
				}
				mx--;
			}
			// 重画界面
			repaint();
		}
	}
}

// 读取地图文件
class Read {
	private int map[][];
	private int mx, my;
	// 保存游戏关卡编号
	private int level;

	public Read(int level) {
		this.level = level;
		String sfilename = "maps/" + level + ".map";
		String content = "";
		// 用字符流读取文件中的地图数据
		try {
			FileReader fr = new FileReader(sfilename);
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			// 一行一行的读取文件的内容，如果读到文件的末尾，则返回null值
			while ((temp = br.readLine()) != null) {
				content += temp;
			}
			// 转换成字节数组,共有400个元素
			byte b[] = content.getBytes();

			map = new int[20][20];
			int c = 0;
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					map[i][j] = b[c] - 48;

					c++;
					if (map[i][j] == 5) {
						mx = i;
						my = j;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[][] getMap() {
		return map;
	}

	public int getMx() {
		return mx;
	}

	public int getMy() {
		return my;
	}
}
