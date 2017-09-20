package T9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Jrejian extends JFrame implements ActionListener,MouseListener{

	JMenuBar jmeBar;
	JTextArea mianban;
	JMenu File,Edit,Form,examined,help;//File 文件 Edit 编辑 Form 格式 examined 查看 help 帮助
	JMenuItem sava,exItem,xinjian,open;
	JMenuItem look,zhantie,jianqie,chexiao,tihuan,ziti,bjcolor;
	JMenuItem zidong,huanhang;
	JMenuItem zhuangtai;
	JMenuItem llook,guanyu,delete,fuzi,quanxuan;
	JLabel tupian;
	JPopupMenu popup;
	public Jrejian() {
		super("记事本");
		setSize(800, 600);
		//菜单条
		jmeBar = new JMenuBar();
		//子菜单
		jmenu();
		//监听事件
		mianban.addMouseListener(this);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Jrejian();
	}
	
	public void jmenu(){
		Icon icon = new ImageIcon("images/41.gif");
		File = new JMenu("选项(X)");
		File.setMnemonic('X');
		
		Edit = new JMenu("选关(G)");
		Edit.setMnemonic('G');
		
		Form = new JMenu("格式(O)");
		Form.setMnemonic('O');
		
		examined = new JMenu("查看(L)");
		examined.setMnemonic('L');
		
		help = new JMenu("帮助(H)");
		help.setMnemonic('H');
		//加入到菜单中
		jmeBar.add(File);
		jmeBar.add(Edit);
		jmeBar.add(Form);
		jmeBar.add(examined);
		jmeBar.add(help);
		//new菜单项，File文件
		xinjian = new JMenuItem("新建(N)",icon);
		xinjian.setMnemonic('N');
		
		open = new JMenuItem("打开(O)",icon);
		open.setMnemonic('O');
		
		sava = new JMenuItem("保存(S)",icon);
		sava.setMnemonic('S');
		
		exItem = new JMenuItem("退出(T)",icon);
		exItem .setMnemonic('T');
		
		//监听
		sava.addActionListener(this);
		exItem.addActionListener(this);
		open.addActionListener(this);
		
		
		//加入到file文件
		File.add(xinjian);
		File.add(open);
		File.add(sava);
		File.addSeparator();
		File.add(exItem);
		
		//newJMenuItem
		chexiao = new JMenuItem("撤销(C)",icon);
		chexiao .setMnemonic('C');
		
		zhantie = new JMenuItem("粘贴(V)",icon);
		zhantie .setMnemonic('V');
		
		jianqie = new JMenuItem("剪切(X)",icon);
		jianqie .setMnemonic('X');
		
		look = new JMenuItem("查找(L)",icon);
		look .setMnemonic('L');
		
		tihuan = new JMenuItem("替换(H)",icon);
		tihuan .setMnemonic('L');
		
		//加入到edit菜单下
		Edit.add(chexiao);
		Edit.add(zhantie);
		Edit.add(jianqie);
		Edit.addSeparator();//分割条
		Edit.add(look);
		Edit.add(tihuan);
		
		//newJMenuItem
		zidong = new JMenuItem("自动换行(D)",icon);
		huanhang = new JMenuItem("换行(G)",icon);
		ziti = new JMenuItem("字体(T)",icon);
		bjcolor = new JMenuItem("背景颜色(R)",icon);
		bjcolor.addActionListener(this);
		//加入到Form菜单
		Form.add(zidong);
		Form.add(huanhang);
		Form.addSeparator();
		Form.add(ziti);
		Form.add(bjcolor);
		
		
		zhuangtai = new JMenuItem("状态栏(Z)",icon);
		examined.add(zhuangtai);
		
		llook = new JMenuItem("查看记事本(J)",icon);
		guanyu = new JMenuItem("关于记事本(S)",icon);
		
		
		help.add(llook);
		help.addSeparator();//分割条
		help.add(guanyu);
		
		setJMenuBar(jmeBar);//往窗口中加入菜单条
		Icon icon1 = new ImageIcon("images/42.gif");
		tupian = new JLabel(icon1);
		mianban = new JTextArea();
		JScrollPane jS = new JScrollPane(mianban);
		add(tupian);
		add(jS);
		delete = new JMenuItem("删除(D)",icon);
		fuzi = new JMenuItem("复制(C)",icon);
		quanxuan = new JMenuItem("全选(A)",icon);
		
		JMenuItem llook1 = new JMenuItem("查看记事本(D)",icon);
		JMenuItem guanyu1 = new JMenuItem("关于记事本(G)",icon);
		
		popup = new JPopupMenu();
		popup.add(chexiao);
		popup.addSeparator();//分割条
		popup.add(zhantie);
		popup.add(jianqie);
		popup.add(delete);
		popup.add(fuzi);
		popup.addSeparator();//分割条
		popup.add(quanxuan);
		popup.addSeparator();//分割条
		popup.add(llook1);
		popup.add(guanyu1);
		popup.addSeparator();//分割条
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==sava){
			JFileChooser dlgopen = new JFileChooser();
			dlgopen.showSaveDialog(this);
		}else if(e.getSource()==open){
			JOptionPane.showMessageDialog(this,"显示的内容", "确认框",JOptionPane.QUESTION_MESSAGE);
			if(JOptionPane.showConfirmDialog(this, "删除确定","选择对话框",JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				JOptionPane.showMessageDialog(this,"您点击的是确定按钮");
			}else{
				JOptionPane.showMessageDialog(this,"您点击的是取消按钮");
			}
			//输入对话框
			String str = JOptionPane.showInputDialog("请输入内容");
			JOptionPane.showMessageDialog(this,"你输入的内容是："+str);
		}else if (e.getSource()==ziti) {
			
		}else if (e.getSource()==bjcolor) {
			JColorChooser dlgcolor = new JColorChooser();
			dlgcolor.show();
			
			Color color= dlgcolor.showDialog(this, "颜色对话框", Color.RED);
		}else if (e.getSource()==exItem) {
			System.exit(0);
		}
	}
	//鼠标单击事件
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton()==3){
			popup.show(this, e.getX(), e.getY());
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
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

