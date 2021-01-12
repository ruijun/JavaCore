package datastructure;

/**
 * 节点
 *
 * @autor rj-liang
 * @date 17-5-27 上午11:11
 */
public class Node<T> {
    // 数据域用来存储数据，指针域用来链接各个链表
    // 数据域
    public T data;
    // 引用域
    public Node<T> next; // 下一个
    public Node<T> prev; // 上一个

    public Node() {

    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
