// https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&&tqId=11217&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 两次循环暴力 O(n*k)
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if(len < size || size < 1) return res;
        for(int i=0; i<=len-size; i++) {
            int max = num[i];
            for(int j=i; j<i+size; j++) {
                max = Math.max(max, num[j]);
            }
            res.add(max);
        }
        return res;
    }
}
// 动态规划法 个人理解左右数组扫描法
// 将num按照size的大小分块，每块里面有k个元素，最后一块可能不足k个
// 维护左右两个大小为size的数组，left[i]代表在size范围内从左往右第i个时最大值，right[j]代表在size范围内块结束到j从右往左的最大值
// max = Math.max(left[i], right[j]) i和j相差一个size的长度 j = i+k-1
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        if(size * len == 0) return res;
        int [] left = new int [len];
        left[0] = num[0]; // 从左往右第0个的最大值就是第0个元素
        int [] right = new int [len];
        right[len-1] = num[len-1]; // 从右往左最后一个的最大值就是最后一个元素
        // 从1开始，因为0已经放进数组了
        for(int i=1; i<len; i++) {
            if(i%size == 0) {
                // 每个块的第一个
                left[i] = num[i];
            } else {
                // 之后的元素同前一个的最大值对比选出最大
                left[i] = Math.max(left[i-1], num[i]);
            }
            // right[]也是一样 从右往左
            // len-i 就是从右往左数的第i个
            if((len-i)%size == 0) {
                right[len-i-1] = num[len-i-1];
            } else {
                right[len-i-1] = Math.max(right[len-i], num[len-i-1]);
            }
        }
        for(int i=0; i<len-size+1; i++) {
            res.add(Math.max(left[i+size-1], right[i]));
        }
        return res;
    }
} 