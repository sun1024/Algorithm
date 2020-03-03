/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (39.48%)
 * Likes:    363
 * Dislikes: 0
 * Total Accepted:    127.5K
 * Total Submissions: 322.8K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) { 
        // 特殊情况提前返回
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        if(haystack.length()<needle.length()) return -1;
        if(needle.length()==1) return haystack.indexOf(needle);
        if(!haystack.contains(Character.toString(needle.charAt(0)))) return -1;
        if(haystack.length()==needle.length()) {
            if(haystack.equals(needle)) return 0;
            else return -1;
        }
        //两层循环匹配
        for(int i=0; i<haystack.length(); i++) {
            for(int j=0; j<needle.length() && needle.length()<haystack.length()+1-i; j++) {
                if(haystack.charAt(i+j)!=needle.charAt(j)) break;
                if(j==needle.length()-1) return i;
            }
        }
        return -1;
    }
}
// @lc code=end

