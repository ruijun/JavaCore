import algorithm.Find;
import leetcode.palindrome.Solution;
import leetcode.reverse.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int n = 3;
//		System.out.println("Before change, n = " + n);
//		changeData(n);
//		System.out.println("After changeData(n), n = " + n);
//
//		StringBuffer sb = new StringBuffer("Hello ");
////		System.out.println("sb = " + sb.hashCode());
//		System.out.println("Before change, sb = " + sb);
//		changeData3(sb);
//		System.out.println("After changeData(n), sb = " + sb);

//		System.out.println(factN(6));

//		LinkedList<Integer> l1 = new LinkedList<>();
//		for (int i = 0; i < 1; i++) {
//			l1.add(i, i + 100);
//		}
//		for (int i = 0; i < l1.size(); i++) {
//			System.out.print("索引" + i + ":" + l1.get(i) + ",");
//		}
//		System.out.println(" " + l1.size());
//
//		l1.addFirst(1000);
//
//		for (int i = 0; i < l1.size(); i++) {
//			System.out.print("索引" + i + ":" + l1.get(i) + ",");
//		}

		testMeasureSpec();

//		test1(true, 2);
//
//		System.out.println("reverse=" + Solution1.reverse(2147483647));
//		System.out.println("isPalindrome=" + Solution.isPalindrome(2147483647));
//		System.out.println("isValid=" + Solution.isValid("{[]}"));
//
////		int []nums = {1, 3, 10, 12, 30, 32, 222, 111, 222, 1234};
////		System.out.println("------------>" + Find.binarySearchFind(nums, 12));
//
//		int []nums1 = {1, 3, 10, 12, 12, 12, 111, 222, 1234};
//		System.out.println("------------>1 " + Find.binarySearchMin(nums1, 12));
//
//		int []nums2 = {1, 3, 10, 12, 12};
//		System.out.println("------------>2 " + Find.binarySearchInsert(nums2, 12));
//
//		for (int i = 0; i < 2; i++) {
//			System.out.println("i=" + i);
//		}
		int num = 30 >> 1;
		int num1 = 30 >>> 1;
		System.out.printf("num=" + num + " num1=" + num1);

	}

	public static void test1(boolean isShow, int num) {
		if (isShow == true && num == 2 || num == 3) {
			System.out.println("isShow = " + isShow + ", num = " + num);
		}
	}

	public static void test() {
		int i = 1;
		while (i <= 15) {
			i++;
			if (i % 3 != 2) {
				continue;
			} else {
				System.out.println("i=" + i);
			}

		}
	}

	public static void changeData(int n) {
		n = 10;
	}

	public static void changeData(StringBuffer sb) {
		sb.append("World!");
		System.out.println("sb = " + sb.hashCode());
	}

	public static void changeData2(StringBuffer sb) {
		sb = new StringBuffer("Hi ");
		sb.append("World!");
//		System.out.println("sb = " + sb.hashCode());
	}

	public static void changeData3(StringBuffer strBuf) {
		StringBuffer sb2 = new StringBuffer("Hi ");
		strBuf = sb2;
		sb2.append("World!");
	}

	private static int factN(int n){
		if(n == 1 || n==0){
			return 1;
		}
		System.out.println(n);
		return n * factN(n - 1);
	}

	private static void testMeasureSpec() {
		// 进位大小 = 2的30次方
		// int的大小为32位，所以进位30位 = 使用int的32和31位做标志位
		int MODE_SHIFT = 30;

		// 运算遮罩：0x3为16进制，10进制为3，二进制为11
		// 3向左进位30 = 11 00000000000(11后跟30个0)
		// 作用：用1标注需要的值，0标注不要的值。因1与任何数做与运算都得任何数、0与任何数做与运算都得0
		int MODE_MASK  = 0x3 << MODE_SHIFT;

		// UNSPECIFIED的模式设置：0向左进位30 = 00后跟30个0，即00 00000000000
		// 通过高2位
		final int UNSPECIFIED = 0 << MODE_SHIFT;

		// EXACTLY的模式设置：1向左进位30 = 01后跟30个0 ，即01 00000000000
		final int EXACTLY = 1 << MODE_SHIFT;

		// AT_MOST的模式设置：2向左进位30 = 10后跟30个0，即10 00000000000
		final int AT_MOST = 2 << MODE_SHIFT;

		String s = Integer.toBinaryString(MODE_MASK);
		System.out.println("MODE_MASK=" + s);
	}
}
