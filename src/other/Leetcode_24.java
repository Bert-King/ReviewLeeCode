package other;

import java.util.ArrayList;

/**
 * @author bertking
 * @Package other
 * @Description: ReviewLeeCode
 * @date 2021/4/9-10:52 下午
 * @problem 679. 24 点游戏
 * @level Hard
 */
public class Leetcode_24 {

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

            for(int i = 0 ; i < size; i++){
                for (int j = 0; j < size; j++) {

                    if(i != j){

                        ArrayList<Double> remains = new ArrayList<>();
                        for (int k = 0; k < size; k++) {
                            if(k != i && k != j){
                                remains.add(nums.get(k));
                            }
                        }


                        for (int opt = 0; opt < 4; opt++) {
                            if(opt < 2 &&  j > i){
                                continue;
                            }

                            remains.add(calculate(nums.get(i),nums.get(j),opt));

                            if(solve(remains)){
                                return true;
                            }

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
