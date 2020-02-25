/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (67.99%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    52K
 * Total Submissions: 76.2K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 */

// @lc code=start
// 暴力
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         ArrayList<Integer> arr = new ArrayList<Integer>();
//         for(int i:nums1) {
//             if(arr.contains(i)) continue;
//             for(int j:nums2) {
//                 if(i==j) {
//                     arr.add(i);
//                     break;
//                 }
//             }
//         }
//         int[] res = new int[arr.size()];
//         for(int i=0; i<arr.size(); i++) {
//             res[i] = arr.get(i);
//         }
//         return res;
//     }
// }
// 排序+二分 O(n*logn)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums2.length; i++) {
            // 在排序后的nums1中二分查找
            int left = 0;
            int right = nums1.length-1;
            while(left<=right) {
                int mid = left + (right-left) / 2;
                if(nums1[mid] == nums2[i]) {
                    set.add(nums2[i]);
                    break;
                }
                if(nums1[mid] > nums2[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        int p = 0;
        int[] res = new int[set.size()];
        for(int i:set) {
            res[p++] = i;
        }
        return res;
    }
}
// @lc code=end

