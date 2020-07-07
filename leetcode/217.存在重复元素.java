import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 *
 * https://leetcode-cn.com/problems/contains-duplicate/description/
 *
 * algorithms
 * Easy (52.34%)
 * Likes:    262
 * Dislikes: 0
 * Total Accepted:    147.2K
 * Total Submissions: 279.8K
 * Testcase Example:  '[1,2,3,1]'
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,1]
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: [1,2,3,4]
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * 
 */

// @lc code=start
// set O(n)
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int i:nums) {
//             if(set.contains(i)) return true;
//             set.add(i);
//         }
//         return false;
//     }
// }
// sort O(nlogn)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}
// @lc code=end

