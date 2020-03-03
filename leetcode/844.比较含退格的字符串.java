/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (49.98%)
 * Likes:    90
 * Dislikes: 0
 * Total Accepted:    15.4K
 * Total Submissions: 30.7K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 
 * 
 * 示例 2：
 * 
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 
 * 
 * 示例 3：
 * 
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 
 * 
 * 示例 4：
 * 
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] sc = S.toCharArray();
        char[] tc = T.toCharArray();
        return trans(sc).equals(trans(tc));
    }
    private String trans(char[] chs) {
        int p1 = 0;
        int p2 = 0;
        // 双指针原地转换
        while(p1<chs.length) {
            if(chs[p1] != '#') {
                chs[p2++] = chs[p1++];
            }else {
                p1++;
                if(p2 != 0) p2--;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<p2; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

