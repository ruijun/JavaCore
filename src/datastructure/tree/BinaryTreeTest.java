package datastructure.tree;

import java.util.Arrays;

import static datastructure.tree.BinaryTree2.*;

/**
 * datastructure.tree
 *
 * @author rj-liang
 * @date 2020/7/2 18:26
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        System.out.println("深度优先：");
        dfsOrderTest();
        System.out.println("\n深度优先2：");
        dfsOrderTest2();
        System.out.println("\n广度优先：");
        bfsOrderTest();
        System.out.println("\n前序遍历：");
        preOrderTest();
        System.out.println("\n中序遍历：");
        inOrderTest();
        System.out.println("\n中序遍历2：");
        inOrderTest2();
        System.out.println("\n后序遍历：");
        postOrderTest();
        System.out.println("\n树的高度：");
        treeHeightTest();

        System.out.println("\n=====================二叉查找树==========================");

        BinarySearchTree bst = initBST();

        System.out.println("\n前序遍历：");
        bst.preOrder(bst.getRoot());

        System.out.println("\nfindMinNode：");
        System.out.println(bst.findMinNode().data + "");

        System.out.println("\nfindMaxNode：");
        System.out.println(bst.findMaxNode().data + "");
    }

    public static void testCreate() {
        BinaryTree2 node = new BinaryTree2("a");
        System.out.println("【testCreate】测试:");
        System.out.println("【node data】:" + node.getData());
        System.out.println("【node left data】:" + (node.left == null ? "null" : node.left.getData()));
        System.out.println("【node right data】:" + (node.right == null ? "null" : node.right.getData()));
    }

    public static void dfsOrderTest() {
        dfsOrder(init());
    }

    public static void dfsOrderTest2() {
        dfsOrder2(init());
    }

    public static void bfsOrderTest() {
        bfsOrder(init());
    }

    public static void preOrderTest() {
        preOrder(init());
    }

    public static void inOrderTest() {
        inOrder(init());
    }

    public static void inOrderTest2() {
        inOrder2(init());
    }

    public static void postOrderTest() {
        postOrder(init());
    }

    public static void treeHeightTest() {
        System.out.print(treeHeight(init()) + " ");

    }

    /**
     *        1
     *    2      5
     *  3  4   6   7
     *
     *
     * @return
     */
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

    /**
     *           13
     *     10         16
     *   9    11   14   17
     *
     *
     * @return
     */
    public static BinarySearchTree initBST() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(new BinarySearchTree.Node(13));
        bst.insert(new BinarySearchTree.Node(10));
        bst.insert(new BinarySearchTree.Node(16));
        bst.insert(new BinarySearchTree.Node(9));
        bst.insert(new BinarySearchTree.Node(11));
        bst.insert(new BinarySearchTree.Node(14));
        bst.insert(new BinarySearchTree.Node(17));

        return bst;
    }
}
