package QQfase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import QQSQL.QQminlin;
import QQSQL.SendCmd;
import QQSQL.SendMsg;
import QQbean.QQidtable;
import SQLBase.QQbase;

public class LookFriend1 extends JFrame implements MouseListener,ActionListener{

	JLabel jbid, jbname, jbage,xiao, guanbi;
	JComboBox nianlin,zhuangtai;
	JButton btlook, btadd, btclose, lookinf;
	JTextField jtfid, jtfname, jtfage;
	JTable dataTable;
	QQidtable qqidtable,friendtable;
	Vector<String> vHead;
	Vector vData;
	String sSex[] = {"不选择","男神","女神"};
	String sStatus[]={"不选择","在线","离线","忙碌","隐身"};
	QQbase qqbase = new QQbase();
	Point loc = null;
	Point tmp = null;
	boolean isDragged = false;
	private void setDragable() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				LookFriend1.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());

				isDragged = true;
				LookFriend1.this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(LookFriend1.this.getLocation().x + e.getX() - tmp.x,
							LookFriend1.this.getLocation().y + e.getY() - tmp.y);
					LookFriend1.this.setLocation(loc);
				}
			}
		});
	}
	public LookFriend1(QQidtable acc) {
		this.qqidtable=acc;
		init();
	}
	public LookFriend1() {
		init();
	}
	public void init(){
		setUndecorated(true);
		setDragable();
		Container c = getContentPane();
		
		// 最小化的位置
		xiao = new JLabel(new ImageIcon(""));
		xiao.setBounds(850, 2, 25, 25);
		c.add(xiao);
		// 让指针变成手型
		xiao.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// 关闭
		guanbi = new JLabel(new ImageIcon(""));
		guanbi.setBounds(880,2, 25, 25);
		c.add(guanbi);
		guanbi.setCursor(new Cursor(Cursor.HAND_CURSOR));


		jbid = new JLabel("QQ号 ");
		jbid.setBounds(40, 80, 60, 25);
		jbid.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(jbid);
		
		jtfid = new JTextField(25);
		jtfid.setText("请输入QQ号");
		jtfid.setBounds(105, 80, 120, 25);
		jtfid.setForeground(Color.cyan);
		c.add(jtfid);

		jbname = new JLabel("昵称 ");
		jbname.setBounds(245, 80, 60, 25);
		jbname.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(jbname);

		jtfname = new JTextField();
		jtfname.setText("请输入好友昵称");
		jtfname.setBounds(285, 80, 120, 25);
		c.add(jtfname);

		jbage = new JLabel("年龄：");
		jbage.setBounds(425, 80, 60, 25);
		jbage.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(jbage);

		jtfage = new JTextField(5);
		jtfage.setBounds(460, 80, 70, 25);
		jtfage.setText("请输入年龄");
		c.add(jtfage);

		nianlin = new JComboBox(sSex);
		nianlin.setBounds(560, 80, 90, 25);
		nianlin.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(nianlin);

		zhuangtai = new JComboBox(sStatus);
		zhuangtai.setBounds(680, 80, 90, 25);
		zhuangtai.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(zhuangtai);
		
		btlook = new JButton("查找");
		btlook.setBounds(800, 80,70, 25);
		btlook.setFont(new Font("微软雅黑",Font.PLAIN,15));
		c.add(btlook);
		
		String[] columnNames = {"头像", "QQ号码", "昵称", "年龄", "性别","血型","星座","民族","爱好","状态","备注"};
		vHead = new Vector<String>();
		for(int i=0;i<columnNames.length;i++){
			vHead.addElement(columnNames[i]);
		}
		String sql = "select qqhead,qqid,qqname,age,sex,blood,start,nation,hobit,zhuangtai,remark from idtable";
		vData = qqbase.look(sql);
		dataTable = new JTable(vData,vHead);
		dataTable.setRowHeight(60);
		JScrollPane js= new JScrollPane(dataTable);
		js.setBounds(2,130,893,420);
		c.add(js);

		// 底部按钮
		btadd = new JButton("添加选中的好友");
		c.add(btadd);
		btadd.setBounds(600, 565,125, 25);


		btclose = new JButton("关闭");
		c.add(btclose);
		btclose.setBounds(750, 565,70, 25);

		
		
		lookinf = new JButton("查看资料");
		c.add(lookinf);
		lookinf.setBounds(500, 565,95, 25);


		JLabel bgimg = new JLabel(new ImageIcon("head/find.png"));
		c.add(bgimg);
		
		xiao.addMouseListener(this);
		guanbi.addMouseListener(this);
		btclose.addActionListener(this);
		btclose.addActionListener(this);
		btadd.addActionListener(this);
		btlook.addActionListener(this);
		dataTable.addMouseListener(this);
		jtfid.addMouseListener(this);
		jtfage.addMouseListener(this);
		jtfname.addMouseListener(this);
		
		setSize(897, 597);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new LookFriend1();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==xiao) {
			setState(JFrame.HIDE_ON_CLOSE);
		}else if (e.getSource()==jtfid) {
			jtfid.setText("");
		}else if (e.getSource()==jtfage) {
			jtfage.setText("");
		}else if (e.getSource()==jtfname) {
			jtfname.setText("");
		}else if (e.getSource()==guanbi) {
			dispose();
		}else if (e.getSource()==dataTable) {
			if (e.getClickCount()==2) {
				int index=dataTable.getSelectedRow();
				if (index>=0) {
					Vector row = (Vector)vData.get(index);
					int qqid = Integer.parseInt(row.get(1).toString());
					//判断是否已经为好友
					if(qqbase.isFriend( qqid,qqidtable.getQQid())){
						JOptionPane.showMessageDialog(this, "你们已经是好友！");
						return;
					}
					QQidtable qqidtable = qqbase.getselectfriend(qqid);
					String str = "是否添加@"+qqidtable.getQQname()+"@为你的好友！";
					if(JOptionPane.showConfirmDialog(this, str,"添加好友",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						
						SendMsg msg = new SendMsg();
						msg.cmd = QQminlin.CMD_ADDFRI;
						msg.idtable = friendtable;
						msg.friendtable = qqidtable;
						SendCmd.send(msg);
						System.out.println("消息指令已经发出！！！");
					}
				}
				
			}
			
		}
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		jtfid.setText("");
		jtfage.setText("");
		jtfname.setText("");
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btclose) {
			System.exit(0);
		}else if (e.getSource()==btlook) {
			String sql = "select qqhead,qqid,qqname,age,sex,blood,start,nation,hobit,zhuangtai,remark from idtable";
			sql += " where 1=1 ";
			String qqcode = jtfid.getText().trim();
			String name = jtfname.getText().trim();
			String age = jtfage.getText().trim();
			if(!qqcode.equals("")){
				sql += " and qqid=" + qqcode ;
			}
			if(!name.equals("")){
				sql += " and qqname like '%"+name + "%'";
			}
			if(!age.equals("")){
				sql += " and age="+age;
			}
			String sex = sSex[nianlin.getSelectedIndex()];
			String status = sStatus[zhuangtai.getSelectedIndex()];
			if(!sex.equals("不选择")){
				sql += " and sex='"+sex + "'";
			}
			if(!status.equals("不选择")){
				sql += " and zhuangtai='"+status + "'";
			}
			sql += " order by age";
			vData = qqbase.look(sql);
			dataTable.setModel(new MyTableModel(vHead,vData));
		}else if (e.getSource()==btclose) {
			System.exit(0);
		}else if (e.getSource()==btadd) {
			int index=dataTable.getSelectedRow();
			if (index>=0) {
				Vector row = (Vector)vData.get(index);
				int qqid = Integer.parseInt(row.get(1).toString());
				//判断是否已经为好友
				if(qqbase.isFriend( qqid,qqidtable.getQQid())){
					JOptionPane.showMessageDialog(this, "你们已经是好友！");
					return;
				}
				QQidtable friendinf = qqbase.getselectfriend(qqid);
				String str = "是否添加@"+friendinf.getQQname()+"@为你的好友！";
				if(JOptionPane.showConfirmDialog(this, str,"添加好友",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					
					SendMsg msg = new SendMsg();
					msg.cmd = QQminlin.CMD_ADDFRI;
					msg.idtable = friendinf;
					msg.friendtable = qqidtable;
					SendCmd.send(msg);
				}
			}
		}
	}


    class MyTableModel extends AbstractTableModel {
    	Vector<String> vHead;
    	Vector data;
        public MyTableModel(Vector<String> vHead,Vector data) {
        	this.vHead = vHead;
        	this.data = data;
        }
        public int getColumnCount() {
            return vHead.size();
        }
        public int getRowCount() {
            return data.size();
        }
        public String getColumnName(int col) {
            return vHead.get(col);
        }
        public Object getValueAt(int row, int col) {
        	Vector rowData = (Vector)vData.get(row);
            if (col==0) {
				return new ImageIcon(rowData.get(col).toString());
			}else {
				return rowData.get(col);
			}
            
        }
        
      //返回指定列的数据类型
        @Override
		public Class<?> getColumnClass(int c) {
        	if(c==0){//表示头像
				return ImageIcon.class;
			}else{
				return super.getColumnClass(c);
			}
        }
        public boolean isCellEditable(int row, int col) {
            return false;
        }
        
        public void setValueAt(Object value, int row, int col) {
        	Vector rowData = (Vector)vData.get(row);
        	rowData.set(col, value);
            fireTableCellUpdated(row, col);
        }
    }

	

	
	
}
