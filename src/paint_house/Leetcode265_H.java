package paint_house;

/**
 * @author bertking
 * @Package paint_house
 * @Description: ReviewLeeCode
 * @date 2021/5/7-9:49 上午
 * @problem 265. 粉刷房子 II
 * @level Hard
 *
 * 题目的难点是：要求O(nk)的时间复杂度，So 这道题的考点 就是用O(n)时间求1维数组的最小值和次小值。
 *
 */
public class Leetcode265_H {

   static class Solution {
        // 时间复杂度为O(n*k*k)
        public int minCostII(int[][] costs) {
            if(costs == null || costs.length == 0) return 0;
            //  房子数目
            int houses = costs.length;
            //  颜色种类
            int colors = costs[0].length;

            int[][] dp = new int[houses][colors];

            // 初始化第0个房子的各种颜色的代价
            for(int i = 0; i < colors; i++){
                dp[0][i] = costs[0][i];
            }

            // 按照染色规定，给房子刷颜色
            for(int i = 1 ; i < houses; i++){
                for(int j = 0; j < colors; j++){

                    int minCost = Integer.MAX_VALUE;
                    for(int k = 0; k < colors; k++){
                        // 其相邻的两个房子颜色不能相同
                        if(j != k){
                            // 取上一层的dp的最小值
                            minCost = Math.min(minCost,dp[i-1][k]+costs[i][j]);
                        }
                    }

                    dp[i][j] = minCost;
                }
            }

            // 从各个颜色中找到最小花费
            int result  = Integer.MAX_VALUE;
            for(int i = 0 ; i < colors; i++){
                result = Math.min(result,dp[houses-1][i]);
            }

            return result;
        }
    }



    class Solution2 {
        // 时间复杂度为O(n*k)
        public int minCostII(int[][] costs) {
            if(costs == null || costs.length == 0) return 0;
            //  房子数目
            int houses = costs.length;
            //  颜色种类
            int colors = costs[0].length;

            // dp[i][j] 表示前0 ～ （i - 1）个房子染成 j种颜色所需要的最小花费
            // dp[i+1][j] =  min {dp[i][k]} + costs[i][j] , 其中 0 <= k < Color, k != j
            int[][] dp = new int[houses+1][colors];


            // 优化通法，求数组中除了它本身的最小值， 只需要维护min， secondmin 以及 min的位置。
            // 容易错的点。 如果 数组中 只有一个元素。 secMin不一定存在。 所以在使用secondmin进行赋值时，需要判断
            // 是否secondmin是否存在，在本题中可记为0;
            for(int i = 0; i < houses; i++){

                //这一块代码是求最小值和次小值。通用的模板。
                int min = Integer.MAX_VALUE;
                int secMin = Integer.MAX_VALUE;

                // 最小值的下标
                int minColor = 0;

                for(int c = 0 ; c < colors; c++){
                    if(dp[i][c] < min){
                        secMin = min;
                        min = dp[i][c];
                        minColor = c;
                    }else if(dp[i][c] < secMin){
                        secMin = dp[i][c];
                    }
                }

                // 这里来保证：相邻房子的颜色不相同。
                for(int c = 0 ; c < colors; c++){
                    if(c == minColor){
                        dp[i+1][c] = costs[i][c]+(secMin == Integer.MAX_VALUE ? 0 : secMin);
                    }else{
                        dp[i+1][c] = min + costs[i][c];
                    }
                }
            }


            // 从各个颜色中找到最小花费
            int result  = Integer.MAX_VALUE;
            for(int i = 0 ; i < colors; i++){
                result = Math.min(result,dp[houses][i]);
            }

            return result;
        }
    }

}
