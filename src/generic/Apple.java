package generic;

/**
 * Apple
 *
 * @autor rj-liang
 * @date 17-5-19 上午9:58
 */
public class Apple<String> extends Fruit implements IBehavior<String>{

    @Override
    protected <T> void print(T t) {
        super.print(t);
    }

    @Override
    public void printfMe(String t) {
        System.out.println("Hello " + t.getClass().getName());
    }
}
