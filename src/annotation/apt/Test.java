package annotation.apt;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-5-15 下午4:58
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getStuName());

        MyProcessor myProcessor = new MyProcessor();
        for (String str : myProcessor.getSupportedAnnotationTypes()) {
            System.out.println(str);
        }
    }
}
