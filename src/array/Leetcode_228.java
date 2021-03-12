package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/12-11:27 上午
 * @problem 228. 汇总区间
 * @level Easy
 */
public class Leetcode_228 {

    /**
     * 双指针解法：https://leetcode-cn.com/problems/summary-ranges/solution/shuang-zhi-zhen-100-miao-dong-by-sweetie-7vo6/
     *
     */
    static class Solution {

        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            if(nums == null || nums.length == 0){
                return result;
            }
            // i 初始指向第1个区间的起始位置
            int i = 0;

            // 从j=0开始向后遍历
            for(int j = 0 ; j < nums.length;j++){
                // 若不满足连续递增(即：)
                if(j+1 == nums.length || nums[j]+1==nums[j+1]){
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[i]);

                    if(i != j){
                        sb.append("->").append(nums[j]);
                    }

                    result.add(sb.toString());

                    i = j+1;
                }
            }
            return result;
        }

    }

}
