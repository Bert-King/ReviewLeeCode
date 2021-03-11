package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/11-12:19 下午
 * @problem 19. 删除链表的倒数第 N 个结点
 * @level Medium
 */
public class Leetcode_19 {

    /**
     * 使用 虚拟头指针，Perfect
     */
   static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 这里设置 虚拟头指针。避免讨论头指针的状态
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode slow = head;
            ListNode fast = head;

            while (n != 0){
                fast = fast.next;
                n--;
            }

            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
            return dummy.next;
        }
    }

    /**
     * 解释已经很充分啦。实在不行动手画个图
     */
    static class Solution1{
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null){
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;
            // 快指针前进N步
            while(n != 0){
                fast = fast.next;
                n --;
            }
            // 若走了N步后fast为null，则表示删除的为head节点。
            if(fast == null){
                return head.next;
            }
            // 若『倒数第n个节点』不是头节点，则找到『倒数第n个节点』的前一个节点
            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            // 删除 『倒数第n个节点』
            slow.next = slow.next.next;

            return head;
        }
    }


    /**
     * 递归：思路清奇
     *
     * 思路：通过递归方法一直遍历到最后一个节点，然后从最后一个节点开始计数，当数量=n时，直接返回节点即可，如果链表长度不到n，就直接返回原链表
     */
    static  class Solution2 {
        int cur = 0;
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null){
                return null;
            }
            head.next = removeNthFromEnd(head.next,n);
            cur ++;

            if(n == cur)return head.next;
            return head;
        }
    }
}
