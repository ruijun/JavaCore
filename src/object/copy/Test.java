package object.copy;

import java.util.Arrays;

/**
 * 测试
 *
 * @autor rj-liang
 * @date 2017/7/23 上午9:34
 */
public class Test {
    public static void main(String[] args) {
        int [] srcArray = new int []{0,1,2,3,4,5,6,7,8} ;
        int [] destArray = new int [7] ;

        System.arraycopy(srcArray, 2, destArray, 0, 7) ;

        System.out.println(Arrays.toString(srcArray)); // [0, 1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(Arrays.toString(destArray)); // [2, 3, 4, 5, 6, 7, 8]

        int [] newArray = Arrays.copyOf(srcArray, 10);
        System.out.println(Arrays.toString(newArray) + " " + newArray.length); // [0, 1, 2, 3, 4, 5, 6, 7]
    }
}
