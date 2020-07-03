package datastructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;

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
     *
     * @param node
     */
    public static void preOrder(BinaryTree2 node) {
        if (node != null) {

            System.out.print(node.data + " ");

            if (node.left != null) {
                node.left.preOrder(node.left);
            }

            if (node.right != null) {
                System.out.print("===" + node.data);
                System.out.print(node.data + " ");
                node.right.preOrder(node.right);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void inOrder(BinaryTree2 node) {
        if (node != null) {
            if (node.left != null) {
                node.left.inOrder(node.left);
            }

            System.out.print(node.data+" ");

            if (node.right != null) {
                node.right.inOrder(node.right);
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public static void postOrder(BinaryTree2 node) {
        if (node != null) {
            if (node.left != null) {
                node.left.postOrder(node.left);
            }

            if (node.right != null) {
                node.right.postOrder(node.right);
            }

            System.out.print(node.data+" ");
        }
    }

    /**
     * 广度排序
     *
     * @param node
     */
    public static void bfsOrder(BinaryTree2 node) {
        if (node != null) {
            Queue<BinaryTree2> queue = new ArrayDeque<BinaryTree2>();
            queue.add(node);

            while (!queue.isEmpty()) {
                BinaryTree2 current_node = queue.poll();

                System.out.print (current_node.data+" ");

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
                    node.data=String.valueOf(node.right.findMinValue(node.right));
                    node.right.removeNode(node.right,Integer.valueOf(node.right.data),node);
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
}

