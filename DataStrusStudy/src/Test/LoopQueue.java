package Test;

public class LoopQueue {
	private int size;
	private int head;
	private int foot;
	private Object[] data;
	public LoopQueue() {
		this.size = 10;
		this.head = 0;
		this.foot = 0;
		data = new Object[size];
	}

	public LoopQueue(int size) {
		this.size = size;
		this.head = 0;
		this.foot = 0;
		data = new Object[size];
	}
//进队
	public void inQueue(Object obj) {
		if (this.isFull()) {
			System.out.println("队列已满");
		} else {
			System.out.println(obj + "入站");
			this.foot = (foot + 1) % size;
			data[foot] = obj;
		}
	}
//出队
	public void  outQueue() {
		Object obj = null;
		if (this.isEmpty()) {
			System.out.println("队列为空车");
		} else {
			this.head = (head + 1) % size;
			obj = data[head];
			System.out.println(obj + "出站");
		}
	}
//判断队列是否为空
	public boolean isEmpty() {
		boolean empty = true;
		if (this.foot == this.head) {
			empty = true;
		} else {
			empty = false;
		}
		return empty;
	}
	//判断队列是否已满
	public boolean isFull() {
		boolean full = true;

		if ((this.foot + 1) % size == this.head) {
			full = true;
		} else {
			full = false;
		}
		return full;
	}
	public void sysplay(){
		if(this.foot!=size){
			System.out.println("---------------------");
			for(int i=head+1;i<foot+1;i++){
				System.out.println(data[i]+"出队");
			}
		}else{
			System.out.println("队列已空！");
		}
	}
	public static void main(String[] args) {
		LoopQueue l = new LoopQueue();
		l.inQueue("1");
		l.inQueue("2");
		l.inQueue("3");
		l.inQueue("4");
		l.inQueue("5");
		l.inQueue("6");
		l.inQueue("7");
		l.inQueue("8");
		l.inQueue("9");
		l.inQueue("10");
		l.sysplay();
		System.out.println("---------------------");
		l.outQueue();
		l.outQueue();
		l.outQueue();
		l.outQueue();
		l.outQueue();
		l.outQueue();
	}
}