package proxy.statics;

/**
 * Created by Administrator on 2018/1/29.
 */
public class ProxySubject implements Subject {
    // 代理类持有一个委托类的对象引用
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doSomething() {
        doBefore();
        // 将请求分派给委托类处理
        delegate.doSomething();
        doAfter();
    }

    public void doBefore() {
        System.out.println("Before");
    }

    public void doAfter() {
        System.out.println("After");
    }
}
