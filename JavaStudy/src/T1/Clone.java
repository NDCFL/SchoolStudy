package T1;

public class Clone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Kerong ke = new Kerong("陈飞龙",21);
		System.out.println("ke的对象名为：\t"+ke.getNameString()+";\tke的对象年龄是：\t"+ke.getAge());
		try {
			Kerong kr = (Kerong)ke.clone();
			System.out.println("kr的对象名称为：\t"+kr.getNameString()+";\t对象年龄为：\t"+kr.getAge());
			System.out.println("ke和kr是否为同一个对象："+(kr==ke));
			kr.setNameString("陈俊彦");
			kr.setAge(20);
			System.out.println("科隆以后的数据如下：=============================================");
			System.out.println("kr的对象名称为：\t"+kr.getNameString()+";\t对象年龄为：\t"+kr.getAge());
			System.out.println("===========ke的属性没有更改============");
			System.out.println("kr的对象名称为：\t"+kr.getNameString()+";\t对象年龄为：\t"+kr.getAge());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
