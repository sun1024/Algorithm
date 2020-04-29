// https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 二分 O(logn) 找到第一个k和最后一个k的位置
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length == 0) return 0;
        int first = getFirst(array, k);
        int last = getLast(array, k);
        if(first == -1 || last == -1) return 0; // 没找到
        return last-first+1;
    }
    private int getFirst(int [] array, int k) {
        int left = 0;
        int right = array.length-1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == k) { // 是第一个k才return
                if(mid>0 && array[mid-1] != k || mid == 0) {
                    return mid;
                } else {
                    right = mid -1;
                }
            } else if(array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    private int getLast(int [] array, int k) {
        int left = 0;
        int right = array.length-1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == k) { // 是最后一个k才return
                if(mid<array.length-1 && array[mid+1] != k || mid == array.length-1) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if(array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}