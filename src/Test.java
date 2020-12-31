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

		test1(true, 2);

		System.out.println("reverse=" + Solution1.reverse(2147483647));
		System.out.println("isPalindrome=" + Solution.isPalindrome(2147483647));
		System.out.println("isValid=" + Solution.isValid("{[]}"));

//		int []nums = {1, 3, 10, 12, 30, 32, 222, 111, 222, 1234};
//		System.out.println("------------>" + Find.binarySearchFind(nums, 12));

		int []nums1 = {1, 3, 10, 12, 12, 12, 111, 222, 1234};
		System.out.println("------------>1 " + Find.binarySearchMin(nums1, 12));

		int []nums2 = {1, 3, 10, 12, 12};
		System.out.println("------------>2 " + Find.binarySearchInsert(nums2, 12));

		for (int i = 0; i < 2; i++) {
			System.out.println("i=" + i);
		}

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
}
