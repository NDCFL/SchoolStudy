package DevicetManger;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class infomanager extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane js;
	JButton find,add,close,update,delete,sum,closeclass;
	JLabel bg,zhicu,lbsuminfo,lbheadtitle,lb2,lbgongzi,lbrichang,lblicai,lbguding,lbtouzi,lbtitle,lbsumin,lbsumout;
	JTextField text,gongzi,richang,guding,touzi,sumin,licai,sumout,suminfo;
	JRadioButton man,weman;
	JTableHeader head;
	JPanel panel;
	String title[]={"账单编号","工资收入","理财收入","日常消费支出","固定资产支出","投资支出"};
	String data[][]=new String[90][6];
	int gongziin = 0;
	static int row=0;
	
	BaseDAOimp sql = new BaseDAOimp();
	@SuppressWarnings("deprecation")
	public infomanager() {
		//设置窗口标题
		setTitle("个人小管家");
		readfile();
		//加入背景图片，用一个label来替代面板
		bg = new JLabel(new ImageIcon("300733.jpg"));
		bg.setLayout(null);
		bg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(bg);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("281128.jpg");
		setIconImage(image);
		//实例化一个面板，null代表的是绝对布局
		//实例化表格控件，存放数据
		table = new JTable(data,title);
		//设置表格显示的位置，绝对布局
		table.setBounds(0, 60, 500, 300);
		//设置表格的行高为30个像素
		table.setRowHeight(30);
		//设置表格的字体，楷体，加粗，14号字体
		table.setFont(new Font("楷体",Font.BOLD,14));
		table.setForeground(Color.blue);
		//获取表头
		head = table.getTableHeader();
	    //设置表头的背景色
		head.setBackground(new Color(200, 200, 200));
	    //设置表头的文字颜色
		head.setFont(new Font("楷体",Font.BOLD,18));
		head.setForeground(Color.blue);
		head.setOpaque(true);
		//滚动面板
		js = new JScrollPane(table);
		//设置面板的位置
		js.setBounds(230,80,560, 292);
		
		//将滚动面板放入到panal面板中
		bg.add(js);
		
		//窗口中的标题
		lbheadtitle = new JLabel("基于MySql的个人小管家系统");
		//标题的位置
		lbheadtitle.setBounds(300, 30, 400, 30);
		//标题的字体
		lbheadtitle.setFont(new Font("楷体",Font.BOLD,24));
		
		lbheadtitle.setForeground(Color.blue);
		//放入面板
		bg.add(lbheadtitle);
		
		lbtitle = new JLabel("个人账单");
		lbtitle.setBounds(50, 50, 140, 30);
		lbtitle.setFont(new Font("楷体",Font.BOLD,20));
		lbtitle.setForeground(Color.blue);
		bg.add(lbtitle);
		
		lbgongzi = new JLabel("工资收入:");
		lbgongzi.setBounds(10, 90, 80, 30);
		lbgongzi.setForeground(Color.blue);
		bg.add(lbgongzi);
		
		gongzi = new JTextField();
		gongzi.setBounds(90, 90, 120, 30);
		bg.add(gongzi);
		
		
		lblicai = new JLabel("理财收入:");
		lblicai.setBounds(10, 130, 80, 30);
		lblicai.setForeground(Color.blue);
		bg.add(lblicai);
		
		licai = new JTextField();
		licai.setBounds(90, 130, 120, 30);
		bg.add(licai);
		
		zhicu = new JLabel("                支出数据填写:");
		zhicu.setBounds(10, 160, 150, 30);
		zhicu.setForeground(Color.blue);
		bg.add(zhicu);
		
		lbrichang = new JLabel("日常消费:");
		lbrichang.setBounds(10, 200, 80, 30);
		lbrichang.setForeground(Color.blue);
		bg.add(lbrichang);
		
		richang = new JTextField();
		richang.setBounds(90, 200, 120, 30);
		bg.add(richang);
		
		lbguding = new JLabel("固定支出:");
		lbguding.setBounds(10, 240, 90, 30);
		lbguding.setForeground(Color.blue);
		bg.add(lbguding);
		
		guding = new JTextField();
		guding.setBounds(90, 240, 120, 30);
		bg.add(guding);
		
		lbtouzi = new JLabel("投资支出:");
		lbtouzi.setBounds(10, 280, 90, 30);
		lbtouzi.setForeground(Color.blue);
		bg.add(lbtouzi);
		
		touzi = new JTextField();
		touzi.setBounds(90, 280, 120, 30);
		bg.add(touzi);
		
		lbsumin = new JLabel("总收入:");
		lbsumin.setBounds(10, 320, 90, 30);
		lbsumin.setForeground(Color.blue);
		bg.add(lbsumin);
		
		sumin = new JTextField();
		sumin.setBounds(90, 320, 120, 30);
		sumin.setEditable(false);
		bg.add(sumin);
		
		lbsumout = new JLabel("最后收入:");
		lbsumout.setBounds(10, 360, 90, 30);
		lbsumout.setForeground(Color.blue);
		bg.add(lbsumout);
		
		sumout = new JTextField();
		sumout.setBounds(90, 360, 120, 30);
		sumout.setEditable(false);
		bg.add(sumout);

		lbsuminfo = new JLabel("消费统计:");
		lbsuminfo.setBounds(10, 400, 90, 30);
		lbsuminfo.setForeground(Color.blue);
		bg.add(lbsuminfo);
		
		suminfo = new JTextField();
		suminfo.setBounds(90, 400, 120, 30);
		suminfo.setEditable(false);
		bg.add(suminfo);

		
		add = new JButton("新增/修改");
		add.setBounds(230, 400, 100, 30);
		add.setForeground(Color.blue);
		bg.add(add);

		find = new JButton("查找账单");
		find.setBounds(550, 400, 100, 30);
		find.setForeground(Color.blue);
		bg.add(find);
		
		update = new JButton("修改账单");
		update.setBounds(450, 400, 90, 30);
		update.setForeground(Color.blue);
		bg.add(update);
		
		delete = new JButton("删除账单");
		delete.setBounds(350, 400, 90, 30);
		delete.setForeground(Color.blue);
		bg.add(delete);
		
		sum = new JButton("消费统计");
		sum.setBounds(660, 400, 90, 30);
		sum.setForeground(Color.blue);
		bg.add(sum);
		
		//对按钮进行监听
		delete.addActionListener(this);
		update.addActionListener(this);
		find.addActionListener(this);
		add.addActionListener(this);
		sum.addActionListener(this);
		//设置窗口大小
		setSize(850, 500);
		//显示窗口
		setVisible(true);
		//窗口在屏幕中间显示
		setLocationRelativeTo(null);
		//关闭窗口，关闭程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//主函数
	public static void main(String[] args) {
		new infomanager();
	}
	//读取文件，放入数组中，以便于后面的操作
	public void readfile(){
		List<DeviceVo> device=null;
		device = sql.devicelist();
		for (int i = 0; i < device.size(); i++) {
			DeviceVo deviceVo = device.get(i);
			data[i][0]=deviceVo.getBillid()+"";
			data[i][1]=deviceVo.getGongzi()+"";
			data[i][2]=deviceVo.getLicai()+"";
			data[i][3]=deviceVo.getGuding()+"";
			data[i][4]=deviceVo.getRichang()+"";
			data[i][5]=deviceVo.getTouzi()+"";
		}
	}
	//事件处理
	public void actionPerformed(ActionEvent e) {
		//查找记录
		if(e.getSource()==find){
			String gongziid = gongzi.getText();
			for(int i=0;i<data.length;i++){
				for(int j=0;j<data[i].length;j++){
					try {
						if(data[i][0].equals(gongziid)){
							row++;
							table.setRowSelectionInterval(i,i);
							JOptionPane.showMessageDialog(this, "查询成功，已经为你高亮显示","账单查询",JOptionPane.INFORMATION_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(this, "账单不存在");
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "账单不存在");
			return;
			//新增记录
		}else if(e.getSource()==add){
			//条件语句用于合法性的验证
			if(gongzi.getText().equals("")){
				JOptionPane.showMessageDialog(this, "工资收入不能为空！","工资收入为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if(licai.getText().equals("")){
				JOptionPane.showMessageDialog(this, "理财投资不能为空！","理财收入为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (richang.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "日常支出不能为空！","日常支出为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (guding.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "固定支出不能为空！","固定支出为空",JOptionPane.ERROR_MESSAGE);
				return;
			}else if (touzi.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "投资支出不能为空！","投资支出为空",JOptionPane.ERROR_MESSAGE);
				return;
			}
			DeviceVo d = sql.finddeviceVo(gongziin+"");
			if(d.getGongzi()!=0){
				//修改操作
				DeviceVo deviceVo = new DeviceVo();
				deviceVo.setGongzi(Integer.parseInt(gongzi.getText()));
				deviceVo.setLicai(Integer.parseInt(licai.getText()));
				deviceVo.setGuding(Integer.parseInt(guding.getText()));
				deviceVo.setRichang(Integer.parseInt(richang.getText()));
				deviceVo.setTouzi(Integer.parseInt(touzi.getText()));
				deviceVo.setBillid(gongziin);
				sql.updatedevice(deviceVo);
				dispose();
				new infomanager();
				JOptionPane.showMessageDialog(this, "账单修改成功！","修改账单",JOptionPane.ERROR_MESSAGE);
				return;
			}
			//获取文本框的值，并放入到javabean中
			DeviceVo deviceVo = new DeviceVo();
			deviceVo.setGongzi(Integer.parseInt(gongzi.getText()));
			deviceVo.setLicai(Integer.parseInt(licai.getText()));
			deviceVo.setGuding(Integer.parseInt(guding.getText()));
			deviceVo.setRichang(Integer.parseInt(richang.getText()));
			deviceVo.setTouzi(Integer.parseInt(touzi.getText()));
			//调用新增函数新增数据
			sql.adddevice(deviceVo);
			//隐藏当前窗口
			dispose();
			//打开新的窗口
			new infomanager();
			//修改账单
		}else if (e.getSource()==update) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要修改的账单记录");
				return;
			}
			gongziin = Integer.parseInt(data[index][0]);
			System.out.println(gongziin+"\\\\\\");
			DeviceVo deviceVo = sql.finddeviceVo(data[index][0]);
			gongzi.setText(deviceVo.getGongzi()+"");
			licai.setText(deviceVo.getLicai()+"");
			guding.setText(deviceVo.getGuding()+"");
			richang.setText(deviceVo.getRichang()+"");
			touzi.setText(deviceVo.getTouzi()+"");
			
			//删除账单
		}else if (e.getSource()==delete) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "还未选择所要删除的账单记录");
				return;
			}
			sql.deletedevice(data[index][0]);
			dispose();
			new infomanager();
		}else if (e.getSource()==sum) {
			int index=table.getSelectedRow();
			if(index==-1){
				JOptionPane.showMessageDialog(null, "请选择要统计的账单");
				return;
			}else{
				sumin.setText((Integer.parseInt(data[index][0])+Integer.parseInt(data[index][1]))+"");
				sumout.setText((Integer.parseInt(data[index][2])+Integer.parseInt(data[index][3])+Integer.parseInt(data[index][4]))+"");
				suminfo.setText((Integer.parseInt(sumin.getText())-Integer.parseInt(sumout.getText()))+"");
			}
			
		}
	}
}
