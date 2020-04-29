// https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 位运算加法
public class Solution {
    public int Add(int num1,int num2) {
        while(num2 != 0) {
            int temp = num1 ^ num2; // 异或 => 不进位加法
            num2 = (num1 & num2) << 1; // 相与再左移1 => 获取进位
            num1 = temp; // 不断进行位运算加法，直到没有发生进位
        }
        return num1;
    }
}