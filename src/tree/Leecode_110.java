package tree;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/2/27-10:56 上午
 * @problem
 */
public class Leecode_110 {

    static class Solution1{

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
