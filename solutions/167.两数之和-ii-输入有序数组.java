import javax.management.MBeanRegistration;

/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (52.28%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    68.6K
 * Total Submissions: 130.4K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * 说明:
 * 
 * 
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 
 * 
 * 示例:
 * 
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 */

// @lc code=start
// 暴力
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] result = new int[2];
//         if(numbers.length == 2 || numbers[0]+numbers[1] == target) {
//             result[0] = 1;
//             result[1] = 2;
//             return result;
//         }
//         for(int i=numbers.length-1; i>=0; i--) {
//             if(target<numbers[i]) continue;
//             for(int j=0; j<numbers.length; j++) {
//                 if(target-numbers[i] == numbers[j]) {
//                     result[0] = j+1;
//                     result[1] = i+1;
//                     return result;
//                 }
//             }
//         }
//         return result;
//     }
// }
// 二分 O(n*logn)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i=0; i<numbers.length; i++) {
            int left = 1;
            int right = numbers.length - 1;
            while(left<=right) {
                int mid = (left + right) / 2;
                if(target-numbers[i] == numbers[mid]) {
                    result[0] = i+1;
                    result[1] = mid+1;
                    return result;
                } else if(target-numbers[i] > numbers[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }
}
// @lc code=end

