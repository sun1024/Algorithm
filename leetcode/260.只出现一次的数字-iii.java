/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 *
 * https://leetcode-cn.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (71.35%)
 * Likes:    211
 * Dislikes: 0
 * Total Accepted:    19.3K
 * Total Submissions: 26.9K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 
 * 示例 :
 * 
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 
 * 注意：
 * 
 * 
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 
 * 
 */
// 剑指offer做了一遍了 剑指offer\数组中只出现一次的数字.java
// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i:nums) {
            xor ^= i;
        }
        int first = 1;
        while((first&xor) == 0) {
            first = first<<1;
        }
        int[] res = new int[2];
        for(int i:nums) {
            if((first&i) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
// @lc code=end

