package stock;

/**
 * @author bertking
 * @Package stock
 * @Description: ReviewLeeCode
 * @date 2021/4/7-4:50 下午
 * @problem 121. 买卖股票的最佳时机
 * @level Easy
 *
 * 注意这道题：只能交易一次
 */
public class Leetcode_121 {

    /**
     * 动态规划:
     * 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     */
    static class Solution{
        public int maxProfit(int prices[]){
            int maxProfit = 0;
            int min = prices[0];//假设0位置为最小

            for (int i = 0; i < prices.length; i++) {
                if(prices[i] > min){
                    maxProfit = Math.max(maxProfit,prices[i]-min); //如果后面比最小大，求差，与现有最大比取最大值
                }else if(prices[i] < min){
                    min = prices[i]; //如果后面比最小还小，那么替换最小值，从这里继续算起
                }
            }

            return maxProfit;
        }
    }


    static class Solution2{
        public int maxProfit(int[] prices){
            int len = prices.length;
            int[][] dp = new int[len][2];

            dp[0][0] = 0; // 代表前一天不持股票的利润，

            dp[0][1] = -prices[0]; //代表前一天持股票的利润

            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
            }
            return dp[len-1][1];
        }
    }

}
