/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;

        TreeNode treeLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode treeRight = lowestCommonAncestor(root.right, p, q);

        if(treeLeft == null) return treeRight;
        if(treeRight == null) return treeLeft;

        return root;
    }
}