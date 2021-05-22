package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/10-10:56 下午
 * @problem 141. 环形链表
 * @level Easy
 */
public class Leetcode_141 {
    /**
     * 快慢指针：若链表有环，则快指针能追上慢指针。
     */
    static class Solution{
        public boolean hasCycle(ListNode head){
            if(head == null || head.next == null ){
                return false;
            }


            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;

                if(slow == fast){
                    return true;
                }
            }
            return false;
        }
    }
}
