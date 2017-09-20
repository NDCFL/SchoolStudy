package SQLBase;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import QQSQL.QQminlin;
import QQbean.QQidtable;
import QQfase.Sound;

import com.sun.awt.AWTUtilities;

public class TipUI extends JFrame {

	JLabel myLabel, bg;

	public TipUI(QQidtable myInfo) {
		new Sound("Global.mid");
		setUndecorated(true);
		Container c = getContentPane();

		JLabel bgimg = new JLabel(new ImageIcon("head/notic.png"));
		c.add(bgimg);

		String str = myInfo.getQQname() + "(" + myInfo.getQQid() + ")";
		if (myInfo.getZhuangtai().equals(QQminlin.STATUS[0])) {
			str += "上线了";
		} else {
			str += "下线了";
		}
		String filename = "";
		String headImg = myInfo.getQQhead();
		int pos = headImg.indexOf('.');
		String pre = headImg.substring(0, pos);
		String fix = headImg.substring(pos, headImg.length());
		filename = pre + "b" + fix;
		myLabel = new JLabel();

		JLabel head = new JLabel(str, new ImageIcon(filename), JLabel.RIGHT);
		head.setBounds(20, 20, 220, 60);
		bgimg.add(head);

		setAlwaysOnTop(true);
		setSize(257, 100);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width=getToolkit().getScreenSize().width;
		int height=getToolkit().getScreenSize().height-30;
		width = width-this.getWidth();
		setVisible(true);

		try {

			for (int i = 1; i <= 75; i++) {
				setLocation(width, height - (int) (i * 1.5));
				Thread.sleep(10);
			}

			for (int i = 100; i >= 1; i--) {

				AWTUtilities.setWindowOpacity(this, 0.01f * i);
				Thread.sleep(150);
			}

			dispose();
		} catch (Exception e) {

		}
	}

	public String changeState(QQidtable myInfo) {
		String status = myInfo.getZhuangtai();
		String filename = myInfo.getQQhead();
		String headImg = myInfo.getQQhead();
		if (status.equals(QQminlin.STATUS[0])) {
			filename = headImg;
		} else if (status.equals(QQminlin.STATUS[1])) {
			int pos = headImg.indexOf('.');
			String pre = headImg.substring(0, pos);
			String fix = headImg.substring(pos, headImg.length());
			filename = pre + "_l" + fix;
		}
		return filename;
	}

	public static void main(String[] args) {
		new TipUI(null);
	}
}
