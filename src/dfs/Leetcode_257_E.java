package dfs;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @Package dfs
 * @Description: ReviewLeeCode
 * @date 2021/5/11-12:22 上午
 * @problem 257. 二叉树的所有路径
 * @level Easy
 */
public class Leetcode_257_E {

    /**
     * 思路：
     * 该题可以使用 dfs 的方式，从根节点一直递归到某个叶子节点，然后再返回；
     * 在递归的过程中，如果当前节点为 null，则返回 return；
     * 如果当前节点不为 null，说明它是一个正常的节点，那么我们就将这个节点放进 path 中，这个 path 表示的是一个字符串，也就是从根节点到某个叶节点的路径，这点需要注意；
     * 如果当前节点的左右孩子都为 null，那么说明当前节点就是叶节点，此时就说明，递归函数已经帮我找到了一条从根节点到当前叶节点的路径，那么我现在将这条路径加入到 ans 中即可；
     * 否则的话，说明当前节点不是叶节点，那么我还要递归的去处理左右孩子；
     * 但是，在递归的处理左右孩子之前，需要往 path 中添加一个 “->” 符号即可。
     */
    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root, "");
            return result;
        }

        public void dfs(TreeNode root, String path) {
            if (root == null) {
                return;
            }
            path += root.val;

            if (root.left == null && root.right == null) {
                result.add(path);
            } else {
                path += "->";
                dfs(root.left, path);
                dfs(root.right, path);
            }
        }
    }

    /**
     * 使用StringBuilder，效率更高
     */
    class Solution2{
        List<String> result = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root){
            dfs(root,new StringBuilder());
            return result;
        }


        public void dfs(TreeNode root,StringBuilder sb){
            if(root == null) {
                return;
            }

            sb.append(root.val);
            if(root.left == null && root.right == null){
                result.add(sb.toString());
            }else {
                sb.append("->");
                dfs(root.left,new StringBuilder(sb));
                dfs(root.right,new StringBuilder(sb));
            }
        }

    }

}
