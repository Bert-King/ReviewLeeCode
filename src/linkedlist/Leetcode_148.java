package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/4/1-5:20 下午
 * @problem 排序链表
 * @level Medium(其实真的不简单)
 *
 * PS: 网易高性能计算-面试题
 */
public class Leetcode_148 {


    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null){
                return null;
            }
            return  mergeSort(head);
        }

        // 找到中间节点并启动归并排序
        private ListNode mergeSort(ListNode head){
            if(head.next == null){
                return head;
            }

            ListNode slow = head;
            ListNode fast = head;

            ListNode pre = null;

            while(fast != null && fast.next != null ){
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            pre.next = null;

            ListNode left = mergeSort(head);
            ListNode right = mergeSort(slow);

            return merge(left,right);
        }


        // 归并排序
        private ListNode merge(ListNode left, ListNode right){
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while(left != null && right != null){

                if(left.val <= right.val){
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                }else{
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                }

                if(left != null){
                    cur.next = left;
                }

                if(right != null){
                    cur.next = right;
                }
            }
            return dummy.next;
        }

    }
}
