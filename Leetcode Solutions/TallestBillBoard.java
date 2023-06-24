class Solution {

    Integer[][] dp;
    int offset = 5000;

    public int tallestBillboard(int[] rods) {

        dp = new Integer[21][2 * offset + 1];
        int ans = solve(0, 0, rods);
        if (ans < 0)
            return 0;
        return ans;
    }

    int solve(int i, int diff, int[] rods) {
        if (i == rods.length) {
            if (diff == 0)
                return 0;
            return Integer.MIN_VALUE;
        }

        if (dp[i][diff + offset] != null)
            return dp[i][diff + offset];

        int op1 = solve(i + 1, diff, rods);
        int op2 = rods[i] + solve(i + 1, diff + rods[i], rods);
        int op3 = solve(i + 1, diff - rods[i], rods);
        return dp[i][diff + offset] = Math.max(op1, Math.max(op2, op3));
    }
}