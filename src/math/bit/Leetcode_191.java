package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/23-3:57 下午
 * @problem 191. 位1的个数(汉明重量)
 * @level Easy
 */
public class Leetcode_191 {

    static class Solution{
        /**
         * n & (n - 1) 可以把 n 的二进制中，最后一个出现的 1 改写成 0。
         */
        public int hammingWeight(int n){
            int count = 0;
            while(n != 0){
                n &= n-1;
                count ++;
            }
            return count;
        }

    }
}
