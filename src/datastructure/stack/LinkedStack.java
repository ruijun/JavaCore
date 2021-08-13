package datastructure.stack;

import datastructure.Node;

/**
 * 基于单链表实现stack
 *
 * @autor rj-liang
 * @date 17-5-27 上午11:09
 */
public class LinkedStack<E> {
    protected int size;
    protected Node<E> top;

    public LinkedStack() {
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

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        //初始化就是边界情况
        dp[0] = 1;
        int maxans = 1;
        //自底向上遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //从下标0到i遍历
            for (int j = 0; j < i; j++) {
                //找到前面比nums[i]小的数nums[j],即有dp[i]= dp[j]+1
                if (nums[j] < nums[i]) {
                    //因为会有多个小于nums[i]的数，也就是会存在多种组合了嘛，我们就取最大放到dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //求出dp[i]后，dp最大那个就是nums的最长递增子序列啦
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
