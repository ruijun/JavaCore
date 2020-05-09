package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型测试类
 *
 * @autor rj-liang
 * @date 17-5-16 下午2:12
 */
public class GenericTest {
    public static void main(String... args) {
        Box<String> box1 = new Box<>("AAA");
        Box<Integer> box2 = new Box<>(123);

        System.out.println(box1.getData());
        System.out.println(box2.getData());
        System.out.println(box1.getClass() == box2.getClass());

        /**
         * 测试协变和逆变 PECS 法则：「Producer-Extends, Consumer-Super」
         *
         * 协变就是用一个窄类型替代宽类型： 泛型不支持协变，但可以通过<? extends E>进行模拟
         * <? extends E>指泛型参数支持E及E的子类
         *
         * 逆变则用宽类型覆盖窄类型：泛型不支持协变，但可以通过<? super E>进行模拟
         * <? super E>指泛型参数支持E及E的父类
         */

        // 泛型不支持协变,这样写编译会出错
//        List<Fruit> list1 = new ArrayList<Orange>();
//
//        // 泛型不支持逆变,这样写编译会出错
//        List<Orange> list2 = new ArrayList<Fruit>();

        // list可以包含任何Fruit的子类和Fruit本身
        List<? extends Fruit> list3 = new ArrayList<Orange>();

        // list2可以包含任何Orange的父类及Orange本身
        List<? super Orange> list4 = new ArrayList<Fruit>();

        Apple<String> apple = new Apple<>();
        apple.printfMe("123");
        apple.print("My name is apple");

        // 因为泛型类型会被擦除，所以可以这样实例化
        Orange orange = new Orange();
        orange.printfMe(123);
        apple.print(20);
    }
}
