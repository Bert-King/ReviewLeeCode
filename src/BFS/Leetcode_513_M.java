package BFS;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bertking
 * @Package BFS
 * @Description: ReviewLeeCode
 * @date 2021/4/14-4:05 下午
 * @problem 513. 找树左下角的值
 * @level Medium
 */
public class Leetcode_513_M {


    /**
     * 树左下角的值：其实就是树的最后一层的第一个。
     *
     * 树的层次遍历:
     * 从上到下，从左到右
     */
    static class Solution{
        public int findBottomLeftValue(TreeNode root) {
            int result = -1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();

                for(int i=0; i< size; i++){

                    TreeNode cur = queue.poll();
                    // 关键在于这里
                    if(i == 0){
                        result = cur.val;
                    }

                    if(cur.left != null){
                        queue.offer(cur.left);
                    }

                    if(cur.right != null){
                        queue.offer(cur.right);
                    }

                }
            }
            return result;
        }
    }

    /**
     * 改变层次遍历的顺序：从上到下，从右往左。
     * 这样最后一个的元素就是：最左的节点
     */
    static class Solution2{
        public int findBottomLeftValue(TreeNode root) {
            int result = -1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();

                for(int i=0; i< size; i++){

                    TreeNode cur = queue.poll();


                    if(cur.right != null){
                        queue.offer(cur.right);
                    }

                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    // 关键在于这里
                    result = cur.val;
                }
            }
            return result;
        }
    }

    /**
     * 代码简化
     */
    static class Solution3{
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();

                for(int i=0; i< size; i++){

                    root = queue.poll();


                    if(root.right != null){
                        queue.offer(root.right);
                    }

                    if(root.left != null){
                        queue.offer(root.left);
                    }
                }
            }
            return root.val;
        }
    }
}
