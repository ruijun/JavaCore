package proxy.dynamic;

/**
 * 委托类
 *
 * Created by ruijun on 17-5-11.
 */
public class RealSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println( "call doSomething");
    }
}
