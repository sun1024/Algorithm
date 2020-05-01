/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 *
 * https://leetcode-cn.com/problems/single-number/description/
 *
 * algorithms
 * Easy (66.49%)
 * Likes:    1186
 * Dislikes: 0
 * Total Accepted:    182.9K
 * Total Submissions: 274.1K
 * Testcase Example:  '[2,2,1]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,1]
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 
 */

// @lc code=start
// 趁热打铁把位运算都做了叭
// 依次异或就只剩只出现一次的数了
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i:nums) {
            xor ^= i;
        }
        return xor;
    }
}
// @lc code=end

