package proxy.statics;

/**
 * 静态代理
 *
 * 由程序员创建或特定工具自动生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了。
 *
 * Created by ruijun on 17-5-11.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(subject);
        proxySubject.doSomething();
    }
}
