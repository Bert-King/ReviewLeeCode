package math;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bertking
 * @Package math
 * @Description: ReviewLeeCode
 * @date 2021/3/18-3:56 下午
 * @problem 989. 数组形式的整数加法
 * @level Easy
 *
 * 此题为66的进阶题
 */
public class Leetcode_989 {


    /**
     * 基于『逐位相加』的思想。
     */
    static class Solution{

        public List<Integer> addToArrayForm(int[] A, int K) {

            LinkedList<Integer> result = new LinkedList<>();

            /**
             * 用来表示 K+ A[i]的各位和。
             */
            int sum = K;
            int i = A.length -1;

            while (i >= 0 || sum > 0){
                if(i >= 0){
                    sum += A[i];
                }

                result.addFirst(sum % 10);
                sum /= 10;

                i --;
            }

            return result;
        }
    }
}
