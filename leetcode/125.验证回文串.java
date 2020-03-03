/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (42.29%)
 * Likes:    161
 * Dislikes: 0
 * Total Accepted:    80.3K
 * Total Submissions: 189.2K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        s = s.toLowerCase();
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1<=p2) {
            if(notAlNum(s.charAt(p1))) {
                p1++;
            } else if(notAlNum(s.charAt(p2))) {
                p2--;
            } else if(s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
            } else return false;
        }
        return true;
    }
    public boolean notAlNum(char a) {
        if(a>='a' && a<= 'z') return false;
        if(a>='0' && a<= '9') return false;
        else return true;
    }
}
// @lc code=end

