import java.util.Arrays;

class Solution {
    private int[][] memo;
    private int[] suffixSum;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        memo = new int[n][n + 1];
        suffixSum = new int[n];
        
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return dfs(0, 1);
    }

    private int dfs(int i, int M) {
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }
        
        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int maxStones = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int opponentScore = dfs(i + X, Math.max(M, X));
            int myScore = suffixSum[i] - opponentScore;
            maxStones = Math.max(maxStones, myScore);
        }

        return memo[i][M] = maxStones;
    }
}