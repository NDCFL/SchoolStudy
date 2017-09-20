package Loopyuju;

public class Baiyuanbaiji {

	public static void main(String[] args) {
		int a, b, c;
		for (a = 1; a <= 20; a++) { /* 外层循环控制鸡翁数 */
			for (b = 1; b <= 33; b++) { /* 内层循环控制鸡母数y在0~33变化 */
				c = 100 - a - b; /* 内外层循环控制下，鸡雏数z的值受x,y的值的制约 */
				if (a + b + c == 100 && 5 * a + 3 * b + 1 / 3 * c == 100) {/* 验证取z值的合理性及得到一组解的合理性 */
					System.out.println("鸡翁有" + a);
					System.out.println("母鸡有" + b);
					System.out.println("小鸡有" + c);
					System.out.println("-------------------");
				}

			}

		}
	}
}
