package bracket;

import java.util.Stack;

/**
 * @author bertking
 * @Package bracket
 * @Description: ReviewLeeCode
 * @date 2021/4/10-4:06 下午
 * @problem  1614. 括号的最大嵌套深度
 * @level Easy
 */
public class Leetcode_1641 {


    /**
     * 此题的描述非常多，但真正的题目在于：
     *
     * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
     *
     * 题目已经保证给定的是『有效括号字符串』
     *
     * 解题思路：
     *
     * 定义一个depth来记录匹配()的数量
     * 当遇到 ( 时 ++；
     * 当遇到 ) 时 --；
     * 如果当前的depth比ans大，则更新ans.
     *（PS: ans 表示的是最大的深度）
     *
     */
    static class Solution{

        public int maxDepth(String s){
            if(s == null || s.length() < 2) return 0;

            char[] chars = s.toCharArray();

            int depth = 0;
            int ans = 0;

            for(char c: chars){
                if(c == '('){
                    depth ++;
                }else if(c == ')'){
                    depth --;
                }

                ans = Math.max(ans, depth);
            }

            return ans;
        }
    }


    /**
     * 用栈来实现(此题不推荐)
     */
    static class Solution2{
        public int maxDepth(String s){
            int max = 0;
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '('){
                    stack.push(chars[i]);
                }else if(chars[i] == ')'){
                    stack.pop();
                }

                max = Math.max(max,stack.size());
            }
            return max;
        }
    }



}
