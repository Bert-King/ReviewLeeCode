package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/12-7:29 下午
 * @problem 171. Excel表列序号
 * @level Easy
 */
public class Leetcode_171 {
    /**
     * 进制转换的两种方式:
     * int ans = 0;
     * ans = ans * 进制 + 当前位; 如：25 
     */
    static class Solution{
        public int titleToNumber(String columnTitle){
            int ans = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                int cur = columnTitle.charAt(i) - 'A' + 1;
                ans = ans * 26 + cur;
            }

            return ans;
        }
    }
}
