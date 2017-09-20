package T5;

public class New {
	//默认的权限只能被同一包中的子类类访问
	static void cenner() throws ClassNotFoundException {
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			System.out.println("异常被抛出");
			throw e;
		}

	}

	public static void main(String[] args) {
		try {
			cenner();
		} catch (ClassNotFoundException e) {
			System.out.println("异常被主函数在一次的抛出");
		}
	}
}
