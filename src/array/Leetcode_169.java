package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/9-10:46 上午
 * @problem 169. 多数元素
 *
 * 进阶：229. 求众数 II
 */
public class Leetcode_169 {

    /**
     * 摩尔投票法
     */
    static class Solution{

        public int majorityElement(int[] nums){
            int count = 0;
            int major = nums[0];
            // 第一次遍历：找出可能的结果。
            for (int num : nums) {
                if(count <= 0){
                    major = num;
                    count ++;
                }else {
                    if(major == num){
                        count++;
                    }else {
                        count--;
                    }
                }
            }

            if(count <= 0){
                return -1;
            }

            // 第二次，统计候选人major真正的出现次数，并验证是否大于nums.length/2
            count = 0;
            for (int num : nums) {
                if(num == major){
                    count++;
                }
            }

            if(count > nums.length>>1){
                return major;
            }

            return -1;
        }

    }


    static class Solution2{

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
