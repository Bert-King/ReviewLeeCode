package dfs;


import java.util.Arrays;

/**
 * @author bertking
 * @Package dfs
 * @Description: ReviewLeeCode
 * @date 2021/4/12-10:55 上午
 * @problem 322. 零钱兑换
 * @level Medium
 *
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class Leetcode_322 {


    /**
     * 解题思路：
     *
     * 典型的动态规划题目
     *
     * 假设f(n) 代表 要凑齐为n时所需的最少硬币数量，那么有：
     * f(n) = min(f(n-c1),f(n-c2),...f(n-cn))+1 其中c1~cn为硬币的所有面额
     *
     * 结合题目，具体解释一下：
     * 输入： coins = [1,2,5], amount = 11
     * 输出： 3
     * 解释: 11 = 5 + 5 + 1
     *
     * 题目求的值为 f(11)，第一次选择硬币时我们有三种选择。
     * 假设我们取面额为 1 的硬币，那么接下来需要凑齐的总金额变为 11 - 1 = 10，即 f(11) = f(10) + 1，这里的 +1 就是我们取出的面额为 1 的硬币。
     * 同理，如果取面额为 2 或面额为 5 的硬币可以得到：
     *  f(11) = f(9) + 1
     *  f(11) = f(6) + 1
     *  所以：
     *
     * f(11) = min(f(10), f(9), f(6)) + 1
     */
    static class Solution{
        public int coinChange(int[] coins, int amount){
            /**
             * 此处采用[总额+1]来表示无解，避免出现 Integer.MAX_VALUE +1为负数的情况
             */
            int NO_ANSWER = amount+1;

            int[] dp = new int[amount+1];
            Arrays.fill(dp,NO_ANSWER);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {

                for (int coin : coins) {
                    if(i - coin >=0){
                        dp[i] = Math.min(dp[i],dp[i-coin]+1);
                    }
                }
            }

            return dp[amount] == NO_ANSWER ? -1 : dp[amount];
        }
    }

    static class Solution2 {
        public int coinChange(int[] coins, int amount) {
            // dp[i] 表示凑成总数为i时所需的最少硬币，Integer.MAX_VALUE即表示无解
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
            // 当总额为0，自然需要0枚硬币
            dp[0] = 0;

            System.out.println(Arrays.toString(dp));

            // 遍历 1 ~ amount 需要多少枚硬币
            for (int i = 1; i <= amount; i++) {
                // 遍历所有硬币
                for (int coin : coins) {
                    /**
                     * 只有总额大于选定的硬币的面值，才能供选择
                     *  dp[i-coin] != Integer.MAX_VALUE 说明之前可以能凑成
                     *
                     *  PS: 因为 Integer.MAX_VALUE + 1 将变为 负值。所以需要在这里过滤掉
                     */
                    if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                        // 子问题dp[i-coin] + 1 就是 当前所需硬币的个数
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            // 当总额为amount时，若为Integer.MAX——VALUE，即表示无解；否则返回其数量即可
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
