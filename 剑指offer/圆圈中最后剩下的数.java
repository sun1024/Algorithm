// https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 模拟这个圆圈
import java.util.ArrayList;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1) return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(i);
        }
        int del = 0; //要删的下标
        while(list.size()>1) {
            del = (del + m - 1) % list.size();
            list.remove(del);
        }
        return list.get(0);
    }
}
// 约瑟夫环 递推公式：f(n, m) = (m + f(n-1, m)) % n 
// 关注元素被删过程中，最后剩下的数的位置变化，从n-1反推n
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1) return -1;
        res = 0; // n=1时只剩一个数 索引为0
        for(int i=2; i<=n; i++) {
            res = (m + res) % i; // 这里要模上当时的n的个数
        }
        return res;
    }
}