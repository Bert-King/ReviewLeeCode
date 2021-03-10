package array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/9-7:37 下午
 * @problem 剑指 Offer 03. 数组中重复的数字
 */
public class Offer_03 {

    /**
     * 原地置换
     * 原理：如果数组中不存在重复元素，则下标与数字对应。这里借用下标来保存值。
     */
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            if(nums == null || nums.length == 0) return -1;

            for(int i = 0; i< nums.length; i++){
                while(nums[i] != i){
                    if(nums[i] == nums[nums[i]]){
                        return nums[i];
                    }

                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }

            return -1;
        }
    }


    /**
     * 快慢指针
     */
   static class Solution4{

        public  int findRepeatNumber(int[] nums) {
            int i= 0;
            while (i < nums.length) {
                for (int j = i+1 ; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        return nums[j];
                    }
                }
                i++;
            }
            return 0;
        }
    }




    /**
     * 借助于HashSet
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     */
    class Solution5 {
        public int findRepeatNumber(int[] nums) {
            HashSet<Integer> hashSet = new HashSet();
            for(int num:nums){
                if(hashSet.contains(num)){
                    return num;
                }
                hashSet.add(num);
            }
            return -1;
        }
    }


    /**
     * 排序后再比较
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(log n)
     */
    class Solution6 {
        public int findRepeatNumber(int[] nums) {
            Arrays.sort(nums);
            for(int i = 0; i < nums.length-1; i ++){
                if(nums[i] == nums[i+1]){
                    return nums[i];
                }
            }
            return -1;
        }
    }
}
