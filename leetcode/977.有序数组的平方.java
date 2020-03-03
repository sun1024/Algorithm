/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (70.93%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    30.4K
 * Total Submissions: 42.8K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 
 * 
 * 示例 2：
 * 
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * 
 * 
 */

// @lc code=start
// 取绝对值 排序 平方 可真是个小机灵鬼。。。
// class Solution {
//     public int[] sortedSquares(int[] A) {
//         for(int i=0; i<A.length; i++) {
//             A[i] = Math.abs(A[i]);
//         }
//         Arrays.sort(A);
//         for(int i=0; i<A.length; i++){
//             A[i] = A[i]*A[i];
//         }
//         return A;
//     }
// }
// 双指针 从两边到中间
class Solution {
    public int[] sortedSquares(int[] A) {
        int p1 = 0;
        int p2 = A.length-1;
        int[] res = new int[A.length];
        int p3 = A.length-1; //从后往前存入结果
        while(p1<=p2) {
            if(A[p1]*A[p1] > A[p2]*A[p2]) {
                res[p3--] = A[p1]*A[p1];
                p1++;
            } else {
                res[p3--] = A[p2]*A[p2];
                p2--;
            }
        }
        return res;
    }
}
// @lc code=end

