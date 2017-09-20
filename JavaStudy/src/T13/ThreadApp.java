package T13;


import java.lang.Thread;
public class ThreadApp {
   public static void main(String[] args){
       new ThreadA().start();//ʵ���̲߳���
       new ThreadB().start();//ʵ���̲߳���

   }
}
//�����߳�A
class ThreadA extends Thread{
   public void run(){
      for(int i=0;i<=10000;i++){
         System.out.print("    A "+i);
      }
   }
}
//�����߳�B
class ThreadB extends Thread{
    public void run(){
       for(int i=90000;i<=100000;i++){
          System.out.println("    B "+i);
       }
   }
}
