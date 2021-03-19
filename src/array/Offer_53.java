package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/19-4:50 下午
 * @problem 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @level Easy
 *
 * 排序数组中的搜索问题，首先想到 二分法 解决
 */
public class Offer_53 {
    /**
     * 暴力解法
     */
    class Solution {
        public int missingNumber(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return nums.length;
        }
    }


    class Solution2 {
        public int missingNumber(int[] nums) {
            int low = 0 ;
            int high = nums.length -1;

            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums[mid] == mid){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }
            return low;
        }
    }

}
