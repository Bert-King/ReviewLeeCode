package array.matrix;

/**
 * @author bertking
 * @Package array.matrix
 * @Description: ReviewLeeCode
 * @date 2021/3/31-12:58 下午
 * @problem 74. 搜索二维矩阵
 * @level Medium
 */
public class Leetcode_74 {

    /**
     * 精妙解法:(从右上角开始)
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            int column = matrix[0].length;

            int i = 0;
            int j = column -1;

            while( j >= 0 && i <= row-1){
                if(matrix[i][j] > target){
                    j--;
                }else if(matrix[i][j] < target){
                    i++;
                }else{
                    return true;
                }
            }
            return false;
        }
    }


    /**
     * 暴力破解
     */
    class Solution1 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            int column = matrix[0].length;


            for(int i = 0 ; i < row; i++){

                for(int j = 0; j< column; j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }

            }

            return false;
        }
    }





}
