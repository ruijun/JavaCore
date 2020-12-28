package datastructure.link;

import datastructure.Node;

/**
 * 链表
 *
 * @autor rj-liang
 * @date 17-5-27 下午1:36
 */
public class LinkedList<E> {

    int size = 0;// 表示数组大小的指标
    Node<E> header = null;// 头结点

    public LinkedList() {
        this.header = new Node<E>();
    }

    public boolean add(E data) {
        if (size == 0) {
            header.data = data;
        } else {
            // 根据需要添加的内容，封装为结点
            Node<E> newNode = new Node<E>(data);
            // 得到当前最后一个结点
            Node<E> last = getNode(size - 1);
            // 在最后一个结点后加上新结点
            last.setNext(newNode);
        }
        size++;// 当前大小自增加1
        return true;
    }

    public boolean insert(int index, E e) {
        Node<E> newNode = new Node<E>(e);
        // 得到第N个结点
        Node<E> cNode = getNode(index);
        newNode.next = cNode.next;
        cNode.next = newNode;
        size++;
        return true;
    }

    /**
     * 遍历当前链表，取得当前索引对应的元素
     *
     * @return
     */
    private Node<E> getNode(int index) {
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
     * 根据索引，取得该索引下的数据
     *
     * @param index
     * @return
     */
    public E get(int index) {
        // 先判断索引正确性
        if (index >= size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }
        Node<E> tem = header;
        int count = 0;
        while (count != index) {
            tem = tem.next;
            count++;
        }
        E e = tem.getData();
        return e;
    }

    public int size() {
        return size;
    }

    /**
     * 设置第N个结点的值
     *
     * @param index
     * @param data
     * @return
     */
    public boolean set(int index, E data) {
        // 先判断索引正确性
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }

        // 得到第x个结点
        Node<E> cNode = getNode(index);
        cNode.data = data;
        return true;
    }

    /**
     * 实现链表的反转
     *
     * 从表头节点依次遍历，将当前节点的后继指针指向它的前驱节点即可；此时需要prev、next分表记录当前节点的前驱节点和后继节点。
     */
    public void reverseIteratively() {
        Node<E> pReversedHead = header;
        Node<E> pNode = header;
        Node<E> pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null)
                pReversedHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }

        this.header = pReversedHead;
    }

    /**
     * 反转链表
     * pre表示上一个节点，head表示当前节点，next则表示下一个节点
     */
    public void reverseLinkedList() {
        Node<E> pre = null;
        Node<E> next = null;

        while (header != null) {
            next = header.next; // 使用next缓存下一个节点
            header.next = pre; // 将当前节点的下一个节点指向head前面的节点，完成逆序
            // 需要将pre和head都向右移动
            pre = header;
            header = next;
        }
        // pre已经移到链表末端，将head指向pre即可
        header = pre;
    }

    /**
     * 递归: https://blog.csdn.net/weixin_38118016/article/details/89368351
     */
    public Node<E> reverse(Node<E> head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这里的cur就是最后一个节点
        Node<E> cur = reverse(head.next);
        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // 而head是4，head的下一个是5，下下一个是空
        // 所以head.next.next 就是5->4
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        // 每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 【使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存】
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public Node<Integer> mergeLinkedList(Node<Integer> head1, Node<Integer> head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }
        // 如果第二个链表为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }
        // 记录两个链表中头部较小的结点
        Node<Integer> tmp = head1;
        if (tmp.data < head2.data) {
            // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            tmp.next = mergeLinkedList(head1.next, head2);
        } else {
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            tmp = head2;
            tmp.next = mergeLinkedList(head1, head2.next);
        }
        // 返回处理结果
        return tmp;
    }

    /**
     * 打印链表中所有数据
     */
    public void printList() {
        Node<E> tmp = header;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printList(Node<E> head) {
        Node<E> tmp = head;
        while (tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
