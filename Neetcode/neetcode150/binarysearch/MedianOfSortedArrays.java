package Neetcode.neetcode150.binarysearch;

import java.util.Map;

public class MedianOfSortedArrays {

    void main() {
        System.out.println(findMedianSortedArrays(new int[]{1,2,3,4,5,6},new int[]{1,2,3,4}));
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1 2 3 4 5 6 10 20 30 40

        if(nums1.length == 0 || nums2.length == 0) return 0.0;

        int[] A = nums1;
        int[] B = nums2;

        int total = A.length + B.length; // we are not doing -1 and -1 here as arrays are zero indexed. we will handle it downstream.
        int half = total / 2;

        if(B.length < A.length){
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0, r = A.length - 1;
        while (true){
            int i = l + (r - l) / 2, j = half - i - 2;
            int ALeft = i >= 0 ? A[i] : Integer.MIN_VALUE;
            int ARight = i + 1 < A.length ? A[i + 1] : Integer.MAX_VALUE;
            int BLeft = j >= 0 ? B[j] : Integer.MIN_VALUE;
            int BRight = j + 1 < B.length ? B[j + 1] : Integer.MAX_VALUE;

            if(ALeft <= BRight && BLeft <= ARight){
                //odd
                if(total % 2 == 0){
                    return Math.min(ARight,BRight);
                }else{
                    return (double) (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2;
                }
            }
        }
        // 1 2 3 4 5 6 len = 6
        // 1 2 3 4 - len = 4 total 10
        //

    }
}
