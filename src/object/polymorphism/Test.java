package object.polymorphism;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-7-21 上午9:38
 */
public class Test {
    public static void main(String[] args) {
        /**
         * Java编译器会先检查当前类有没有实现同名方法，如果有，执行当前类的方法；
         * 若没有，则去执行父类的同名方法；若父类没有，则再检查父类的父类有没有实现这个方法，以此类推
         *
         * 优先级由高到低依次为：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)
         */
        A a2 = new B();
        B b = new B();
        System.out.println(a2.show(b)); // B and A
    }
}
