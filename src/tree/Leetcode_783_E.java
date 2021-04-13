package tree;

import java.util.Stack;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/4/13-10:54 上午
 * @problem 783. 二叉搜索树节点最小距离
 * @level Easy
 *
 * 考虑对升序数组 aa 求任意两个元素之差的最小值，答案一定为相邻两个元素之差的最小
 *
 * 二叉搜索树有个性质为二叉搜索树中序遍历得到的值序列是递增有序的，
 */
public class Leetcode_783_E {

    /**
     * 递归解法
     * 利用二叉搜索树的性质：中序遍历 是 递增有序的。
     */
    static class Solution{
        int pre = -1;
        int ans = Integer.MAX_VALUE;

        public int minDiffInBST(TreeNode root) {
            inOrder(root);
            return ans;
        }

        private void inOrder(TreeNode node){
            if(node == null) return;

            inOrder(node.left);

            if(pre == -1){
                pre = node.val;
            }else{
                ans = Math.min(ans,node.val - pre);
                pre = node.val;
            }

            inOrder(node.right);
        }
    }

    /**
     * 非递归解法
     */
    static class Solution2{
        int pre = -1;
        int ans = Integer.MAX_VALUE;

        public int minDiffInBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            while(root != null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if(pre == -1){
                    pre = root.val;
                }else{
                    ans = Math.min(ans,root.val - pre);
                    pre = root.val;
                }

                root = root.right;
            }

            return ans;
        }
    }
}
