package other;

/**
 * @author bertking
 * @Package other
 * @Description: ReviewLeeCode
 * @date 2021/3/29-1:50 下午
 * @problem 504. 七进制数
 * @level Easy
 */
public class Leetcode_504 {

    /**
     * 递归实现
     */
    class Solution {
        public String convertToBase7(int num) {
            if(num < 0){
                return "-"+convertToBase7(-num);
            }

            if(num < 7){
                return Integer.toString(num);
            }

            return convertToBase7(num / 7)+(num %7);

        }
    }

    /**
     * Java 迭代实现
     */
    class Solution2 {
        public String convertToBase7(int num) {
            StringBuilder sb = new StringBuilder();
            if(num >=0 && num < 7){
                return Integer.toString(num);
            }

            boolean isNegative = false;

            if(num < 0){
                num = -num;
                isNegative = true;
            }

            while (num != 0){
                sb.append(num%7);
                num /= 7;
            }

            sb.reverse();
            if(isNegative){
                sb.insert(0,"-");
            }

            return sb.toString();
        }
    }

    /**
     * Java API，
     */
    class Solution3{
        public String convertToBase7(int num){
            return Integer.toString(num,7);
        }
    }

}
