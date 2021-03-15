package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/15-8:15 下午
 * @problem 剑指 Offer 18. 删除链表的节点
 * @level Easy
 */
public class Offer_18 {

    static class Solution{
        /**
         *  一般删除链表节点都要注意在头节点前添加一个哑节点，以免待删节点为头节点时操作无法进行。
         * @param head
         * @param val
         * @return
         */
        public ListNode deleteNode(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;
            while(head != null){
                if(head.val == val){
                    pre.next = pre.next.next;
                    break;
                }

                pre = head;
                head = head.next;
            }

            return dummy.next;
        }
    }
}
