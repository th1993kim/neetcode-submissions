class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int n = nums.length;
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n];
        int[] zeroDp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        zeroDp[1] = nums[1];
        zeroDp[2] = Math.max(nums[1], nums[2]);
    
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        for (int i = 3; i < n; i++) {
            zeroDp[i] = Math.max(zeroDp[i - 2] + nums[i], zeroDp[i - 1]);
        }

        return Math.max(dp[n-2], zeroDp[n-1]);

    }
}
