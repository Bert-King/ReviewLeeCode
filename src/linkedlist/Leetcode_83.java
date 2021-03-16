package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/16-3:27 下午
 * @problem 83. 删除排序链表中的重复元素
 * @level Easy
 */
public class Leetcode_83 {


    /**
     * 递归法
     */
    class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            // 边界条件
            if(head == null || head.next == null){
                return head;
            }

            // 真实逻辑
            if(head.val == head.next.val){
               head =  deleteDuplicates(head.next);
            }else {
                head.next = deleteDuplicates(head.next);
            }

            return head;
        }

    }

    /**
     * 常规判断(不加虚拟头节点)
     */
    class Solution2{
        public ListNode deleteDuplicates(ListNode head){
            if(head == null || head.next == null){
                return head;
            }

            ListNode  cur = head;

            while(cur != null && cur.next != null){
                if(cur.val == cur.next.val){
                    cur = cur.next.next; // 当前节点的值与其后继节点的值相同，则删除当前节点的后继节点
                }else {
                    cur = cur.next;
                }
            }

            return head;
        }
    }

    /**
     *
     * 常规判断(虚拟头节点)
     *
     *  我们不想对特殊情况(链表为空or链表只有一个节点)的判断。
     *  为了避免判断特殊情况。这就是『虚拟头节点』的用武之地。
     */
    class Solution3{

        public ListNode deleteDuplicates(ListNode head){
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode cur = dummy;

            while (cur.next != null){
                if(cur.val == cur.next.val){
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }

    }





}
