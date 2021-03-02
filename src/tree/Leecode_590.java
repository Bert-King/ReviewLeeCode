package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/2-7:32 下午
 * @problem 590. N 叉树的后序遍历
 */
public class Leecode_590 {

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


    
}
