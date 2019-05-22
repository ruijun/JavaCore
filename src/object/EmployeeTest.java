package object;


/**
 * Created by ruijun on 17-5-5.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Employee e1 = new Employee("tom", 7000);
        Employee e2 = new Employee("jerry", 4000);
        swap1(e1, e2);
        System.out.println(e1);	// tom 7000
        System.out.println(e2);	// jerry 4000

        swap2(e1, e2);
        System.out.println(e1); // caroline 7000
        System.out.println(e2); // benjamin 4000

        justTest();
    }

    private static void justTest() {
        Employee e = new Employee("Jim", 20000);
        e.setAge(26);
        System.out.println("name:" + e.getName() + " salary:" + e.getSalary() + " age:" + e.getAge());
        e = new Employee("Jimson", 18000);
        System.out.println("name:" + e.getName() + " salary:" + e.getSalary() + " age:" + e.getAge());
    }

    private static void swap1(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }

    private static void swap2(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        x.setName("benjamin");
        y.setName("caroline");
    }
}
