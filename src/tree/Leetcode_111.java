package tree;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/2-3:08 下午
 * @problem 111. 二叉树的最小深度
 *
 * 最小深度 : 参考最大深度 将Math.max改成Math.min即可。但是由于是求最小，这样就不得不考虑左右子树为null的情况。
 */
public class Leetcode_111 {

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 左,右子树的深度
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            //左(右)子树为空，深度为右(左)子树深度+当前节点深度1
            if (left == 0) return right + 1;
            if (right == 0) return left + 1;


            //左、右子树不为空，深度为左、右子树深度较小者+当前节点深度1
            return Math.min(left, right) + 1;
        }
    }

    static class Solution2 {

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left != null && root.right == null) {
                return 1 + minDepth(root.left);
            }

            if (root.left == null && root.right != null) {
                return 1 + minDepth(root.right);
            }


            int left = minDepth(root.left);
            int right = minDepth(root.right);

            return Math.min(left, right) + 1;
        }
    }
}
