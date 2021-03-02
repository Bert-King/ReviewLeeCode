package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/2-7:00 下午
 * @problem 589. N 叉树的前序遍历
 */
public class Leecode_589 {

    // 递归
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
}
