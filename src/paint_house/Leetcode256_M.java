package paint_house;

/**
 * @author bertking
 * @Package paint_house
 * @Description: ReviewLeeCode
 * @date 2021/5/4-1:20 下午
 * @problem 256. 粉刷房子
 * @level  Medium
 *
 * 每刷一个房子都需要保证当前尽量最优，而且当前的决策受到之前的决策的影响，这是一个非常明显的：最优子结构+子问题重叠。所以使用dp八九不离十。
 *
 * 具有最优子结构可以使用贪心算法求解。如果他们也有重叠的子问题，则可以用动态规划算法求解。
 *
 * 解题思路：典型的动态规划
 *
 */
public class Leetcode256_M {
    /**
     * 思路:
     * 当我刷第 n 个房子时，我的选择是根据前面 n-1 个房子的总成本来定。
     * 定义 dp[i][j] 表示前 i 个房子在最后一个房子选择颜色 j 的情况下的总成本。
     *
     * 动态规划法，一共三种方案：
     *   1. 如果当前房子染红色，最小代价是将上个房子染成价格最少的蓝色或绿色 + 当前房子染成红色价格。
     *   2. 如果当前房子染蓝色，最小代价是将上个房子染成价格最少的红色或绿色 + 当前房子染成蓝色价格。
     *   3. 如果当前房子染绿色，最小代价是将上个房子染成价格最少的红色或蓝色 + 当前房子染成绿色价格。
     *
     *   最终选取三种方案中最低的价格即可。
     */
    static class  Solution{
        public int minCost(int[][] costs){
            int len = costs.length;

            if(len == 0){
                return 0;
            }
            // dp含义第i个房子分别涂0：红色，1：蓝色，2：绿色的总花费最小值
            int[][] dp = new int[len][3];
            // 初始化第一个房子
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];

            for (int i = 1; i < len; i++) {
                // 状态转移方程
                dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
                dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
            }

            return Math.min(dp[len-1][0],Math.min(dp[len-1][1],dp[len-1][2]));
        }
    }


    /**
     * 滚动数组空间优化
     */
    static class Solution1{
        public int minCost(int[][] costs){
            if(costs == null || costs.length == 0){
                return 0;
            }

            int len = costs.length;

            int[][]  dp = new int[len][3];
            for (int i = 1; i <= len ; i++) {
                dp[i % 3][0] = Math.min(dp[(i - 1) % 3][1], dp[(i - 1) % 3][2]) + costs[i - 1][0];
                dp[i % 3][1] = Math.min(dp[(i - 1) % 3][0], dp[(i - 1) % 3][2]) + costs[i - 1][1];
                dp[i % 3][2] = Math.min(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1]) + costs[i - 1][2];
            }

            return Math.min(dp[len % 3][0], Math.min(dp[len % 3][1], dp[len % 3][2]));
        }
    }





    /**
     * 从选择颜色的纬度上来考虑问题：
     * 选择红色，蓝色，绿色的花费。
     */
    static class Solution2{
        public int minCost(int[][] costs){
            int len = costs.length;
            if(len == 0) return 0;

            for (int i = 1; i < len ; i++) {
                costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
                costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
            }
            return Math.min(costs[len-1][0],Math.min(costs[len-1][1],costs[len-1][2]));
        }
    }
}
