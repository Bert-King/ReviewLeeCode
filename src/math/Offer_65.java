package math;

/**
 * @author bertking
 * @Package math
 * @Description: ReviewLeeCode
 * @date 2021/3/22-8:27 下午
 * @problem 剑指 Offer 65. 不用加减乘除做加法
 * @level Easy
 *
 * 本质上考察的是：位运算的内容
 */
public class Offer_65 {
    /**
     * 思路:
     * 异或: 计算本位值。00得0，01或者10得1，11得0
     * 与:   计算进位。00，01,10都得0，即没有进位，11得1有进位。
     * 与运算得到的进位结果左移一位，即为进位的位置。再将进位作为b和a迭代到本函数进行计算；
     * 最终进位必然全部计算完，函数的两个输入必有一个0，计算终止。
     */
    class Solution {
        public int add(int a, int b) {
            if(a == 0){ // 终止条件
                return b;
            }

            if(b ==0){ // 终止条件
                return a;
            }

            int a1 = a^b; // 『异或』计算本位值
            int b1 = (a & b) <<1; //记录进位

            return add(a1,b1);//迭代计算进位，直到没有进位
        }
    }
}
