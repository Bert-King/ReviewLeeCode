package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author bertking
 * @Package BFS
 * @Description: ReviewLeeCode
 * @date 2021/4/12-7:33 下午
 * @problem 752. 打开转盘锁
 * @level Medium
 */
public class Leetcode_752_M {
    static class Solution{
        public int openLock(String[] deadends, String target){
            Set<String>  deads = new HashSet<>();
            for(String s:deadends){
                deads.add(s);
            }

            Set<String> visited = new HashSet<>();

            int step = 0;
            Queue<String> queue = new LinkedList<>();
            queue.offer("0000");
            visited.add("0000");

            while (!queue.isEmpty()){
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();

                    if(deads.contains(cur)){
                        continue;
                    }

                    if(cur.equals(target)){
                        return step;
                    }

                    for (int j = 0; j < 4; j++) {
                        String upOne = upOne(cur, j);
                        if(!visited.contains(upOne)){
                            queue.offer(upOne);
                            visited.add(upOne);
                        }

                        String downOne = downOne(cur, j);
                        if(!visited.contains(downOne)){
                            queue.offer(downOne);
                            visited.add(downOne);
                        }
                    }

                    step ++;
                }
            }

            return -1;
        }


        private String upOne(String s,int j){
            char[] chars = s.toCharArray();
                if(chars[j] == '9'){
                    chars[j] = '0';
                }else {
                    chars[j] ++;
                }
            return new String(chars);
        }

        private String downOne(String s,int j){
            char[] chars = s.toCharArray();
            if(chars[j] == '0'){
                chars[j] = '9';
            }else {
                chars[j] --;
            }
            return new String(chars);
        }

    }


}
