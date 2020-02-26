/*
 * @lc app=leetcode.cn id=1237 lang=java
 *
 * [1237] 找出给定方程的正整数解
 *
 * https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/description/
 *
 * algorithms
 * Easy (67.61%)
 * Likes:    16
 * Dislikes: 0
 * Total Accepted:    3.8K
 * Total Submissions: 5.6K
 * Testcase Example:  '1\n5'
 *
 * 给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。
 * 
 * 给定函数是严格单调的，也就是说：
 * 
 * 
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * 
 * 
 * 函数接口定义如下：
 * 
 * interface CustomFunction {
 * public:
 * // Returns positive integer f(x, y) for any given positive integer x and
 * y.
 * int f(int x, int y);
 * };
 * 
 * 
 * 如果你想自定义测试，你可以输入整数 function_id 和一个目标结果 z 作为输入，其中 function_id
 * 表示一个隐藏函数列表中的一个函数编号，题目只会告诉你列表中的 2 个函数。  
 * 
 * 你可以将满足条件的 结果数对 按任意顺序返回。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：function_id = 1, z = 5
 * 输出：[[1,4],[2,3],[3,2],[4,1]]
 * 解释：function_id = 1 表示 f(x, y) = x + y
 * 
 * 示例 2：
 * 
 * 输入：function_id = 2, z = 5
 * 输出：[[1,5],[5,1]]
 * 解释：function_id = 2 表示 f(x, y) = x * y
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= function_id <= 9
 * 1 <= z <= 100
 * 题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
 * 在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。
 * 
 * 
 */

// @lc code=start
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        // 对于两个都有序 使用双指针
        int p1 = 1; //指向x的开头
        // int p2 = 1000; //指向y的末尾
        int p2 = z; // x,y 不可能大于z 从而缩小规模
        while(p1<=z && p2>=1) {
            if(customfunction.f(p1, p2) == z) {
                List<Integer> list = new ArrayList<>();
                list.add(p1++);
                list.add(p2--);
                res.add(list);
            } else if(customfunction.f(p1, p2) > z) {
                p2--;
            } else {
                p1++;
            }
        }
        return res;
    }
}
// @lc code=end

