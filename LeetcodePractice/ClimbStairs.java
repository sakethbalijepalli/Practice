package LeetcodePractice;

public class ClimbStairs {

    void main() {
        System.out.println(climbStairs(45));
    }
    public int climbStairs(int n) {
        if(n == 2){
            return 2;
        }
        if(n == 1){
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
