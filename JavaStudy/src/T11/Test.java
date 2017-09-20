package T11;

import java.util.Random;

public class Test {

		public static void main(String[] x) {
			Test a=new Test();
			a.method(8);
			a.method(1.2f);		
		}
		void method(float i)	{
			System.out.println("float: "+i);
		}
		void method(long i)	{
			System.out.println("long: "+i);
		}

		}


