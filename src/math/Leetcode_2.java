package math;

import tree.ListNode;

/**
 * @author bertking
 * @Package linkedlist
 * @Description: ReviewLeeCode
 * @date 2021/3/17-7:14 下午
 * @problem 2. 两数相加
 * @level Medium
 */
public class Leetcode_2 {


    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            int result = 0;
            while (l1 != null || l2 != null || result != 0) {
                if (l1 != null) {
                    result += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    result += l2.val;
                    l2 = l2.next;
                }

                System.out.println("result:" + result);
                // 这里的 result % 10 是为了解决 想加 >= 10的情况。
                pre.next = new ListNode(result % 10);
                pre = pre.next;
                // 标记：是否进位
                result /= 10;
            }

            return dummy.next;

        }
    }


    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1.val == 0 && l1.next == null){
                return l2;
            }

            if(l2.val == 0 && l2.next == null){
                return l1;
            }

            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            int carry = 0; // carry表示进位

            while(l1 != null  || l2 != null){
                int v1 = l1 != null ? l1.val : 0;
                int v2 = l2 != null ? l2.val : 0;

                int sum = v1 + v2 + carry;

                carry = sum / 10;

                pre.next = new ListNode(sum %10);
                pre = pre.next;

                if(l1 != null){
                    l1 = l1.next;
                }

                if(l2 != null){
                    l2 = l2.next;
                }
            }

            // // 如果到了最后carry不是0，说明最后一位相加之后还有进位，再添加一个新的结点
            if(carry != 0){
                pre.next = new ListNode(1);
            }

            return dummy.next;
        }

    }

}
