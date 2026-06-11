package Neetcode.neetcode150;

public class TrappingRainWater {
    void main() {
        System.out.println(trap(new int[]{
                0,2,0,3,1,0,1,3,2,1
        }));
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1 , totalWater = 0;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        while (left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }
                else{
                    totalWater += leftMax - height[left];
                }
                left++;
            }
            else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
