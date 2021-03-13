package other;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/12-7:29 下午
 * @problem 171. Excel表列序号
 * @level Easy
 *
 * 本质：进制转换
 */
public class Leetcode_171 {
    /**
     * 进制转换的两种方式:
     * 第一种:
     * int ans = 0;
     * ans = ans * 进制 + 当前位;
     * 如：25
     * 1）: 0 * 10 + 2
     * 2): 2 * 10 + 5
     * 3): 25
     *
     * 第二种(常规算法):
     * int ans = n1 * 进制^(n1-1) + n2 * 进制^(n2-1)....
     * 如：
     * 25 = 2 * 10^1 + 5 * 10^0
     *
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
