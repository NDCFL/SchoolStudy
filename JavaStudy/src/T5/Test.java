package T5;

public class Test {
	public static void main(String[] agrs){
		Man s1 = new Man();
		s1.display();
		//Man.Women s2 = s1.new Women();
		//s2.play();
		Man.Women s2 = new Man.Women();
		s2.play();
	}
}
