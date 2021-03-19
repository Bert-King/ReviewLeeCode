package array;

/**
 * @author bertking
 * @Package array
 * @Description: ReviewLeeCode
 * @date 2021/3/19-2:20 下午
 * @problem 1588. 所有奇数长度子数组的和
 * @level Easy
 *
 * 此题感觉不太容易啊。
 */
public class Leetcode_1588 {


    class Solution1 {

        public int sumOddLengthSubarrays(int[] arr) {
            int sum = 0;
            // 相加的起始位置
            for(int i = 0 ; i < arr.length; i++){
                // 相加数组的大小。(1,3,5...)
                for(int j = 1 ; i + j-1 < arr.length ; j += 2 ){
                    // 求数组的和
                    for(int k = i ; k < j+i; k++){
                        sum += arr[k];
                    }
                    System.out.println("i:"+i+"，sum ="+sum);
                }
            }

            return sum;
        }
    }


    class Solution2{
        public int sumOddLengthSubarrays(int[] arr) {
            int sum = 0;
            // 奇数数组的大小 (1,3,5...),注意这里是(i <= arr.length)
            for(int i = 1 ; i <= arr.length; i += 2){
                // 从头开始找奇数数组。
                for(int j = 0 ; j+i-1 < arr.length ; j ++ ){
                    // 求和
                    for(int k = j ; k < j+i; k++){
                        sum += arr[k];
                    }

                    System.out.println("奇数数组的大小:"+i+",起始下标j:"+j+"，sum ="+sum);
                }
            }

            return sum;
        }
    }


}
