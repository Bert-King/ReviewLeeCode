package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/23-8:20 下午
 * @problem 338. 比特位计数
 * @level Medium
 */
public class Leetcode_338 {

    /**
     * DP(动态规划)
     *
     * 将（整数 - 1） 与其本身做位与运算，相当于将其最右边的 1 变成 0
     *
     * 代码中 res[i] 为 i 中 1 的个数，也就是 i & (i - 1) 中 1 的个数再 + 1。
     *
     * 等式是成立了，但是为什么可以拿来做赋值操作呢？ 我们可以看到，如果整数最右边的 1 变成了 0，无论如何，它都是减少的。
     * 即，我们是拿前面的数来算后面的数，题目中要求为 1-num，而 1 前面的数是 0，具有 **0 个 1**。
     */
    class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num+1];
            result[0] = 0;
            for(int i =1 ; i <= num; i++){
                result[i] = result[i &(i-1)]+1;
            }
            return result;
        }
    }

    /**
     * 这里其实还是借鉴了191的策略。(PS: 非最优解)
     *
     * 原因: 重复计算。
     *  我们没有很好地利用各个相邻数值间二进制数中1的个数之间的关系。
     *  (这里我们针对每一个i，都从头求一次1的个数)。
     *
     */
    class Solution2{

        public int[] countBits(int num) {
            int[] result = new int[num+1];

            for(int i =1 ; i <= num; i++){
                int tmp = i;
                while(tmp != 0){
                    tmp &= (tmp -1);
                    result[i]++;
                }
            }
            return result;
        }

    }

}
