package datastructure.queue;

import datastructure.Node;

/**
 * 基于链表的队列实现
 *
 * @autor rj-liang
 * @date 2017/5/30 下午9:53
 */
public class LinkedQueue<E> {
    private Node<E> head;  // 头结点
    private Node<E> rear;   // 尾指针
    private int size;   // 队列大小

    public LinkedQueue() {
        head = rear = new Node<E>(null);
    }

    /**
     * @param data
     * @description 添加元素到队尾
     * @author rico
     * @created 2017年5月19日 下午8:52:20
     */
    public void put(E data) {
        Node<E> node = new Node<E>(data);
        rear.next = node;
        rear = node;
        size++;
    }

    /**
     * @return
     * @description 删除队头并返回队头元素的值
     * @author rico
     * @created 2017年5月19日 下午8:52:24
     */
    public E pop() {
        if (!isEmpty()) {
            E e = null;
            Node<E> temp = head.next;
            head.next = temp.next;
            e = temp.data;

            temp.data = null;
            temp.next = null;
            size--;
            return e;
        }
        return null;
    }

    /**
     * @return
     * @description 返回队头元素的值
     * @author rico
     * @created 2017年5月19日 下午8:52:28
     */
    public E peek() {
        if (!isEmpty()) {
            return head.next.data;
        }
        return null;
    }


    /**
     * @return
     * @description 队列是否为空
     * @author rico
     * @created 2017年5月19日 下午8:52:33
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * @return
     * @description 队列大小
     * @author rico
     * @created 2017年5月19日 下午8:52:35
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node<E> cur = head.next;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.data).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }


}
