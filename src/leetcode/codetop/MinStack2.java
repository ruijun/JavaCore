package leetcode.codetop;

/**
 * MinStack2
 *
 * @autor rj-liang
 * @date 2021/8/10 10:50 上午
 */
class MinStack2 {
    private Node head;

    public void push(int x) {
        if(head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
