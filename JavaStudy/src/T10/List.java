package T10;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;


public class List extends JFrame{

	private static final ListModel DatMode = null;
	public List() {
		super("下拉列表");
		setSize(500, 500);
		getContentPane().setLayout(new GridLayout(1,2));
		JList list = new JList(new DatMode());
		//设置对齐方式
		getContentPane().add(new JScrollPane(list));
		//添加字符串
		//利用下拉列表加入参数
		//jlist();
		//利用矢量加入参数
		//shiliang();
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new List();
	}
	public void shiliang(){
		
		Vector v1 = new Vector();
		v1.addElement("苹果");
		v1.addElement("香蕉");
		v1.addElement("雪梨");
		v1.addElement("柚子");
		v1.addElement("西瓜");
		JList list = new JList(v1);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBorder(BorderFactory.createTitledBorder("你喜欢的水果"));
		Vector v = new Vector();
		v.addElement("小米");
		v.addElement("魅族");
		v.addElement("苹果");
		v.addElement("OPPO");
		v.addElement("vivo");
		JList list1 = new JList(v);
		list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list1.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
		getContentPane().add(new JScrollPane(list));
		getContentPane().add(new JScrollPane(list1));
		
	}
	public void jlist(){
		String [] str = {"苹果","香蕉","榴莲","柚子","雪梨","橘子","脐橙"};
		JList list = new JList(str);
		//设置对齐方式
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setBorder(BorderFactory.createTitledBorder("你喜欢的水果"));
		
		String [] str1 = {"苹果","小米","OPPO","vivo","魅族","三星","联想"};
		JList list1 = new JList(str1);
		
		
		//设置对齐方式
		list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list1.setBorder(BorderFactory.createTitledBorder("你喜欢的手机"));
		
		getContentPane().add(new JScrollPane(list));
		getContentPane().add(new JScrollPane(list1));
		list.setVisibleRowCount(5);
		list1.setVisibleRowCount(5);
	}
	class DatMode extends AbstractListModel{
		String [] str = {"苹果","香蕉","榴莲","柚子","雪梨"};
		public Object getElementAt(int e) {
			Object o = (e +1 )+"."+str[e++];
			System.out.println(o);
			return o;
		}

		public int getSize() {
			
			return str.length;
		}
		
	}
}
