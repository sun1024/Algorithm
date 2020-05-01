/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (51.24%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    23.7K
 * Total Submissions: 46.1K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
// 三指针+动态规划
class Solution {
    public int nthUglyNumber(int n) {
        if(n<1) return 0;
        int[] res = new int[n];
        res[0] = 1;
        int p1=0, p2=0, p3=0;
        for(int i=1; i<n; i++) {
            res[i] = Math.min(res[p1]*2, Math.min(res[p2]*3, res[p3]*5));
            if(res[i] == res[p1]*2) p1++;
            if(res[i] == res[p2]*3) p2++;
            if(res[i] == res[p3]*5) p3++;
        }
        return res[n-1];
    }
}
// @lc code=end

