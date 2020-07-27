// https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&&tqId=11219&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 更熟悉递归式的dfs
public class Solution {
    int count = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean [][] visited = new boolean[rows][cols];
        // 从i=0 j=0 开始搜索
        dfs(0, 0, threshold, visited, rows, cols);
        return count;
    }
    private void dfs(int i, int j, int threshold, boolean[][] visited, int rows, int cols) {
        if(i>=rows || j>=cols || sum(i, j)>threshold || visited[i][j]) return;
        visited[i][j] = true;
        count++;
        // 从左上角看，只用往下或者往右
        dfs(i+1, j, threshold, visited, rows, cols);
        dfs(i, j+1, threshold, visited, rows, cols);
    }
    private int sum(int i, int j) {
        int sum = 0;
        while(i != 0) {
            sum += i%10;
            i = i/10;
        }
        while(j != 0) {
            sum += j%10;
            j = j/10;
        }
        return sum;
    }
}