package tree;

import java.util.List;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/2-7:01 下午
 * @problem N叉树的节点
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};