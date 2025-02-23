public class Stock {
    public static void main(String[] args) {
        // int[] prices = {7,6,4,3,1};
        int[] prices = {5,8,13,3,6};
        int profit = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            int currPrice = prices[i];
            if(currPrice<min)
                min = currPrice;
            else{
                int currProfit = currPrice - min;
                profit = currProfit>profit ? currProfit : profit;
            }
        }
        System.out.println(profit);
    }
}
