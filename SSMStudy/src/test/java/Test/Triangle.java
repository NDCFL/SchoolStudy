package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class Triangle {
    private int num1;
    private int num2;
    private int num3;
    public Triangle(){}
    public Triangle(int num1,int num2,int num3){
        this.num1=num1;
        this.num2=num2;
        this.num3=num3;
    }
    public static  void main(String [] arg){
        MainClass<Triangle> m = new MainClass <Triangle>();
        List<Triangle> list2 = new ArrayList <Triangle>();
        list2 = m.display();
        for(int i=0;i<list2.size();i++){
            Triangle o = list2.get(i);
            System.out.println("三角形"+(i+1)+"的信息：三角形边1："+o.num1+"\t三角形边2："+o.num2+"\t三角形边3："+o.num3);
        }
    }
}
class MainClass<T>{
    List <T> list = new ArrayList <T>();
    public void add(){
        list.add((T) new Triangle(20,15,10));
        list.add((T) new Triangle(30,20,15));
        list.add((T) new Triangle(10,8,6));
    }
    public List<T> display(){
        add();
        return  list;
    }
}
