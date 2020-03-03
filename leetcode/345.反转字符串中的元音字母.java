/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (48.98%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    25.6K
 * Total Submissions: 51.9K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] inputs = s.toCharArray();
        // 首尾指针
        int p1 = 0;
        int p2 = inputs.length-1;
        while(p1<p2) {
            if(!isYuanyin(inputs[p1])) {
                p1++;
                continue;
            }
            if(!isYuanyin(inputs[p2])) {
                p2--;
                continue;
            }
            char temp = inputs[p2];
            inputs[p2--] = inputs[p1];
            inputs[p1++] = temp;
        }
        return new String(inputs);
    }
    public boolean isYuanyin(char c) {
        char[] yuanyin = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char a:yuanyin) {
            if(a == c) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

