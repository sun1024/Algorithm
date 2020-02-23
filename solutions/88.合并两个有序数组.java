/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (46.49%)
 * Likes:    424
 * Dislikes: 0
 * Total Accepted:    110.8K
 * Total Submissions: 237.3K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
// 暴力插入
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         for(int i=0; i<nums2.length; i++) {
//             for(int j=0; j<nums1.length; j++) {
//                 if(j-i>=m) { // nums2[i]比nums1中所有数都大
//                     nums1[j] = nums2[i];
//                     break;
//                 }
//                 if(nums2[i]<=nums1[j]) {
//                     for(int k=nums1.length-1; k>j; k--) {
//                         nums1[k] = nums1[k-1];
//                     }
//                     nums1[j] = nums2[i];
//                     break;
//                 }
//             }
//         }
//     }
// }
// 双指针 从前往后 需要额外空间
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] nums1_copy = new int[m];
//         for(int i=0; i<m; i++) {
//             nums1_copy[i] = nums1[i];
//         }
//         int p = 0; //nums1_copy指针
//         int q = 0; //nums2指针
//         int j = 0; //nums1指针
//         while(p < m && q < n) {
//             nums1[j] = Math.min(nums1_copy[p], nums2[q]);
//             if(nums1_copy[p]>nums2[q]) q++;
//             else p++;
//             j++;
//         }
//         if(p < m) { // nums2都小于nums1_copy剩下的
//             for(int i=0; i<m-p; i++) {
//                 nums1[n+p+i] = nums1_copy[p+i];
//             }
//         } else { // q < n  nums1_copy都小于nums2剩下的
//             for(int i=0; i<n-q; i++) {
//                 nums1[m+q+i] = nums2[q+i];
//             }
//         }
//     }
// }
// 双指针 从后往前 不需要额外空间
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1; //nums1
        int p2 = n-1; //nums2
        int p3 = m+n-1; //nums1空间大小大于或等于m+n,以m+n-1为开始
        while(p1>=0 && p2>=0) {
            nums1[p3] = Math.max(nums1[p1], nums2[p2]);
            if(nums1[p1] > nums2[p2]) p1--;
            else p2--;
            p3--;
        }
        if(p2>=0) { //nums1都比nums2剩下的大
            for(int i=0; i<=p2; i++) nums1[i] = nums2[i];
        }
    }
}
// @lc code=end

