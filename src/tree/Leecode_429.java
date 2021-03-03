package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/3-2:24 下午
 * @problem 429. N 叉树的层序遍历
 *
 */
public class Leecode_429 {

    // 常规做法：借助队列来完成树的层次遍历
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result  = new ArrayList();
            if(root == null) return result;

            Queue<Node> queue = new LinkedList();
            queue.add(root);

            while(!queue.isEmpty()){
                int len = queue.size();
                List<Integer> list = new ArrayList();
                for(int i =0; i< len; i++){
                    Node node = queue.poll();
                    list.add(node.val);
                    queue.addAll(node.children);
                }
                result.add(list);
            }
            return result;
        }
    }

    // 递归实现,DFS，有讨巧之处。
    class Solution2 {

        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            if (root != null) traverseNode(root, 0);
            return result;
        }

        private void traverseNode(Node node, int level) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            for (Node child : node.children) {
                traverseNode(child, level + 1);
            }
        }
    }

}
