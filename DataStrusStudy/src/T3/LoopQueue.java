package T3;

public class LoopQueue {
	private int size;
	private int front;
	private int rear;
	private Object[] data;

	public LoopQueue() {
		this.size = 10;
		this.front = 0;
		this.rear = 0;
		data = new Object[size];
	}

	public LoopQueue(int size) {
		this.size = size;
		this.front = 0;
		this.rear = 0;
		data = new Object[size];
	}

	public int inQueue(Object obj) {
		if (this.isFull()) {
			System.out.println("队列已满");
			return -1;
		} else {
			System.out.println(obj + "入站");
			this.rear = (rear + 1) % size;
			data[rear] = obj;
			return rear;
		}
	}

	public int outQueue() {
		Object obj = null;
		if (this.isEmpty()) {
			System.out.println("队列为空车");
			return -1;
		} else {
			this.front = (front + 1) % size;
			obj = data[front];
			System.out.println(obj + "出站");
			return front;
		}
	}

	public boolean isEmpty() {
		boolean empty = true;
		if (this.rear == this.front) {
			empty = true;
		} else {
			empty = false;
		}
		return empty;
	}

	public boolean isFull() {
		boolean full = true;

		if ((this.rear + 1) % size == this.front) {
			full = true;
		} else {
			full = false;
		}
		return full;
	}
	public static void main(String[] args) {
		
	}
}