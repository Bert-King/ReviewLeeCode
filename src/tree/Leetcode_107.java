package tree;

import java.util.*;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/3-5:26 下午
 * @problem 107. 二叉树的层序遍历 II
 *
 * Bottom --> Top。(需要注意的是，我们可以采用头插法来避免直接翻转102的结果)
 */
public class Leetcode_107 {
    // 迭代
    static class Solution{
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if(root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                int level = queue.size();

                List<Integer> temp = new ArrayList();
                for(int i =0 ; i < level ; i++){
                    TreeNode node = queue.poll();
                    temp.add(node.val);

                    if(node.left != null){
                        queue.add(node.left);
                    }

                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
                // 如果我们在这里采用尾插法。就可以避免最后的执行过程中，需要发转结果
                result.add(0,temp);
            }
            // 这里将：102的结果翻转一下，但是不够优雅
//            Collections.reverse(result);
            return result;
        }
    }

    // 递归:深度优先遍历(DFS)
   static class Solution2{
        // 这里采用LinkedList是为了后面的头插法，提高效率
        List<List<Integer>> result = new LinkedList();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if(root == null) return result;
            traverse(root,0);
            return result;
        }

        public void traverse(TreeNode node , int level){
            if(node == null) return;

            if(result.size() -1 < level){
                // 这里采用头插法是亮点
                result.add(0,new ArrayList<Integer>());
            }

            result.get(result.size()- level -1).add(node.val);

            traverse(node.left,level + 1);

            traverse(node.right,level +1);

        }
   }

}
