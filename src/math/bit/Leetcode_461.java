package math.bit;

/**
 * @author bertking
 * @Package math.bit
 * @Description: ReviewLeeCode
 * @date 2021/3/23-4:58 下午
 * @problem  461. 汉明距离
 * @level Easy
 *
 * 汉明距离:广泛应用于多个领域。在编码理论中用于错误检测，在信息论中量化字符串之间的差异
 *
 * 两个整数之间的汉明距离是对应位置上数字不同的位数
 *
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
