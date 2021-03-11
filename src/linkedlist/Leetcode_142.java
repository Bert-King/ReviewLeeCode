package linkedlist;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/11-11:30 上午
 * @problem 142. 环形链表 II
 * @level Medium
 *
 * 此题充分利用了双指针的知识：『快慢指针』+『同步指针』
 */
public class Leetcode_142 {

    /**
     * 关于第二步的思路：
     * 设 s 为慢指针走的路程，f为快指针走的路程, b为环的距离：
     * 则根据题意可以得出： 在相遇的情况下。
     *  1. f = 2s;（快指针每次走2步，慢指针每次走1步）
     *  2. f = s + nb (相遇时，快指针刚好多走了N圈。)
     *
     * 根据1，2，得出 s = nb.
     *
     * 从 head --> 入环点 需要走 A + nb的路程。而 慢指针slow已经走了nb.所以若slow再走A 步就是入环点啦。
     *
     * 如何确定A的值呢？
     * 从head开始，和slow指针一起走，相遇时刚好就是A步啦。
     *
     */
    static class Solution{
        public ListNode detectCycle(ListNode head){
            /**
             *  第一步：利用『快慢指针』确定是否有环。
             */
            ListNode slow = head;
            ListNode fast = head;
            boolean hasCycle = false;

            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;

                if(fast == slow){
                    hasCycle = true;
                    break;
                }
            }
            System.out.println("");

            /**
             * 第二步：确定有环，利用『同步指针』找到目标。
             */
            if(hasCycle){
             ListNode result = head;
             while (head != slow){
                 slow = slow.next;
                 result = result.next;
             }
             return result;
            }else {
                return null;
            }

        }
    }
}
