package strings;

/**
 * @author bertking
 * @Package strings
 * @Description: ReviewLeeCode
 * @date 2021/3/26-3:56 下午
 * @problem 6. Z 字形变换
 * @level Medium
 */
public class Leetcode_6 {


    class Solution {
        /**
         * https://leetcode-cn.com/problems/zigzag-conversion/solution/javashi-pin-jiang-jie-xi-lie-zigzag-conversion-by-/
         * @param s
         * @param numRows
         * @return
         */
        public String convert(String s, int numRows) {
            if(s == null || s.length() ==0 || numRows == 1){
                return s;
            }

            StringBuilder[] arr = new StringBuilder[numRows];
            int direction = 1;
            int index = 0;
            for(int i = 0; i< numRows;i++){
                arr[i] = new StringBuilder();
            }

            for(char c:s.toCharArray()){
                arr[index].append(c);
                index = index+direction;

                if(index == 0 || index == numRows-1){
                    direction = -direction;
                }
            }

            StringBuilder result = new StringBuilder();
            for(int i = 0; i < numRows; i++){
                result.append(arr[i]);
            }

            return result.toString();
        }
    }

    /**
     * 将其分为 『竖列』和 『斜列』来看
     */
    class Solution2 {
        public String convert(String s, int numRows) {
            int len = s.length();
            if (len == 0 || numRows < 1) {
                return "";
            }

            if (numRows == 1) {
                return s;
            }

            StringBuilder[] res = new StringBuilder[numRows];
            for (int i = 0; i < numRows; ++i) {
                res[i] = new StringBuilder();
            }

            /**
             * 对于输入的字符串S，其下标 i / (numRows-1)
             * 如果结果为 偶数 or 0,则代表该下标代表的字符在Z字型中属于 『竖列』。
             * 如果结果为 奇数，则代表该下标代表的字符在Z字型中属于 『斜列』(PS: Z字型的中间倾斜部分)。
             *
             * 另外，如果当前字符属于『竖列』，则按照正序依次保存在数组中；
             * 如果属于『斜列』，则逆序保存在数组中。
             */
            for (int i = 0; i < len; i++) {

                int ans = i / (numRows - 1);
                int remain = i % (numRows - 1);
                if (ans % 2 == 0) {
                    res[remain].append(s.charAt(i)); // //按余数正序保存
                } else {
                    res[numRows - remain - 1].append(s.charAt(i)); // //按余数倒序保存
                }

            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                stringBuilder.append(res[i].toString());
            }

            return stringBuilder.toString();
        }
    }

    class Solution1 {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }

            int length = s.length();

            StringBuilder sb = new StringBuilder();
            /**
             * 通过总结,我们可以发现：周期为 cycle = 2 * (numRows-1)
             */
            int cycleLen = 2 * (numRows - 1);

            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < length; j += cycleLen) {
                    sb.append(s.charAt(j));

                    if(i > 0 && i < numRows-1){
                        int sec = j + 2*(numRows-i-1);
                        if(sec < length){
                            sb.append(s.charAt(sec));
                        }
                    }
                }
            }

            return sb.toString();
        }

    }




}
