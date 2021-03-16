package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/16-4:21 下午
 * @problem
 * @level
 */
public class Leetcode_82 {

    static class Solution{

        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;
            ListNode cur = head;

            while (cur != null && cur.next != null ){
                if(cur.val == cur.next.val){

                    // 处理多个连续重复的情况
                    while (cur.next != null && cur.val == cur.next.val){
                        cur = cur.next;
                    }

                    pre.next = cur.next;
                }else {
                    pre = cur;
                }

                cur = cur.next;
            }

            return dummy.next;
        }

    }
}
