package leetcode.link;

/**
 * 链表相关问题
 *
 * @author rj-liang
 * @date 2021/1/15 11:06
 */
public class Solution {

    /**
     * 给定一个链表，判断链表中是否有环。
     * 快指针走两步 慢指针走一步 如果有环 终有一天会追上
     * https://leetcode-cn.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 1->2->3->4->5->6
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 两两交换链表中的节点
     * <p>
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;//前驱节点
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;//交换节点1
            ListNode end = temp.next.next;//交换节点2
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }


    /**
     * K个一组反转链表
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     * https://blog.csdn.net/dadongwudi/article/details/106264128?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161068336116780269872228%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=161068336116780269872228&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_v2~rank_v29-2-106264128.pc_v2_rank_blog_default&utm_term=K%E9%93%BE%E8%A1%A8&spm=1018.2226.3001.4450
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个假的节点。
        ListNode dummy = new ListNode(0);
        //假节点的next指向head。
        // dummy->1->2->3->4->5
        dummy.next = head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if (end == null) {
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next = end.next;
            //然后断开链表
            end.next = null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next = reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;


    }

    // 链表翻转(迭代)
    // 例子：   head： 1->2->3->4
    public ListNode reverse(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;//nextNode 指向下一个节点,保存当前节点后面的链表。
            curNode.next = preNode;//将当前节点next域指向前一个节点   null<-1<-2<-3<-4
            preNode = curNode;//preNode 指针向后移动。preNode指向当前节点。
            curNode = nextNode;//curNode指针向后移动。下一个节点变成当前节点
        }
        return preNode;

    }

    // 链表翻转(递归)
    // 1->2->3->4->5
    public ListNode reverse2(ListNode head) {
        // 递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverse2(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    /**
     * 反转链表 II
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverse2(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode preNode = head, afterNode = head;
        int step = 0;
        while (preNode != null) {
            preNode = preNode.next;
            step++;
            if (step > k) {
                afterNode = afterNode.next;
            }
        }
        return afterNode;
    }

}
