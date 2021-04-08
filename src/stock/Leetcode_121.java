package stock;

/**
 * @author bertking
 * @Package stock
 * @Description: ReviewLeeCode
 * @date 2021/4/7-4:50 下午
 * @problem 121. 买卖股票的最佳时机
 * @level Easy
 */
public class Leetcode_121 {

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
}