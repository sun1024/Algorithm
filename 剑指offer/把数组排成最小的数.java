// https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&&tqId=11185&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
// 字符串两两拼接比较判断先后顺序，感觉这么比是对的，但是谁tm第一次能想到orz
import java.util.ArrayList;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        fastSort(strs, 0, numbers.length-1);
        StringBuilder res = new StringBuilder();
        for(int s:strs) {
            res.append(s);
        }
        return res.toString();
    }
    // 敲一遍快排，已经忘得差不多了
    private void fastSort(String[] strs, int low, int high) {
        if(low<=high) {
            int index = partition(strs, low, high);
            fastSort(strs, low, index-1);
            fastSort(strs, index+1, high);
        }
    }
    // // 基准点，让左边所有数比它小，右边所有数比它大，这里的判断改为字符串比较
    // private int partition(String[] strs, int low, int high) {
    //     int i = low; 
    //     int j = high;
    //     String x = strs[i];
    //     while(i<j) {
    //         // 从右往左
    //         while((x + strs[j]).compareTo(strs[j] + x) && i<j) j--;

    //     }
    // }
}