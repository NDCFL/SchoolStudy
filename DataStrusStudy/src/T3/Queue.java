package T3;


public class Queue {

	String queuevalue[];
	int head;
	int foot;
	int size;
	public Queue() {
		head=-1;
		foot=-1;
		size=10;
		queuevalue = new String[size];//初始化为10个容量
	}
	public Queue( int size) {
		head=-1;
		foot=-1;//动态产生数组的容量
		this.size=size;
		queuevalue = new String[size];
	}	
	public void inqueue(String data){
		if(this.foot!=size){
			foot++;
			queuevalue[foot]=data;
			System.out.println(data+"入队了");
		}else{
			System.out.println("队列已满！");
		}
	}
	public void sysplay(){
		if(this.foot!=size){
			for(int i=head+1;i<foot+1;i++){
				System.out.println(queuevalue[i]+"出队");
				//循环的队列
//				if(i==foot){
//					i=0;
//				}
			}
			
		}else{
			System.out.println("队列已空！");
		}
	}
	public void outqueue(){
		if(this.head!=foot){
			head++;
//			System.out.println(head);
			System.out.println(queuevalue[head]+"出队了");
			if(head==foot){
				head=-1;
			}
		}else{
			System.out.println("队列已空！");
		}
	}
	public void findqueue(String data){
		head=-1;
		if(this.foot!=size){
			for(int i=head+1;i<foot+1;i++){
				if(queuevalue[i].equals(data)){
					System.out.println("在第"+(i+1)+"个地方找到了"+data);
					break;
				}
			}
		}else{
			System.out.println("队列已空！");
		}
		
	}
	public static void main(String[] args) {
		Queue q = new Queue(10);
		q.inqueue("虾米");
		q.inqueue("小鱼");
		q.inqueue("大鱼");
		q.inqueue("人");
		q.inqueue("吸血鬼");
		System.out.println("------------------------");
		q.sysplay();
		System.out.println("------------------------");
		q.outqueue();
		q.outqueue();
		q.outqueue();
		q.outqueue();
		q.outqueue();
		System.out.println("============");
		q.outqueue();
		q.outqueue();
		q.outqueue();
		System.out.println("--------查找--------------");
		q.findqueue("人");
	}
}
