/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (41.51%)
 * Likes:    490
 * Dislikes: 0
 * Total Accepted:    72.4K
 * Total Submissions: 171.9K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
// 二维数组搜索
class Solution {
    int x;
    int y;
    boolean visited[][];
    char[][] board;
    String word;
    boolean has = false;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        
        this.x = board.length;
        this.y = board[0].length;
        this.visited = new boolean[x][y];
        this.board = board;
        this.word = word;
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                dfs(i, j, 0);
                if(has) return true;
            }
        }
        return has;
    }
    private void dfs(int i, int j, int k) {
        // 退出条件
        if(i<0 || j<0 || i>=x || j>=y || visited[i][j] || has || board[i][j] != word.charAt(k)) return;
        if(k == word.length()-1) {
            has = true;
            return;
        }
        // 访问标记
        visited[i][j] = true;
        dfs(i+1, j, k+1);
        dfs(i-1, j, k+1);
        dfs(i, j+1, k+1);
        dfs(i, j-1, k+1);
        // 回溯清除标记
        visited[i][j] = false;
    }
}
// @lc code=end

