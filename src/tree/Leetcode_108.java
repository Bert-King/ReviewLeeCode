package tree;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/10-4:17 下午
 * @problem 108. 将有序数组转换为二叉搜索树
 */
public class Leetcode_108 {
    /**
     * 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return dfs(nums,0,nums.length-1);
        }

        public TreeNode dfs(int[] nums,int low,int high){
            if(low > high){
                return null;
            }

            int medium = low + (high - low) / 2;

            TreeNode root = new TreeNode(nums[medium]);

            root.left = dfs(nums,low,medium-1);
            root.right = dfs(nums,medium+1,high);

            return root;
        }
    }
}
