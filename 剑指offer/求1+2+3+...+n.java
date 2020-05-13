// https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 不用乘除法和循环，第一反应递归，但是需要用if终止
public class Solution {
    public int Sum_Solution(int n) {
        if(n<2) return n;
        return n+Sum_Solution(n-1);
    }
}
// 看题解使用&&操作的短路效应实现终止递归 ||也可以
public class Solution {
    public int Sum_Solution(int n) {
        // && 左边在n=0时就不会执行右边，跳出递归
        // && 右边>0只是为了得到一个boolean值，随便怎么比较都行，<0 =0都可
        boolean b = (n > 0) && ((n += Sum_Solution(n - 1)) > 0);
        // boolean b = (n == 0) || ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}