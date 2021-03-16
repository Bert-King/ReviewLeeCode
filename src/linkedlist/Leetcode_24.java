package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/16-11:34 上午
 * @problem 24. 两两交换链表中的节点
 * @level Easy
 */
public class Leetcode_24 {

    /**
     * 递归解法
     */
    static class Solution{

        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;

            return newHead;
        }
    }


    /**
     * 迭代法：
     *
     * 如果 tmp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。
     * 否则就交换 tmp 后面的两个节点node1和node2.
     */
    static class Solution2 {

        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode tmp = dummy;

            while (tmp.next != null && tmp.next.next != null){
                ListNode node1 = tmp.next;
                ListNode node2 = tmp.next.next;

                // 交互操作: tmp -> node1 -> node2 转化为 tmp -> node2 -> node1
                tmp.next = node2;
                node1.next = node2.next;
                node2.next = node1;

                tmp = node1;
            }

            return dummy.next;
        }
    }
}
