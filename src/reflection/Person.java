package reflection;

/**
 * 实体类,用于测试反射
 *
 * @autor rj-liang
 * @date 2017/5/14 下午9:55
 */
public class Person {
    private int age;
    private String name;

    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

