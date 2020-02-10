/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (36.05%)
 * Likes:    867
 * Dislikes: 0
 * Total Accepted:    182.8K
 * Total Submissions: 507.2K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<=0) return "";
        int min = strs[0].length();
        for(int i=0; i<strs.length; i++){
            if(strs[i].length()<min) min = strs[i].length();
        }
        for(int i=0; i<strs.length-1; i++){
            for(int j=0; j<min; j++){
                if(strs[i].charAt(j) != strs[i+1].charAt(j)){
                    min = j;
                    break;
                }
                    
            }
        }
        return strs[0].substring(0, min); 
    }
}
// @lc code=end

