package object.polymorphism;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-7-21 上午9:40
 */
public class B extends A {
    public String show(final B obj) {
        return ("B and B");
    }

    @Override
    public String show(final A obj) {
        return ("B and A");
    }
}
