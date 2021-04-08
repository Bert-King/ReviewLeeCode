package stock;

/**
 * @author bertking
 * @Package stock
 * @Description: ReviewLeeCode
 * @date 2021/4/8-3:04 下午
 * @problem 122. 买卖股票的最佳时机 II
 * @level Easy
 * <p>
 * 这道题与121的区别在于：可以交易多次
 * <p>
 * 此题采用『贪心算法』最容易
 */
public class Leetcode_122 {

    /**
     * 贪心算法：策略是所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）
     * <p>
     * 要得到最大值，那么需要连续每天交易时只取收益为正数的那天即可
     * <p>
     * 只要今天的股价比昨天高，交易。
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length < 2){
                return 0;
            }

            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                int cur = prices[i];
                int prev = prices[i-1];

                if (cur > prev) {
                    maxProfit += (cur-prev);
                }
            }
            return maxProfit;
        }
    }

    /**
     * 动态规划(DP)
     *
     * 第i天只有两种状态: 不持有or持有 股票 ：
     * 1. 当天不持有股票的状态：可能来自 昨天卖出 OR 昨天也不持有
     * 2. 当天持有股票的状态：  可能来自 昨天买入 OR 昨天也持有
     *
     * 取最后一天的不持有股票状态就是问题的解。
     */
    static class Solution2 {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            /**
             * cash : 持有现金
             * hold : 持有股票
             * 状态数组
             * 状态转移: cash -> hold -> cash -> hold -> cash -> hold -> cash
             */
            int[] cash = new int[len];
            int[] hold = new int[len];

            cash[0] = 0;
            hold[0] = -prices[0];

            for (int i = 1; i < len; i++) {
                // 现金:即不持有股票的状态
                cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
                // 股票:即持有股票的状态
                hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
            }

            return cash[len - 1];

        }
    }


    /**
     * 动态规划(DP)
     * 省空间，但是不是标准的DP
     */
    static class Solution3{
        public int maxProfit(int[] prices){
            int len = prices.length;
            int dp0 = 0;
            int dp1 = -prices[0];

            for (int i = 1; i < len; i++) {
                dp0= Math.max(dp0,dp1+prices[i]);

                dp1 = Math.max(dp1,dp0-prices[i]);
            }

            return dp0;
        }
    }

    /**
     * 标准的DP
     *
     * 不能同时参与多笔交易，所以每天交易结束只有持有一只股票和没有股票两种状态
     *
     * 我们使用dp[i][0] 表示第i天交易完成后没有持股的最大利润，dp[i][1] 表示第i天交易完成后持股的最大利润.
     * 第一种dp[i][0]，说明第i天没有持股，此时有两种可能，第i-1天没有持股，然后今天也没有买入交易，则利润为dp[i-1][0]，或者第i-1天持有股票，在今天卖出，利润为dp[i-1][1]+prices[i];
     * 所以dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
     *
     * 第二种情况dp[i][1],说明第i天持有股票，此时有两种可能，第i-1天就持有股票，今天保持不动没有交易，则利润为dp[i-1][1],或者第i-1天没有持股，是在今天买入了一支股票,则利润为dp[i-1][0] - prices[i];
     * 所以dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
     *
     * 观察两种情况我们发现我们今天的利润只和前一天相关，我们需要记录前一天的利润。
     * 那么对于第一天来说dp[0][0] = 0,dp[0][1] = -prices[0]因为第一天利润为0，花钱买入所以为负值
     * 那么最后一天dp[n][0],dp[n][1]则肯定是全部卖出不持股钱最多。
     */
    static class Solution4{
        public int maxProfit(int[] prices){
            int len = prices.length;
            if(len < 2){
                return 0;
            }

            int[][] dp = new int[len][2];


            dp[0][0] = 0; // 代表前一天不持股票的利润，

            dp[0][1] = -prices[0]; //代表前一天持股票的利润

            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            }

            return dp[len-1][0];
        }
    }



}
