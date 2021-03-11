package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/11-5:28 下午
 * @problem 283. 移动零
 * @level Easy
 */
public class Leetcode_283 {

    /**
     *
     * 思路: 把0移到后面 <==>  把非0的元素按顺序移到前面。
     *
     * 每次移动完非0元素后，自动将该位置置为0，这样循环一遍，最后的位置都直接为0.（PS:如果i == index,是不需要交换的）
     */
    static class Solution{

        public void moveZeroes(int[] nums){
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != 0){
                    if(index != i){
                        nums[index] = nums[i];
                        nums[i] = 0;
                    }
                    index ++;
                }
            }
        }

    }

}
