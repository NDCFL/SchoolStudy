package T5;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
/**
 * 调试方法：
 * 	1.写打印语句，把信息打印出来看
 * 	2.调试运行状态
 * 		1.设置断点:程序运行到断点的地方就会停下来(判断出错的原因与语句)
 * 		2.点击调试运行按钮,程序会自动停止在有断点的地方；
 * 		3.按F6（F5）按一下执行一条语句；可以看到所有变量在内存中的值
 * 		4.如果问题解决，不需要调试了，按F8
 * 		5.删除断点
 * 			1.双击断点
 * 			2.删除所有断点
 * 
 * */
public class QQMainUI extends JFrame{

	JLabel lblTitle;
	JList lstFriendinfo;
	JButton btnFace,btnDodong;
	Vector<FriendInfo> vfriendInfo;
	public QQMainUI() {
		
		super("QQ2016");
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image icon = tool.getImage("images/tubiao.png");
		setIconImage(icon);
		
		lblTitle = new JLabel("老王(今天心情很好，快放假了.....)",new ImageIcon("images/1.png"),JLabel.LEFT);
		add(lblTitle,BorderLayout.NORTH);
		/**
		 * 初始化列表数据
		 * */
		FriendInfo f1 = new FriendInfo(1001,"张三丰","images/1.png","我是张三丰");
		FriendInfo f2 = new FriendInfo(1002,"李小龙","images/2.png","我是李小龙");
		FriendInfo f3 = new FriendInfo(1003,"小丽","images/3.png","我是美女");
		FriendInfo f4 = new FriendInfo(1004,"软件之家","images/4.jpg","我是程序员");
		FriendInfo f5 = new FriendInfo(1005,"老王","images/5.jpg","我是隔壁老王");
		FriendInfo f6 = new FriendInfo(1006,"小翠","images/6.png","快点上酸菜");
		FriendInfo f7 = new FriendInfo(1007,"笑笑","images/7.jpg","我很快乐");
		vfriendInfo = new Vector<FriendInfo>();
		vfriendInfo.add(f1);
		vfriendInfo.add(f2);
		vfriendInfo.add(f3);
		vfriendInfo.add(f4);
		vfriendInfo.add(f5);
		vfriendInfo.add(f6);
		vfriendInfo.add(f7);
		//把朋友信息传到Datamodel类中
		lstFriendinfo = new JList(new DataModel(vfriendInfo));
		lstFriendinfo.setCellRenderer(new myfind(vfriendInfo));
		
		JScrollPane sp = new JScrollPane(lstFriendinfo);
		add(lstFriendinfo);
		
		
		
		setSize(300,600);
		setVisible(true);
		int width = tool.getScreenSize().width-300;
		setLocation(width, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new QQMainUI();
	}
	
	//显示文本信息
	class DataModel extends AbstractListModel {
		Vector<FriendInfo> data;
		public DataModel() {
				
		}
		public DataModel(Vector<FriendInfo> data) {
			this.data = data;
		}
	    //系统自动运行，下标从0开始计算
	    public Object getElementAt(int index) {
	    	FriendInfo info = data.get(index);
	    	return info.getNickName()+"("+info.getQqCode()+")【"+info.getRemark()+"]";
	    }

	    public int getSize() {
	        return data.size();
	    }
	    
	}
	// 获取好友头像
	class myfind extends DefaultListCellRenderer {
		Vector<FriendInfo> datas;
		public myfind(Vector<FriendInfo> datas) {
			this.datas = datas;
		}
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			if (index >= 0 && index < datas.size()) {
				FriendInfo user =  datas.get(index);
				// 给列表中好友状态设置头像
				setIcon(new ImageIcon(user.getHeadimg()));
				//设置文本内容
				setText(user.getNickName().trim() + "(" + user.getNickName() + ")");
				System.out.println(user.getHeadimg());
			}
			// 设置字体颜色
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			//设置有效
			setEnabled(list.isEnabled());
			//设置默认字体
			setFont(list.getFont());
//			setFont(new Font("宋体",Font.BOLD,14));
			//设置透明背景
			setOpaque(true);
			return this;
		}
	}
}


