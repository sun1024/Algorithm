// https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&&tqId=11216&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 之前没看明白数据流，以为是个啥高大上的玩意，结果发现就是动态的输入
// // 不看题解的思路，每次排下序 O(nlogn)
// import java.util.*;
// public class Solution {
//     ArrayList<Integer> nums = new ArrayList<>();
    
//     public void Insert(Integer num) {
//         nums.add(num);
//     }

//     public Double GetMedian() {
//         int len = nums.size();
//         if(nums.size() == 0) return 0.0;
//         if(len == 1) return nums.get(0) * 1.0;
//         Collections.sort(nums);
//         if(len % 2 == 0) {
//             return (nums.get(len/2) + nums.get(len/2-1)) / 2.0;
//         } else {
//             return nums.get(len/2) * 1.0;
//         }
//     }
// }
// 插入一个排一次序，很容易想到直接用插入排序 O(n)
import java.util.*;
public class Solution {
    ArrayList<Integer> nums = new ArrayList<>();
    public void Insert(Integer num) {
        int len = nums.size();
        if(len == 0) {
            nums.add(num);
            return;
        }
        for(int i=0; i<len; i++) {
            if(num<nums.get(i)) {
                nums.add(i, num);
                return;
            }
        }
        // num最大的话直接排在末尾
        nums.add(len-1, num);
    }
    public Double GetMedian() {
        int len = nums.size();
        if(len == 0) return 0.0;
        if(len == 1) return nums.get(0) * 1.0;
        if(len % 2 == 0) {
            int a = nums.get(len/2-1);
            int b = nums.get(len/2);
            return (a+b) / 2.0;
        } else {
            return nums.get(len/2) * 1.0;
        }
    }
}
// 插入过程可以用二分，但是nums.add(i, num)还是O(n)所以整体还是O(n)
import java.util.*;
public class Solution {
    ArrayList<Integer> nums = new ArrayList<>();
    public void Insert(Integer num) {
        int len = nums.size();
        if(len == 0) {
            nums.add(num);
            return;
        }
        int i = bs(nums, num);
        nums.add(i, num);
    }
    private int bs(ArrayList<Integer> nums, int num) {
        int left = 0;
        int right = nums.size() - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            // 等的话插在mid前面后面都行
            if(num == nums.get(mid)) return mid;
            if(num > nums.get(mid)) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
    public Double GetMedian() {
        int len = nums.size();
        if(len == 0) return 0.0;
        if(len == 1) return nums.get(0) * 1.0;
        if(len % 2 == 0) {
            int a = nums.get(len/2-1);
            int b = nums.get(len/2);
            return (a+b) / 2.0;
        } else {
            return nums.get(len/2) * 1.0;
        }
    }
}
// 还有用堆或者二叉树的做法，下次刷到再看吧，反正笔试遇到了就直接第一种快速A