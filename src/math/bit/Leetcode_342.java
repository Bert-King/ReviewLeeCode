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
            /**
             * WHY ？
             *
             * 4的幂一定是2的幂，另外 (4的幂-1)一定是 3的倍数。
             *
             */
            return n % 3 == 1;
        }
    }


    class Solution2 {
        public boolean isPowerOfFour(int n) {
            if(n <= 0 || (n &(n-1)) != 0){
                return false;
            }
            /**
             * WHY ?
             *
             * x = 1:  00000001
             * x = 4:  00000100
             * x = 16: 00010000
             * x = 64: 10000000
             * -----------------------------
             *
             * x = 2:  00000010
             * x = 8:  00001000
             * x = 32: 00100000
             * x = 64: 10000000
             *
             * 通过上面我们会发现，
             * 1. 4的幂一定是2的幂
             * 2. 4的幂的二进制数中1都位于奇数位上(下标从0开始)
             *
             * 所以：
             * 方法一: 我们可以让 4的幂 和 (1010101010..10)进行与运算会得到 0.
             * 其中 (101010..10)的十六进制表示为：(0xaaaaaaaa)
             *
             * 方法二: 我们可以让 4的幂 和 (01010101010101010101010101010101)进行运算 会得到本身。
             * 其中 (01010101010101010101010101010101)的十六进制表示为:(0x55555555)
             */
            return (n & 0x55555555) == n;
        }
    }

    /**
     * 通用解法
     *
     * 正则表达式法：可以用来解决x的幂的问题
     *
     * 原理:
     * 1. 对于10进制数来说，10的n次幂表达为10，100，1000，...
     * 2. 对于2进制数来讲，2的n次幂表达为 10，100，1000，...
     * 3. 对于3进制数来讲，3的n次幂表达为 10，100，1000，...
     * 4. 对于4进制数来讲，4的n次幂表达为 10，100，1000，...
     * ... 往后数，依然如此...
     *
     * 实验 504
     */
    class Solution3{
        public boolean isPowerOfFour(int n){
            // 将n 由 十进制转化为 X(此题是 4) 进制
            String string = Integer.toString(n, 4);
            /**
             * ^ 表示正则的开始，$表示正则的结束。
             * 意思为: 匹配1开头中间可以无数个0的字符
             */
            boolean result = string.matches("^10*$");
            return result;
        }
    }

    /**
     * 通用解法: 任何n次幂的问题都可以这样做
     */
    class Solution4{

        public boolean isPowerOfFour(int n){
            if(n < 1){
                return false;
            }

            while(n != 1){
                if(n % 4 != 0){
                    return false;
                }else{
                    n /= 4;
                }
            }

            return true;
        }

    }

}
