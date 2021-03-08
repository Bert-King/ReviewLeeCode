package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/3-2:53 下午
 * @problem  102. 二叉树的层序遍历
 */
public class Leetcode_102 {

    /**
     * 借助队列实现的BFS。
     */
    class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();

            if(root ==  null) return list;

            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);

            while(!queue.isEmpty()){
                int level = queue.size();
                List<Integer> nList = new ArrayList();
                for(int i = 0; i< level; i++){
                    TreeNode node = queue.poll();
                    nList.add(node.val);

                    /****START***
                     *  跟 N叉树的层次遍历对比，仅在此处稍有区别
                     * */
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                    /****END****/

                }
                list.add(nList);
            }
            return list;

        }


    }


    /**
     * 递归实现 即：DFS
     */
    static class Solution2{
        public List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root ==  null) return result;

            traverse(root,0);

            return result;
        }

        public void traverse(TreeNode node,int level){
            if(node == null) return;

            if(result.size()-1 < level){
                result.add(new ArrayList<Integer>());
            }
            result.get(level).add(node.val);

            traverse(node.left,level+1);

            traverse(node.right,level+1);

        }
    }


}
