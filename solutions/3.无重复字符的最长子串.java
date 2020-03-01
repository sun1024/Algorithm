import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (32.79%)
 * Likes:    3238
 * Dislikes: 0
 * Total Accepted:    365.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
// 滑动窗口
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //使用hashset作为滑动窗口 满足条件：不重复 便于查找窗口中是否存在下一个字符 O(1)
        Set<Character> window = new HashSet<>(); 
        int i = 0; //窗口左边
        int res = 0; //记录最长结果 把初始值赋为最小
        //从左向右滑动
        for(int j=0; j<s.length(); j++) {
            while(window.contains(s.charAt(j))) {  //包含j 则有重复
                window.remove(s.charAt(i)); //不断的删除窗口左边 知道窗口与j不重复
                i++;
            }
            window.add(s.charAt(j)); //不重复的情况下 窗口扩展到j
            res = Math.max(res, j-i+1); //比较当前窗口长度和历史最大值 j-i+1
        }
        return res;
    }
}
// @lc code=end

