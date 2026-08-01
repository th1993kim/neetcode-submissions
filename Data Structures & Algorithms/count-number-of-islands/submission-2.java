class Solution {
    private int[][] dir = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    public int numIslands(char[][] grid) {
            
            int answer = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        answer++;
                        dfs(i, j, grid);
                    }
                }
            }

            return answer;
        }
        private void dfs(int y, int x, char[][] grid) {
            grid[y][x] = '0';
            for (int i = 0; i < dir.length; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (nx >= 0 && ny >= 0 && ny < grid.length && nx < grid[0].length && grid[ny][nx] == '1') {
                    
                    dfs(ny, nx, grid);
                }
            }
        }
}
