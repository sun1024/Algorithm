// https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 一看就觉得是动态规划，动态方程：dp[i]=min(dp[j]*2, dp[j]*3, dp[j]*5) j肯定在0-i的范围内 但是没法办法找到确切的一个或几个j
// 看题解是三指针+动态规划 还算比较好理解 将j拆成三个指针分别对应*2、*3、*5，dp[i]使用了哪个就把那个指针加一
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        int[] res = new int[index];
        res[0] = 1;
        int p1=0, p2=0, p3=0;
        for(int i=1; i<index; i++) {
            res[i] = Math.min(res[p1]*2, Math.min(res[p2]*3, res[p3]*5));
            if(res[i] == res[p1]*2) p1++;
            if(res[i] == res[p2]*3) p2++;
            if(res[i] == res[p3]*5) p3++;
        }
        return res[index-1];
    }
}