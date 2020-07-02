/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 *
 * https://leetcode-cn.com/problems/super-egg-drop/description/
 *
 * algorithms
 * Hard (28.32%)
 * Likes:    418
 * Dislikes: 0
 * Total Accepted:    25.8K
 * Total Submissions: 90.5K
 * Testcase Example:  '1\n2'
 *
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 
 * 你的目标是确切地知道 F 的值是多少。
 * 
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 
 * 
 * 示例 2：
 * 
 * 输入：K = 2, N = 6
 * 输出：3
 * 
 * 
 * 示例 3：
 * 
 * 输入：K = 3, N = 14
 * 输出：4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= K <= 100
 * 1 <= N <= 10000
 * 
 * 
 */

// @lc code=start
// 太难了，直接记方法吧，动态规划+二分
// 设dp(K, N)为题目要求的扔鸡蛋次数
// 在第X层楼扔下第一颗鸡蛋，有两种情况：
// 1. 鸡蛋碎了，则剩下K-1个鸡蛋，只需要在X-1层楼中进行尝试，问题从dp(K, N)到dp(K-1, X-1)+1
// 2. 鸡蛋没碎，则还剩K个鸡蛋，只需要在N-X的楼层里进行尝试，问题从dp(K, N)到dp(K, N-X)+1
// 要保证K个鸡蛋一定能试出来哪一层会碎，所以要考虑最坏情况
// 即对于第X层来讲，一定能试出来的次数为：max(1 + dp(K-1, X-1), 1 + dp(K, N-X))
// 然后选第一颗鸡蛋在每一层第一次扔的次数中的最小值，即为最小扔鸡蛋次数：
// dp(K, N) = min(max(1 + dp(K-1, X-1), 1 + dp(K, N-X)))，1<=X<=N
// 直接求解时间复杂度为O(KN2) 可以在找min时使用二分降到O(kNLogN)
class Solution {
    public int superEggDrop(int K, int N) {
        if(K<1 || N<1) return 0;
        // 先建一个二维空间，用来存储K个鸡蛋，N层楼的最优解
        int[][] dp = new int[K+1][N+1];
        // 将dp中所有值初始化为最大尝试次数，因为后面要求的是最小
        for(int i=0; i<=K; i++) {
            for(int j=0; j<=N; j++) {
                // N层楼最大尝试N次，从1-N扔一次一定能得到结果
                // 这样初始化后，i=1或j=1的值已经是最优了
                dp[i][j] = j; 
            }
        }
        // 根据动态转移方程求解
        for(int i=2; i<=K; i++) {
            for(int j=2; j<=N; j++) {
                // 直接层层扫描
                // for(int k=1; k<=j; k++) {
                //     dp[i][j] = Math.min(dp[i][j], Math.max(1 + dp[i-1][k-1], 1 + dp[i][j-k]));
                // }
                //二分
                int left = 1;
                int right = j;
                while(left < right) {
                    int mid = left + (right - left + 1) / 2;
                    // 根据碎还是没碎二分
                    int sui = dp[i-1][mid-1];
                    int notsui = dp[i][j-mid];
                    if(sui > notsui) right = mid - 1;
                    else left = mid;
                }
                dp[i][j] = Math.min(dp[i][j], Math.max(1 + dp[i-1][left-1], 1 + dp[i][j-left]));
            }
        }
        return dp[K][N];
    }
}
// @lc code=end

