package T4;

public class Text {
	public static void main(String [] agrs){
		String s1=new String();
		String s2=new String("String 2");
		char chars[]={' ',' ','s','t','r','i','n','g'};
		String s3=new String(chars);
		String s4=new String(chars,2,6);
		byte bytes[]={0,1,2,3,4,5,6,7,8,9};
		StringBuffer sb=new StringBuffer(s3);
		String s5=new String(sb);
		System.out.println("The String No.1 is "+s1); 
		System.out.println("The String No.2 is "+s2);
		System.out.println("The String No.3 is "+s3); 
		System.out.println("The String No.4 is "+s4); 
		System.out.println("The String No.5 is "+s5);

	} 

	
	
}
