package array.matrix;

/**
 * @author bertking
 * @Package array.matrix
 * @Description: ReviewLeeCode
 * @date 2021/3/31-2:22 下午
 * @problem  240. 搜索二维矩阵 II
 * @level Medium
 *
 * 字节题库
 */
public class Leetcode_240 {

    /**
     * 从右上角开始，逐渐缩小范围
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null){
                return false;
            }

            int rows =  matrix.length ;
            if(rows <= 0 ){
                return false;
            }

            int columns = matrix[0].length;
            if(columns <= 0){
                return false;
            }

            // 从右上角出发
            int i = 0;
            int j = columns -1;

            while(i <= rows-1 && j >=0){
                if(matrix[i][j] > target){
                    j--;
                }else if(matrix[i][j] < target){
                    i ++;
                }else{
                    return true;
                }
            }
            return false;
        }
    }
}
