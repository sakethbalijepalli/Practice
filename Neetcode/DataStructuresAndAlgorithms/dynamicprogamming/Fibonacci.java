package Neetcode.DataStructuresAndAlgorithms.dynamicprogamming;

public class Fibonacci {
    void main() {
        System.out.println(fib(6));
    }

    //Using recursion
    public int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // dynamic programming top down approach.
    public int memoization(int  n, int[] cache) {
        if (n <= 1) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = memoization(n - 1, cache) + memoization(n - 2, cache);
        return cache[n];
    }

    // Dynamic Programming, bottom up
    public int dp(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = {0,1};
        int i = 2;
        while (i <= n) {
            int tmp = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = tmp;
            i++;
        }
        return dp[1];
    }

}
