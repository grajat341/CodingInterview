class Solution {
     public int equalPairs(int[][] grid) {
        int res = 0; int l = grid.length;
        for(int i = 0; i < l; i++){
            // Create temp arr to hold current column
            int[] temp = new int[l];
            for(int j = 0; j < l; j++) 
                temp[j] = grid[j][i];
            // Compare curr column to each row
            for(int y = 0; y < l; y++) 
                if(Arrays.equals(temp, grid[y])) 
                    res++;
        } return res;
    }
}
