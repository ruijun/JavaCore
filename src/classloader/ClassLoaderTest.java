package classloader;

import java.lang.reflect.Method;

/**
 * ClassLoader测试类
 *
 * @autor rj-liang
 * @date 17-5-17 上午10:59
 */
public class ClassLoaderTest {

    public static void main(String... args) {
        loadFileSystemClass(Test.class.getName());
        loadClassFromDiffLoader(Test.class.getName());
        loadExtraClass("Plugin");
//        mockStringClass();
//        loadStringClass();
    }

    private static void loadFileSystemClass(String className) {
        try {
            FileSystemClassLoader loader = new FileSystemClassLoader();
            Class<?> c = loader.findClass(className);
            Object object = c.newInstance();
            Method method = c.getDeclaredMethod("show", null);
            method.invoke(object, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void loadClassFromDiffLoader(String className) {
        try {
            FileSystemClassLoader loader1 = new FileSystemClassLoader();
            FileSystemClassLoader loader2 = new FileSystemClassLoader();

            Class<?> c1 = loader1.findClass(className);
            Class<?> c2 = loader2.findClass(className);

            System.out.println("c1.hashCode " + c1.hashCode());
            System.out.println("c2.hashCode " + c2.hashCode());
            System.out.println("c1 == c2 " + (c1 == c2));

            FileSystemClassLoader loader3 = new FileSystemClassLoader();

            Class<?> c3 = loader3.loadClass(className);
            Class<?> c4 = loader3.loadClass(className);

            System.out.println("c3.hashCode " + c3.hashCode());
            System.out.println("c4.hashCode " + c4.hashCode());
            System.out.println("c3 == c4 " + (c3 == c4));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void loadExtraClass(String className) {
        try {
            URLClassLoader loader = new URLClassLoader("file:/home/ruijun/Demo/JavaCore/extrajar/plugin.jar/");
            Class<?> c = loader.findClass(className);
            System.out.println(c);
//            Object object = c.newInstance();
//            Method method = c.getDeclaredMethod("show", null);
//            method.invoke(object, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void mockStringClass() {
        try {
            Class<?> stringClass = Class.forName("java.lang.String");
            Method printNameMethod = stringClass.getMethod("printName", null);
            System.out.printf("printNameMethod = %s", (printNameMethod == null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadStringClass() {
        try {
            FileSystemClassLoader loader = new FileSystemClassLoader();
            Class<?> c = loader.findClass("java.lang.String");
            Object object = c.newInstance();
            Method printNameMethod = c.getMethod("printName", null);
            System.out.printf("printNameMethod = %s", (printNameMethod == null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
