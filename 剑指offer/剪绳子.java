// https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 很明显的动态规划，但是动态方程不是很好考虑
public class Solution {
    public int cutRope(int target) {
        // 动态方程：dp[i] = max(dp[i], j*(i-j), j*dp[i-j])
        // 理解：j从0-i遍历 将i从j处分为两半 则最优解在当前dp[i]、j*(i-j)、j*dp[i-j]之中 
        // 考虑到对称性 j属于0-i/2即可
        // 容易出错的地方是dp[3]=2 如果3不分割的话反而比分割(1+2)大，但是题目明确要求m>1，至少切一刀
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=target; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[target];
    }
}