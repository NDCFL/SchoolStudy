package T15_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class QQLook extends JFrame implements ActionListener{

	//定义控件
	JPanel south,nouth;
	JLabel jname,jage,jtitle,jtj;
	JTextField tname,tcard;
	JButton blook,bdenglu,bzhuce;
	Vector column;
	Vector row;
	JTable table1;
	//QQ查找界面
	public QQLook() {
		super("QQ查找");
		nouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jtitle = new JLabel("查找QQ好友",JLabel.CENTER);
		jtitle.setBounds(130, 40, 200, 40);
		jtitle.setFont(new Font("黑体",Font.BOLD,30));
		jtitle.setForeground(Color.pink);
		jtj = new JLabel("请输入条件");
		jtj.setFont(new Font("黑体",Font.BOLD,16));
		jtj.setForeground(Color.blue);
		jtj.setBounds(10, 20, 100, 30);
		nouth.add(jtj);
		jname = new JLabel("昵称:");
		jname.setFont(new Font("黑体",Font.BOLD,16));
		jname.setForeground(Color.blue);
		jname.setBounds(120, 20, 60, 30);
		nouth.add(jname);
		tname = new JTextField(10);
		tname.setBounds(180, 25, 120, 25);
		nouth.add(tname);
		jage = new JLabel("Q Q：");
		jage.setFont(new Font("黑体",Font.BOLD,16));
		jage.setForeground(Color.blue);
		jage.setBounds(320, 20, 60, 30);
		nouth.add(jage);
		tcard = new JTextField(10);
		tcard.setBounds(370, 25, 120, 25);
		nouth.add(tcard);
		blook = new JButton("查找");
		blook.setFont(new Font("黑体",Font.BOLD,16));
		blook.setForeground(Color.blue);
		blook.setBounds(100, 60, 80, 30);
		nouth.add(blook);
		bdenglu = new JButton("登录");
		bdenglu.setFont(new Font("黑体",Font.BOLD,16));
		bdenglu.setForeground(Color.blue);
		bdenglu.setBounds(210, 60, 80, 30);
		nouth.add(bdenglu);
		
		bzhuce = new JButton("注册");
		bzhuce.setFont(new Font("黑体",Font.BOLD,16));
		bzhuce.setForeground(Color.blue);
		bzhuce.setBounds(320, 60, 80, 30);
		
		//监听事件
		blook.addActionListener(this);
		bdenglu.addActionListener(this);
		bzhuce.addActionListener(this);
		
		nouth.add(bzhuce);
		add(nouth,BorderLayout.NORTH);
		head();
		row = new SQLyujuimp().findlike("","");
		table ta= new table(column,row); 
		table1 = new JTable(ta);
		//设置行高
		table1.setRowHeight(30);
		add(new JScrollPane(table1));
		setSize(680, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	//监听事件
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==blook) {
			String name = tname.getText().trim();
			String card = tcard.getText().trim();
			row = new SQLyujuimp().findlike(name,card);
			table tb= new table(column,row);
			table1.setModel(tb);
			
 			JOptionPane.showMessageDialog(this, "你是否想查找如下好友！！！");
		}else if(e.getSource()==bzhuce){
			new QQzhuce1();
		}else if (e.getSource()==bdenglu) {
			JOptionPane.showMessageDialog(this, "你点了登录按钮！！！");
		}
	}
	//主函数
	public static void main(String[] args) {
		new QQLook();
	}
	public void head(){
		column = new Stack<String>();
		column.addElement("编号");
		column.addElement("昵称");
		column.addElement("Q Q");
		column.addElement("密码");
		column.addElement("性别");
		column.addElement("年龄");
		column.addElement("邮箱");
		column.addElement("签名");
	}
	class table extends AbstractTableModel{
		private Vector<String> column;
		private Vector data;
		public table(Vector<String> column,Vector data){
			this.column = column;
			this.data=data;
		}
		public int getColumnCount() {
			return column.size();
		}
		public int getRowCount() {
			return data.size();
		}
		public Object getValueAt(int row, int col) {
			Vector v = (Vector)data.get(row);
        	Object obj = v.get(col);
            System.out.println(" 该单元的值为data["+row+"]["+col+"] ："+obj);
            return obj;
		}
		public String getColumnName(int col) {
	            System.out.println(" 该列的列名为："+column.get(col));
	            return column.get(col);
	    }
		public void setValueAt(Object value, int row, int col){
			Vector v = (Vector)data.get(row);
        	Object obj = v.get(col);
			fireTableRowsUpdated(row, col);
		}
	}
	
}
