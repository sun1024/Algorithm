/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (37.50%)
 * Likes:    305
 * Dislikes: 0
 * Total Accepted:    94.8K
 * Total Submissions: 252.5K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

// @lc code=start
// 暴力从小到大跑
// class Solution {
//     public int mySqrt(int x) {
//         if(x == 0) return 0;
//         int i = 1;
//         while(x / i > i && x/i > i+1) {
//             i++;
//         }
//         if(i*i>x) return i-1;
//         return i;
//     }
// }
// 二分法
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        long left = 1; 
        long right = x / 2;
        while(left < right) {
            long mid = (left + right + 1) / 2; // 注意取右中位数
            long square = mid * mid;
            if(square == x) return(int) mid;
            if(square > x) right = mid-1;
            else left = mid;
        }
        return(int) left;
    }
}
// @lc code=end

