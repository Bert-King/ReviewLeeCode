package tree;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/11-8:29 下午
 * @problem 965. 单值二叉树
 * @level Easy
 */
public class Leetcode_965 {
    /**
     * 递归
     */
    static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if(root == null){
                return true;
            }

            if(root.left != null && root.left.val != root.val){
                return false;
            }

            if(root.right != null && root.right.val != root.val){
                return false;
            }


            return  isUnivalTree(root.left)&&isUnivalTree(root.right);
        }
    }
}
