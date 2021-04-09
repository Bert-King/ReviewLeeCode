package bracket;

import java.util.*;

/**
 * @author bertking
 * @Package bracket
 * @Description: ReviewLeeCode
 * @date 2021/4/9-10:42 上午
 * @problem 20. 有效的括号
 * @level Easy
 *
 * GFMA(Google,Facebook,Microsoft,Amazon)都出过该题目
 *
 * 据网友反馈，B站也出现该题目
 */
public class Leetcode_20 {


    /**
     * 括号匹配是使用栈解决的经典题目
     *
     * 不匹配的三种情况：
     * 1. 字符串中的左括号多余
     * 2. 字符串中的右括号多余
     * 3. 括号不多余，但类型不匹配
     */
    static class Solution{
        public boolean isValid(String s){
            if(s == null || s.length() == 0) return true;

            Stack<Character> stack = new Stack<>();
            for(char c:s.toCharArray()){
                if(c == '('){
                    stack.push(')');
                }else if(c == '['){
                    stack.push(']');
                }else if(c == '{'){
                    stack.push('}');
                    // 此处的stack不为空，说明右括号多余
                }else if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
            // 此处：若stack不为空，则左括号多余
            return stack.isEmpty();
         }
    }


    /**
     * 最容易想到的方案，上面的Solution是该方案的对立面。逆向思维
     */
    static class Solution2{
        public boolean isValid(String s) {
            if(s == null || s.length() == 0){
                return true;
            }

            Map<Character,Character> map = new HashMap<>();
            map.put(']','[');
            map.put(')','(');
            map.put('}','{');

//            Deque<Character> deque = new ArrayDeque<>();
            Stack<Character> stack = new Stack<>();

            for(char c:s.toCharArray()){
                if(c == '(' || c == '[' || c == '{'){
                    stack.push(c);
                }else {
                    if(stack.size() == 0 || stack.pop() != map.get(c) ){
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }


}
