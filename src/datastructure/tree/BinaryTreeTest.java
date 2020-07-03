package datastructure.tree;

import static datastructure.tree.BinaryTree2.*;

/**
 * datastructure.tree
 *
 * @author rj-liang
 * @date 2020/7/2 18:26
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        preOrderTest();
    }

    public static void testCreate() {
        BinaryTree2 node = new BinaryTree2("a");
        System.out.println("【testCreate】测试:");
        System.out.println("【node data】:" + node.getData());
        System.out.println("【node left data】:" + (node.left == null ? "null" : node.left.getData()));
        System.out.println("【node right data】:" + (node.right == null ? "null" : node.right.getData()));
    }

    public static void preOrderTest() {
        preOrder(init());
    }

    public static BinaryTree2 init() {
        BinaryTree2 node_1 = new BinaryTree2("1");
        node_1.insertLeft(node_1, "2");
        node_1.insertRight(node_1, "5");

        BinaryTree2 node_2 = node_1.left;
        BinaryTree2 node_5 = node_1.right;

        node_2.insertLeft(node_2, "3");
        node_2.insertRight(node_2, "4");

        node_5.insertLeft(node_5, "6");
        node_5.insertRight(node_5, "7");

        return node_1;
    }
}
