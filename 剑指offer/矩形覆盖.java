// https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 随便写几个就能看出来是斐波那契了
// 直观理解也很容易：覆盖的方法可以分为：第一个竖着覆盖剩下2*(i-1)的矩形，和第一个横着覆盖剩下2*(i-2)的矩形
// 递归
public class Solution {
    public int RectCover(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        return RectCover(target-1)+RectCover(target-2);
    }
}
// dp
public class Solution {
    public int RectCover(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}