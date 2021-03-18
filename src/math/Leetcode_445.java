package math;

import tree.ListNode;

import java.util.Stack;

/**
 * @author bertking
 * @Package math
 * @Description: ReviewLeeCode
 * @date 2021/3/18-7:23 下午
 * @problem 445. 两数相加 II
 * @level Medium
 */
public class Leetcode_445 {

    class Solution{

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            Stack<Integer> s1 = new Stack<>();

            Stack<Integer> s2  = new Stack<>();

            while(l1 != null){
                s1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }


            int tmp = 0;// 标记是否进位
            ListNode head = null;

            while (!s1.isEmpty() || !s2.isEmpty() || tmp != 0){
                if(!s1.isEmpty()){
                    tmp += s1.pop();
                }

                if(!s2.isEmpty()){
                    tmp += s2.pop();
                }

                ListNode cur = new ListNode(tmp % 10);
                // 头插法
                cur.next = head;
                head = cur;


                tmp /= 10;

            }

            return head;
         }
    }

}
