package T13;

import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class jiemian extends JFrame{
	public jiemian() {
		super("进度条");
		setSize(200,200);
		new Jindutiao();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new jiemian();

	}
	class Jindutiao extends Thread{

		/**
		 * @param args
		 */
		int [] progress={6,10,16,25,29,34,38,49,59,67,91,100};
		JButton button;
		JProgressBar jBar;
		
		public Jindutiao(JProgressBar jBar, JButton button) {
			this.jBar=jBar;
			this.button=button;
		}
		public Jindutiao() {
			
			Panel panel = new Panel();
			jBar = new JProgressBar();
			jBar.setStringPainted(true);
			jBar.setIndeterminate(true);
			jBar.setString("QQ正在进行中。。。。");
			button = new JButton("完成");
			panel.add(jBar);
			panel.add(button);
			add(panel);
			new Jindutiao(jBar,button).start();
			
		}
		@Override
		public void run() {
			for (int i = 0; i < progress.length; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (i<100) {
					button.setEnabled(false);
					jBar.setValue(progress[i]);
					jBar.setIndeterminate(false);
				}
				
				if (i==100) {
					jBar.setString("升级完成！！！！");
					button.setEnabled(true);
				}
				
			}
		}
		

	}

}
