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

    /**
     * 定义两个指针： prepre 和 curcur ；prepre 在前 curcur 在后。
     * 每次让 prepre 的 nextnext 指向 curcur ，实现一次局部反转
     * 局部反转完成之后， prepre 和 curcur 同时往前移
     *
     */
    class Solution {
        // 局部 --> 局部 --> 局部
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


    /**
     * 使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 retret .
     * 此后，每次函数在返回的过程中，让当前结点的下一个结点的 nextnext 指针指向当前节点。
     * 同时让当前结点的 nextnext 指针指向 NULLNULL ，从而实现从链表尾部开始的局部反转
     * 当递归函数全部出栈后，链表反转完成。
     *
     */
    class Solution2{
        // 先递归到最后一个节点，然后再局部
        public ListNode reverseList(ListNode head){
            if(head == null || head.next == null){
                return head;
            }

            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

}
