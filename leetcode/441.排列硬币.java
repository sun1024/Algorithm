/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 *
 * https://leetcode-cn.com/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (39.91%)
 * Likes:    49
 * Dislikes: 0
 * Total Accepted:    16.1K
 * Total Submissions: 40.3K
 * Testcase Example:  '5'
 *
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * 
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * 
 * 示例 1:
 * 
 * 
 * n = 5
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * 因为第三行不完整，所以返回2.
 * 
 * 
 * 示例 2:
 * 
 * 
 * n = 8
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * 因为第四行不完整，所以返回3.
 * 
 * 
 */

// @lc code=start
// 迭代 O(n)
// class Solution {
//     public int arrangeCoins(int n) {
//         int i = 1;
//         while(n>=i) {
//             n = n-i;
//             i++;
//         }
//         return i-1;
//     }
// }
// 二分 O(logn)
class Solution {
    public int arrangeCoins(int n) {
        // x*(x+1)/2 == n
        long left = 0;
        long right = n / 2 + 1;
        while(left<=right) {
            long mid = left + (right - left) / 2;
            if(mid*(mid+1)/2 == n) return (int)mid;
            if(mid*(mid+1)/2 > n) right = mid - 1;
            else left = mid + 1;
        }
        return (int)left-1;
    }
}
// @lc code=end

