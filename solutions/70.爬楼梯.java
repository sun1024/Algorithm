/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (47.78%)
 * Likes:    844
 * Dislikes: 0
 * Total Accepted:    136.4K
 * Total Submissions: 284.8K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
// 暴力递归
// class Solution {
//     public int climbStairs(int n) {
//         if(n == 1) return 1;
//         if(n == 2) return 2;
//         if(n == 3) return 3;
//         if(n == 4) return 5;
//         if(n == 5) return 8;
//         if(n == 6) return 13;
//         // 多一阶可以看成(n-1)阶+1或者(n-2)阶+2
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
// }
// 循环
class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int first = 1;
        int second = 2;
        for(int i=3; i<=n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
// @lc code=end

