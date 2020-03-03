/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (43.01%)
 * Likes:    92
 * Dislikes: 0
 * Total Accepted:    23.9K
 * Total Submissions: 55.3K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        // int left = 1;
        // int right = num - 1;
        long left = 1;
        long right = num / 2 + 1;
        while(left<=right) {
            // int mid = left + (right - left) / 2;
            long mid = left + (right - left) / 2;
            if(mid*mid == num) return true;
            if(mid*mid > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
// @lc code=end

