package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/2/27-4:45 下午
 * @problem 104. 二叉树的最大深度
 */
public class Leecode_104 {
    /**
     * (DFS深度优先搜索)递归实现
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return Math.max(left, right) + 1;
        }
    }

    /**
     * BFS(广度优先搜索)
     * 由于每个节点仅访问一次，所以时间复杂度O(n)
     */
    static class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int level = 0;

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                level += 1;
                // 遍历当前层
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if(node.left != null){
                        queue.add(node.left);
                    }

                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
            }
            return level;
        }
    }
}
