package datastructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * datastructure.tree
 *
 * @author rj-liang
 * @date 2020/7/3 16:29
 */
public class BinaryTree2 {

    public BinaryTree2 left; //左节点

    public BinaryTree2 right; //右节点

    public String data;  //树的内容

    public BinaryTree2() {
    }

    /**
     * 构造方法
     *
     * @param data
     * @param left
     * @param right
     */
    public BinaryTree2(String data, BinaryTree2 left, BinaryTree2 right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    /**
     * 构造方法
     *
     * @param data
     */
    public BinaryTree2(String data) {
        this(data, null, null);
    }

    /**
     * 判断是否为叶子节点
     *
     * @return
     */
    public boolean isleaf() {
        return this.left != null && this.right != null;
    }

    public BinaryTree2 getLeft() {
        return left;
    }

    public void setLeft(BinaryTree2 left) {
        this.left = left;
    }

    public BinaryTree2 getRight() {
        return right;
    }

    public void setRight(BinaryTree2 right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * 插入节点 ，如果不存在新建并插入节点，存在则新建节点替换原来节点，并把原来节点连接到新的节点上
     *
     * @param node
     * @param value
     */
    public static void insertLeft(BinaryTree2 node, String value) {
        if (node != null) {
            if (node.left == null) {
                node.setLeft(new BinaryTree2(value));
            } else {
                BinaryTree2 newNode = new BinaryTree2(value);
                newNode.left = node.left;
                node.left = newNode;
            }
        }
    }

    public static void insertRight(BinaryTree2 node, String value) {
        if (node != null) {
            if (node.right == null) {
                node.setRight(new BinaryTree2(value));
            } else {
                BinaryTree2 newNode = new BinaryTree2(value);
                newNode.right = node.right;
                node.right = newNode;
            }
        }
    }

    /**
     * 前序遍历
     * 对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树
     *
     * @param node
     */
    public static void preOrder(BinaryTree2 node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        node.left.preOrder(node.left);
        node.right.preOrder(node.right);
    }

    /**
     * 中序遍历
     * 对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树
     *
     * @param node
     */
    public static void inOrder(BinaryTree2 node) {
        if (node == null) {
            return;
        }

        node.left.inOrder(node.left);
        System.out.print(node.data + " ");
        node.right.inOrder(node.right);

    }

    public static void inOrder2(BinaryTree2 node) {
        if (node == null) {
            return;
        }

        Stack<BinaryTree2> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }

    }

    /**
     * 后序遍历
     * 对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身
     *
     * @param node
     */
    public static void postOrder(BinaryTree2 node) {
        if (node == null) {
            return;
        }

        node.left.postOrder(node.left);
        node.right.postOrder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 广度排序（逐层打印）
     *
     * @param node
     */
    public static void bfsOrder(BinaryTree2 node) {
        if (node != null) {
            Queue<BinaryTree2> queue = new ArrayDeque<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                BinaryTree2 current_node = queue.poll();

                System.out.print(current_node.data + " ");

                if (current_node.left != null) {
                    queue.add(current_node.left);
                }
                if (current_node.right != null) {
                    queue.add(current_node.right);
                }
            }
        }
    }

    /**
     * 深度遍历（前序，中序，后序）
     * 先从根节点出发，沿着左子树进行纵向遍历直到找到叶子节点为止。然后回溯到前一个节点，进行右子树节点的遍历，
     * 直到遍历完所有可达节点为止。
     *
     * @param node
     */
    public static void dfsOrder(BinaryTree2 node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        dfsOrder(node.left);
        dfsOrder(node.right);
    }

    public static void dfsOrder2(BinaryTree2 node) {
        if (node == null) {
            return;
        }

        Stack<BinaryTree2> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            BinaryTree2 curNode = stack.pop();
            System.out.print(curNode.data + " ");

            if (curNode.right != null) {
                stack.push(curNode.right);
            }

            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

    /**
     * 插入树
     *
     * @param node
     * @param value
     */
    public void insertNode(BinaryTree2 node, Integer value) {
        if (node != null) {
            if (value <= Integer.valueOf(node.data) && node.left != null) {
                node.left.insertNode(node.left, value);
            } else if (value <= Integer.valueOf(node.data)) {
                node.left = new BinaryTree2(String.valueOf(value));
            } else if (value > Integer.valueOf(node.data) && node.right != null) {
                node.right.insertNode(node.right, value);
            } else {
                node.right = new BinaryTree2(String.valueOf(value));
            }
        }
    }

    /**
     * 查找节点是否存在
     *
     * @param node
     * @param value
     * @return
     */
    public boolean findNode(BinaryTree2 node, Integer value) {
        if (node != null) {
            if (value < Integer.valueOf(node.data) && node.left != null) {
                return node.left.findNode(node.left, value);
            }
            if (value > Integer.valueOf(node.data) && node.right != null) {
                return node.right.findNode(node.right, value);
            }
            return value == Integer.valueOf(node.data);
        }
        return false;
    }

    /**
     * 删除节点
     *
     * @param node
     * @param value
     * @param parent
     * @return
     */
    public boolean removeNode(BinaryTree2 node, Integer value, BinaryTree2 parent) {
        if (node != null) {
            if (value < Integer.valueOf(node.data) && node.left != null) {
                return node.left.removeNode(node.left, value, node);
            } else if (value < Integer.valueOf(node.data)) {
                return false;
            } else if (value > Integer.valueOf(node.data) && node.right != null) {
                return node.right.removeNode(node.right, value, node);
            } else if (value > Integer.valueOf(node.data)) {
                return false;
            } else {
                if (node.left == null && node.right == null && node == parent.left) {
                    parent.left = null;
                    node.clearNode(node);
                } else if (node.left == null && node.right == null && node == parent.right) {
                    parent.right = null;
                    node.clearNode(node);
                } else if (node.left != null && node.right == null && node == parent.left) {
                    parent.left = node.left;
                    node.clearNode(node);
                } else if (node.left != null && node.right == null && node == parent.right) {
                    parent.right = node.left;
                    node.clearNode(node);
                } else if (node.right != null && node.left == null && node == parent.left) {
                    parent.left = node.right;
                    node.clearNode(node);
                } else if (node.right != null && node.left == null && node == parent.right) {
                    parent.right = node.right;
                    node.clearNode(node);
                } else {
                    node.data = String.valueOf(node.right.findMinValue(node.right));
                    node.right.removeNode(node.right, Integer.valueOf(node.right.data), node);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 清空节点
     *
     * @param node
     */
    public void clearNode(BinaryTree2 node) {
        node.data = null;
        node.left = null;
        node.right = null;
    }

    /**
     * 查找树中最小值
     */
    public Integer findMinValue(BinaryTree2 node) {
        if (node != null) {
            if (node.left != null) {
                return node.left.findMinValue(node.left);
            } else {
                return Integer.valueOf(node.data);
            }
        }
        return null;
    }

    public static int treeHeight(BinaryTree2 tree) {
        if (tree == null) {
            return 0;
        }

        int lHeight = treeHeight(tree.left);
        int rHeight = treeHeight(tree.right);

        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }
}

