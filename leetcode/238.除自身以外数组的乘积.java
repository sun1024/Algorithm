/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 *
 * https://leetcode-cn.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (67.68%)
 * Likes:    371
 * Dislikes: 0
 * Total Accepted:    36.1K
 * Total Submissions: 53.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 
 * 
 * 
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * 
 */

// @lc code=start
// 两次遍历
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0) return res;
        res[0] = 1;
        for(int i=1; i<nums.length; i++) {
            res[i] = res[i-1]*nums[i-1]; // res[i] = nums在i之前的所有数相乘
        }
        int temp = 1;
        for(int j=nums.length-2; j>=0; j--) {
            temp *= nums[j+1]; //通过中间变量存储 nums在j之后的所有数相乘
            res[j] *= temp; //res[i] * temp 即为所求
        }
        return res;
    }
}
// @lc code=end

