import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (61.44%)
 * Likes:    464
 * Dislikes: 0
 * Total Accepted:    116.4K
 * Total Submissions: 188.6K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

// @lc code=start
// // 排序返回中间值
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return (nums[nums.length/2]);
//     }
// }
// // hashmap 记录出现次数
// class Solution {
//     public int majorityElement(int[] nums) {
//         if(nums.length == 0) return 0;
//         if(nums.length == 1) return nums[0];
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i:nums) {
//             if(map.containsKey(i)) {
//                 map.put(i, map.get(i)+1);
//                 if(map.get(i) > nums.length/2) {
//                     return i;
//                 }
//             } else {
//                 map.put(i, 1);
//             }
//         }
//         return 0;
//     }
// }
// 不用hashmap 记录出现次数
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        int prev = nums[0];
        int count = 0;
        for(int i:nums) {
            if(prev == i) count++;
            else {
                count--;
                if(count == 0) {
                    prev = i; 
                    count=1;
                }
            }
        }
        return prev;
    }
}
// @lc code=end

