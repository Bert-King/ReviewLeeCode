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

    static class Solution {
        /**
         * 一般删除链表节点都要注意在头节点前添加一个哑节点，以免待删节点为头节点时操作无法进行。
         * <p>
         *     添加头节点是为了方便操作，但不是必须。
         * <p>
         * 双指针 + 虚拟头节点
         * <p>
         * 定义两个指针：分别指向 『当前遍历的节点』和『前一个节点』
         */
        public ListNode deleteNode(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;
            while (head != null) {
                if (head.val == val) {
                    pre.next = pre.next.next;
                    break;
                }

                pre = head;
                head = head.next;
            }

            return dummy.next;
        }
    }


    /**
     * 未添加虚拟头结点的方案
     */
    static class Solution2{

        public ListNode deleteNode(ListNode head, int val) {
            if(head == null) return null;

            if(head.val == val){
                return head.next;
            }

            ListNode cur = head;

            // 找到要删除结点的上一个结点
            while(cur.next != null && cur.next.val != val){
                cur = cur.next;
            }
            // 删除结点
            cur.next = cur.next.next;
            return head;
        }
    }

    /**
     * 『递归』解法 —————— 递归大法好啊
     */
    static class Solution3 {
        public ListNode deleteNode(ListNode head, int val) {
            if(head ==  null) return null;

            if(head.val == val) return head.next;

            head.next = deleteNode(head.next,val);

            return head;
        }
    }




}
