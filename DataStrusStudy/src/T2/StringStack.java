package T2;

public class StringStack {

	Object data[];
	//栈顶的标志
	int top=-1;
	public StringStack() {
		//默认的初始容量
		data = new Object[10];
	}
	public StringStack(int num) {
		//默认的初始容量
		data = new Object[num];
	}
	//判断数组中的元素是否已满
	public boolean stringisfull(){
		boolean isfull=false;
		if(top+1==data.length){
			System.out.println("堆栈已满！");
			isfull=true;
		}
		return isfull;
	
	}
	//判断数组中的元素是为空
	public boolean isEmpty(){
		boolean isnull=false;
		if(top==-1){
			System.out.println("堆栈已空！");
			isnull=true;
		}
		return isnull;
	}
	//新增元素
	public void push(String string){
		if(stringisfull()){
			System.out.println("堆栈已满！");
			return;
		}
		data[++top]=string;
	}
	//出栈
	public Object pop(){
		if(isEmpty()){
			System.out.println("堆栈已空！");
			return null;
		}
		return data[top--];
	}
	//堆栈的大小
	public int size(){
		return top+1;
		
	}
	//堆栈的容量
	public int captity(){
		return data.length;
	}
	//查找元素
	public Object findstack(String string){
		for(int i=0;i<=top;i++){
			if(data[i].toString().equals(string)){
				System.out.println("在第"+(i+1)+"个位置找到了"+string);
				break;
			}
		}
		return string;
	}
	public static void main(String[] args) {
		StringStack ss = new StringStack();
		ss.push("虾米");
		ss.push("小鱼");
		ss.push("大鱼");
		ss.push("人");
		ss.push("吸血鬼");
		ss.findstack("大鱼");
		System.out.println("堆栈大小为："+ss.size());
		System.out.println("堆栈容量为："+ss.captity());
		while(!ss.isEmpty()){
			System.out.println(ss.pop());
		}
		System.out.println("堆栈大小为："+ss.size());
		System.out.println("堆栈容量为："+ss.captity());
		
	}
	
}
