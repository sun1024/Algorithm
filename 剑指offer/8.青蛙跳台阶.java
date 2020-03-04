// https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
public class Solution {
    public int JumpFloor(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        if(target == 3) return 3;
        if(target == 4) return 5;
        //dp[n] = dp[n-1] + dp[n-2]
        //先后次序不同算不同的结果
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 3;
        dp[4] = 5;
        for(int i=5; i<=target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}