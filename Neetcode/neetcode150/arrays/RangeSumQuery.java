package Neetcode.neetcode150.arrays;

import java.util.ArrayList;
import java.util.List;

public class RangeSumQuery {

    List<Integer> prefix = new ArrayList<>();

    void main() {
        NumArray(new int[]{-2,0,3,-5,2,-1});
    }

    public void NumArray(int[] nums) {
        int total = 0;

        for(int i : nums){
            total += i;
            prefix.add(total);
        }
    }

    public int sumRange(int left, int right) {
        int prefixRight = prefix.get(right);
        int prefixLeft = left > 0 ? prefix.get(left - 1) : 0;

        return prefixRight - prefixLeft;
    }
}
