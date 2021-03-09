package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/9-10:46 上午
 * @problem 169. 多数元素
 */
public class Leetcode_169 {

    /**
     * 摩尔投票法：
     */
    static class Solution{

        public int majorityElement(int[] nums){
            int vote = 0;
            int result = nums[0];

            for(int num: nums){
                if(vote <= 0){
                    result = num;
                }

                if(result == num){
                    vote += 1;
                }else {
                    vote -= 1;
                }
            }
            return result;
        }


    }
}
