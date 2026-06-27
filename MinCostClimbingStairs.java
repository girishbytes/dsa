class Solution {

// Let dp[i] represent the minimum cost to reach step i.
// To reach step i, you can:
// Come from step i-1, after spending dp[i-1] to get there, then pay cost[i-1]
// Come from step i-2, after spending dp[i-2] to get there, then pay cost[i-2]
// We choose the cheaper total cost, not just the cheaper single step cost.
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n+1];

        for(int i = 2; i<=n; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        
        return dp[n];
    }
}
