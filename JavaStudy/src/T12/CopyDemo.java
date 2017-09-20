package T12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CopyDemo extends JFrame implements ActionListener{

	JPanel panel,panel2,panel3;
	JButton bcopy,bsrc,bto;
	JTextField tsrc,tto;//tsrc为源文件，tto为目标文件
	JLabel lsrc,lto;//lsrc为源文件，lto为目标文件
	public CopyDemo() {
		//标题
		super("文件的拷贝");
		//获取一个面板
		panel = new JPanel();
		
		lsrc = new JLabel("请选择要拷贝的文件");
		tsrc = new JTextField(20);
		bsrc = new JButton("....");
		
		lto = new JLabel("请选择要拷贝的路径");
		tto = new JTextField(20);
		bto = new JButton("....");
		
		bcopy = new JButton("拷贝");
		
		panel.add(lsrc);
		panel.add(tsrc);
		panel.add(bsrc);
		
		panel2 = new JPanel();
		
		panel2.add(lto);
		panel2.add(tto);
		panel2.add(bto);
		
		panel3 = new JPanel();
		
		panel3.add(bcopy);
		
		//监听事件
		bsrc.addActionListener(this);
		bto.addActionListener(this);
		bcopy.addActionListener(this);
		
		add(panel);
		add(panel2);
		add(panel3);
		this.setLayout(new GridLayout(3,1));
		pack();
		//可视化
		setVisible(true);
		this.setResizable(false);
		//居中显示
		setLocationRelativeTo(null);
		//关闭程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		//风格
		//JFrame.setDefaultLookAndFeelDecorated(true);
		new CopyDemo();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==bsrc) {
			//文件选择框
			JFileChooser jfc= new JFileChooser("");
			//打开文件
			jfc.setDialogType(JFileChooser.OPEN_DIALOG);
			//选择文件
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setDialogTitle("请选择要复制的文件");
			if (jfc.showOpenDialog(this) == jfc.APPROVE_OPTION) {
				tsrc.setText(jfc.getSelectedFile().getAbsolutePath());
			}
		}else if (e.getSource()==bto) {
			//文件选择框
			JFileChooser jfc= new JFileChooser("");
			//打开文件
			jfc.setDialogType(JFileChooser.OPEN_DIALOG);
			//只能选择文件夹
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.setDialogTitle("请选择要复制的路径");
			if (jfc.showOpenDialog(this) == jfc.APPROVE_OPTION) {
				tto.setText(jfc.getSelectedFile().getAbsolutePath());
			}
		}else if (e.getSource()==bcopy) {
			if (tsrc.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请选择所要复制的文件");
			}else if (tto.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "请选择所要拷贝文件的路径");
			}
			//获取复制的文件路径
			File srcfile = new File(tsrc.getText());
			String filename = srcfile.getName();
			this.copy(tsrc.getText(), tto.getText()+"\\"+filename);
		}
	}
	public void copy(String srcfile , String tofile){
		try {
			FileInputStream fis = new FileInputStream(srcfile);
			FileOutputStream fos = new FileOutputStream(tofile);
			byte b[] = new byte[1024];
			int n=0;
			while ((n=fis.read(b, 0, b.length))>0) {
				fos.write(b, 0, n);
			}
			System.out.println("复制完成请查看！！！！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
