/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (44.37%)
 * Likes:    848
 * Dislikes: 0
 * Total Accepted:    120.9K
 * Total Submissions: 269.3K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 
 * 说明:
 * 
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n^2) 。
 * 
 * 
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * 
 */

// @lc code=start
// O(n2) DP 重点在于dp状态的定义
// dp[i] 表示以nums[i]结尾的最长上升子序列的长度, 注意一定会包含dp[i]
// 那么，dp[i]可以分成两种情况：
// 如果dp[i]前面的所有数都比dp[i]大，那么按照dp[i]的定义，dp[i] = 1
// 如果dp[i]前面存在比dp[i]小的，那么dp[i] = max(dp[a]+1, dp[b]+1 ... dp[x]+1) 这里的a就是i前面满足dp[a]<dp[i]的
// 题目所求就是max(dp[i])
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2) return nums.length;
        int [] dp = new int[nums.length];
        dp[0] = 1; // 第0个前面没有只能是1
        for(int i=1; i<nums.length; i++) {
            dp[i] = 1; // 每个dp[i]都要置为1，因为至少有它自己
            for(int j=0; j<i; j++) {
                if(nums[j]<nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int res = 0;
        for(int i:dp) {
            res = Math.max(i, res);
        }
        return res;
    }
}
// @lc code=end

