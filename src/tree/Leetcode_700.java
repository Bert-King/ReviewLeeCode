package tree;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/12-2:13 下午
 * @problem 700. 二叉搜索树中的搜索
 * @level Easy
 */
public class Leetcode_700 {

   static class Solution {

        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null){
                return null;
            }

            if(root.val == val){
                return root;
            }

            if(root.val > val){
                return searchBST(root.left,val);
            }else{
                return   searchBST(root.right,val);
            }
        }
    }

}
