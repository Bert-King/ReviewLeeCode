package dfs;

import java.util.Arrays;

/**
 * @author bertking
 * @Package dfs
 * @Description: ReviewLeeCode
 * @date 2021/4/12-10:55 上午
 * @problem 322. 零钱兑换
 * @level Medium
 */
public class Leetcode_322 {

    static class Solution {
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
                    // 只有总额大于选定的硬币的面值，才能供选择 , dp[i-coin] != Integer.MAX_VALUE 说明之前可以能凑成
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
