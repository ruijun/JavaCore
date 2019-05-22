package reflection;

import java.lang.reflect.*;

/**
 * 反射测试类
 *
 * @autor rj-liang
 * @date 2017/5/14 下午9:57
 */
public class ReflectTest {

    /**
     * 为了看清楚Java反射部分代码，所有异常我都最后抛出来给虚拟机处理
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {

        System.out.println("demo1：通过Java反射机制得到类的包名和类名");
        demo1();

        System.out.println("");
        System.out.println("demo2：验证所有的类都是Class类的实例对象");
        demo2();

        System.out.println("");
        System.out.println("demo3：通过Java反射机制，用 Class 创建类对象，这也就是反射存在的意义所在");
        demo3();

        System.out.println("");
        System.out.println("demo4：通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象");
        demo4();

        System.out.println("");
        System.out.println("demo5：通过Java反射机制操作成员变量, set 和 get");
        demo5();

        System.out.println("");
        System.out.println("demo6：通过Java反射机制得到类的一些属性：继承的接口、父类、函数信息、成员信息、类型等");
        demo6();

        System.out.println("");
        System.out.println("demo7：通过Java反射机制调用类方法");
        demo7();

        System.out.println("");
        System.out.println("demo8：通过Java反射机制得到类加载器信息");
        demo8();
    }

    /**
     * demo1：通过Java反射机制得到类的包名和类名
     */
    public static void demo1() {
        Person person = new Person();
        System.out.println("包名：" + person.getClass().getPackage().getName());
        System.out.println("完整类名：" + person.getClass().getName());
    }

    /**
     * demo2：验证所有的类都是Class类的实例对象
     */
    public static void demo2() throws ClassNotFoundException {
        //定义两个类型都未知的Class，设置初值为null，看看如何给它们赋值成Person类
        Class<?> class1 = null;
        Class<?> class2 = null;
        //写法1，可能抛出 ClassNotFoundException 异常，多用这个写法
        class1 = Class.forName("demo.reflect.Box");
        System.out.println("写法1，包名：" + class1.getPackage().getName() + " , 完整类名：" + class1.getName());
        //写法2
        class2 = Person.class;
        System.out.println("写法2，包名：" + class2.getPackage().getName() + " , 完整类名：" + class2.getName());
    }

    /**
     * demo3：通过Java反射机制，用 Class 创建类对象，这也就是反射存在的意义所在
     */
    public static void demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> class1 = null;
        class1 = Class.forName("demo.reflect.Box");
        //由于这里不能带参数，所以你要实例化的这个类Person，一定要有无参构造函数
        Person person = (Person) class1.newInstance();
        person.setName("xiaoming");
        person.setAge(20);
        System.out.println(person.getName() + " , " + person.getAge());
    }

    /**
     * demo4：通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
     */
    public static void demo4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> class1 = null;
        Person person1 = null;
        Person person2 = null;

        class1 = Class.forName("demo.reflect.Box");
        Constructor<?>[] constructors = class1.getConstructors();

        person1 = (Person) constructors[0].newInstance();
        person1.setName("xiaoming");
        person1.setAge(20);
        System.out.println(person1.getName() + " , " + person1.getAge());
        person2 = (Person) constructors[1].newInstance(21, "xiaohong");
        System.out.println(person2.getName() + " , " + person2.getAge());
    }

    /**
     * demo5：通过Java反射机制操作成员变量, set 和 get
     */
    public static void demo5() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, SecurityException {
        Class<?> class1 = Class.forName("demo.reflect.Box");
        Object obj = class1.newInstance();
        Field personNameField = class1.getDeclaredField("name");
        personNameField.setAccessible(true); //取消访问检查
        personNameField.set(obj, "小虎");
        System.out.println("修改属性之后得到属性变量的值：" + personNameField.get(obj));
    }

    /**
     * demo6：通过Java反射机制得到类的一些属性：继承的接口、父类、函数信息、成员信息、类型等
     */
    public static void demo6() throws ClassNotFoundException {
        Class<?> class1 = Class.forName("demo.reflect.SuperMan");

        //取得父类名称
        Class<?> superclass = class1.getSuperclass();
        System.out.println("SuperMan类的父类名：" + superclass.getName());

        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("类中的成员" + i + "： " + fields[i]);
        }

        //取得类方法
        Method[] methods = class1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("取得SuperMan类的方法" + i + "：");
            System.out.println("函数名：" + methods[i].getName());
            System.out.println("函数返回类型：" + methods[i].getReturnType());
            System.out.println("函数访问修饰符：" + Modifier.toString(methods[i].getModifiers()));
            System.out.println("函数代码写法： " + methods[i]);
        }

        //取得类实现的接口，因为接口类也属于Class，所以得到接口中的方法也是一样的方法得到哈
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("实现的接口类名： " + interfaces[i].getName());
        }
    }

    /**
     * demo7：通过Java反射机制调用类方法
     */
    public static void demo7() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> class1 = Class.forName("demo.reflect.SuperMan");

        System.out.println("调用无参方法fly()：");
        Method method = class1.getMethod("fly");
        method.invoke(class1.newInstance());

        System.out.println("调用有参方法walk(int m)：");
        method = class1.getMethod("walk", int.class);
        method.invoke(class1.newInstance(), 100);
    }

    /**
     * demo8：通过Java反射机制得到类加载器信息
     * 在java中有三种类类加载器
     * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
     * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类
     * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器，同时也是java中默认的加载器。
     */
    public static void demo8() throws ClassNotFoundException {
        Class<?> class1 = Class.forName("demo.reflect.SuperMan");
        String name = class1.getClassLoader().getClass().getName();
        System.out.println("类加载器类名：" + name);
    }
}
