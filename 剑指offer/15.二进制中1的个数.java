// https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 位运算 n&1
// public class Solution {
//     public int NumberOf1(int n) {
//         int res = 0;
//         while(n != 0) {
//             res += n & 1;
//             n >>>= 1;
//         }
//         return res;
//     }
// }
// n&(n-1) 不断消去最右一个1
public class Solution {
    public int NumberOf1(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n-1;
        }
        return res;
    }
}