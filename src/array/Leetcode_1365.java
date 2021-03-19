package array;

import java.util.Arrays;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/19-4:12 下午
 * @problem 1365. 有多少小于当前数字的数字
 * @level Easy
 *
 */
public class Leetcode_1365 {

    /**
     * 利用『桶排序』的思想
     */
    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            //桶计数算法
            int[] bucket = new int[101];

            for(int i = 0; i < nums.length; i ++){
                bucket[nums[i]]++;
            }

            System.out.println("初始化桶:"+ Arrays.toString(bucket));

            for(int j = 1; j < bucket.length; j++){
                bucket[j] += bucket[j-1];
            }

            System.out.println("桶:"+Arrays.toString(bucket));

            for(int k = 0; k < nums.length;k++){
                nums[k] = nums[k]>0?bucket[nums[k]-1]:0;
            }

            System.out.println("结果:"+Arrays.toString(nums));

            return nums;
        }
    }



    /**
     * 暴力破解
     */
    static class Solution2{

        public int[] smallerNumbersThanCurrent(int[] nums) {

            int[] result = new int[nums.length];

            for(int i = 0; i< nums.length; i++){

                int count = 0;
                for(int j = 0; j < nums.length; j++){
                    if(nums[i]>nums[j]){
                        count++;
                    }
                }
                result[i] = count;

            }
            return result;
        }
    }
}
