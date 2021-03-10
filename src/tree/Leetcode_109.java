package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bertking
 * @Package tree
 * @Description: ReviewLeeCode
 * @date 2021/3/10-7:34 下午
 * @problem 109. 有序链表转换二叉搜索树
 */
public class Leetcode_109 {

    /**
     * 更容易理解的：快慢指针找到中间结点，然后左右构建BST。
     */
    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head, null);
        }

        public TreeNode buildTree(ListNode left, ListNode right) {
            if (left == right) {
                return null;
            }

            ListNode medium = getMedium(left, right);

            TreeNode root = new TreeNode(medium.val);

            root.left = buildTree(left, medium);

            root.right = buildTree(medium.next, right);

            return root;
        }


        public ListNode getMedium(ListNode left, ListNode right) {
            ListNode slow = left;
            ListNode fast = left;

            while (fast != right && fast.next != right) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }


    }


    /**
     * 利用『快慢指针』，找出中间节点。
     */
    static class Solution1 {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return new TreeNode(head.val);
            }

            ListNode slow = head;
            ListNode fast = head;

            // 此处的medium是中间节点的前驱节点
            ListNode mediumPre = null;

            while (fast != null && fast.next != null) {
                mediumPre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            // 将链表断开，使之成为两部分。 此处为链表的左半部分，用于构建左子树
            mediumPre.next = null;

            // 代表 链表的右半部分，用于构造右子树
            ListNode rightList = slow.next;

            // 此时的slow为中间结点，用slow构造BST的根节点
            TreeNode treeNode = new TreeNode(slow.val);

            // 构造左子树
            treeNode.left = sortedListToBST(head);
            // 构造右子树
            treeNode.right = sortedListToBST(rightList);

            return treeNode;

        }
    }

    /**
     * 将 有序链表---> 有序数组。从而将问题改造为Leetcode_108
     */
    static class Solution2 {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null)return null;
            if(head.next == null)return new TreeNode(head.val);

            List<Integer> list = new ArrayList<>();
            while(head != null){
                list.add(head.val);
                head = head.next;
            }
            return buildTree(0, list.size() - 1, list);
        }

        TreeNode buildTree(int left, int right, List<Integer> list){
            if(left > right)return null;
            int mid = left + (right - left + 1) / 2;
            TreeNode root = new TreeNode(list.get(mid));
            root.left = buildTree(left, mid - 1, list);
            root.right = buildTree(mid + 1, right, list);
            return root;
        }
    }
}
