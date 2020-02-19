/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.29%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    68.2K
 * Total Submissions: 210.4K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        char blank = ' ';
        int last_char_index = s.length()-1;
        if(s.charAt(last_char_index) != blank) { //先判断末尾是否空格
            for(int i=last_char_index; i>=0; i--) {
                if(s.charAt(i) == blank) {
                    if(i==s.length()-1) return 1;
                    return s.length()-1-i;
                }
                if(i == 0) return s.length();
            }
        } else { //找出最后一个字符位置
            for(int i=last_char_index; i>=0; i--) {
                if(s.charAt(i) != blank) {
                    last_char_index = i;
                    break;
                }
            }
            for(int i=last_char_index; i>=0; i--) {
                if(s.charAt(i) == blank) return last_char_index-i;
                if(i == 0) return last_char_index+1;
            }
        }
        return 0;
    }
}
// @lc code=end

