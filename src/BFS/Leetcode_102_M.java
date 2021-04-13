package BFS;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bertking
 * @Package BFS
 * @Description: ReviewLeeCode
 * @date 2021/4/13-7:35 下午
 * @problem 102. 二叉树的层序遍历
 * @level Medium(其实很简单)
 */
public class Leetcode_102_M {

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                List<Integer> levelList = new ArrayList<>();
                while (size > 0) {
                    TreeNode cur = queue.poll();
                    levelList.add(cur.val);

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }

                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }

                    size--;
                }

                result.add(levelList);
            }

            return result;
        }
    }
}
