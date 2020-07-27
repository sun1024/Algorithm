// https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&&tqId=11182&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 直接sort()取前k个，显然这么写就没意思了
// 堆的知识还没复习到，就用快速选择的方法做吧, 顺便复习下快排
// 个人理解就是经过剪枝的快排，O(n)并不知道咋算出来的复杂度2333
import java.util.*;
public class Solution {
    ArrayList<Integer> res = new ArrayList<>();    
    int k;
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length) return res;
        this.k = k;
        qs(input);
        for(int i=0; i<k; i++) {
            res.add(input[i]);
        }
        return res;
    }
    private void qs(int [] input) {
        int len = input.length;
        qs(input, 0, len-1);
    }
    private void qs(int [] input, int low, int high) {
        if(low>=high) return;
        int index = partition(input, low, high);
        // 这里的边界要弄清楚
        // 关键在于只要最小的k个 是不用排序的
        if(k == index) return; // 符合条件前k个已经是最小的
        else if(k < index) { 
            // 排除掉比index的值更大的 在low到index-1范围内挖坑填坑
            qs(input, low, index-1); 
        } else { 
            // 排除掉比index的值更小的，因为他们都满足,在index+1到high范围内挖坑填坑
            qs(input, index+1, high);
        }
    }
    // 基准值找法和快排一样
    private int partition(int [] input, int low, int high) {
        int i = low;
        int j = high;
        int temp = input[i];
        while(i<j) {
            // j 从右往左 找第一个比temp小的
            while(input[j] >= temp && i<j) {
                j--;
            }
            // 填坑
            if(i<j) {
                input[i] = input[j];
                i++;
            }
            // i 从左往右 找第一个比temp大的
            while(input[i] <= temp && i<j) {
                i++;
            }
            if(i<j) {
                input[j] = input[i];
                j--;
            }
        }
        input[i] = temp;
        return i;
    }
}