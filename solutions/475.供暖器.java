/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 *
 * https://leetcode-cn.com/problems/heaters/description/
 *
 * algorithms
 * Easy (29.17%)
 * Likes:    91
 * Dislikes: 0
 * Total Accepted:    7.3K
 * Total Submissions: 24.8K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * 
 * 说明:
 * 
 * 
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4],[1,4] 
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        //排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        //用来装所有house的最短距离 可以不用
        int[] min = new int[houses.length]; 
        for(int i=0; i<houses.length; i++) {
            // 搜索每一个house到达heater的最短距离
            int res = Integer.MAX_VALUE;
            int left = 0; 
            int right = heaters.length-1;
            while(left<=right) {
                int mid = left + (right - left) / 2;
                if(heaters[mid] == houses[i]) {
                    res = 0;
                    break;
                }
                else if(heaters[mid] > houses[i]) {
                    if(res > heaters[mid] - houses[i]) {
                        res = heaters[mid] - houses[i];
                    }
                    right = mid - 1;
                } else {
                    if(res > houses[i] - heaters[mid]) {
                        res = houses[i] - heaters[mid];
                    }
                    left = mid + 1;
                }
            }
            min[i] = res;
        }
        Arrays.sort(min); //取所有最短距离的最大值
        return min[min.length-1];
    }
}
// @lc code=end

