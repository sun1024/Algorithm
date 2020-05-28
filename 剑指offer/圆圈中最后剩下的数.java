// https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 约瑟夫环 递推公式：
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1) return -1;
        int res = 0;
        for(int i=2; i<=n; i++) {
            res = (res + m % i) % i;
        }
        return res;
    }
}