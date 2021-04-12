package dfs;

/**
 * @author bertking
 * @Package dfs
 * @Description: ReviewLeeCode
 * @date 2021/4/12-3:40 下午
 * @problem 518. 零钱兑换 II
 * @level Medium
 *
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 */
public class Leetcode_518 {

    static class Solution{
        public int change(int amount,int[] coins){
            int[] dp = new int[amount+1];
            dp[0] = 1; // 有一种方案凑成 0 元，那就是 一个也不选

            for(int coin : coins){
                for (int i = coin; i <= amount; i++) {
                    dp[i] = dp[i] + dp[i-coin];
                }
            }

            return dp[amount];
        }
    }
}
