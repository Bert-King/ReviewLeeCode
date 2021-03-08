package tree;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/2/27-10:56 上午
 * @problem 110. 平衡二叉树
 *
 * 平衡二叉(搜索)树是一种结构平衡的二叉搜索树，它是一种每个节点的左右两子树『高度差』都不超过1的二叉树。
 *
 * 由于涉及到树高度的问题，所以推荐先做【104-二叉树的最大深度】
 *
 */
public class Leetcode_110 {

    static class Solution1{
        /**
         * 按照『平衡二叉树』的定义来解
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root){
            if(root == null) return true;
//            if(Math.abs(height(root.left) - height(root.right)) > 1){
//                return false;
//            }
            return Math.abs(height(root.left) - height(root.right)) > 1 && isBalanced(root.left) && isBalanced(root.right);
        }
        /**
         * 求树的高(深)度
         * @param root
         * @return
         */
        private int height(TreeNode root){
            if(root == null){
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            return Math.max(left,right)+1;
        }
    }



   static class Solution2 {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }
        /**
         * 这里进行了一个讨巧的处理，用 return -1 来 表示非平衡。
         */
        private int height(TreeNode root){
            if(root == null){
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            /**
             * 判断是否是否『平衡』的关键在于：左右子树的高度差 <= 1 即： Math.abs(leftHeight - rightHeight) <= 1
             */
            if(leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1){
                return Math.max(leftHeight,rightHeight) + 1;
            }else{
                return -1;
            }
        }
    }


}
