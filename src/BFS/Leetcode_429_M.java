package BFS;

import tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bertking
 * @Package BFS
 * @Description: ReviewLeeCode
 * @date 2021/4/14-4:51 下午
 * @problem 429. N 叉树的层序遍历
 * @level Medium
 */
public class Leetcode_429_M {

    /**
     * BFS的层次遍历
     */
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result  = new ArrayList();
            if(root == null) return result;

            Queue<Node> queue = new LinkedList();
            queue.add(root);

            while(!queue.isEmpty()){
                int len = queue.size();
                List<Integer> list = new ArrayList();
                for(int i =0; i< len; i++){
                    Node node = queue.poll();
                    list.add(node.val);

                    List<Node> children = node.children;
                    for(int j= 0; j < children.size(); j++){
                        queue.add(children.get(j));
                    }
                }
                result.add(list);
            }
            return result;
        }
    }

}
