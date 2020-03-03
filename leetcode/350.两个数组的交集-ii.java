/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (46.37%)
 * Likes:    235
 * Dislikes: 0
 * Total Accepted:    67.6K
 * Total Submissions: 144.6K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 
 * 说明：
 * 
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 * 进阶:
 * 
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 
 */

// @lc code=start
// 暴力
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int MAX_VALUE = Integer.MAX_VALUE;
//         LinkedList<Integer> list = new LinkedList<>();
//         for(int i=0; i<nums1.length; i++) {
//             for(int j=0; j<nums2.length; j++) {
//                 if(nums1[i] == nums2[j]) {
//                     list.addLast(nums1[i]);
//                     nums2[j] = MAX_VALUE;
//                     break;
//                 }
//             }
//         }
//         int[] res = new int[list.size()];
//         for(int i=0; i<list.size(); i++) {
//             res[i] = list.get(i);
//         }
//         return res;
//     }
// }
// 排序+双指针
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while(p1<nums1.length && p2<nums2.length) {
            if(nums1[p1] > nums2[p2]) p2++;
            else if(nums1[p1] < nums2[p2]) p1++;
            else if(nums1[p1] == nums2[p2]) {
                nums1[p3++] = nums1[p1++]; //直接用nums1存储 节约空间
                p2++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, p3);
        // int[] res = new int[p3];
        // for(int i=0; i<p3; i++) {
        //     res[i] = nums1[i];
        // }
        // return res;
    }
}
// @lc code=end

