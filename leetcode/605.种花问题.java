/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 *
 * https://leetcode-cn.com/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (31.71%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    27.6K
 * Total Submissions: 86.1K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n
 * 朵花？能则返回True，不能则返回False。
 * 
 * 示例 1:
 * 
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 
 * 
 * 注意:
 * 
 * 
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 排除只有一个元素的情况，方便后面少些判断
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 0) return n<2;
            else return n<1;
        }
        int count = 0;
        for(int i=0; i<flowerbed.length-1; i++) {
            // 大前提是i上没种花
            if(flowerbed[i] == 0) {
                if(i == 0) { // 注意判断条件
                    if(flowerbed[i+1] == 0) {
                        count++;
                        flowerbed[i] = 1; // 把花种上
                        i++; // 种上之后 i+1也不能种了 所以直接跳过
                    }
                } else if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0) { // 不包含最后一个元素，所以这里i-1和i+1一定存在
                    count++;
                    flowerbed[i] = 1;
                    i++;
                }
            }
            // 提前返回
            if(count >= n) {
                return true;
            }
        }
        // 单独处理最后一个元素
        if(flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0) count++;
        if(count >= n) return true;
        else return false;
    }
}
// @lc code=end

