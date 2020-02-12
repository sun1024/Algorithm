/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.76%)
 * Likes:    1370
 * Dislikes: 0
 * Total Accepted:    197.9K
 * Total Submissions: 485.5K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if(s=="") return true;
        if(s.length()%2 == 1) return false;
        for(int i=0; i<s.length(); i++){
             if(s.charAt(i) == '('){
                 int flag = 0;
                 for(int j=i+1; j<s.length();){
                   if(s.charAt(j) == ')'){
                       flag = 1;
                       break;
                   }   
                   j += 2; 
                 }
                 if(flag == 0) return false;
             }   
             if(s.charAt(i) == '{'){
                 int flag = 0;
                 for(int j=i+1; j<s.length();){
                   if(s.charAt(j) == '}'){
                       flag = 1;
                       break;
                   }   
                   j += 2; 
                 }
                 if(flag == 0) return false;
             } 
             if(s.charAt(i) == '['){
                 int flag = 0;
                 for(int j=i+1; j<s.length();){
                   if(s.charAt(j) == ']'){
                       flag = 1;
                       break;
                   }   
                   j += 2; 
                 }
                 if(flag == 0) return false;
             }  
        }
        return true;
    }
}
// @lc code=end

