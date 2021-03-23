package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/23-4:45 下午
 * @problem
 * @level
 */
public class Leetcode_477 {

    /**
     * 此方法虽然不错，但因为双层for循环，导致超时。
     */
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int sum = 0;
            for(int i =0 ; i< nums.length; i++){
                for(int j =i; j< nums.length; j++){
                    if(i != j){
                        sum += hammingDistance(nums[i],nums[j]);
                    }
                }
            }
            return sum;
        }

        // Hamming距离
        public int hammingDistance(int x,int y){
            int result = 0;
            int tmp = x^y;
            return hammingWeight(tmp);
        }

        // Hamming重量
        public int hammingWeight(int n){
            int result = 0;
            while( n != 0 ){
                n &= (n-1);
                result ++;
            }
            return result;
        }
    }

}
