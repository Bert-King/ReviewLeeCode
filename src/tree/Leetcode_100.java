package tree;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/11-8:27 下午
 * @problem  100. 相同的树
 * @level Easy
 */
public class Leetcode_100 {

    /**
     * 理解递归
     */
    static class Solution{

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null){
                return true;
            }

            if(p == null || q == null){
                return false;
            }

            if(p.val != q.val){
                return false;
            }

            return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);

        }

    }
}
