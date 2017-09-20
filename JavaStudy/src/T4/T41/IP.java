package T4.T41;
import T4.PhoneCard;
public class IP extends PhoneCard{
	//他们记费方式不同（每分钟费用分别为0.3和0.45）；
	//给定一个时间time=5,和初始金额30，分别计算出剩余金额。
	public IP(){
		super();
		double c= initMoney-time*0.3f;
		System.out.println("IP剩余金额="+c);
	}
}
