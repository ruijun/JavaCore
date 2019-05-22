package generic;

/**
 * Orange
 *
 * @autor rj-liang
 * @date 17-5-19 上午10:00
 */
public class Orange<Integer> extends Fruit implements IBehavior<Integer>{
    @Override
    protected <T> void print(T t) {
        super.print(t);
    }

    @Override
    public void printfMe(Integer t) {
        System.out.println("Hello " + t.getClass().getName());
    }
}
