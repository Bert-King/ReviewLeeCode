package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/23-4:58 下午
 * @problem  461. 汉明距离
 * @level Easy
 */
public class Leetcode_461 {

    class Solution {

        public int hammingDistance(int x, int y) {
            int counter = 0;
            int tmp = x ^ y; //  通过『异或』操作将不相同的位置标记为1；(PS:相同为0，不同为1)

            while(tmp != 0) { // 统计 tmp二进制中的1的个数。
                tmp &= (tmp-1);
                counter ++;
            }

            return counter;
        }
    }

}
