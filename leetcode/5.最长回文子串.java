/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (30.32%)
 * Likes:    2483
 * Dislikes: 0
 * Total Accepted:    327K
 * Total Submissions: 1M
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
// 中心扩展法
// 从每个字符向两边扩展 判断是否为回文 记录最大值
// 两种回文都要考虑到  abba  aba  
// class Solution {
//     public String longestPalindrome(String s) {
//         if(s.length() == 0) return "";
//         // 初始化子串 
//         String res = s.substring(0, 1);
//         for(int i=0; i<s.length()-1; i++) {
//             String str1 = getSubString(s, i, i); // aba
//             String str2 = getSubString(s, i, i+1); // abba
//             // 比谁长
//             if(str1.length()>str2.length() && str1.length()>res.length()) res = str1;
//             else if(str2.length()>str1.length() && str2.length()>res.length()) res = str2;
//         }
//         return res;
//     }
//     private String getSubString(String s, int i, int j) {
//         while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
//             i--;
//             j++;
//         }
//         // i比子串左边小1 j比子串右边大1 
//         // substring [left, right)
//         return s.substring(i+1, j);
//     }
// }
// 动态规划
// dp[i][j] 表示[i, j]的子串是否回文
// dp[i][j] = dp[i+1][j-1] && s[i] == s[j] 
// 关键点在于同时考虑 aba abba
// 实测还没有第一种方法快
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int len = s.length();
        // 初始化
        int maxLen = 1;
        int start = 0;

        boolean [][] dp = new boolean[len][len];
        for(int i=0; i<len; i++) {
            dp[i][i] = true; // aba 的情况 b肯定回文
        }
        // 转移方程：dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
        // 因为要j-1,所以j从1开始
        // 左边小于右边,所以i<j
        // 只有将小一点的dp[i][j]判断出来，才能去判断长一点的dp[i][j]. 
        // 注意这里两层for循环的边界，体会动态规划的无后效性
        for(int j=1; j<len; j++) {
            for(int i=0; i<j; i++) {
                if(s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else {
                    if(j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                    if(dp[i][j] && j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        start = i; 
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
// @lc code=end

