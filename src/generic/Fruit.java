package generic;

/**
 * Fruit
 *
 * @autor rj-liang
 * @date 17-5-19 上午9:57
 */
public class Fruit {
    protected <T> void print(T t) {
        System.out.println("t.getClass() " + t.getClass());
    }
}
