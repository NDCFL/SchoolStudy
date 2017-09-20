package T11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;

public class Order_1 extends JFrame implements ActionListener,KeyListener{
	
	JPanel p1;
	JLabel id,name,price,where;
	JTextField Orderid,Ordername,Orderprice,Orderwhere;
	JButton tianjia,look;
	ArrayList<list_2> array;
	public Order_1() {
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
		
		tianjia = new JButton("添加(T)");
		tianjia.setMnemonic('T');
		tianjia.setBounds(20, 220, 80, 30);
		p1.add(tianjia);
		
		look = new JButton("查找(L)");
		look.setMnemonic('L');
		look.setBounds(130, 220, 80, 30);
		p1.add(look);
		
		tianjia.addActionListener(this);
		look.addActionListener(this);
		Orderid.addKeyListener(this);
		array = new ArrayList<list_2>();
		
		add(p1);
		setSize(240, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Order_1();
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
			list_2 lt= new list_2(Orderid.getText(),Ordername.getText(),Orderprice.getText(),Orderwhere.getText());
			array.add(lt);
			String str="编号为"+lt.getId() +"的订单信息如下:\n";
			str += "订单名称:"+lt.getName() +"\n";
			str += "订单价格:"+lt.getPrice() +"\n";
			str += "订单地址:"+lt.getWhere();
			JOptionPane.showMessageDialog(this, str,"订单信息",JOptionPane.INFORMATION_MESSAGE);
		
		}else if (e.getSource()==look) {
			String str1 = Orderid.getText();
			for (list_2 lt1 : array) {
				if(lt1.getId().equals(str1)){
					String str="编号为"+lt1.getId() +"的订单信息如下:\n";
					str += "订单名称:"+lt1.getName() +"\n";
					str += "订单价格:"+lt1.getPrice() +"\n";
					str += "订单地址:"+lt1.getWhere();
					JOptionPane.showMessageDialog(this, str,"订单信息",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent k) {
		
		if(k.getSource()==Orderid){
			if (k.getKeyCode()==10){ 
			String str1 = Orderid.getText();
			System.out.println("djfgvkpdfjgkdf");
			for (list_2 lt1 : array) {
					if(lt1.getId().equals(str1)){
						Orderid.setText(lt1.getId());
						Ordername.setText(lt1.getName());
						Orderprice.setText(lt1.getPrice());
						Orderwhere.setText(lt1.getWhere());
						break;
					}
			}
		}
		}
	}
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
