package other;

import java.util.ArrayList;

/**
 * @author bertking
 * @Package other
 * @Description: ReviewLeeCode
 * @date 2021/4/9-10:52 下午
 * @problem 679. 24 点游戏
 * @level Hard
 *
 *
 * 平时玩24点游戏的思路：
 * 1. 选择其中的两个数字，进行四则运算；
 * 2. 然后根据计算结果与剩下的两个数字中，再次选择两个数字，进行四则运算，得到结果；
 * 3. 最终剩下两个数字，进行四则运算；
 * 4. 最后看其结果是否为24.
 */
public class Leetcode_24 {


    /**
     * 回溯法
     *
     * 需要注意的地方：
     * 1. 题目中明确表示除法运算是实数除法，而不是整数除法；
     *      这就是为什么转换为Double类型的原因。另外这里涉及到精度问题，默认误差小于 1e-6 即相等
     * 2. 加法，乘法符合交换律，可以减少计算次数。
     * 3. 除数不能为0.
     */
    static class Solution{
        public boolean judgePoint24(int[] nums){
            ArrayList<Double> list = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                list.add((double) nums[i]);
            }

            return solve(list);
        }


        private boolean solve(ArrayList<Double> nums){
            int size = nums.size();

            if(size == 0){
                return false;
            }

            if(size == 1){
                return Math.abs(24-nums.get(0) ) < 1e-6;
            }


            for(int i = 0 ; i < size; i++){ // 取第一个数
                for (int j = 0; j < size; j++) { // 取第二个数

                    if(i != j){

                        // 其余元素放入列表
                        ArrayList<Double> remains = new ArrayList<>();
                        for (int k = 0; k < size; k++) {
                            if(k != i && k != j){
                                remains.add(nums.get(k));
                            }
                        }

                        // 遍历进行四则运算，同时将结果放入列表中
                        for (int opt = 0; opt < 4; opt++) {
                            // 此处就是因为 +，* 符合交换律，故直接跳过本次结果。
                            if(opt < 2 &&  j > i){
                                continue;
                            }

                            remains.add(calculate(nums.get(i),nums.get(j),opt));

                            // 计算后，判断剩下的元素是否符合要求
                            if(solve(remains)){
                                return true;
                            }
                            // 每次缩小计算范围
                            remains.remove(remains.size()-1);
                        }

                    }
                }
            }

            return false;
        }


        private double calculate(double x, double y, int opt){
            switch (opt){
                case 0:
                    return x + y;
                case 1:
                    return x * y;
                case 2:
                    return x - y;
                case 3:
                    if(y != 0){
                        return x / y;
                    }
                default:
                    return 0;
            }
        }
    }
}
