package Neetcode.neetcode150.slidingwindow;

public class BestTimeToBuyAndSellStocks {
    void main() {
        System.out.println(maxProfit(new int[]{10,1,5,6,7,1}));
    }

    public int maxProfit(int[] prices) {

        int profit = 0;
        int buyStocks = Integer.MAX_VALUE;

        for (int price : prices) {
            buyStocks = Math.min(buyStocks, price);
            profit = Math.max(profit, price - buyStocks);
        }
        return profit;
    }
}
