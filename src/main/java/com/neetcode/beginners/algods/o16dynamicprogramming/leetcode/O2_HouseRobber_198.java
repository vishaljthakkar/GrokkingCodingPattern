package com.neetcode.beginners.algods.o16dynamicprogramming.leetcode;

public class O2_HouseRobber_198 {
    /* Logic here is as follows:
     1. Lets say robber robbed 2nd house, then he/she cannot rob 3rd house.
     2. Robber now reaches 3rd house, the only way he can decide to rob this house is
        if money in (current house + current house - 2) is more than (current house - 1)
        Also see explanation in the solution.
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // return dp(nums);

        // Time limit exceeded with dfs. but works
        // return dfs(nums, 0);

        // Below memoization solution is working solution
        // int[] cache = new int[nums.length];
        // Arrays.fill(cache, -1);
        // return dfsCache(nums, 0, cache);

        // Bottom up DP
        return dp(nums);
    }


    private static int dfs(int[] nums, int pos) {
        if (pos >= nums.length)
            return 0;
        // I rob the house at this location. Then take the amount and proceed 2 steps.
        int option1 = nums[pos] + dfs(nums, pos+2);
        // I do not rob this house and proceed immidiate next house.
        int option2 = dfs(nums, pos+1);
        return Math.max(option1, option2);
    }

    private static int dfsCache(int[] nums, int pos, int[] cache) {
        if (pos >= nums.length) return 0;
        if (cache[pos] != -1) return cache[pos];

        int option1 = nums[pos] + dfsCache(nums, pos + 2, cache);
        int option2 = dfsCache(nums, pos + 1, cache);
        cache[pos] = Math.max(option1, option2);
        return cache[pos];
    }

    private static int dp(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // One house. Nothing much to steal :)
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int option1 = nums[i] + dp[i - 2];
            int option2 = dp[i - 1];
            dp[i] = Math.max(option1, option2);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{2,1,1,20}));
        System.out.println(rob(new int[]{2,1,1,2}));
        System.out.println(rob(new int[]{0}));
    }
}
