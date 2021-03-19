package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/19-10:34 上午
 * @problem 剑指 Offer 50. 第一个只出现一次的字符
 * @level Easy
 */
public class Offer_50 {

    static class Solution{
        public char firstUniqChar(String s) {
            int[] arr = new int[26];

            char[] chars = s.toCharArray();
            // 此处将a..z分别对应于arr数组的下标，其对应的值为字符所出现的个数。
            for(char c:chars){
                arr[c-'a'] ++;
            }

            // 找出第一个字符所出现的个数为1的情况。
            for(char c:chars){
                if(arr[c-'a'] == 1){
                    return c;
                }
            }

            return ' ';
        }

    }

}
