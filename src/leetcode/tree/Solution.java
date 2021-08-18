package leetcode.tree;

import java.util.*;

/**
 * 二叉树相关问题解决
 *
 * @autor rj-liang
 * @date 2021/8/9 12:04 下午
 */
public class Solution {
    ArrayList<Integer> preOrderReverse(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    /**
     * 前序遍历：根节点-左节点-右节点
     *
     * @param root
     * @param result
     */
    public void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    /**
     * 中序遍历：左节点-根节点-右节点
     *
     * @param root
     * @param result
     */
    public void inOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        preOrder(root.left, result);
        result.add(root.val);
        preOrder(root.right, result);
    }

    /**
     * 后序遍历：左节点-右节点-根节点
     *
     * @param root
     * @param result
     */
    public void postOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        preOrder(root.left, result);
        preOrder(root.right, result);
        result.add(root.val);
    }

    /**
     * 求二叉树最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * 求二叉树中的节点个数
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }


    /**
     * 求二叉树的最大层数(最大深度)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 判断二叉树是不是平衡二叉树
     * 高度平衡二叉树定义为： 一个二叉树，其中每个节点的两个子树的深度差不相差超过1。
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(maxHigh(root.left) - maxHigh(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxHigh(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxHigh(root.left), maxHigh(root.right))+1;
    }

    /**
     * 二叉树的锯齿形层序遍历
     * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        //创建队列，保存节点
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);//先把节点加入到队列中
        boolean leftToRight = true;//第一步先从左边开始打印
        while (!queue.isEmpty()) {
            //记录每层节点的值
            List<Integer> level = new ArrayList<>();
            //统计这一层有多少个节点
            int count = queue.size();
            //遍历这一层的所有节点，把他们全部从队列中移出来，顺便
            //把他们的值加入到集合level中，接着再把他们的子节点（如果有）
            //加入到队列中
            for (int i = 0; i < count; i++) {
                //poll移除队列头部元素（队列在头部移除，尾部添加）
                TreeNode node = queue.poll();
                //判断是从左往右打印还是从右往左打印。
                if (leftToRight) {
                    //如果从左边打印，直接把访问的节点值加入到列表level的末尾即可
                    level.add(node.val);
                } else {
                    //如果是从右边开始打印，每次要把访问的节点值
                    //加入到列表的最前面
                    level.add(0, node.val);
                }
                //左右子节点如果不为空会被加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把这一层的节点值加入到集合res中
            res.add(level);
            //改变下次访问的方向
            leftToRight = !leftToRight;
        }
        return res;
    }

    /**
     * BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    /**
     * dfs
     */
    public static void dfsOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            System.out.print(curNode.val + " ");

            // stack先进后出，所以先右后左
            if (curNode.right != null) {
                stack.push(curNode.right);
            }

            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

    public TreeNode invertTree(TreeNode root) {
        // 层次遍历--直接左右交换即可
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode rightTree = node.right;
            node.right = node.left;
            node.left = rightTree;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        // 后序遍历-- 从下向上交换
        if (root == null) {
            return null;
        }

        TreeNode leftNode = invertTree2(root.left);
        TreeNode rightNode = invertTree2(root.right);
        root.right = leftNode;
        root.left = rightNode;

        return root;
    }

    /**
     * 二叉搜索树的第k个结点
     */
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode p = root;
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode node = stack.pop();
                count ++;
                if(count == k)
                    return node.val;
                p = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * 求二叉树第K层的节点个数
     */
    public int getKLevelNumber(TreeNode root, int k){
        if(root == null || k <=0){
            return 0;
        }
        if(root != null && k == 1){
            return 1;
        }
        return getKLevelNumber(root.left, k-1) + getKLevelNumber(root.right, k-1);
    }

    /**
     * 求二叉树的直径
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值
     * 对于每个节点，它的最长路径等于左子树的最长路径+右子树的最长路径
     */
    private int path = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diamHelper(root);
        return path;
    }

    private int diamHelper(TreeNode root){
        if(root == null)
            return 0;
        int left = diamHelper(root.left);
        int right = diamHelper(root.right);
        path = Math.max(path, left + right);
        return Math.max(left, right) + 1;
    }

    /**
     * 求二叉搜索树的最近公共祖先
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;
        }
    }

    public static TreeNode initTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        return node1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = initTree();
        Solution solution = new Solution();
        solution.invertTree2(treeNode);
    }
}
