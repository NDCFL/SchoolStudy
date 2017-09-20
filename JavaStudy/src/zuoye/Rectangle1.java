package zuoye;

public class Rectangle1 {
	/**
	 * 一： （1）创建Rectangle类，添加属性width、height； （2）在Rectangle类中添加两种方法计算矩形的周长和面积；
	 * （3）编程利用Rectangle输出一个矩形的周长和面积
	 * 
	 */
	float width, height, sum; 

	public void zhouchang() {
		this.height = 5.3f;
		this.width = 3.3f;
		sum = (height + width) * 2;
		System.out.println("长=" + width);
		System.out.println("高=" + height);
		System.out.println("周长=" + sum);
	}

	public void mianji() {
		this.height = 5.3f;
		this.width = 3.3f;
		sum = height * width;
		System.out.println("长=" + width);
		System.out.println("高=" + height);
		System.out.println("面积=" + sum);

	}

	public static void main(String[] agrs) {
		Rectangle1 juxing = new Rectangle1();
		juxing.zhouchang();
		juxing.mianji();

	}

}
