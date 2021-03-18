package array.math;

/**
 * @author bertking
 * @Package array.math
 * @Description: ReviewLeeCode
 * @date 2021/3/18-10:42 上午
 * @problem 66. 加一
 * @level Easy
 */
public class Leetcode_66 {

    /**
     * 只要+1求余数，余数不等于0，说明没有进位，直接返回。如果余数等于0，说明有进位，遍历前一个数字，加1再求余数，以此循环
     */
    class Solution{

        public int[] plusOne(int[] digits) {
            for(int i = digits.length-1; i >= 0 ; i--){
                digits[i] += 1;
                digits[i] = digits[i] % 10;
                if(digits[i] != 0){
                    return digits;
                }
            }

            /**
             * 处理 9, 99 等 +1 变成 10，100...的情况.
             * 然后首位为1 其他位为0
             */
            digits = new int[digits.length+1];
            digits[0] = 1;

            return digits;
        }
    }


    /**
     * 常规解法(由于『溢出问题』不通过)
     */
    class Solution2 {
        public int[] plusOne(int[] digits) {
            int[] result = new int[digits.length];

            /**
             * 算出来数组的值。(PS: 使用long是为了避免整数溢出，但是由于题目中并没有限制整数大小，故long实际上也是不行的。)
             */
            long sum =0;
            for(int i = 0; i< digits.length; i ++){
                sum = sum * 10 + digits[i];
            }


            sum +=1;


            /**
             * 将数组的值 + 1之后，根据 %，/ 得到每位的值，再放置回数组中。
             */
            for(int i = digits.length -1 ; i>=0; i--){
                result[i] = (int)(sum %10);
                sum /= 10;
            }


            /**
             * 处理类似于9，99，这种需要进位的问题。
             */
            if(result[0] ==0){
                int[] result1 = new int[digits.length+1];
                result1[0] = 1;
                return result1;
            }

            return result;
        }
    }
}
