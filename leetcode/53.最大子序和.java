/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (48.99%)
 * Likes:    1624
 * Dislikes: 0
 * Total Accepted:    160.6K
 * Total Submissions: 326.5K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */

// @lc code=start
// O(n*n)
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max = nums[0];
//         for(int i=0; i<nums.length; i++) {
//             int temp = 0;
//             for(int j=i; j<nums.length; j++) {
//                 temp += nums[j];
//                 if(temp>max) max = temp;
//             }
//         }
//         return max;
//     }
// }
// O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur_max = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > cur_max+nums[i]) cur_max = nums[i];
            else cur_max += nums[i];
            if(cur_max > max) max = cur_max;
        }
        return max;
    }
}
// @lc code=end

