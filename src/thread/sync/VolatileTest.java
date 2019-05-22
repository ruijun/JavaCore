package thread.sync;

/**
 * Created by Administrator on 2019/5/20.
 */
public class VolatileTest {
    private volatile int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        VolatileTest dome = new VolatileTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                dome.setA(10);
                System.out.println("111 " + dome.a);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (dome.getA() == 10) {
                        System.out.println("222 " + dome.a);
                        break;
                    }
                }
            }
        }).start();
    }
}
