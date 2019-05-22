package object.inner;

/**
 * Created by Administrator on 2018/1/26.
 */
public class Outer {
    private String language = "en";
    private String region = "US";


    public class InnerClass {
        public void printOuterClassPrivateFields() {
            String fields = "language = " + language + ";region = " + region;
            System.out.println(fields);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.InnerClass inner = outer.new InnerClass();
        inner.printOuterClassPrivateFields();
    }
}
