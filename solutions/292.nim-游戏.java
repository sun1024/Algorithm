/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 *
 * https://leetcode-cn.com/problems/nim-game/description/
 *
 * algorithms
 * Easy (69.72%)
 * Likes:    275
 * Dislikes: 0
 * Total Accepted:    38.8K
 * Total Submissions: 55.7K
 * Testcase Example:  '4'
 *
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * 
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: false 
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * 
 * 
 */

// @lc code=start
// 递归 会超时ORZ
// class Solution {
//     public boolean canWinNim(int n) {
//         if(n<4) return true;
//         if(n==4) return false;
//         if(n==5) return true; //!canWinNim(n-1)
//         if(n==6) return true; //!canWinNim(n-1) || !canWinNim(n-2)
//         if(n==7) return true; //!canWinNim(n-1) || !canWinNim(n-2) || !canWinNim(n-3)
//         if(n==8) return false; 
//         if(n==9) return true; 
//         if(n==10) return true; 
//         if(n==11) return true; 
//         if(n==12) return false; 
//         if(n==13) return true; 
//         if(n==14) return true; 
//         if(n==15) return true; 
//         if(n==16) return false; // 4的倍数为false
//         return !canWinNim(n-1) || !canWinNim(n-2) || !canWinNim(n-3);
//     }
// }
// 4的倍数为false
class Solution {
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
}
// dp[n] = !dp[n-1] || !dp[n-2] || !dp[n-3] n太大栈溢出了。。。
// class Solution {
//     public boolean canWinNim(int n) {
//         if(n<4) return true;
//         boolean[] dp = new boolean[n+1];
//         dp[1] = true;
//         dp[2] = true;
//         dp[3] = true;
//         dp[4] = false;
//         if(n>4) {
//             for(int i=5; i<=n; i++) {
//                 dp[i] = !dp[i-1] || !dp[i-2] || !dp[i-3];
//             }
//         }
//         return dp[n];
//     }
// }
// 空间优化dp 还是超时 算了不折腾。。。
// class Solution {
//     public boolean canWinNim(int n) {
//         if(n<4) return true;
//         boolean dp1 = true;
//         boolean dp2 = true;
//         boolean dp3 = true;
//         boolean res = false;
//         for(int i=4; i<=n; i++) {
//             res = !dp1 || !dp2 || !dp3;
//             dp1 = dp2;
//             dp2 = dp3;
//             dp3 = res;
//         }
//         return res;
//     }
// }
// @lc code=end

