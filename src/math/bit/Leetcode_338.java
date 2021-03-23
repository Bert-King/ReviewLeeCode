package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/23-8:20 下午
 * @problem 338. 比特位计数
 * @level Medium
 */
public class Leetcode_338 {


    class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num+1];
            result[0] = 0;
            for(int i =1 ; i <= num; i++){
                result[i] = result[i &(i-1)]+1;
            }
            return result;
        }
    }

    /**
     * 这里其实还是借鉴了191的策略。(PS: 非最优解)
     *
     * 原因:
     *
     *
     */
    class Solution2{

        public int[] countBits(int num) {
            int[] result = new int[num+1];

            for(int i =1 ; i <= num; i++){
                int tmp = i;
                while(tmp != 0){
                    tmp &= (tmp -1);
                    result[i]++;
                }
            }
            return result;
        }

    }

}
