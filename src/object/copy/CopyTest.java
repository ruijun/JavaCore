package object.copy;

/**
 * 深拷贝与浅拷贝
 *
 * @autor rj-liang
 * @date 2017/5/14 下午9:55
 */
class Family implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 深拷贝
     * @return
     */
    /*@Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }*/
}
class Student implements Cloneable{
    private String name;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * 浅拷贝 对其对象的引用却没有拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深拷贝
     */
    /*@Override
    protected Object clone() {
        Student o = null;
        try {
            o = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        o.family = (Family) family.clone();
        return o;
    }*/
}

public class CopyTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Family family = new Family();
        family.setName("Jeff Family");
        Student student1 = new Student();
        student1.setFamily(family);
        student1.setName("Jeff");

        Student student2 = (Student) student1.clone();
        student2.setName("Jeff2");
        student2.getFamily().setName("Jeff2 Family");
        System.out.println("Name:" + student1.getName() + " Family:" + student1.getFamily().getName());
        System.out.println("Name:" + student2.getName() + " Family:" + student2.getFamily().getName());
    }
}