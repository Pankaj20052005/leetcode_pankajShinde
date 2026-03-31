class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i =0 ;i<grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i,j);
                }
            }
        }

        return count;
    }

    static void dfs(char[][] grid, int sr, int sc){

        int m = grid.length;
        int n = grid[0].length;
        if(sr <0 || sc < 0 || sr >= m || sc >= n || grid[sr][sc] == '0'){
            return;
        }
        grid[sr][sc] = '0';

        dfs(grid, sr+1, sc);
        dfs(grid, sr-1, sc);
        dfs(grid, sr, sc+1);
        dfs(grid, sr, sc-1);
        
    }
}