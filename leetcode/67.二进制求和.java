/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (52.17%)
 * Likes:    305
 * Dislikes: 0
 * Total Accepted:    63.3K
 * Total Submissions: 121.2K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        // 保证a比b长
        if(a.length()<b.length()) return addBinary(b, a); 
        StringBuilder sb = new StringBuilder();
        int flag = 0; //进位标识
        for(int i=a.length()-1, j=b.length()-1; i>=0; i--,j--) {
            if(j<0) break; // b遍历完毕
            if(flag == 1) { //有进位
                if(a.charAt(i) == '1') sb.append(b.charAt(j));
                else if(b.charAt(j) == '1') sb.append('0');
                else {
                    sb.append('1');
                    flag = 0;
                }
            } else { //无进位
                if(a.charAt(i) == '0') sb.append(b.charAt(j));
                else if(b.charAt(j) == '0') sb.append('1');
                else {
                    sb.append('0');
                    flag = 1;
                }
            }
        }
        for(int i=a.length()-b.length()-1; i>=0; i--) {
            if(flag == 1) { //有进位
                if(a.charAt(i) == '1') sb.append('0');
                else {
                    sb.append('1');
                    flag = 0;
                }
            } else sb.append(a.charAt(i)); //无进位
        }
        if(flag == 1) sb.append('1'); //进位溢出
        return sb.reverse().toString();
    }
}
// @lc code=end

