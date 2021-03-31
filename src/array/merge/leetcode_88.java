package array.merge;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/30-11:51 下午
 * @problem 88. 合并两个有序数组
 * @level Easy
 */
public class leetcode_88 {

    /**
     * 从尾部开始对比
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            int pos = (m--)+(n--)-1;

            int pos = m + n -1;

            /**
             * 这里需要注意一下，题目中说明:初始化 nums1 和 nums2 的元素数量分别为 m 和 n
             * 这里进行 减1 操作是为了得到两者的尾部下标。
             */
            m = m -1;
            n = n-1;


            while(m >= 0 && n >= 0){
                if(nums1[m] > nums2[n]){
                    nums1[pos--] = nums1[m--];
                }else{
                    nums1[pos--] = nums2[n--];
                }
            }

            while(n >= 0){
                nums1[pos--] = nums2[n--];
            }
        }
    }
}
