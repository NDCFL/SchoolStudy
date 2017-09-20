package T11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Order extends JFrame implements ActionListener{

	JPanel p1;
	JLabel id,name,price,where;
	JTextField Orderid,Ordername,Orderprice,Orderwhere;
	JButton tianjia,look;
	ArrayList<OrderList> array;
	public Order() {
		super("订单管理");
		//绝对布局
		p1 = new JPanel(null);
		
		id=new JLabel("订单编号：");
		id.setBounds(10, 20, 70, 40);
		p1.add(id);
		
		Orderid = new JTextField();
		Orderid.setBounds(80, 27, 120, 25);
		p1.add(Orderid);
		
		name=new JLabel("订单名称：");
		name.setBounds(10, 70, 70, 40);
		p1.add(name);
		
		Ordername = new JTextField();
		Ordername.setBounds(80, 77, 120, 25);
		p1.add(Ordername);
		
		price=new JLabel("订单价格：");
		price.setBounds(10, 120, 70, 40);
		p1.add(price);
		
		Orderprice = new JTextField();
		Orderprice.setBounds(80, 127, 120, 25);
		p1.add(Orderprice);
		
		where=new JLabel("订单地址：");
		where.setBounds(10, 170, 70, 40);
		p1.add(where);
		
		Orderwhere = new JTextField();
		Orderwhere.setBounds(80, 177, 120, 25);
		p1.add(Orderwhere);
		
		tianjia = new JButton("添加");
		tianjia.setBounds(40, 220, 60, 30);
		p1.add(tianjia);
		
		look = new JButton("查找");
		look.setBounds(110, 220, 60, 30);
		p1.add(look);
		
		tianjia.addActionListener(this);
		look.addActionListener(this);
		
		array = new ArrayList<OrderList>();
		
		add(p1);
		setSize(220, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Order();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tianjia){
			if(Orderid.getText().equals("")){
				JOptionPane.showMessageDialog(null, "订单编号不能为空");
				Orderid.requestFocus();
				return;
			}
			if (Ordername.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "定单名称不能为空");
				Ordername.requestFocus();
				return;
			}
			if (Orderprice.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "定单价格不能为空");
				Orderprice.requestFocus();
				return;
			}
			if (Orderwhere.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "定单地址不能为空");
				Orderwhere.requestFocus();
				return;
			}
			OrderList oList = new OrderList(Orderid.getText(),Ordername.getText(),Orderprice.getText(),Orderwhere.getText());
			array.add(oList);
			String str="编号为"+oList.getId() +"的订单信息如下:\n";
			str += "订单名称:"+oList.getName() +"\n";
			str += "订单价格:"+oList.getPrice() +"\n";
			str += "订单地址:"+oList.getWhere();
			JOptionPane.showMessageDialog(this, str,"订单信息",JOptionPane.INFORMATION_MESSAGE);
			
		}else if(e.getSource()==look){
			String orderid = Orderid.getText();//获取订单号
			for (OrderList ols : array) {
				if(ols.getId().equals(orderid)){
					String str="编号为"+ols.getId() +"的订单信息如下:\n";
					str += "订单名称:"+ols.getName() +"\n";
					str += "订单价格:"+ols.getPrice() +"\n";
					str += "订单地址:"+ols.getWhere();
					JOptionPane.showMessageDialog(this, str,"订单信息",JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
		
	}
}
