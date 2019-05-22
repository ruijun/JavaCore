package datastructure.stack;

import datastructure.Node;

/**
 * 基于单链表实现stack
 *
 * @autor rj-liang
 * @date 17-5-27 上午11:09
 */
public class LInkedStack<E> {
    protected int size;
    protected Node<E> top;

    public LInkedStack() {
        this.size = 0;
        this.top = null;
    }

    public int size() {
        return this.size;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return this.top.getData();
    }

    public void push(E data) {
        Node<E> newNode = new Node<E>(data);

        if (isEmpty()) {
            this.top = newNode;
        } else {
            newNode.setNext(this.top);
            this.top = newNode;
        }

        this.size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new NullPointerException();
        }

        E data = this.top.getData();
        this.top = this.top.getNext();
        this.size--;

        return data;
    }

    public void clear() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String glue) {
        StringBuilder sb = new StringBuilder();

        Node<E> current = this.top;

        while (current != null) {
            sb.append(current.getData());

            current = current.getNext();

            // If we are done traversing, don't add the glue string
            if (current != null) {
                sb.append(glue);
            }
        }

        return sb.toString();
    }
}
