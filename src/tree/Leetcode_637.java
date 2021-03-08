package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/3-4:57 下午
 * @problem 637. 二叉树的层平均值
 *
 * 还是『层次遍历』的思想。
 *
 */
public class Leetcode_637 {

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList();
            if(root == null) return result;

            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);

            while(!queue.isEmpty()){
                int level = queue.size();

                double sum = 0.0;
                for(int i = 0; i < level; i++ ){
                    TreeNode node = queue.poll();
                    sum += node.val;

                    if(node.left != null){
                        queue.add(node.left);
                    }

                    if(node.right != null){
                        queue.add(node.right);
                    }
                }

                result.add(sum / level);
            }
            return result;
        }
    }

}
