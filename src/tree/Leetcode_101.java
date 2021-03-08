package tree;

import java.util.LinkedList;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/8-5:28 下午
 * @problem 101. 对称二叉树
 */
public class Leetcode_101 {
    /**
     * 递归解法
     * 写递归，首先就是找到那件需要重复做的事，然后抽象成函数
     * 思路：
     * 1. 怎么判断一棵树是不是对称二叉树？ Answer: 如果所给根节点为空，则对称，若不为空，当它的左子树与右子树对称时，则对称；
     * 2. 如何判断左子树和右子树是否对称？Answer: 如果左子树的左孩子与右子树的右孩子，左子树的右孩子与右子树的左孩子对称，则左子树和右子树对称；
     *
     * 滤清思路，得到递归点：判断左子树和右子树是否对称。
     *
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }

            return isSymmetric(root.left,root.right);
        }

        public boolean isSymmetric(TreeNode left,TreeNode right){
            if(left == null && right == null) return true;

            if(left == null || right == null) return false;

            return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
        }
    }

    /**
     * 迭代
     */
    class Solution2{
        public boolean isSymmetric(TreeNode root){
            if(root == null) return true;

            if(root.left == null && root.right == null){
                return true;
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            // 将根节点的左右孩子放到队列中
            queue.add(root.left);
            queue.add(root.right);

            while (!queue.isEmpty()){
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeFirst();

                if(left == null && right == null){
                    continue;
                }

                if(left == null || right == null){
                    return false;
                }

                if(left.val != right.val){
                    return false;
                }
                // 将左节点的左孩子，右节点的右孩子放入队列
                queue.add(left.left);
                queue.add(right.right);

                // 将左节点的右孩子，右节点的左孩子放入队列
                queue.add(left.right);
                queue.add(right.left);

            }
            return true;
        }

    }
}
