// https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// dp[n] = dp[n-1] + dp[n-2] ...
// dp[n-1] = dp[n-2] + dp[n-3] ...
// => dp[n] = 2 * dp[n-1]
public class Solution {
    public int JumpFloorII(int target) {
        if(target<=0) return 0;
        if(target==1) return 1;
        return 2*JumpFloorII(target-1);
    }
}