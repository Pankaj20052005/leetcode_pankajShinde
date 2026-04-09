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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        ArrayList<TreeNode> l = new ArrayList<>();
        preorder(root, l);
        TreeNode cur = root;
        for(int i= 1; i<l.size(); i++){
            cur.left = null;
            cur.right = l.get(i);
            cur = cur.right;
        }
    }

    void preorder(TreeNode root, ArrayList<TreeNode> l){
        if(root == null) return;
        l.add(root);
        preorder(root.left, l);
        preorder(root.right, l);
    }
}