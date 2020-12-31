package datastructure.link;

import datastructure.Node;

/**
 * Enter the description
 *
 * @autor rj-liang
 * @date 17-5-27 下午5:38
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("a");
        stringLinkedList.add("b");
        stringLinkedList.add("c");
        stringLinkedList.add("d");
        stringLinkedList.add("e");
        stringLinkedList.add("f");

        for (int i = 0 ; i < stringLinkedList.size(); i++) {
            System.out.println(stringLinkedList.get(i));
        }
        stringLinkedList.printList();
        Node<String> header = stringLinkedList.reverse(stringLinkedList.header);
        stringLinkedList.printList(header);

        LinkedList<Integer> numList1 = new LinkedList<>();
        LinkedList<Integer> numList2 = new LinkedList<>();
        numList1.add(1);
        numList1.add(2);
        numList1.add(4);
        numList2.add(1);
        numList2.add(3);
        numList2.add(4);
        numList2.add(5);
        numList2.add(6);

        Node<Integer> header1 = LinkedList.mergeTwo(numList1.header, numList2.header);
        numList1.printList(header1);

        LinkedList<String> stringLinkedList1 = new LinkedList<>();
        stringLinkedList1.add("a");
        stringLinkedList1.add("b");
        stringLinkedList1.add("c");
        stringLinkedList1.add("d");
        stringLinkedList1.add("e");
        stringLinkedList1.add("f");

        stringLinkedList1.delNode(stringLinkedList1.getNode(5));
        stringLinkedList.printList(stringLinkedList1.header);

    }


}
