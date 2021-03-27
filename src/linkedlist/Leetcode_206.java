package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/27-2:31 下午
 * @problem 206. 反转链表
 * @level Easy
 */
public class Leetcode_206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode prev = null;// 前指针节点
            ListNode cur = head; // 当前指针节点

            while(cur != null){
                ListNode nextTmp = cur.next;// 临时节点，暂存当前节点的下一节点，用于后移
                cur.next = prev; // 将当前节点指向 它前面的节点
                prev = cur; // 前指针后移
                cur = nextTmp;//当前指针后移
            }
            return prev;
        }
    }

}
