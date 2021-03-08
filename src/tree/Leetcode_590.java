package tree;

import java.util.*;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/2-7:32 下午
 * @problem 590. N 叉树的后序遍历
 *
 * 此题：若用递归则为easy;若用迭代则为medium
 */
public class Leetcode_590 {

    // 递归
    class Solution {
        List<Integer> result = new ArrayList<Integer>();

        public List<Integer> postorder(Node root) {
            if(root == null) return result;

            if(!root.children.isEmpty()){
                for(int i =0; i < root.children.size(); i++){
                    postorder(root.children.get(i));
                }
            }

            result.add(root.val);

            return result;
        }
    }

    // 迭代: 回想迭代的先序遍历(根右左)，翻转后为左右根。注这里有个翻转操作。可以使用再用栈倒一下，也可以采用LinkedList的api来实现
    class Solution2 {

        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<Integer>();

            if(root == null) return result;

            Stack<Node> stack = new Stack();
            stack.push(root);

            while(!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);

                for(int i=0; i< root.children.size(); i ++){
                    stack.push(root.children.get(i));
                }
            }
            Collections.reverse(result);
            return result;
        }
    }

    /**
     * 讨巧的迭代---LinkedList
     * pollLast()尾部删除；
     * add() 尾部插入；
     * addFirst()：头部插入；
     */
    class Solution3 {
        public List<Integer> postorder(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                output.addFirst(node.val);
                for (Node item : node.children) {
                    if (item != null) {
                        stack.add(item);
                    }
                }
            }
            return output;
        }
    }






}
