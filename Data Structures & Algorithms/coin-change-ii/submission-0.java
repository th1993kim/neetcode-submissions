class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            int i = 0;
            while (i + coin <= amount) {
                if (dp[i] > 0) {
                    int next = i+coin;
                    dp[next] += dp[i];
                }
                i++;
            }
        }
        return dp[amount];
    }
}
