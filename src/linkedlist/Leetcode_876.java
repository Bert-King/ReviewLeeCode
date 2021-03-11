package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/10-8:39 下午
 * @problem 876. 链表的中间结点
 */
public class Leetcode_876 {

    /**
     * 快慢指针：快指针fast每次走2步，慢指针slow每次走1步，当fast走到末尾时，slow刚好走到中间。
     */
    static class Solution{

        public ListNode middleNode(ListNode head) {
            if(head == null){
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }


}
