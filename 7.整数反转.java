/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (32.21%)
 * Total Accepted:    104.6K
 * Total Submissions: 324.8K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */
class Solution {
    public int reverse(int x) {
        String result = "";
        String str_x = String.valueOf(x);
        if(x>=Math.pow(-2, 31) && x<=Math.pow(2, 31)-1)
        {
            int flag = 0;
            if(str_x.charAt(0) == '-'){
                result += '-';
            }
            for(int i=str_x.length()-1; i>=0; i--)
            {
                if (str_x.charAt(i) != '0'){
                        flag = 1;
                    }
                if (flag == 1 && str_x.charAt(i) != '-'){
                    result += str_x.charAt(i);
                }
            }
            if(result != ""){
                long re = Long.parseLong(result);
                if(re>=Math.pow(-2, 31) && re<=Math.pow(2, 31)-1){
                    return (int)re;
                }else return 0;
            }else{
                return 0;
            }
        }
        else
        return 0;
    }
}

