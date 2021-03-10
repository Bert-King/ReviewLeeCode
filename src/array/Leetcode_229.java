package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/9-4:15 下午
 * @problem 229. 求众数 II
 */
public class Leetcode_229 {

    /**
     * 摩尔投票法
     */
   static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList();
            if(nums.length <1)return result;

            int count1 = 0;
            int count2 = 0;

            int major1 = nums[0];
            int major2 = nums[0];
            // 1. 选出出现最多的两个元素；
            for(int num:nums){
                if(num == major1){
                    count1 += 1;
                }else if(num == major2){
                    count2 += 1;
                }else if(count1 <= 0){
                    count1 = 1;
                    major1 = num;
                }else if(count2 <= 0){
                    count2 = 1;
                    major2 = num;
                }else{
                    count1 --;
                    count2 --;
                }
            }

            // 2. 对1中选出的元素进行验证
            count1 = 0;
            count2 = 0;

            for(int num:nums){
                if(num == major1){
                    count1 ++;
                }else if(num == major2){
                    count2 ++;
                }
            }

            if(count1 > nums.length / 3){
                result.add(major1);
            }

            if(major1 != major2 && count2 > nums.length/3){
                result.add(major2);
            }

            return result;
        }




    }
}
