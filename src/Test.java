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

		System.out.println(factN(6));
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
