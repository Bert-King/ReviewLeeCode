package array;

import java.util.Arrays;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/4/12-7:16 下午
 * @problem 179. 最大数
 * @level Medium
 */
public class Leetcode_179 {

    static class Solution{
        public String largestNumber(int[] nums){
            if(nums == null||nums.length == 0){
                return "";
            }

            String[] arr = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));


            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s);
            }

            String result = sb.toString();

            if(result.charAt(0) == '0'){
                result = "0";
            }

            return result;
        }
    }
}
