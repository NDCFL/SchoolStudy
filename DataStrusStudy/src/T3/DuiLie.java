package T3;

public class DuiLie {

	private int size;
	private int front;
	private int rear;
	private Object[] queue;
	public DuiLie(int size)
	{
		this.size=size;	//初始化队列长度
		this.front=-1;	//初始化头指针
		this.rear=-1;	//初始化尾指针
		queue=new Object[size];
	}
	/*****************************
	 *
	 * 入队操作
	 *
	 *****************************/
	public void inQueue(Object obj)
	{
		if(this.rear<size)
		{
			rear++;		//先将伪指针向后移动一个单位
			queue[rear]=obj;		//将数据放入
			System.out.println(obj+"入队");
		}
		else
		{
			System.out.println("队列已满");
		}
	}
	/*****************************
	 *
	 * 出队操作
	 *
	 *****************************/
//	public Object outQueue()		
//	{
//		Object obj=null;
//		if(this.front!=this.rear)
//		{
//			front++;				//将头指针向后移动一个单位，指向要出队的数据
//			obj=queue[front];		//将头指针所指数据取出
//			System.out.println(obj+"出队");
//		}
//		else
//		{
//			System.out.println("队列为空");
//		}
//		return obj;
//	}
	/*****************************
	 *
	 *	遍历队列
	 *
	 *****************************/
	public void display()			
	{
		if(front!=rear)
		{
			for(int i=front+1;i<rear+1;i++)
			{
				System.out.println(queue[i]);
			}
		}
		else
		{
			System.out.println("队中无数据");
		}
	}
	public static void main(String[] args) {
		DuiLie d = new DuiLie(10);
		d.inQueue("组长");
		d.inQueue("部门经理");
		d.inQueue("主管副总");
		d.inQueue("总经理");
		d.inQueue("董事长");
		d.display();
	}
}
