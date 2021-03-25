package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/24-8:05 下午
 * @problem 342. 4的幂
 * @level Easy
 */
public class Leetcode_342 {

    class Solution {
        public boolean isPowerOfFour(int n) {
            if(n <= 0 || (n &(n-1)) != 0){
                return false;
            }

            return n % 3 == 1;
        }
    }


    class Solution2 {
        public boolean isPowerOfFour(int n) {
            if(n <= 0 || (n &(n-1)) != 0){
                return false;
            }

            return (n & 0x55555555) == n;
        }
    }

}
