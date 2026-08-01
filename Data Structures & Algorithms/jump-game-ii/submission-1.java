class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) continue;
            int subLength = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= subLength; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[nums.length - 1];
    }
}
