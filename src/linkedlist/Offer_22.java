package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/11-3:54 下午
 * @problem 剑指 Offer 22. 链表中倒数第k个节点
 * @level Easy
 */
public class Offer_22 {
    /**
     * 快慢指针的典型
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && k > 0){
                fast = fast.next;
                k --;
            }

            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }
}
