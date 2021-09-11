package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类的调用处理器
 *
 *
 * Created by ruijun on 17-5-11.
 */
public class ProxyHandler implements InvocationHandler{
    // 委托类
    private Object target;

    public ProxyHandler(Object obj) {
        super();
        this.target = obj;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    /**
     *
     *
     * @param proxy   我们所代理的那个真实对象
     * @param method  指代的是我们所要调用真实对象的某个方法的Method对象
     * @param arg     指代的是调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
        Object result = null;
        // Call before
        doBefore();
        // Call original method, invoke the method on the obj object
        result = method.invoke(target, arg);
        // Call after
        doAfter();

        return result;
    }

    public void doBefore() {
        System.out.println("Before");
    }

    public void doAfter() {
        System.out.println("After");
    }
}
