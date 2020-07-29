// https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&&tqId=11218&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 写的不算优雅的dfs
public class Solution {
    boolean has = false;
    int rows;
    int cols;
    char[] str;
    boolean [][] visited;
    
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length == 0) return false;
        this.rows = rows;
        this.cols = cols;
        this.str = str;
        this.visited = new boolean [rows][cols];
        // 先搞成二维数组
        char[][] myMatrix = new char[rows][cols];
        int index = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                myMatrix[i][j] = matrix[index];
                index++;
            }
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                // 开始搜索
                bfs(i, j, myMatrix, 0);
                if(has) return true;
            }
        }
        return has;
    }
    private void bfs(int i, int j, char[][] myMatrix, int k) {
        // 递归结束条件，i,j超过范围，visited，已经has，不相等
        if(i<0 || j<0 || i>=rows || j>=cols || visited[i][j] || has || myMatrix[i][j] != str[k]) return;
        // 完全匹配
        if(k == str.length - 1) {
            has = true;
            return;
        }
        // 访问过标记
        visited[i][j] = true;
        bfs(i-1, j, myMatrix, k+1);
        bfs(i+1, j, myMatrix, k+1);
        bfs(i, j-1, myMatrix, k+1);
        bfs(i, j+1, myMatrix, k+1);
        // 搜索回溯 清除标记 ***
        visited[i][j] = false;
    }
}