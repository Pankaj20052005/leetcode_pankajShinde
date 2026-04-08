class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode node, int sum){
        if(node == null) return false;

        sum -= node.val;
        
        if(node.left == null && node.right == null){
            return sum == 0;
        }

        return dfs(node.left, sum) || dfs(node.right, sum);
    }
}