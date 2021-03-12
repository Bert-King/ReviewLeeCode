package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/12-5:07 下午
 * @problem 977. 有序数组的平方
 * @level Easy
 */
public class Leetcode_977 {

    /**
     * 此题的重点在于：
     *
     * 最大值永远出现在数组的两端：===> 首尾双指针。
     *
     * 另外技巧点，最大值容易得出，所以result从尾部开始。
     *
     */
    static class Solution{

        public int[] sortedSquares(int[] nums){
            int[] result = new int[nums.length];

            /**
             * 设置两个指针
             */
            int start = 0;
            int end = nums.length-1;

            int i = nums.length-1;

            while(start <= end){
                int s1 = nums[start]*nums[start];
                int s2 = nums[end] * nums[end];

                if(s1 < s2){
                    result[i] = s2;
                    end--;
                }else {
                    result[i] = s1;
                    start++;
                }

                i --;
            }

            return result;
        }

    }

}
