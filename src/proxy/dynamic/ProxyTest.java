package proxy.dynamic;

import java.lang.String;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * 代理
     在某些情况下，我们不希望或是不能直接访问对象 A，而是通过访问一个中介对象 B，由 B 去访问 A 达成目的，这种方式我们就称为代理。
     这里对象 A 所属类我们称为委托类，也称为被代理类，对象 B 所属类称为代理类。
     代理优点有：
         隐藏委托类的实现
         解耦，不改变委托类代码情况下做一些额外处理，比如添加初始判断及其他公共操作
     缺点：
        只能针对接口创建代理，不能针对类创建代理。
 *
 * Created by ruijun on 17-5-11.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler invocationHandler = new ProxyHandler(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), invocationHandler);
        proxy.doSomething();
    }
}
