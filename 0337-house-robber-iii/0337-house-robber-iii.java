/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] ans = traversal(root);
        return Math.max(ans[0], ans[1]);
    }

    int[] traversal(TreeNode curr){
        if(curr == null){
            return new int[] {0,0};
        }

        int[] left = traversal(curr.left);
        int[] right = traversal(curr.right);

        int notrob = Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        int rob = curr.val + left[0] + right[0];
        return new int[] {notrob, rob};
    }
}