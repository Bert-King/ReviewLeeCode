package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/4/1-4:47 下午
 * @problem 21. 合并两个有序链表
 * @level Easy
 */
public class Leetcode_21 {

    /**
     * 类似『归并排序』的解法
     */
    class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 类似归并排序中的合并过程
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;

            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            // 任一为空，直接连接另一条链表
            if(l1 == null){
                cur.next = l2;
            }else{
                cur.next = l1;
            }

            return dummy.next;
        }
    }

    /**
     * 递归解法
     */
    class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }

            if(l2 == null){
                return l1;
            }

            ListNode res = null;

            if(l1.val < l2.val){
                res = l1;
                res.next = mergeTwoLists(l1.next,l2);
            }else {
                res = l2;
                res.next = mergeTwoLists(l1,l2.next);
            }

            return res;
        }
    }


}
