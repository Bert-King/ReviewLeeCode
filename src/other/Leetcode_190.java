package other;

/**
 * @author bertking
 * @Package other
 * @Description: ReviewLeeCode
 * @date 2021/3/29-7:33 下午
 * @problem 190. 颠倒二进制位
 * @level Easy
 */
public class Leetcode_190 {

    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            return Integer.reverse(n);
        }
    }


    /**
     * 将 nn 视作一个长为 3232 的二进制串，从低位往高位枚举 nn 的每一位，将其倒序添加到翻转结果 \textit{rev}rev 中。
     *
     * 代码实现中，每枚举一位就将 nn 右移一位，这样当前 nn 的最低位就是我们要枚举的比特位。当 nn 为 00 时即可结束循环。
     *
     */
    public class Solution2 {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int a = 0;
            // 循环i=32次，每次取N的最后一位左移i位，然后N右移1位

            /**
             *左移<<：左边的二进制位丢弃，右边补0

             右移>>：正数左补0，负数左补1，右边丢弃

             无符号左移<<<：左边的二进制位丢弃，右边补0

             无符号右移>>>：忽略符号位，空位都以0补齐
             */
            for(int i = 31; i >= 0; i --){
                a |= (n&1) << i;
                n >>>= 1;
            }
            return a;
        }
    }
}
