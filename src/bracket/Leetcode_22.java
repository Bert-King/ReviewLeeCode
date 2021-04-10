package bracket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @Package bracket
 * @Description: ReviewLeeCode
 * @date 2021/4/10-5:01 下午
 * @problem 22. 括号生成
 * @level Medium
 */
public class Leetcode_22 {

    static class Solution{

        public List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n){
            dfs(n,n,"");

            return list;
        }

        public void dfs(int left,int right,String str){
            // 递归的终止条件，左右括号都不剩余
            if(left == 0 && right == 0){
                list.add(str);
                return;
            }
            
            // 如果左括号有剩余，可以拼接左括号
            if(left > 0){
                dfs(left-1,right,str+"(");
            }

            // 如果右括号剩余比左括号多，可以拼接右括号
            if(right>left){
                dfs(left,right-1,str+")");
            }
        }

    }
}
