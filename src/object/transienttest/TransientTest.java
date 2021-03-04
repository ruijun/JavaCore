package object.transienttest;

import java.io.*;

/**
 * object.transienttest
 * java中static、transient修饰的属性不能被序列化
 *
 * @author rj-liang
 * @date 2021/3/1 11:20
 */
public class TransientTest {

    public static void main(String[] args) {

        User user = new User();
        user.setUserName("Alexia");
        user.setPassWd("123456");

        System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUserName());
        System.err.println("password: " + user.getPassWd());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("E:/user.txt"));
            os.writeObject(user); // 将User对象写进文件
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("E:/user.txt"));
            user = (User) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + user.getUserName());
            System.err.println("password: " + user.getPassWd());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
