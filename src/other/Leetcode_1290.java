package other;

import tree.ListNode;

/**
 * @author bertking
 * @Package other
 * @Description: ReviewLeeCode
 * @date 2021/3/25-4:45 下午
 * @problem 1290. 二进制链表转整数 (二进制转10)
 * @level Easy
 */
public class Leetcode_1290 {

    class Solution {
        public int getDecimalValue(ListNode head) {
            int result = 0;
            while(head != null){
                result = result*2 +head.val;
                head = head.next;
            }
            return result;
        }
    }

}
