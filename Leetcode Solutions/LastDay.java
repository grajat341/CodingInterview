class Solution {

    public boolean bfsUtil
    (int r, int c, int [][]dayOfWatering, int m, boolean [][]visited) {

        int rows = dayOfWatering.length, cols = dayOfWatering[0].length;
        if (!(r >= 0 && r < rows && c >= 0 && c < cols))
        return false;

        if (visited[r][c])
        return false;

        if (dayOfWatering[r][c] <= m)
        return false;

        visited[r][c] = true;

        if (r == rows - 1)
        return true;

        return bfsUtil(r, c + 1, dayOfWatering, m, visited) |
        bfsUtil(r + 1, c, dayOfWatering, m, visited) | 
        bfsUtil(r - 1, c, dayOfWatering, m, visited) |
        bfsUtil(r, c - 1, dayOfWatering, m, visited);
    }

    public boolean bfs(int [][]dayOfWatering, int m) {
        int rows = dayOfWatering.length, cols = dayOfWatering[0].length;
        
        boolean [][]visited = new boolean[rows][cols];

        for (int col = 0; col < cols; col++) {
            if(bfsUtil(0, col, dayOfWatering, m, visited))
            return true;
        }
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int n = cells.length;

        int [][]dayOfWatering = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
            dayOfWatering[i][j] = n + 1;
        }

        for (int i = 0; i < n; i++) {
            int []curr = cells[i];

            dayOfWatering[curr[0] - 1][curr[1] - 1] = i + 1;
        }

        int l = 0, r = n - 1;

        while(l <= r) {
            int m = l + (r-l)/2;
            int day = m + 1;

            if (!bfs(dayOfWatering, day))
            r = m - 1;
            else 
            l = m + 1;
        }
        return r + 1;
    }
}