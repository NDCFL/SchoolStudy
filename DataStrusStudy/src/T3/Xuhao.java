package T3;

public class Xuhao {

	int queuevalue[];
	int head;
	int foot;
	int size;
	public Xuhao() {
		head=-1;
		foot=-1;
		size=10;
		queuevalue = new int[size];//初始化为10个容量
	}
	public Xuhao( int size) {
		head=-1;
		foot=-1;//动态产生数组的容量
		this.size=size;
		queuevalue = new int[size];
	}	
	public void inqueue(int data){
		int t=0;
		if(this.foot!=size){
			foot++;
			queuevalue[foot]=data;
			for(int i=0;i<=foot;i++){
				for(int j=0;j<i;j++){
					if(queuevalue[i]<queuevalue[j]){
						t=queuevalue[i];
						queuevalue[i]=queuevalue[j];
						queuevalue[j]=t;
					}
				}
			}
//			System.out.println(queuevalue[foot]+"入队了");
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
	public void findqueue(int data){
		head=-1;
		if(this.foot!=size){
			for(int i=head+1;i<foot+1;i++){
				if(queuevalue[i]==data){
					System.out.println("在第"+(i+1)+"个地方找到了"+data);
					break;
				}
			}
		}else{
			System.out.println("队列已空！");
		}
		
	}
	public static void main(String[] args) {
		Xuhao q = new Xuhao(10);
		q.inqueue(4);
		q.inqueue(5);
		q.inqueue(3);
		q.inqueue(1);
		q.inqueue(2);
		q.sysplay();
	}

}
