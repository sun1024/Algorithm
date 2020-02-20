/*

import jdk.nashorn.internal.ir.annotations.Ignore;
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (42.86%)
 * Likes:    427
 * Dislikes: 0
 * Total Accepted:    119.3K
 * Total Submissions: 277.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] != 9) {
                digits[i]++;
                break;
            }
            digits[i] = 0;
            if(i==0) {
                // 巧妙解法：全是9的情况，输出为1000...
                digits = new int[digits.length+1];
                digits[0] = 1;
                // 菜鸡解法：新建数组ORZ...
                // int[] new_digits = new int[digits.length+1];
                // for(int j=digits.length-1; j>=0; j--) {
                //     new_digits[j+1] = digits[j];
                // }
                // new_digits[0] = 1;
                // return new_digits;
            }
        }
        return digits;
    }
}
// @lc code=end

