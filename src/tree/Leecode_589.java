package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/2-7:00 下午
 * @problem 589. N 叉树的前序遍历
 */
public class Leecode_589 {

    // 递归：实际上就是调用了隐式栈。So 将其转化为迭代 just only 把栈显式化即可。
   static class Solution {
        List<Integer> result = new ArrayList();

        public List<Integer> preorder(Node root) {

            if(root == null) return result;

            result.add(root.val);

            List<Node> children = root.children;

            if(children != null && !children.isEmpty()){
                for(int i = 0; i< children.size(); i++){
                    preorder(children.get(i));
                }
            }
            return result;
        }
    }

    // 迭代
    class Solution2 {

        public List<Integer> preorder(Node root) {
            
            List<Integer> result = new ArrayList();
            if(root == null) return result;

            Stack<Node> stack = new Stack<Node>();
            stack.push(root);

            while(!stack.isEmpty()){
                Node node = stack.pop();
                result.add(node.val);

                for(int i = node.children.size()-1; i>=0;i--){
                    stack.add(node.children.get(i));
                }

            }
            return result;
        }
    }
}
