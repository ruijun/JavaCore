package classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-5-17 下午2:54
 */
public class URLClassLoader extends ClassLoader {
    private String address;


    public URLClassLoader(String address) {
        this.address = address;
    }

    /**
     * 重写父类的查找类方法
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classAddress = address + name.replace(".", "/") + ".class";
        InputStream in = null;
        byte[] classbytes = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            URL url = new URL(classAddress);
            in = url.openStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = in.read(b)) != -1) {
                os.write(b, 0, len);
            }
            classbytes = os.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Class<?> c = defineClass(name, classbytes, 0, classbytes.length);
        if (c != null) {
            return c;
        } else {
            return super.findClass(classAddress);
        }
    }

}
