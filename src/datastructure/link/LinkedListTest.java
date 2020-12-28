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
    }


}
