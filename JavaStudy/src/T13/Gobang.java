package T13;

import java.awt.Frame;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.ImageIcon;
public class Gobang{
	public static void main(String args[]){
		Vector vec=new Vector();//�����岽��
		vec.add("8-8");
		vec.add("7-8");
		vec.add("8-9");
		vec.add("8-7");
		vec.add("8-10");
		vec.add("6-7");
		vec.add("8-11");
		vec.add("6-8");
		vec.add("8-12");
		vec.add("6-5");
		MainGame mg=new MainGame();
		mg.show();//������

		UserA a=new UserA(vec,mg);//��һ���û�
		UserB b=new UserB(vec,mg);//�ڶ����û�
		a.useB(b);//��Ϊ��һ��������һ�����Ҫ֪ͨ�ڶ��������壬����Ҫ�Ѷ���b����
		b.useA(a);//ͬ��
		a.start();//�����߳�
		try{
			Thread.sleep(1000);
		}catch(Exception e){e.printStackTrace();}

		b.start();//�����߳�ʽ
	}
}

 class MainGame extends Frame{
	int a=0,b=0;
	Vector rec=new Vector();//�浱ǰ�µ�ĳһ�����֮ǰ�Ĳ��裬��Ϊ����ÿ�ζ�Ҫ�ӻ���
							//����Ҫ���±���Vector
	public MainGame(){
		super("�����帴����Ϸ");
		this.setSize(437,460);
	}
	public void paint(Graphics g){
		g.drawImage(new ImageIcon("IMboard.gif").getImage(),0,25,this);//���ͼƬ
		for(int i=0;i<rec.size();i++){
			String tmp=(String)rec.get(i);
			String aaa[]=tmp.split("-");//�����к���֮����"-"�ָ�
			int hang=Integer.parseInt(aaa[0]);
			int lie=Integer.parseInt(aaa[1]);
			a=17+lie*25-12;//������ת��Ϊ��������
			b=43+hang*25-12;
			System.out.println(a+"  "+b);
			if(i%2==0){//�ǻ����廹�ǻ�����
				g.drawImage(new ImageIcon("Black.gif").getImage(),a,b,this);
			}
			else
			{
				g.drawImage(new ImageIcon("white.gif").getImage(),a,b,this);
			}
		}
	}

	public void update(Graphics g){
		this.paint(g);
	}
	public void goChess(String nowChess){
		rec.add(nowChess);//��ǰ���岽��
		this.repaint();//�ػ�
	}

}

class UserA extends Thread{
	Vector vec;//��������в���
	UserB b;//���B
	MainGame fg;//������
	public UserA(Vector vec,MainGame fg){
		this.vec=vec;
		this.fg=fg;
	}

	public void useB(UserB b){
		this.b=b;
	}
	public void run(){
		for(int i=0;i<10;i=i+2){//ֻȡ����5��
			synchronized(vec){
				fg.goChess((String)vec.get(i));//������һ����
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){e.printStackTrace();}
			b.resume();//���߳�B���öԷ�����
			this.suspend();//�����ѹ���
		}
	}
}


class UserB extends Thread{
	Vector vec;//��������в���
	UserA a;//���A
	MainGame fg;//������
	public UserB(Vector vec,MainGame fg){
		this.vec=vec;
		this.fg=fg;
	}
	public void useA(UserA a){
		this.a=a;
	}
	public void run(){
		for(int i=1;i<10;i=i+2){//ֻȡ����5��
			synchronized(vec){
				fg.goChess((String)vec.get(i));//������һ����
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){e.printStackTrace();}
			a.resume();//���߳�B���öԷ�����
			this.suspend();//�����ѹ���
		}
	}
}
