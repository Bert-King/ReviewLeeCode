package array.matrix;

/**
 * @author bertking
 * @Package array.matrix
 * @Description: ReviewLeeCode
 * @date 2021/3/21-10:52 下午
 * @problem 1572. 矩阵对角线元素的和
 * @level Easy
 */
public class Leetcode_1572 {

    /**
     * 更妙一些
     */
    class Solution {
        public int diagonalSum(int[][] mat) {
            int length = mat.length;
            int result = 0;

            /**
             * 先将主对角线想加,然后将其置为0，再进行副对角线想加。
             */
            for(int i = 0; i < length; i++){
                result += mat[i][i];
                mat[i][i]=0;
                result += mat[i][length-i-1];
            }

            return result;
        }
    }

    /**
     * 常规思路
     */
    class Solution2 {
        public int diagonalSum(int[][] mat) {
            int length = mat.length;
            int result = 0;

            // 主、副对角线 相加
            for(int i = 0; i < length; i++){
                result += mat[i][i] + mat[i][length-i-1];
            }
            // 应题目要求，删除交叉在主副对角线的元素
            if(length %2 != 0){
                result -= mat[length/2][length/2];
            }

            return result;
        }
    }
}
