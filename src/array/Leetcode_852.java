package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/25-7:50 下午
 * @problem 852. 山脉数组的峰顶索引
 * @level Easy
 */
public class Leetcode_852 {

    /**
     * 不一样的二分法
     */
    class Solution {

        public int peakIndexInMountainArray(int[] arr) {
            int start = 0;
            int end = arr.length -1;

            while(end >= start){
                int mid = start + (end - start) / 2 ;

                if(arr[mid+1] > arr[mid]){
                    start = mid + 1;
                }else if(arr[mid -1] >  arr[mid]){
                    end = mid -1;
                }else{
                    return mid;
                }
            }

            return -1;
        }
    }

}
