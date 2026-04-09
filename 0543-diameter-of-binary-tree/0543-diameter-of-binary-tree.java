class Solution {

    int maxd = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxd;
    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        int cd = left + right;
        maxd = Math.max(cd, maxd);

        return 1 + Math.max(left, right);
    }
}