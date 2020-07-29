/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (76.05%)
 * Likes:    807
 * Dislikes: 0
 * Total Accepted:    159.5K
 * Total Submissions: 208.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
// 全排列问题的回溯解法，不整那些花里胡哨的了
// 把排列过程看成树形的选择，先选1,然后可以选2或者3,选2的话再选3，就构成[1,2,3]
// 个人理解回溯就是dfs再进行一些剪枝
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        List<Integer> list = new LinkedList<>();
        dfs(nums, list);
        return res;
    }
    private void dfs(int[] nums, List<Integer> list) {
        if(nums.length == list.size()) { // list里已经放完了
            res.add(new LinkedList(list)); // list的内容一直在变，要进行深拷贝
            return;
        }
        for(int i=0; i<nums.length; i++) {
            // 这里可以整一个visited[i]来判断的
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, list);
            // 回溯 状态回退
            list.remove(list.size()-1);
        }
    }
}
// @lc code=end

