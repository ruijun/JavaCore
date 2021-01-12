package datastructure.link;

import datastructure.Node;

/**
 * 双向链表
 *
 * @author rj-liang
 * @date 2021/1/12 11:28
 */
public class DoubleLinkedList<E> {
    private int size; // 链表大小
    private Node<E> header = null; // 头结点
    private Node<E> tail = null; // 尾结点

    public DoubleLinkedList() {
        this.header = new Node<>();
    }


    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            header = newNode;
            tail = newNode;
        } else {
            newNode.next = header;
            header.prev = newNode;
            header = newNode;
        }
        size++;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            header = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(E data, int index) {
        // 先判断索引正确性
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size()) {
            addLast(data);
            return;
        }

        Node<E> newNode = new Node<>(data);
        Node<E> origin = getNode(index);
        Node<E> next = origin.next;
        origin.next = newNode;
        newNode.prev = origin;
        newNode.next = next;
        next.prev = newNode;

        size++;
    }

    /**
     * 遍历当前链表，取得当前索引对应的元素
     *
     * @return
     */
    public Node<E> getNode(int index) {
        // 先判断索引正确性
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }
        Node<E> tem = header;
        int count = 0;
        while (count != index) {
            tem = tem.next;
            count++;
        }
        return tem;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获取链表的大小
     * @return
     */
    public int size(){
        return size;
    }

    public void display() {
        Node<E> tmp = header;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void removeFist() {
        if (isEmpty()) {
            return;
        }

        if (size() == 1) {
            header = tail = null;
            return;
        }

        Node<E> tmpNode = header.next;
        tmpNode.prev = null;
        header = tmpNode;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        if (size() == 1) {
            header = tail = null;
            return;
        }

        Node<E> tmpNode = tail.prev;
        tmpNode.next = null;
        tail = tmpNode;
        size--;
    }

    public void remove(int index) {
        // 先判断索引正确性
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }

        if (index == 0) {
            removeFist();
            return;
        }

        if (index == size() - 1) {
            removeFist();
            return;
        }

        Node<E> curNode = getNode(index);
        Node<E> curPreNode = curNode.prev;
        curPreNode.next = curNode.next;
        curNode.next.prev = curPreNode;

        size--;
    }
}
