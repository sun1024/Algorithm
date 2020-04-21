// https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
// 两次遍历
public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A.length == 0) return B;
        B[0] = 1;
        for(int i=1; i<A.length; i++) {
            B[i] = B[i-1] * A[i-1]; // 每个B[i]先乘上i前的元素
        }
        int temp = 1;
        for(int j=A.length-2; j>=0; j--) {
            temp *= A[j+1];
            B[j] *= temp; //借助中间变量，再让每个B[i]乘以i后的元素
        }
        return B;
    }
}