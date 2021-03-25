package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/24-3:54 下午
 * @problem 231. 2的幂
 * @level Easy
 */
public class Leetcode_231 {

    /**
     * 原理：
     * 1. 2的幂n 一定大于0；
     * 2. 2的幂n 用二进制表示，二进制最高位为1，其余是0。(n-1则一定是最高位为0，其它低位全是1)
     * <p>
     * 基于此: n & (n-1) == 0即可
     * <p>
     * 举例：
     * 4的二进制为 100；
     * 3的二进制为 011；
     * <p>
     * 4&3 == 0
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
        }
    }


    /**
     * 负数在计算机中以补码表示(补码 = 反码 +1)
     * 正数在计算机中以原码表示。
     *
     * 将两者进行与操作(n & -n),得到的肯定是原码中最后的一个二进制1.
     *
     * (8&(-8)->00001000 & 11111000 得 00001000，即8)
     */
    class Solution2 {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (-n)) == n;
        }
    }


}
