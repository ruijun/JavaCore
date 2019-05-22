package datastructure.stack;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-5-27 上午11:20
 */
public class StackTest {
    public static void main(String[] args) {
        LInkedStack<String> stringStack = new LInkedStack<>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        stringStack.push("e");

        stringStack.pop();
        stringStack.pop();

        System.out.println(stringStack.peek() + " " + stringStack.size());
    }
}
