package QQfase;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import QQSQL.QQminlin;
import QQSQL.SendCmd;
import QQSQL.SendMsg;
import QQbean.QQidtable;
import SQLBase.OpenWeb;
import SQLBase.QQbase;
public class Chatfase extends JFrame implements ActionListener, MouseListener ,KeyListener{

	JLabel bg, min, exit, send, close, head, name, hobot,doudong,jiepin;
	JLabel jlhead1, jlhead2, qianming, title,btnfile;
	JTextPane txtread, txtwrite;
	JTextField tbendi, jduifangarea, tduifang;
	QQidtable idtable, friendtable;
	Font fontstyle;
	Vector<QQidtable> friendGroup;
	JLabel cbsize, cbFont,shiping;
	JLabel color;
	QQbase qqbase = new QQbase();
	JMenuItem sonti, heiti, kaiti, lishu, size1, size2, size3, size4, size5,size6, size7, size8;
	JPopupMenu font, size;
	public Chatfase(QQidtable idtable, QQidtable friendtable,Vector<QQidtable> friendGroup) {
		this.idtable = idtable;
		this.friendtable = friendtable;
		this.friendGroup=friendGroup;
		setUndecorated(true);
		bg = new JLabel(new ImageIcon("photo/chat.jpg"));
		// 绝对布局
		bg.setLayout(null);
		add(bg);

		exit = new JLabel(" ");
		exit.setBounds(565, 3, 20, 20);
		bg.add(exit);

		min = new JLabel("  ");
		min.setBounds(505, 3, 20, 20);
		bg.add(min);

		head = new JLabel(new ImageIcon(friendtable.getQQhead()));
		head.setBounds(6, 2, 48, 48);
		bg.add(head);

		name = new JLabel(friendtable.getQQname());
		name.setBounds(60, 5, 60, 20);
		bg.add(name);

		btnfile = new JLabel("   ");
		btnfile.setBounds(130, 50, 50, 30);
		bg.add(btnfile);
		
		jiepin = new JLabel("  ");
		jiepin.setBounds(250, 370, 50, 30);
		bg.add(jiepin);
		
		title = new JLabel(idtable.getQQname() + "和" + friendtable.getQQname()
				+ "正在聊天");
		title.setBounds(150, 5, 300, 30);
		title.setFont(new Font("宋体", Font.BOLD, 16));
		title.setForeground(Color.blue);
		bg.add(title);

		qianming = new JLabel(friendtable.getHobit());
		qianming.setBounds(60, 25, 200, 30);
		bg.add(qianming);

		send = new JLabel("发送(S)");
		send.setBounds(368, 478, 60, 20);
		bg.add(send);

		close = new JLabel("关闭(X)");

		close.setBounds(298, 478, 60, 20);
		bg.add(close);

		shiping = new JLabel("   ");
		shiping.setBounds(45, 50, 60, 30);
		bg.add(shiping);
		
		jlhead1 = new JLabel(new ImageIcon("head/88.gif"));
		jlhead1.setBounds(447, 35, 135, 235);
		bg.add(jlhead1);

		jlhead2 = new JLabel(new ImageIcon("head/1111.gif"));
		jlhead2.setBounds(447, 270, 135, 235);
		bg.add(jlhead2);

		txtread = new JTextPane();
		JScrollPane js = new JScrollPane(txtread);
		js.setBounds(0, 83, 447, 290);
		txtread.setFont(new Font("黑体",Font.BOLD,16));
		txtread.setForeground(Color.blue);
		js.setBorder(null);
		txtread.setEnabled(false);
		bg.add(js);

		txtwrite = new JTextPane();
		JScrollPane jss = new JScrollPane(txtwrite);
		jss.setBounds(0, 393, 447, 80);
		jss.setBorder(null);
		txtwrite.setFont(new Font("黑体",Font.BOLD,16));
		txtwrite.setForeground(Color.blue);
		bg.add(jss);

		cbsize = new JLabel("  ");
		cbsize.setBounds(10, 370, 20, 20);
		bg.add(cbsize);

		cbFont = new JLabel("  ");
		cbFont.setBounds(35, 370, 30, 30);
		bg.add(cbFont);

		color = new JLabel("  ");
		color.setBounds(68, 370, 20, 30);
		bg.add(color);

		doudong = new JLabel("  ");
		doudong.setBounds(94, 370, 20, 30);
		bg.add(doudong);
		
		size = new JPopupMenu();
		sonti = new JMenuItem("宋体");
		heiti = new JMenuItem("黑体");
		kaiti = new JMenuItem("楷体");
		lishu = new JMenuItem("隶书");
		size.add(sonti);
		size.add(heiti);
		size.add(kaiti);
		size.add(lishu);

		sonti.addActionListener(this);
		heiti.addActionListener(this);
		kaiti.addActionListener(this);
		lishu.addActionListener(this);
		jiepin.addMouseListener(this);

		font = new JPopupMenu();
		size1 = new JMenuItem("8");
		size2 = new JMenuItem("14");
		size3 = new JMenuItem("18");
		size4 = new JMenuItem("20");
		size5 = new JMenuItem("24");
		size6 = new JMenuItem("28");
		size7 = new JMenuItem("32");
		size8 = new JMenuItem("40");
		font.add(size1);
		font.add(size2);
		font.add(size3);
		font.add(size4);
		font.add(size5);
		font.add(size6);
		font.add(size7);
		font.add(size8);

		size1.addActionListener(this);
		size2.addActionListener(this);
		size3.addActionListener(this);
		size4.addActionListener(this);
		size5.addActionListener(this);
		size6.addActionListener(this);
		size7.addActionListener(this);
		size8.addActionListener(this);

		exit.addMouseListener(this);
		send.addMouseListener(this);
		txtwrite.addKeyListener(this);
		close.addMouseListener(this);
		min.addMouseListener(this);
		cbsize.addMouseListener(this);
		cbFont.addMouseListener(this);
		color.addMouseListener(this);
		doudong.addMouseListener(this);
		btnfile.addMouseListener(this);
		shiping.addMouseListener(this);
		
		setDragable();
		setSize(582, 507);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	// 设置界面可以拖动的方法
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;

	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				Chatfase.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
				Chatfase.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(Chatfase.this.getLocation().x + e.getX()
							- tmp.x, Chatfase.this.getLocation().y + e.getY()
							- tmp.y);
					Chatfase.this.setLocation(loc);
				}
			}
		});
	}

	public static void main(String[] args) {
	}

	public void appendView( String name, StyledDocument xx)
			throws BadLocationException {
		StyledDocument vdoc = txtread.getStyledDocument();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 设置显示时分秒的格式
		String time = sdf.format(date);
		SimpleAttributeSet as = new SimpleAttributeSet();
		String s = name + "    " + time + "\n";
		vdoc.insertString(vdoc.getLength(), s, as);
		int end = 0;
		while (end < xx.getLength()) {
			javax.swing.text.Element e0 = xx.getCharacterElement(end);
			SimpleAttributeSet as1 = new SimpleAttributeSet();
			StyleConstants.setForeground(as1, StyleConstants.getForeground(e0
					.getAttributes()));
			StyleConstants.setFontSize(as1, StyleConstants.getFontSize(e0
					.getAttributes()));
			StyleConstants.setFontFamily(as1, StyleConstants.getFontFamily(e0
					.getAttributes()));
			s = e0.getDocument().getText(end, e0.getEndOffset() - end);
			if ("icon".equals(e0.getName())) {
				vdoc.insertString(vdoc.getLength(), s, e0.getAttributes());
			} else {
				vdoc.insertString(vdoc.getLength(), s, as1);
			}
			end = e0.getEndOffset();
		}
		vdoc.insertString(vdoc.getLength(), "\n", as);
		txtread.setCaretPosition(vdoc.getLength());
		txtread.setForeground(Color.blue);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sonti) {
			fontstyle = new Font("宋体", Font.BOLD, 20);
			txtwrite.setFont(fontstyle);
		} else if (e.getSource() == heiti) {
			fontstyle = new Font("黑体", Font.BOLD, 14);
			txtwrite.setFont(fontstyle);
		} else if (e.getSource() == kaiti) {
			fontstyle = new Font("楷体", Font.BOLD, 14);
			txtwrite.setFont(fontstyle);
		} else if (e.getSource() == lishu) {
			fontstyle = new Font("隶书", Font.BOLD, 14);
			txtwrite.setFont(fontstyle);
		} else if (e.getSource() == size1) {

		}

	}
	public void sendinf(){
		
		if(txtwrite.getText().equals("")){
			JOptionPane.showMessageDialog(this, "请输入你要发送的内容。");
			return;
		}
		try {
			appendView(idtable.getQQname(), txtwrite.getStyledDocument());
			
			friendtable = qqbase.getselectfriend(friendtable.getQQid());
			if(friendtable.getGroupname()!=null && friendtable.getGroupname().equals(QQminlin.GROUPNAME[3])){
				SendCmd.sendAll(friendGroup, idtable, QQminlin.CMD_SEND,txtwrite.getStyledDocument());
			}else{
				SendMsg msg= new SendMsg();
				msg.cmd = QQminlin.CMD_SEND;
				msg.idtable = idtable;
				msg.friendtable = friendtable;
				msg.doc = txtwrite.getStyledDocument();
				SendCmd.send(msg);
			}
			
			if (friendtable.getZhuangtai().equals("离线")) {
				qqbase.offline(idtable.getQQid(), friendtable.getQQid(), QQminlin.CMD_OFFLINE, txtwrite.getText());
				System.out.println("friendtable.getZhuangtai()=="+friendtable.getZhuangtai());
				System.out.println("fidtable.getQQid()=="+idtable.getQQid());
				System.out.println("friendtable.getQQid()=="+friendtable.getQQid());
				System.out.println("txtwrite.getText()=="+txtwrite.getText());
			}
			txtwrite.setText("");
		} catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==exit) {
			dispose();
		}else if (e.getSource()==send) {
			sendinf();
		}else if (e.getSource()==close) {
			System.exit(0);
		}else if(e.getSource()==min){
			setState(JFrame.HIDE_ON_CLOSE);
		}else if (e.getSource()==cbsize) {
			if (e.getButton()==1) {
				size.show(this, 35, 370);
			}else if (e.getButton()==3) {
				font.show(this, 35, 370);
			}
		}else if (e.getSource()==color) {
			JColorChooser colordlg = new JColorChooser();
			// 打开颜色对话框，并且获取选中的颜色
			Color color=colordlg.showDialog(this, "请选择字体颜色", Color.BLACK);
			// 设置发送文本框的字体颜色
			txtwrite.setForeground(color);
		}else if (e.getSource()==cbFont) {
			int x=this.getLocation().x+20;
			int y=this.getLocation().y+50;
			new BqUI(this,x,y);
		}else if (e.getSource()==doudong) {
			SendMsg msg = new SendMsg();
			msg.cmd = QQminlin.CMD_SHAKE;//抖动
			msg.idtable = idtable;
			msg.friendtable = friendtable;
			SendCmd.send(msg);
			shake();
			txtwrite.setText("");
		}else if(e.getSource()==btnfile){
			FileDialog dlg = new FileDialog(this,"请选择要发送的文件(64K以下)",FileDialog.LOAD);
			dlg.show();
			String filename = dlg.getDirectory() + dlg.getFile();
			try {
				FileInputStream fis = new FileInputStream(filename);
				int size = fis.available();
				byte b[] = new byte[size];
				fis.read(b);
				SendMsg msg = new SendMsg();
				msg.cmd = QQminlin.CMD_FILE;
				msg.idtable=idtable;
				msg.friendtable = friendtable;
				msg.b = b;
				msg.fileName = dlg.getFile();
				SendCmd.send(msg);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource()==shiping) {
			JOptionPane.showMessageDialog(this, "对！想他了就该视频聊天");
			new Sound("Audio.wav");
			new OpenWeb("360魔法摄像头.lnk");
		}else if (e.getSource()==jiepin) {
			RectD rd = new RectD();
	        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
	                .getDefaultScreenDevice();
	        gd.setFullScreenWindow(rd);
		}		
	}
	public void shake(){
		
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		for (int i = 0; i < 3000; i++) {
			if (i%2==0) {
				this.setLocation(x+4, y+4);					
			}else {
				this.setLocation(x-4, y-4);		
			}
		}
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	class thread extends Thread {

		DatagramSocket ds;

		public thread() {
			// 得到端口值
			int port = Integer.parseInt(tbendi.getText().trim());
			try {
				ds = new DatagramSocket(port);
			} catch (SocketException e) {

				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (true) {
				try {
					byte b[] = new byte[1024*512];
					DatagramPacket dp = new DatagramPacket(b, b.length);
					ds.receive(dp);
					// 读取字符，从0开始读取，读到数据报的结束
					String str = new String(b, 0, dp.getLength());
					String s = txtread.getText();
					s += new Date().toLocaleString() + "\n";
					s += str + "\n";
					// 显示在显示框中
					txtread.setText(s);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==10) {
			if (!txtwrite.equals("")) {
				sendinf();
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	class RectD extends JFrame {
	    private static final long serialVersionUID = 1L;
	    int orgx, orgy, endx, endy;
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    BufferedImage image;
	    BufferedImage tempImage;
	    BufferedImage saveImage;
	    Graphics g;
	 
	    @Override
	    public void paint(Graphics g) {
	        RescaleOp ro = new RescaleOp(0.8f, 0, null);
	        tempImage = ro.filter(image, null);
	        g.drawImage(tempImage, 0, 0, this);
	    }
	 
	    public RectD() {
	        snapshot();
	        setVisible(true);
	        // setSize(d);//最大化窗口
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.addMouseListener(new MouseAdapter() {
	            public void mousePressed(MouseEvent e) {
	                orgx = e.getX();
	                orgy = e.getY();
	            }
	        });
	        this.addMouseMotionListener(new MouseMotionAdapter() {
	            public void mouseDragged(MouseEvent e) {
	                endx = e.getX();
	                endy = e.getY();
	                g = getGraphics();
	                g.drawImage(tempImage, 0, 0, RectD.this);
	                int x = Math.min(orgx, endx);
	                int y = Math.min(orgy, endy);
	                int width = Math.abs(endx - orgx)+1;
	                int height = Math.abs(endy - orgy)+1;
	                // 加上1，防止width或height为0
	                g.setColor(Color.BLUE);
	                g.drawRect(x-1, y-1, width+1, height+1);
	                //减1，加1都是为了防止图片将矩形框覆盖掉
	                saveImage = image.getSubimage(x, y, width, height);
	                g.drawImage(saveImage, x, y, RectD.this);
	            }
	        });
	        this.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyReleased(KeyEvent e) {
	                // 按Esc键退出
	                if (e.getKeyCode() == 10) {
	                    saveToFile();
	                    dispose();
	                }
	                if(e.getKeyCode()==27){
	                	dispose();
	                }
	            }
	        });
	    }
	 
	    public void saveToFile() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
	        String name = sdf.format(new Date());
	        File path = FileSystemView.getFileSystemView().getHomeDirectory();
	        String format = "jpg";
	        File f = new File(path + File.separator + name + "." + format);
	        try {
	            ImageIO.write(saveImage, format, f);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public void snapshot() {
	        try {
	            Robot robot = new Robot();
	            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	            image = robot.createScreenCapture(new Rectangle(0, 0, d.width,
	                    d.height));
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
	    }
	    public void yuxin(){
	    	
	    }
	}

}
